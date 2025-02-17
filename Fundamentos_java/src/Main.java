import java.util.*;

import static java.util.Arrays.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hola, " + hola_mundo_personalizado(scanner) + "! Bienvenido al mundo de Java.");
        System.out.println("*********************************\n");
        System.out.println("Bienvenido a Calculadora!");
        int suma = sumar_enteros(scanner);
        System.out.println("La suma de los números es: " + suma);
        System.out.println("*********************************\n");
        System.out.println("Por acá pondremos a prueba si un número es Par o Impar.");
        String par = par_impar(scanner);
        System.out.println(par);
        System.out.println("*********************************\n");
        System.out.println("Evaluación de Calificaciones");
        String evaluate = calificar(scanner);
        System.out.println("Tu calificación es: " + evaluate);
        System.out.println("*********************************\n");
        System.out.println("Maximo de Tres!");
        int maximo = maximo_tres(scanner);
        System.out.println("El máximo de tres es: " + maximo);
        System.out.println("*********************************\n");
        System.out.println("Promedio de un Arreglo");
        float avg_numbers = averange_numbers(scanner);
        System.out.println("El promedio es: " + avg_numbers);
        System.out.println("*********************************\n");
        System.out.println("Buscando a Nemo!!! ");
        String search = search_number(scanner);
        System.out.println(search);
        System.out.println("*********************************\n");
        System.out.println("Manipulación de Listas\n");
        List<String> friuts = list_fruit(scanner);
        System.out.println("Actualizando la lista de frutas... \n");
        for (String friut: friuts) {
            System.out.println(friut);
        }
        System.out.println("*********************************\n");
        System.out.println("Orden Ascendente de Arreglo\n");
        List<Integer> order_by = order_numbers(scanner);
        System.out.println("Te presento la lista ordenada: " + order_by);
        System.out.println("*********************************\n");
        System.out.println("Tabla de Multiplicar\n");
        int multiply = multiply_by(scanner);
        System.out.println("*********************************\n");
        System.out.println("Suma de Elementos Pares en un Arreglo\n");
        int pair = sum_pair(scanner);
        if (pair==0){
            System.out.println("No hubo numeros pares para sumar");
        }
        else System.out.println("La suma de números pares es: " + pair);
        System.out.println("*********************************\n");
        System.out.println("Invertir el Contenido de una Lista");
        List<String> reverse_list = reversed(scanner);
        System.out.println("\nLa lista invertida quedaría así: " + reverse_list);
        System.out.println("*********************************\n");
        System.out.println("Lista de Números sin Repeticiones");
        List<Integer> not_repeat = do_not_repeat(scanner);
        System.out.println("Lista de números sin repetir: " + not_repeat);
        System.out.println("*********************************\n");
        System.out.println("Intercambio de Elementos en un Arreglo");
        List<Integer> swap_numbers = swap_nro(scanner);
        System.out.println("Lista intercambiada: " + swap_numbers);
        System.out.println("*********************************\n");
        System.out.println("Concatenación de Listas de Palabras.");
        List<String> concat = concatenate(scanner);
        System.out.println("Así queda la concatenación: " + concat);



    }

    private static List<String> concatenate(Scanner scanner) {
        System.out.println("\nAqui vamos a cargar la primer lista de 3 palabras");
        List<String> lista1 = new ArrayList<>();
        for (int i=0; i<3; i++){
            System.out.println("Palabra nro " + (i+1) + ": ");
            String palabra = scanner.nextLine();
            lista1.add(palabra);
        }
        System.out.println("\nAqui vamos a cargar la segunda lista de 3 palabras");
        List<String> lista2 = new ArrayList<>();
        for (int i=0; i<3; i++){
            System.out.println("Palabra nro " + (i+1) + ": ");
            String palabra = scanner.nextLine();
            lista2.add(palabra);
        }

        List<String> lista_combinada = new ArrayList<>(lista1);
        lista_combinada.addAll(lista2);
        int i = 1;
        System.out.println("\nAsí queda la lista combinada:");
        for (String elemento : lista_combinada){
            System.out.println(i + ". " + elemento);
            i++;
        }

        System.out.println("\nAhora la ordenamos alfabéticamente");
        Collections.sort(lista_combinada);
        return lista_combinada;
    }

    private static List<Integer> swap_nro(Scanner scanner) {
        System.out.println("Debemos ingresar 5 numeros para esta operación:\n");
        List<Integer> numeros = new ArrayList<>();
        for (int i=0; i<5; i++){
            System.out.println("Ingrese el nro " + (i+1) + ":");
            int num = scanner.nextInt();
            numeros.add(num);
        }
        System.out.println("\nEsto fue lo cargado: " + numeros);
        System.out.println("\nAhora veremos de intercambar los nros...");

        List<Integer> swap_numeros = new ArrayList<>();
        for (int i = numeros.size() - 1; i >= 0; i--){
                swap_numeros.add(numeros.get(i));
        }

        return swap_numeros;
    }

    private static List<Integer> do_not_repeat(Scanner scanner) {
        System.out.println("Debemos ingresar 8 numeros para esta operación:\n");
        List<Integer> numeros = new ArrayList<>();
        int contador = 0;
        while (contador < 8) {
            System.out.print("Ingrese el número " + (contador + 1) + ": ");
            int numero = scanner.nextInt();

            if (numeros.contains(numero)) {
                System.out.println("El número " + numero + " ya existe en la lista. Intente con otro número.");
            } else {
                numeros.add(numero);
                contador++;
                System.out.println("Número " + numero + " agregado correctamente.");
            }
        }

        return numeros;
    }

    private static List<String> reversed(Scanner scanner) {
        List<String> words = new ArrayList<>();
        System.out.println("Ingresar las 5 palabras...\n");
        for(int i=0; i<5; i++){
            System.out.println("Ingrese palabra numero " + (i+1) + ":");
            String word = scanner.nextLine();
            words.add(word);
        }

        System.out.println("La lista que cargaste: \n");
        int i=1;
        for (String word: words){
            System.out.println(i+ ": " + word);
            i= i + 1;
        }
        List<String> reversed_list = new ArrayList<>();
        for (int y = words.size() - 1; y >= 0; y--) {
            reversed_list.add(words.get(y));
        }

        return reversed_list;
    }

    private static int sum_pair(Scanner scanner) {
        System.out.println("Debemos ingresar 10 numeros para esta operación:\n");
        List<Integer> numeros = new ArrayList<>();
        for(int i=0; i<10; i++){
            System.out.println("Ingrese el nro " + (i+1) + ":");
            int num = scanner.nextInt();
            numeros.add(num);
        }
        int total = 0;
        for(int numero: numeros){
            if(numero%2 == 0){
                total += numero;
            }
        }

        return total;
    }

    private static int multiply_by(Scanner scanner) {
        System.out.println("Ingrese el número del cual quiera saber la tabla del 1 al 10");
        int numero = scanner.nextInt();

        for (int i=1; i<11; i++){
            System.out.println(numero + "*" + i + " = " + (i*numero));
        }

        return 0;
    }

    private static List<Integer> order_numbers(Scanner scanner) {
        System.out.println("Vamos a ingresar 5 números \n");
        List<Integer> numeros_array = new ArrayList<>();
        int[] numeros = new int[5];
        int count = 5;
        for (int i=0; i<count; i++){
            System.out.println("Ingresando el numero " + (i + 1) + ":");
            numeros[i] = scanner.nextInt();
            }

        for (int valor : numeros) {
            numeros_array.add(valor);
        }

        numeros_array.sort(null);
        return numeros_array;
    }

    private static List<String> list_fruit(Scanner scanner) {
        List<String> friuts = new ArrayList<>();
        friuts.add("Manzana");
        friuts.add("Banana");
        friuts.add("Naranja");

        System.out.println("**Listando las frutas que hay en tu carrito**\n");
        for (String fruit: friuts){
            System.out.println(fruit);
        }

        System.out.println("Que fruta te faltó agregar? \n");
        String friut_to_add = scanner.nextLine();
        friuts.add(friut_to_add);

        System.out.println("Actualizando la lista de frutas... \n");
        for (String friut: friuts){
            System.out.println(friut);
        }

        System.out.println("Del 1 al 4, elija cual fruta eliminar: \n");
        int opcion = scanner.nextInt();
        friuts.remove(opcion-1);

        return friuts;
    }

    private static String search_number(Scanner scanner) {
        int[] numeros = new int[5];
        int count = 5;
        for (int i=0; i<count; i++){
            System.out.println("Ingresando el numero " +(i+1) +":");
            numeros[i] = scanner.nextInt();
        }
        System.out.println("Ya tenemos los numeros, ahora busquemos algún numero: ");
        int search_for = scanner.nextInt();

        String encontrado = new String();
        for (int numero : numeros){
            if (numero == search_for){
                encontrado = "El numero buscado (" + search_for + "), fue encontrado";
                break;
            }
            else {
                encontrado = "El numero buscado (" + search_for + "), NO fue encontrado";
            }
        }

        return encontrado;
    }

    private static float averange_numbers(Scanner scanner) {
        float avg;
        float []numeros = new float[5];
        System.out.println("Vamos a ingresar 5 números \n");
        float total = 0;
        int count = 5;
        for (int i=0; i<count; i++){
            System.out.println("Ingresando el numero " +(i+1) +":");
            numeros[i] = scanner.nextFloat();
            total += numeros[i];
        }


        return avg=total/count;
    }

    private static int maximo_tres(Scanner scanner) {
        System.out.println("Ingrese 3 números \n");
        System.out.println("Primer número: ");
        int valor1 = scanner.nextInt();
        System.out.println("Segundo número: ");
        int valor2 = scanner.nextInt();
        System.out.println("Tercer número: ");
        int valor3 = scanner.nextInt();
        System.out.println("Estamos calculando");
        Integer [] numeros = {valor1, valor2, valor3};
        sort(numeros, Collections.reverseOrder());
        int max = numeros[0];

        return max;
    }

    private static String calificar(Scanner scanner) {
        String evaluate;
        System.out.println("Ingresar un número para calificar (0 al 10): ");
        int valor = scanner.nextInt();
        while (valor < 0 || valor > 10){
            System.out.println("El número debe ser entre 0 y 10. Cargue de nuevo un valor: ");
            valor = scanner.nextInt();
        }

        String calificacion = switch (valor){
            case 10 -> "Excelente";
            case 9 -> "Excelente";
            case 8 -> "Bueno";
            case 7 -> "Bueno";
            case 6 -> "Regular";
            case 5 -> "Regular";
            default -> "Insuficiente";
        };

        return calificacion;
    }

    private static String par_impar(Scanner scanner) {
        String resultado;
        System.out.println("Ingresá un número: ");
        int numero = scanner.nextInt();
        if (numero%2 == 0){
            String nro_to_string = String.valueOf(numero);
            resultado = nro_to_string + " es PAR.-";
        }
        else{
            String nro_to_string = String.valueOf(numero);
            resultado = nro_to_string + " es IMPAR.-";
        }

        return resultado;
    }

    private static int sumar_enteros(Scanner scanner) {
        System.out.println("Ingresar el primer número: ");
        int num1 = scanner.nextInt();
        System.out.println("Ingresar el segundo número: ");
        int num2 = scanner.nextInt();

        return num1 + num2;
    }

    private static String hola_mundo_personalizado(Scanner scanner) {
        System.out.println("Ingresa un nombre: ");
        String nombre = scanner.nextLine();

        return nombre;
    }
}