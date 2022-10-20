package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        System.out.println("Please provide your name");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();


    }
}
//zacząć od środka gry, czyli:
1) if (jeżeli user1 daje kamień, a user2 daje papier to kto wygrywa) - przejść przez wszystkie kombinacje
2) losowanie liczb Random (od 1 do 3), aby zasymulować działanie komputera
3) dopiero potem obudować to w Scanner i sout