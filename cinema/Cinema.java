package cinema;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentPrice = 0;
        int totalIncome = 0;
        int count = 0;
        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        int rowCount = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        int seatsCount = scanner.nextInt();
        char[][] array = new char[rowCount][seatsCount];
        boolean flag = true;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < seatsCount; j++) {
                array[i][j] = 'S';
            }
        }
        while (flag) {
            System.out.println("\n1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.print("> ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    printSeats(array);
                    break;
                case 2:
                    currentPrice += buyTicket(array);
                    count++;
                    break;
                case 3:
                    totalIncome = countTotalIncome(array);
                    System.out.println("\nNumber of purchased tickets: " + count);
                    double percent = ((double)count * 100.0) / ((double) rowCount * (double) seatsCount);
                    System.out.println(String.format("Percentage: %.2f%%", percent));
                    System.out.println("Current income: $" + currentPrice);
                    System.out.println("Total income: $" + totalIncome);
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }
    public static int countTotalIncome(char[][] array) {
        if (array.length * array[0].length <= 60)
            return array.length * array[0].length * 10;
        else {
            return (array.length / 2) * array[0].length * 10 + (int)Math.ceil((double)array.length / 2) * array[0].length * 8;
        }
    }
    public static void printSeats(char[][] array) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < array[0].length; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == 0)
                    System.out.print((i + 1) +" " + array[i][j] + " ");
                else
                    System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static int buyTicket(char[][] array) {
        Scanner scanner = new Scanner(System.in);
        int price = 0;
        while(true) {
            System.out.println("Enter a row number:");
            System.out.print("> ");
            int row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            System.out.print("> ");
            int seat = scanner.nextInt();
            if (row > 0 && seat > 0 && row <= array.length
                    && seat <= array[0].length && array[row - 1][seat - 1] == 'S') {
                if (array.length * array[0].length <= 60)
                    price = 10;
                else {
                    if (row > (array.length / 2))
                        price = 8;
                    else
                        price = 10;
                }
                System.out.println("Ticket price: $" + price);
                array[row - 1][seat - 1] = 'B';
                return price;
            } else {
                if (row > 0 && seat > 0 && row <= array.length
                        && seat <= array[0].length && array[row - 1][seat - 1] == 'B')
                    System.out.println("\nThat ticket has already been purchased");
                else
                    System.out.println("\nWrong input!\n");
                continue;
            }
        }
    }
        // Write your code here
}