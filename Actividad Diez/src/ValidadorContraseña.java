import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ValidadorContraseña implements Runnable {
    private final String password;
    private final String result;

    public ValidadorContraseña(String password, String result) {
        this.password = password;
        this.result = result;
    }

    @Override
    public void run() {
        boolean isValid = isValidPassword(password);
        System.out.println("La contraseña '" + password + "' es " + (isValid ? "válida." : "no válida."));
        guardarResultadoEnArchivo(password, isValid);
    }

    private static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        return password.matches("^(?=.*[A-Z].*[A-Z])(?=.*[a-z].*[a-z].*[a-z])(?=.*\\d).+$");
    }

    private static void guardarResultadoEnArchivo(String password, boolean isValid) {
        String fileName = "registro_contrasenas.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Contraseña: " + password + " - " + (isValid ? "Válida" : "No válida"));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de contraseñas a validar:");

        int numberOfPasswords;
        while (true) {
            try {
                numberOfPasswords = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(numberOfPasswords);
        for (int i = 0; i < numberOfPasswords; i++) {
            System.out.println("Ingrese la contraseña " + (i + 1) + ":");
            String password = scanner.nextLine();
            Runnable validator = new ValidadorContraseña(password, "resultado");
            executor.execute(validator);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(60, java.util.concurrent.TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Error al esperar la finalización de los hilos: " + e.getMessage());
        }

        scanner.close();
        System.out.println("Proceso de validación completo. Resultados guardados en 'registro_contrasenas.txt'.");
    }
}