import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el nombre a mostrar: ");
        String nombre = scanner.nextLine();

        System.out.println("Mi nombre es: " + nombre + ".");
        scanner.close();
        System.out.println("Estoy aprendiendo a programar en Java.");
        System.out.println("¡Esto es divertido!");

    }
}