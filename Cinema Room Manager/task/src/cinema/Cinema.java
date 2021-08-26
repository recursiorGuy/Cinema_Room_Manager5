package cinema;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.lang.Math.round;

public class Cinema {

    static int numTickets = 0;
    static int totalTickets = 0;
    static int currentIncome = 0;
    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();
        totalTickets = row * seatsPerRow;

        char seatArray[][] = new char[row + 1][seatsPerRow + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= seatsPerRow; j++) {
                seatArray[i][j] = 'S';
            }
        }
        int choice = 1;
        int totalPrice =0;
        System.out.println();
        int seats = row * seatsPerRow;
        int price;
        if (seats <= 60) {
            totalPrice= 10*totalTickets;
        } else {
            totalPrice = (10*(row/2)*seatsPerRow)+ (8*(row-(row/2))*seatsPerRow);


        }
        while (choice != 0) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showSeats(seatArray, seatsPerRow, row);
                    break;
                case 2:
                    seatArray=buyTicket(seatArray, seatsPerRow, row);
                    break;
                case 3:
                    stats(seatArray, totalPrice);
            }
        }

    }
    public static void stats(char seatArray[][], int totalPrice){
//        System.out.println(((double)numTickets/(double)totalTickets));
        System.out.println("Number of purchased tickets: " + numTickets);
        double per = ((double)((double)numTickets/(double)totalTickets)*100);
        System.out.printf("Percentage: %.2f%% %n", per );

        System.out.println("Current Income: $" + currentIncome);
        System.out.println("Total Income: $" + totalPrice);

    }
    public static void showSeats(char seatArray[][], int seatsPerRow,int row){
        System.out.print("Cinema:");
        System.out.print("  ");
        for (int i=1; i<=seatsPerRow; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i=1; i<=row; i++){
            System.out.print(i + " ");
            for (int j=1; j<=seatsPerRow; j++){
                System.out.print(seatArray[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static char[][] buyTicket(char seatArray[][], int seatsPerRow,int row){
        Scanner scanner = new Scanner(System.in);
        int rowNo,SeatNo,ticketFlag=0;
        do{
            System.out.println("Enter a row number:");
             rowNo = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            SeatNo = scanner.nextInt();
            if(rowNo > row || SeatNo > seatsPerRow){
                System.out.println("Wrong input!");
            }else if (seatArray[rowNo][SeatNo] == 'B'){
                System.out.println("That ticket has already been purchased!");
            } else {


                    int seats = row * seatsPerRow;
                    int price;
                    if (seats <= 60) {
                        price = 10;
                    } else {
//            if(row %2 == 1){
                        if (rowNo <= row / 2)
                            price = 10;
                        else price = 8;
//            }
//                price = ((row/2) * 10 * seatsPerRow) + (((row/2)+1)*8 * seatsPerRow);
//            else price = ((row/2) * 10 * seatsPerRow) + ((row/2)*8 * seatsPerRow);;
                    }
                    ticketFlag =1;
                    numTickets ++;
                    currentIncome = price+currentIncome;
                    System.out.printf("Ticket Price $%d\n", price);
                    seatArray[rowNo][SeatNo] = 'B';
                }

        } while (ticketFlag == 0);
        return seatArray;



//        showSeats(seatArray, seatsPerRow, row);
//        System.out.print("Cinema:");
//        System.out.print("  ");
//        for (int i=1; i<=seatsPerRow; i++){
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        for (int i=1; i<=row; i++){
//            System.out.print(i + " ");
//            for (int j=1; j<=seatsPerRow; j++){
//                System.out.print(seatArray[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
}