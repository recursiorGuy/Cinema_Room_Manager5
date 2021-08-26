import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int sum = 0;
        while(num % 10 != 0 || num >0){

            sum = sum+(num%10);
            num =num/10;
        }
        System.out.print(sum);
        // put your code here
    }
}