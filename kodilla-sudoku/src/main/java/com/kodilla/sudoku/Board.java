package com.kodilla.sudoku;

public class Board {
    private int[][] board;
    public static final int GRID = 9;
    public static final int BLOCK = 3;

    public int[][] getBoard() {
        return board;
    }

    public void printBoard(int[][] board) {
        System.out.println("\n" + "==== solved board ====" );
        for (int row = 0; row < GRID; row++) {
            if (row % BLOCK == 0 && row !=0) {
                System.out.println(" - - - - - - - - - - -");
                for (int column = 0; column < GRID; column++) {
                    System.out.print(" ");
                    if (column % BLOCK == 0 && column != 0) {
                        System.out.print("| ");
                    }
                    System.out.print(board[row][column]);
                }
                System.out.println();
            }
            System.out.println("======================");
            }
        }
    }

