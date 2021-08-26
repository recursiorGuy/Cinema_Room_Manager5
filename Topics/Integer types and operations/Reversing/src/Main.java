import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int b = scanner.nextInt();
        System.out.println((b % 10 * 100) + (((b / 10) % 10) * 10) + (b / 100));
    }
}
