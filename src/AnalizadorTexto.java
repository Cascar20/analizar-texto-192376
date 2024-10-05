import java.util.Scanner;

public class AnalizadorTexto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un texto para analizar:");
        String texto = scanner.nextLine().toLowerCase();

        int[] frecuencia = new int[26];
        int totalLetras = 0;
        int totalPalabras = 0;
        int totalVocales = 0;
        
        final int LARGO_TEXTO = texto.length(); // El largo del texto se saca del for para que dicha operacion no se repita tantas veces

        for (int i = 0; i < LARGO_TEXTO ; i++) {
            char caracter = texto.charAt(i); // Se agrega una variable mas descriptiva para que la revision de codigo sea mas sencilla
            if (caracter >= 'a' && caracter <= 'z') {
                frecuencia[caracter - 'a']++;
                totalLetras++;
                if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                    totalVocales++;
                }
            } else if (caracter == ' ' && i > 0 && texto.charAt(i - 1) != ' ') {
                totalPalabras++;
            }
        }
        totalPalabras++; // Contar la última palabra

        System.out.println("Análisis del texto:");
        System.out.println("Total de letras: " + totalLetras);
        System.out.println("Total de palabras: " + totalPalabras);
        System.out.println("Total de vocales: " + totalVocales);
        System.out.println("Frecuencia de letras:");

        final byte LETRAS_ALFABETO = 26; // Se saca el valor magico y se le da a una variable; se usa byte porque el numero es y siempre sera pequeño
        for (int i = 0; i < LETRAS_ALFABETO; i++) {
            if (frecuencia[i] > 0) {
                System.out.println((char) (i + 'a') + ": " + frecuencia[i]);
            }
        }

        scanner.close();
    }
}

