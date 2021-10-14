import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("To find the root of the equation: ln(7,622x) + 8,59x + 0,5 = 0:");
        Scanner scanner = new Scanner(System.in);
        final float MAX_E = 1, MIN_E = 0.000030518509476F, MAX_X = 10, MIN_X = 1;
        boolean isInCorrect;
        double e = 1, currentX = 1, previousX;
        do {
            isInCorrect = false;
            System.out.print("Enter epsilon: ");
            try {
                e = Double.parseDouble(scanner.nextLine());
            } catch (Exception ex) {
                System.out.println("Integer expected. Repeat the input");
                isInCorrect = true;
            }
            if (!isInCorrect && e < MIN_E) {
                System.out.println("Your number is too small. Input number bigger than " + MIN_E + ". Repeat the input");
                isInCorrect = true;
            }
            if (!isInCorrect && e > MAX_E) {
                System.out.println("Your number is too big. Input number smaller than " + MAX_E + ". Repeat the input");
                isInCorrect = true;
            }
        } while (isInCorrect);

        do {
            isInCorrect = false;
            System.out.print("Enter start value: ");
            try {
                currentX = Double.parseDouble(scanner.nextLine());
            } catch (Exception ex) {
                System.out.println("Integer expected. Repeat the input");
                isInCorrect = true;
            }
            if (!isInCorrect && currentX < MIN_X) {
                System.out.println("Your number is too small. Input number bigger than " + MIN_X + ". Repeat the input");
                isInCorrect = true;
            }
            if (!isInCorrect && currentX > MAX_X) {
                System.out.println("Your number is too big. Input number smaller than " + MAX_X + ". Repeat the input");
                isInCorrect = true;
            }
        } while (isInCorrect);

        do {
            System.out.println(String.format("Current X: %.3f", currentX));
            previousX = currentX;
            currentX = Math.exp(-0.5 - 8.59 * currentX) / 7.622;
        } while (Math.abs(currentX - previousX) > e);

        System.out.println(String.format("The root of the equation ln(7,622x) + 8,59x + 0,5 = 0 \nx = %.3f", currentX));
    }
}
