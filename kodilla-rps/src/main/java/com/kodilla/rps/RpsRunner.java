package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {


    public static void main(String[] args) {
        boolean end = false;
        int nbOfWonRounds = 0;
        int nbOfLostRounds = 0;

        RPS game = new RPS();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide your name");
        String userName = scanner.nextLine();
        System.out.println("Welcome " + userName + "\n" + "How many won rounds do you want to play to win the game?");
        int nbOfRoundsToWin = scanner.nextInt();

        System.out.println("Game instruction:");
        System.out.println("""
                Press "1" key to choose "Rock"\s
                Press "2" key to choose "Paper"\s
                Press "3" key to choose "Scissors\"""");
        System.out.println("Press \"x\" key to end the game");
        System.out.println("Press \"n\" key to start new game");

        while (!end) {
            game.userChoice();
            String userAttribute = game.getUserAttribute();
            game.computerChoice();
            String computerAttribute = game.getComputerAttribute();
            System.out.println("Your move: " + userAttribute + " " + "Computer's move: " + computerAttribute);
            String result = game.gameResult();
            System.out.println(result);

            if (result.equals("You won")) {
                nbOfWonRounds = nbOfWonRounds + 1;
                if (nbOfWonRounds == nbOfRoundsToWin) {
                    System.out.println("Congratulations " + userName + "\n" + "You won the game");
                    System.out.println("Do you want to play again?");
                    if (scanner.nextLine().equals("n")) {
                        System.out.println("How many won rounds do you want to play to win the game?");
                        nbOfRoundsToWin = scanner.nextInt();
                        nbOfWonRounds = 0;
                    } else if (scanner.nextLine().equals("x")) {
                        end = true;
                    }
                }
            } else if (result.equals("You lost")) {
                nbOfLostRounds = nbOfLostRounds + 1;
                if (nbOfLostRounds == nbOfRoundsToWin) {
                    System.out.println("You lost the game ");
                    System.out.println("Do you want play again?");
                    if (scanner.next().equals("n")) {
                        System.out.println("How many won rounds do you want to play to win the game?");
                        nbOfRoundsToWin = scanner.nextInt();
                        nbOfLostRounds = 0;
                        scanner.nextLine();
                    } else if (scanner.next().equals("x")) {
                        end = true;
                    }
                }
            }
        }
    }
}

