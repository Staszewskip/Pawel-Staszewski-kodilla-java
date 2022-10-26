package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RPS {
    private int userChoice;
    private int computerChoice;
    private String userAttribute;
    private String computerAttribute;

    public int getUserChoice() {
        return userChoice;
    }

    public int getComputerChoice() {
        return computerChoice;
    }

    public void userChoice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nChoose your move:");
        userChoice = scan.nextInt();
        while (userChoice > 0 && userChoice <= 3) {
            if (userChoice == 1) {
                userAttribute = "Rock";
            } else if (userChoice == 2) {
                userAttribute = "Paper";
            } else {
                userAttribute = "Scissors";
            }
        }
    }
    public void computerChoice() {
        Random random = new Random();
        computerChoice = random.nextInt(4);
        if (computerChoice == 1) {
            computerAttribute = "Rock";
        } else if (computerChoice == 2) {
            computerAttribute = "Paper";
        } else {
            computerAttribute = "Scissors";
        }
    }
    public String gameResult() {
        String gameResult = "";
        if (userChoice == computerChoice) {
            gameResult = "Draw";
        }   else if (userChoice == 1 && computerChoice == 2 || userChoice == 2 && computerChoice == 3 || userChoice == 3 && computerChoice == 1) {
            gameResult = "You lost";
        } else if (userChoice == 2 && computerChoice == 1 || userChoice == 3 && computerChoice == 2 || userChoice == 1 && computerChoice == 3) {
            gameResult = "You won";
        }
        return gameResult;
    }
}
