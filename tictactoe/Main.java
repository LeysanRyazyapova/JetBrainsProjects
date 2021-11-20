package tictactoe;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int wins = 0;
        int x_o = 0;
        char[][] array = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = ' ';
            }
        }
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print("  ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        while (wins == 0) {
            while (true) {
                System.out.print("Enter the coordinates: ");
                String coordinates = scanner.nextLine();
                String[] spCoor = coordinates.split(" ");
                String str = scanner.
                try {
                    x = Integer.parseInt(spCoor[0]);
                    y = Integer.parseInt(spCoor[1]);
                    if (x > 3 || x < 1 || y < 1 || y > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        continue;
                    }
                    if (array[x - 1][y - 1] != ' ') {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    } else {
                        if (x_o == 0) {
                            array[x - 1][y - 1] = 'X';
                            x_o++;
                        } else if (x_o == 1) {
                            array[x - 1][y - 1] = 'O';
                            x_o--;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                break;
            }
            if ((array[0][0] == 'X' && array[0][1] == 'X' && array[0][2] == 'X')
                    || (array[1][0] == 'X' && array[1][1] == 'X' && array[1][2] == 'X')
                    || (array[2][0] == 'X' && array[2][1] == 'X' && array[2][2] == 'X')
                    || (array[0][0] == 'X' && array[1][0] == 'X' && array[2][0] == 'X')
                    || (array[0][1] == 'X' && array[1][1] == 'X' && array[2][1] == 'X')
                    || (array[0][2] == 'X' && array[1][2] == 'X' && array[2][2] == 'X')
                    || (array[0][0] == 'X' && array[1][1] == 'X' && array[2][2] == 'X')
                    || (array[0][2] == 'X' && array[1][1] == 'X' && array[2][0] == 'X'))
                wins = 1;
            if ((array[0][0] == 'O' && array[0][1] == 'O' && array[0][2] == 'O')
                    || (array[1][0] == 'O' && array[1][1] == 'O' && array[1][2] == 'O')
                    || (array[2][0] == 'O' && array[2][1] == 'O' && array[2][2] == 'O')
                    || (array[0][0] == 'O' && array[1][0] == 'O' && array[2][0] == 'O')
                    || (array[0][1] == 'O' && array[1][1] == 'O' && array[2][1] == 'O')
                    || (array[0][2] == 'O' && array[1][2] == 'O' && array[2][2] == 'O')
                    || (array[0][0] == 'O' && array[1][1] == 'O' && array[2][2] == 'O')
                    || (array[0][2] == 'O' && array[1][1] == 'O' && array[2][0] == 'O')) {
                wins = 2;
            }
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");
            if (wins == 1)
                System.out.println("X wins");
            else if (wins == 2)
                System.out.println("O wins");
            else if (array[0][0] != ' ' && array[0][1] != ' ' && array[0][2] != ' '
            && array[1][0] != ' ' && array[1][1] != ' ' && array[1][2] != ' '
            && array[2][0] != ' ' && array[2][1] != ' ' && array[2][2] != ' ') {
                System.out.println("Draw");
                break;
            }

        }
    }
}
