package cinema;
import java.util.Scanner;
public class Cinema {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask input for rows and seats
        System.out.println("Enter the number of rows: ");
        int numRows = scanner.nextInt(); // chosen amount of rows in the cinema
        System.out.println("Enter the number of seats in each row: ");
        int numSeats = scanner.nextInt(); // chosen amount of seats in the cinema

        // declare & initialize variables
        int totalSeats = numSeats * numRows; // total amount of seats depending on input
        int pricePerSeat = 0; // price per seat depending on row
        int amountBought = 0; // amount of tickets bought by user
        double totalOnePercent = (double) totalSeats / 100; // calculate 1 % of total tickets
        double percentage = 0; // how much % the bought seats are from the total amount available
        int earnings = 0; // total earnings depending on prices and seats chosen
        int totalIncome = 0; // total amount of income possible for the selected amount of total seats available

        // Display user choice menu
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int actionChosen = scanner.nextInt(); // user input = chosen action
        System.out.println();

        // Create array of seats and rows and assigning value 'S'.
        char[][] seats = new char[numRows][numSeats]; // array [7][8] 7 rows with each 8 seats
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numSeats; j++) {
                seats[i][j] = 'S';
            }
        }
        // if action chosen is 0, quit program
        if (actionChosen == 0) {
            System.out.println("Exit");
        }

        // create while loop as long as the chosen action is not 0 and not higher than the options available (1-3)
        while (actionChosen != 0) {

            // if action chosen is 1, print array seats (print the cinema seats + rows)
            if (actionChosen == 1) {
                System.out.print("Cinema:\n  ");


                for (int i = 0; i < numSeats; i++) {
                    System.out.print(i + 1 + " ");

                }
                System.out.println();

                for (int i = 0; i < numRows; i++) {
                    System.out.print(i + 1 + " ");
                    for (int j = 0; j < numSeats; j++) {
                        System.out.print(seats[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            // if action chosen is 2, allow user to buy a ticket
            } else if (actionChosen == 2) {
                System.out.println("Enter a row number:");
                int chosenRow = scanner.nextInt();
                System.out.println("Enter a seat number in that row:");
                int chosenSeat = scanner.nextInt();
                if (chosenSeat <= numSeats && chosenRow <= numRows) {
                    if (seats[chosenRow - 1][chosenSeat - 1] == 'S'){
                        seats[chosenRow - 1][chosenSeat - 1] = 'B'; // the bought seat becomes 'B' instead of 'S' in printed cinema

                        // if the cinema has equal or less than 60 seats, the price is $10
                        if (totalSeats <= 60 && chosenSeat <= numSeats && chosenRow <= numRows) {
                            pricePerSeat = 10;
                            System.out.println("Ticket price: $" + pricePerSeat);
                            System.out.println();
                            amountBought++; // add one ticket bought to the total amount bought tickets
                            percentage = totalOnePercent * amountBought; // calculate how much % of tickets has been bought
                            earnings += pricePerSeat; // add 1 bought ticket price to the total earnings
                            totalIncome = pricePerSeat * amountBought; // calculate maximum possible income depending on chosen cinema size

                        // if cinema has more than 60 seats, the back half of rows cost $8 per seat
                        } else if (totalSeats > 60 && chosenSeat <= numSeats && chosenRow <= numRows && chosenRow > (numRows / 2)) {
                            pricePerSeat = 8;
                            System.out.println("Ticket price: $" + pricePerSeat);
                            System.out.println();
                            amountBought++; // add one ticket bought to the total amount bought tickets
                            percentage = totalOnePercent * amountBought; // calculate how much % of tickets has been bought
                            earnings += pricePerSeat; // add 1 bought ticket price to the total earnings
                            totalIncome = pricePerSeat * amountBought; // calculate maximum possible income depending on chosen cinema size


                        // if cinema has more than 60 seats, the front half of rows cost $10 per seat
                        } else if (totalSeats > 60 && chosenSeat <= numSeats && chosenRow <= numRows && chosenRow <= (numRows / 2)) {
                            pricePerSeat = 10;
                            System.out.println("Ticket price: $" + pricePerSeat);
                            System.out.println();
                            amountBought++; // add one ticket bought to the total amount bought tickets
                            percentage = totalOnePercent * amountBought; // calculate how much % of tickets has been bought
                            earnings += pricePerSeat; // add 1 bought ticket price to the total earnings
                            totalIncome = pricePerSeat * amountBought; // calculate maximum possible income depending on chosen cinema size

                        }
                    } else if (seats[chosenRow - 1][chosenSeat - 1] == 'B') {
                        System.out.println("That ticket has already been purchased!");


                    }
                } else if (chosenSeat > numSeats || chosenRow > numRows) {
                    System.out.println("Wrong input!");

                }
                // if action chosen is 3, show statistics
            } else if (actionChosen == 3) {
                System.out.println("Number of purchased tickets: " + amountBought);
                System.out.println("Percentage: " + percentage );
                System.out.println("Current income: " + earnings );
                System.out.println("Total income: " + totalIncome);
            }
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            actionChosen = scanner.nextInt();
        }
    }
}