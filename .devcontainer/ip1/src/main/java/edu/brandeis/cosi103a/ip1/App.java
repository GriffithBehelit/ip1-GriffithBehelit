package edu.brandeis.cosi103a.ip1;
import java.util.Scanner;
import java.util.Random;

public class App 
{

    public static int rollDie(Random rng){
        return rng.nextInt(6) +1;
    }

    public static int takeTurn(Scanner scanner,Random rng){

        int value = rollDie(rng);
        System.out.println("You rolled: " + value);
    
        int rerollsUsed = 0;
    
        while (rerollsUsed < 2) {
            System.out.print("Re-roll? (y/n): ");
            String choice = scanner.nextLine().trim().toLowerCase();
    
            if (!choice.equals("y")) {
                break;
            }
    
            value = rollDie(rng);
            rerollsUsed++;
            System.out.println("You rolled: " + value);
        }
    
        System.out.println("Final value for this turn: " + value);
        return value;

    }

    public static void playGame(){

        Scanner scanner = new Scanner(System.in);
        Random rng = new Random();

        int player1Score = 0;
        int player2Score = 0;

        for (int turn = 1; turn <= 10; turn++) {
            System.out.println("\n--- Turn " + turn + " ---");

            System.out.println("Player 1's turn");
            player1Score += takeTurn(scanner, rng);
            System.out.println("Player 1 total score: " + player1Score);

            System.out.println("\nPlayer 2's turn");
            player2Score += takeTurn(scanner, rng);
            System.out.println("Player 2 total score: " + player2Score);
        }

        System.out.println("\n=== Final Scores ===");
        System.out.println("Player 1: " + player1Score);
        System.out.println("Player 2: " + player2Score);

        if (player1Score > player2Score) {
            System.out.println("Player 1 wins!");
        } else if (player2Score > player1Score) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();

    }
    public static void main( String[] args ){
        playGame();
    }
}

