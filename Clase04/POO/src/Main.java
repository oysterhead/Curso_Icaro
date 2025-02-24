import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persona persona = new Persona("Sebastián", 42);
        System.out.println(persona.toString());

        Persona otra_persona = new Persona("Macarena", 22);
        System.out.println(otra_persona.toString());

        CuentaBancaria cuenta1 = new CuentaBancaria();
        System.out.println("Al abrir tu cuenta, tenes un saldo de $" + cuenta1.getBalance());
        System.out.println("Que operación desea realizar: \n");
        System.out.println("1. Depositar\n");
        System.out.println("2. Retirar");
        int option = scanner.nextInt();
        switch (option){
            case 1 ->{
                System.out.println("Ingrese el importe a depositar: ");
                double amount = scanner.nextDouble();
                System.out.println("Nuevo total: " + cuenta1.Deposit(amount));
            }

            case 2 ->{
                System.out.println("Ingrese el importe a depositar: ");
                double widraw = scanner.nextDouble();
                widraw = cuenta1.Widraw(widraw);
                if (widraw == 0){
                    System.out.println("Ud desea extraer más de lo disponible.");
                }
                else{
                    System.out.println("Se extrajo " + widraw + " con exito.");
                }

            }

        }

        System.out.println("Ingresa la marca del vehículo: ");
        String marca = scanner.nextLine();
        System.out.println("Ahora, ingrese el modelo del vehículo: ");
        String modelo = scanner.nextLine();
        System.out.println("Ingrese la cantidad de puertas: ");
        int numPuertas = scanner.nextInt();
        Coche coche1 = new Coche(marca, modelo, numPuertas);
        System.out.println("coche creado! \n Aquí va los datos: \n" );
        System.out.println("Marca: " + coche1.getMarca());
        System.out.println("Modelo: " + coche1.getModelo());
        System.out.println("Cantidad de puertas: " + coche1.getNumPuertas());;

        System.out.println("\nVamos con el punto 5!\n");
        System.out.println("Creando un array de estudiantes!");
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        for (int i = 0; i<3; i++){
            System.out.println("Ingrese el nombre del estudiante " + (i+1) + ": ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese la nota: ");
            int nota = scanner.nextInt();
            Estudiante estudiante = new Estudiante(nombre, nota);
            estudiantes.add(estudiante);
        };

        for (Estudiante estudiante : estudiantes){
            System.out.println("Estudiante: " + estudiante.getNombre());
            System.out.println("Nota: " + estudiante.getNota());
        };
    };
}