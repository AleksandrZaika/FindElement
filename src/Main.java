import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "C:/Users/User007/Downloads/QAtest.txt";

        long start = System.currentTimeMillis();
        System.out.println("Подождите, сканируем файл.");

        getLinesCount(path);
        getSymbolCount(path);

        System.out.println("Сканирование завершено.");
        System.out.println("Времени прошло: " + (System.currentTimeMillis() - start) / 1000 + " секунд.");


    }

    public static void getLinesCount(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int lines = 0;

        while (scanner.hasNextLine()) {

            String[] array = scanner.nextLine().split("\r\n");
            lines += array.length;

        }
        System.out.println("Number of lines: " + lines);

        scanner.close();
    }

    public static void getSymbolCount(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int count = 0;

        while (reader.ready()) {
            for (char symbol : reader.readLine().toCharArray()) {
                if (symbol == 'A' || symbol == 'a') {
                    count++;
                }
            }
        }
        System.out.println("Number of characters: " + count);
    }

}