package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RPS {
    private int userChoice;
    private int computerChoice;
    private String userAttribute;
    private String computerAttribute;

    public String getUserAttribute() {
        return userAttribute;
    }

    public String getComputerAttribute() {
        return computerAttribute;
    }

    public void userChoice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nChoose your move:");
        userChoice = scan.nextInt();
        if (userChoice == 1) {
            userAttribute = "Rock";
        } else if (userChoice == 2) {
            userAttribute = "Paper";
        } else if (userChoice == 3) {
            userAttribute = "Scissors";
        } else {
            System.out.println("Please choose a number from 1 to 3");
        }
    }

    public void computerChoice() {
        Random random = new Random();

        while (computerChoice == 0) {
            computerChoice = random.nextInt(4);
        }
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
        } else if (userChoice == 1 && computerChoice == 2 || userChoice == 2 && computerChoice == 3 || userChoice == 3 && computerChoice == 1) {
            gameResult = "You lost";
        } else if (userChoice == 2 && computerChoice == 1 || userChoice == 3 && computerChoice == 2 || userChoice == 1 && computerChoice == 3) {
            gameResult = "You won";
        }
        return gameResult;
    }
}
