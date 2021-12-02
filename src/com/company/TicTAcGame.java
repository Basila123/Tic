package com.company;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicTAcGame {
    static char[] board = new char[10];
    static char player;
    static char computerPlayer;
    static boolean won = false;

    public static void main(String[] args){
        System.out.println("Welcome to TicTacToe Game");
        createBoard();
        showBoard();
        playerChoice();
        showBoard();

        while(!won) {
            makeMove();
            showBoard();
        }
    }
    //Method for creating the game board
    public static void createBoard(){
        for (int i=0;i<board.length;i++){
            board[i]= ' ';
        }
    }
    //Method for choosing X or O by the user and also deciding who plays 1st.
    public static void playerChoice(){

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose X or O : ");
        player = ((scanner.next().toUpperCase(Locale.ROOT)).charAt(0));

        if (player == 'X'){
            computerPlayer = 'O';
        }else if (player == 'O'){
            computerPlayer = 'X';
        }
        int rand = random.nextInt(2);
        System.out.println(rand);
        if (rand == 0){
            System.out.println("Its Heads so Computer plays first.");
            board[random.nextInt(9)+1]=computerPlayer;
        }else {
            System.out.println("Its tails so You start 1st ");
            makeMove();
        }
    }
    //Method to show the game board
    public static void showBoard(){
        System.out.println(" "+board[1]+" | "+board[2]+" | "+board[3]);
        System.out.println("-----------");
        System.out.println(" "+board[4]+" | "+board[5]+" | "+board[6]);
        System.out.println("-----------");
        System.out.println(" "+board[7]+" | "+board[8]+" | "+board[9]);
    }
    //Method for user to make a move.
    public static void makeMove(){
        System.out.println("Choose an index from 1 to 9 to write: "+ player);
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        if (board[index]==' '){
            board[index]=player;
        }else{
            System.out.println("   ****** Choose an empty place! ******   ");
            System.out.println();
            makeMove();
        }
    }
}