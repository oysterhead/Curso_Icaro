import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Vamos a necesitar que ingreses tres números enteros");
        System.out.println("***************************************************");
        System.out.println("");
        System.out.print("Ingresa el primer número: ");
        int num1 = scanner.nextInt();
        System.out.print("Ingresa el segundo número: ");
        int num2 = scanner.nextInt();
        System.out.print("Ingresa el tercer número: ");
        int num3 = scanner.nextInt();

        scanner.close();
        System.out.println("Si sumamos " + num1 + ", " + num2 + "y " + num3 + ", obtenemos " + (num1+num2+num3) +".-");
    }
}