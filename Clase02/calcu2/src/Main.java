import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String numero1, numero2 = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa primer numero: ");
        numero1 = scanner.nextLine();
        float num1 = 0;
        try {
            num1 = Float.parseFloat(numero1);
        }
        catch (NumberFormatException e){
            System.out.println("No se pudo parcear: " + e);
        }

        System.out.print("Ingresa segundo numero: ");
        numero2 = scanner.nextLine();
        float num2 = 0;
        try {
            num2 = Float.parseFloat(numero2);
        }
        catch (NumberFormatException e){
            System.out.println("No se pudo parcear: " + e);
        }
        scanner.close();

        System.out.println("La suma de los numeros es: " + suma(num1, num2));
        System.out.println("La resta de los numeros es: " + resta(num1, num2));
        float resultado_division = division(num1, num2);
        if (resultado_division!=0){
            System.out.println("La division de los numeros es: " + resultado_division);
        }
        else {
            System.out.println("El numero " + numero2 + " no puede ser 0.");
        }

        System.out.println("La multiplicacion de los numeros es: " + multiplicacion(num1, num2));
    }

    public static float suma(float num1, float num2){
        return num1 + num2;
    }

    public static float resta(float num1, float num2){
        return num1 - num2;
    }

    public static float division(float num1, float num2){
        if  (num2 != 0){
            try {
                return num1/num2;
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else return 0;
    }

    public static float multiplicacion(float num1, float num2){
        return num1*num2;
    }
}