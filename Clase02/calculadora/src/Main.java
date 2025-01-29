import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;

        System.out.println("Bienvenidos a la sumadora de Sebastián...");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el primer número: ");
        num1 = scanner.nextInt();
        System.out.print("Ingresa el segundo número: ");
        num2 = scanner.nextInt();
        scanner.close();

        System.out.println("La suma de " + num1 + " y " + num2 + " es: " + (num1 + num2) +".-");

    }
}