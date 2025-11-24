import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Unused field
    public static int unusedField = 42;

    // Public mutable field
    public List<String> names = new ArrayList<>();

    // Bad constant naming style
    public static final int badConstant = 123;

    public static void main(String[] args) {

        // Unused variables
        int a = 10;
        int b = 20;

        // Redundant scanner
        Scanner sc = new Scanner(System.in);

        // Division by zero
        try {
            int x = 1 / 0;
        } catch (Exception e) {
            // empty catch
        }

        // Duplicate conditions and unreachable code
        for (int i = 0; i < 5; i++) {
            if (i == 2) break;
            if (i == 2) break; // duplicate condition
        }

        if (1 == 2) {
            System.out.println("Impossible");
        }

        if (false) {
            System.out.println("Unreachable code");
        }

        // Redundant objects
        Random rand = new Random();
        Random rand2 = new Random();

        // FileReader without try-with-resources
        try {
            FileReader fr = new FileReader("non_existing_file.txt");
            int data = fr.read();
            while (data != -1) {
                data = fr.read();
            }
            // fr not closed -> triggers resource leak
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        // Numeric overflow / duplicate calls
        int result = calculate(5, 10);
        int result2 = calculate(5, 10);

        // Unused method result
        unusedMethod();

        // Deep nesting (for fun, triggers style warnings)
        if (result > 10) {
            if (result > 20) {
                if (result > 30) {
                    if (result > 40) {
                        System.out.println("Deep nesting detected");
                    }
                }
            }
        }

        System.out.println("Program ended.");
    }

    public static int calculate(int x, int y) {
        int r = x + y;

        if (r > 10) {
            r += 5;
        } else {
            r -= 5;
        }

        // Duplicate logic
        if (r > 10) {
            r += 5;
        } else {
            r -= 5;
        }

        return r;
    }

    public static void unusedMethod() {
        int unused1 = 0;
        int unused2 = 1;
        int unused3 = unused1 + unused2;
        unused3++; // value changed but never used
    }

    public static void longBadMethod() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Line " + i);

            // Nested pointless conditions
            if (i % 2 == 0) {
                if (i % 3 == 0) {
                    if (i % 5 == 0) {
                        System.out.println("Very nested logic");
                    }
                }
            }

            // Bad: sleeping in loop
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                // empty catch
            }

            // Bad: unused object
            Object o = new Object();
        }
    }
}
