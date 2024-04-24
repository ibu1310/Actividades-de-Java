import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrodeUsuario {
    public static void main(String[] args) {
        GestorUsuarios gestor = new GestorUsuarios();
        gestor.registrarUsuario();

        if (gestor.esRegistroValido()) {
            System.out.println("Registro exitoso.");
        } else {
            System.out.println("Registro fallido. Verifique la información ingresada.");
        }
    }
}

class GestorUsuarios {
    private static final Pattern PATRON_NOMBRE = Pattern.compile("^[a-zA-Z\\s]+$");
    private static final Pattern PATRON_EMAIL = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    private static final Pattern PATRON_CONTRASENA = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    private String nombre;
    private String email;
    private String contrasena;

    public GestorUsuarios() {
        this.nombre = "";
        this.email = "";
        this.contrasena = "";
    }

    public void registrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        this.nombre = obtenerEntradaValida(scanner, "Ingrese su nombre:", PATRON_NOMBRE);
        this.email = obtenerEntradaValida(scanner, "Ingrese su correo electrónico:", PATRON_EMAIL);
        this.contrasena = obtenerEntradaValida(scanner, "Ingrese su contraseña:", PATRON_CONTRASENA);
        scanner.close();
    }

    public boolean esRegistroValido() {
        return validarEntrada(nombre, PATRON_NOMBRE) && validarEntrada(email, PATRON_EMAIL) && validarEntrada(contrasena, PATRON_CONTRASENA);
    }

    private String obtenerEntradaValida(Scanner scanner, String mensaje, Pattern patron) {
        while (true) {
            System.out.println(mensaje);
            String entrada = scanner.nextLine();
            Matcher matcher = patron.matcher(entrada);
            if (matcher.matches()) {
                return entrada;
            } else {
                System.out.println("Entrada no válida. Por favor, inténtelo de nuevo.");
            }
        }
    }

    private boolean validarEntrada(String entrada, Pattern patron) {
        Matcher matcher = patron.matcher(entrada);
        return matcher.matches();
    }
}