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
    
    /** A number hundred.*/
    private final int hundred = 100;
    
    /** A score of the user.*/
    private int score;
    
    /** Scanner object.*/
    private Scanner scan;
    
    /** Random object.*/
    private Random generator;
    
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
        System.out.println("Welcome to the Games Program!"
                + "\nMake your choice (enter a number):"
                + "\n1. See your score"
                + "\n2. Guess a number"
                + "\n3. Play Rock, Paper, Scissors"
                + "\n4. Quit");
        System.out.print(">");
        int choice = scan.nextInt();
        
        if (choice == 1) {
            System.out.println("Your score is " + score);
            this.play();
        } else if (choice == 2) {
            this.guessANumber();
        } else if (choice == three) {
            this.rockPaperScissors();
        } else if (choice == four) {
            System.out.println("Game end.");
            
        } else if (choice > four || choice <= 0) {
            System.out.println("Invalid choice.");
            this.play();
        }
    }
    
    /**
     * Sets the guess a number game.
     */
    public void guessANumber() {
        int answer = generator.nextInt(hundred);
        System.out.println("I've picked a random number between "
                + "0 and 100"
                + "\nCan you guess it?"
                + "\nGuess the number!");
        int input = scan.nextInt();
        while (input > 0 && input < hundred) {
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
                System.out.println("RIGHT!\nFive points!");
                score = score + five;
                break;
            }
        }
        this.play();
    }
    
    /**
     * Sets a rock paper scissors game.
     */
    public void rockPaperScissors() {
        int a = generator.nextInt(2);
        System.out.println("I've picked one of ROCK, PAPER, AND SCISSORS"
                + "\nWhich one do you choose?");
        String choice = scan.next();
        int rep = 0;
        while (choice.equals(choice)) {
            if (choice.toLowerCase().equals("rock")) {
                rep = 0;
                break;
            } else if (choice.toLowerCase().equals("paper")) {
                rep = 1;
                break;
            } else if (choice.toLowerCase().equals("scissors")) {
                rep = 2;
                break;
            } else {
                System.out.println("Invalid chocie! Try again!");
                choice = scan.next();
            }
        }
        if (rep == a) {
            System.out.println("Tied!\nSocre doesn't change.");
        } else if (rep == 2 && a == 0 || rep == (a - 1)) {
            System.out.println("You loose! Take 3 points from you score.");
            score = score - three;
        } else if (rep == 0 && a == 2 || rep == (a + 1)) {
            System.out.println("You win! Add 5 points on your score.");
            score = score + five;
        }
        this.play();
    }
}
