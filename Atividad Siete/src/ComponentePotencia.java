import java.util.ArrayList;
import java.util.Scanner;

public class ComponentePotencia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> registros = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Calculadora Geométrica ===");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.println("6. Calcular Potencia");
            System.out.println("7. Mostrar Registros");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción (0-7): ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    calcularCirculo(scanner, registros);
                    break;
                case 2:
                    calcularCuadrado(scanner, registros);
                    break;
                case 3:
                    calcularTriangulo(scanner, registros);
                    break;
                case 4:
                    calcularRectangulo(scanner, registros);
                    break;
                case 5:
                    calcularPentagono(scanner, registros);
                    break;
                case 6:
                    calcularPotencia(scanner, registros);
                    break;
                case 7:
                    mostrarRegistros(registros);
                    break;
                case 0:
                    System.out.println("Gracias por utilizar la Calculadora Geométrica.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Selección no válida. Por favor, elija una opción válida.");
            }
        }
    }

    private static void calcularCirculo(Scanner scanner, ArrayList<String> registros) {
        System.out.println("\n=== Cálculo de Círculo ===");
        System.out.print("Ingrese el radio del círculo: ");
        double radio = scanner.nextDouble();
        double area = Math.PI * radio * radio;
        double perimetro = 2 * Math.PI * radio;
        mostrarResultados("Círculo", area, perimetro);
        registros.add("Círculo - Área: " + area + ", Perímetro: " + perimetro);
    }

    private static void calcularCuadrado(Scanner scanner, ArrayList<String> registros) {
        System.out.println("\n=== Cálculo de Cuadrado ===");
        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = scanner.nextDouble();
        double area = lado * lado;
        double perimetro = 4 * lado;
        mostrarResultados("Cuadrado", area, perimetro);
        registros.add("Cuadrado - Área: " + area + ", Perímetro: " + perimetro);
    }

    private static void calcularTriangulo(Scanner scanner, ArrayList<String> registros) {
        System.out.println("\n=== Cálculo de Triángulo ===");
        System.out.print("Ingrese la base del triángulo: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura del triángulo: ");
        double altura = scanner.nextDouble();
        double area = (base * altura) / 2;
        double perimetro = base * 3;
        mostrarResultados("Triángulo", area, perimetro);
        registros.add("Triángulo - Área: " + area + ", Perímetro: " + perimetro);
    }

    private static void calcularRectangulo(Scanner scanner, ArrayList<String> registros) {
        System.out.println("\n=== Cálculo de Rectángulo ===");
        System.out.print("Ingrese la base del rectángulo: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura del rectángulo: ");
        double altura = scanner.nextDouble();
        double area = base * altura;
        double perimetro = 2 * (base + altura);
        mostrarResultados("Rectángulo", area, perimetro);
        registros.add("Rectángulo - Área: " + area + ", Perímetro: " + perimetro);
    }

    private static void calcularPentagono(Scanner scanner, ArrayList<String> registros) {
        System.out.println("\n=== Cálculo de Pentágono ===");
        System.out.print("Ingrese la longitud del lado del pentágono: ");
        double lado = scanner.nextDouble();
        double apotema = lado / (2 * Math.tan(Math.PI / 5));
        double area = (5 * lado * apotema) / 2;
        double perimetro = 5 * lado;
        mostrarResultados("Pentágono", area, perimetro);
        registros.add("Pentágono - Área: " + area + ", Perímetro: " + perimetro);
    }

    private static void calcularPotencia(Scanner scanner, ArrayList<String> registros) {
        System.out.println("\n=== Cálculo de Potencia ===");
        System.out.print("Ingrese la base: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese el exponente: ");
        int exponente = scanner.nextInt();
        double resultado = Math.pow(base, exponente);
        System.out.println("La potencia de " + base + " elevado a " + exponente + " es: " + resultado);
        registros.add("Potencia - Base: " + base + ", Exponente: " + exponente + ", Resultado: " + resultado);
    }

    private static void mostrarResultados(String figura, double area, double perimetro) {
        System.out.println("=== Resultados para " + figura + " ===");
        System.out.println("Área: " + area);
        System.out.println("Perímetro: " + perimetro);
    }

    private static void mostrarRegistros(ArrayList<String> registros) {
        System.out.println("\n=== Registros ===");
        for (String registro : registros) {
            System.out.println(registro);
        }
    }
}