import java.io.*;
import java.util.Scanner;

public class MorseCodeDriver {
    public static void main(String[] arg) throws IOException {
        translate();
    }

    static void translate() throws IOException {
        Scanner keyType = new Scanner(System.in);

        System.out.println("Choose an option.");
        displayOptions();
        int option = keyType.nextInt();
        keyType.nextLine();
        System.out.println("Type in name of file to translate.");
        String input = keyType.nextLine();
        switch (option) {
            case 1: //Encode english to morse code
                try {
                    System.out.println(EnglishToMorse.toMorse(readFile(input)));
                } catch (FileNotFoundException f) {
                    try {
                        System.out.println(EnglishToMorse.toMorse(readFile("src/" + input)));
                    } catch (FileNotFoundException f2) {
                        System.out.println(f2);
                        System.out.println("Type in full path of file.");
                        System.out.println(EnglishToMorse.toMorse(readFile(keyType.nextLine())));
                    }
                }
                break;
            case 2://Decode morse code to english
                try {
                    System.out.println(MorseToEnglish.toEnglish(readFile(input)));
                } catch (FileNotFoundException f) {
                    try {
                        System.out.println(MorseToEnglish.toEnglish(readFile("src/" + input)));
                    } catch (FileNotFoundException f2) {
                        System.out.println(f2);
                        System.out.println("Type in full path of file.");
                        System.out.println(MorseToEnglish.toEnglish(readFile(keyType.nextLine())));
                    }
                }
                break;
            case 3:
                return;
            default: //Invalid option
                System.out.println("Choose a valid option.");
                break;
        }
        keyType.close();
    }

    static String[] readFile(String filename) throws IOException {
        Scanner fileInput = new Scanner(new File(filename));
        String[] file = new String[filesize(filename)];
        int i = 0;
        while (fileInput.hasNextLine()) {
            file[i] = fileInput.nextLine();
            i++;
        }
        fileInput.close();
        return file;
    }

    static int filesize(String filename) throws IOException {
        Scanner fileInput = new Scanner(new File(filename));
        int numLines = 0;
        while (fileInput.hasNextLine()) {
            numLines++;
            fileInput.nextLine();
        }
        fileInput.close();
        return numLines;
    }

    static void displayOptions() {
        System.out.println("1. English to Morse");
        System.out.println("2. Morse to English");
        System.out.println("3. Exit");
    }
}
      
