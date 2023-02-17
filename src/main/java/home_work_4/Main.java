package home_work_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Метод вывода дерева в консоль не реализован.
 *
 * Запускать через Debug с точной останова на 22-й строке.
 */

public class Main {

    public static void main(String[] args) {
        final RedBlackTree tree = new RedBlackTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (true) {
                try {
                    int value = Integer.parseInt(reader.readLine());
                    tree.add(value);
                    System.out.println("finish");
                } catch (Exception ignored) {

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
