import java.util.Scanner;

public class ReformularCalculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Calculadora de Operaciones Matemáticas ===");

        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        Suma suma = new Suma(num1, num2);
        Resta resta = new Resta(num1, num2);
        Multiplicacion multiplicacion = new Multiplicacion(num1, num2);
        Division division = new Division(num1, num2);

        System.out.println("Resultados:");
        System.out.println("Suma: " + suma.calcular());
        System.out.println("Resta: " + resta.calcular());
        System.out.println("Multiplicación: " + multiplicacion.calcular());
        System.out.println("División: " + division.calcular());

        scanner.close();
    }

    interface Operacion {
        double calcular();
    }

    static class Suma implements Operacion {
        private double num1;
        private double num2;

        public Suma(double num1, double num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public double calcular() {
            return num1 + num2;
        }
    }

    static class Resta implements Operacion {
        private double num1;
        private double num2;

        public Resta(double num1, double num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public double calcular() {
            return num1 - num2;
        }
    }

    static class Multiplicacion implements Operacion {
        private double num1;
        private double num2;

        public Multiplicacion(double num1, double num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public double calcular() {
            return num1 * num2;
        }
    }

    static class Division implements Operacion {
        private double num1;
        private double num2;

        public Division(double num1, double num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public double calcular() {
            if (num2 != 0) {
                return num1 / num2;
            } else {
                System.out.println("Error: No se puede dividir por cero.");
                return Double.NaN;
            }
        }
    }
}