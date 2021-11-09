package ca.bcit.comp1510.lab08;

import java.util.Scanner;
import java.util.Random;

/**
 * Represents the game's menu, a guess number game and rock paper scissors game.
 * @author Jason(Junsang) Yoo
 * @version 2021
 */
public class Games {
    /** A number four.*/
    private final int four = 4;
    
    /** A number three.*/
    private final int three = 3;
    
    /** A number five.*/
    private final int five = 5;
    
    /** A score of the user.*/
    private int score;
    
    /** Scanner object.*/
    private Scanner scan = new Scanner(System.in);
    
    /** Random object.*/
    private Random generator = new Random();
    
    /**
     * Constructor sets the initial score to 0 and
     * instantiates the Scanner and random object.
     * */
    public Games() {
        score = 0;
        scan = new Scanner(System.in);
        generator = new Random(); 
    }
    
    /**
     * Sets the game menu.
     */
    public void play() {
        boolean programRe = true;
        
        while (programRe) {
            System.out.println("Welcome to the Games Program!"
                    + "\nMake your choice (enter a number):"
                    + "\n1. See your score"
                    + "\n2. Guess a number"
                    + "\n3. Play Rock, Paper, Scissors"
                    + "\n4. Quit");
            System.out.print(">");
            
            int choice = scan.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Your score is " + score);
                    break;
                case 2:
                    guessANumber();
                    break;
                case three:
                    rockPaperScissors();
                    break;
                case four:
                    programRe = false;
                    break;
                default:
                    System.out.println("Invalid chocie.");
            }
        }
        
        
    }
    
    /**
     * Sets the guess a number game.
     */
    public void guessANumber() {
        final int range = 101;
        int answer = generator.nextInt(range);
        System.out.println("I've picked a random number between "
                + "0 and 100"
                + "\nCan you guess it?"
                + "\nGuess the number!");
        int input = scan.nextInt();
        while (input > 0 && input < range) {
            while (answer < input) {
                System.out.println("Too high, guess again!"
                        + "\nGuess the number!");
                input = scan.nextInt();
            }
            while (answer > input) {
                System.out.println("Too low, guess again!"
                        + "\nGuess the number!");
                input = scan.nextInt();
            }
            if (answer == input) {
                System.out.println("RIGHT!");
                break;
            }
        }
    }
    
    /**
     * Sets a rock paper scissors game.
     */
    public void rockPaperScissors() {
        int a = generator.nextInt(three);
        
        System.out.println("I've picked one of ROCK, PAPER, AND SCISSORS"
                + "\nWhich one do you choose?");
        
        String choice = scan.next();
        choice.toLowerCase();
        
        boolean programReturn = true;
        
        while (programReturn) {
            
            switch (choice) {
            
                case "rock":
                    if (a == 0) {
                        System.out.println("Tied!");
                    }
                    if (a == 1) {
                        System.out.println("I've picked paper!"
                                + "\nYou loose!\n-3 points!");
                        score = score - three;
                    }
                    if (a == 2) {
                        System.out.println("I've picked scissors!"
                                + "You win!\n+5points!");
                        score = score + five;
                    }
                    programReturn = false;
                    break;
                    
                case "paper":
                    if (a == 0) {
                        System.out.println("I've picked rock!"
                                + "\nYou win!\n+5 points!");
                        score = score + five;
                    }
                    if (a == 1) {
                        System.out.println("Tied!");
                    }
                    if (a == 2) {
                        System.out.println("I've picked scissors!"
                               + "\nYou loose!\n-3 points!"); 
                        score = score - three;
                    }
                    programReturn = false;
                    break;
                    
                case "scissors":
                    if (a == 0) {
                        System.out.println("I've picked rock!"
                                + "\nYou loose!\n-3points");
                        score = score - three;
                    }
                    if (a == 1) {
                        System.out.println("I've picked paper!"
                                + "\nYou win!\n+5 points");
                        score = score + five;
                    }
                    if (a == 2) {
                        System.out.println("Tied!");
                    }
                    programReturn = false;
                    break;
                    
                default:
                    System.out.println("Invalid choice! Try again!");
                    choice = scan.next();
            }
        }
    }
}
