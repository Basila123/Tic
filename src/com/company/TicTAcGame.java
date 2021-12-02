package com.company;

import java.util.Locale;
import java.util.Scanner;

public class TicTAcGame {

    static char[] board = new char[10];
    static char player;
    static char computerPlayer;

    public static void main(String[] args){

        System.out.println("Welcome to TicTacToe Game");
        createBoard();
        playerChoice();
        showBoard();

        if (player == 'X'){
            computerPlayer = 'O';
        }else{
            computerPlayer = 'X';
        }
        while(true) {
            makeMove();
            showBoard();
        }
    }
    public static void createBoard(){
        for (int i=0;i<board.length;i++){
            board[i]= ' ';
        }
    }
    public static void playerChoice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose X or O : ");
        player = ((scanner.next().toUpperCase(Locale.ROOT)).charAt(0));
    }
    public static void showBoard(){
        System.out.println(" "+board[1]+" | "+board[2]+" | "+board[3]);
        System.out.println("-----------");
        System.out.println(" "+board[4]+" | "+board[5]+" | "+board[6]);
        System.out.println("-----------");
        System.out.println(" "+board[7]+" | "+board[8]+" | "+board[9]);
    }
    public static void makeMove(){
        System.out.println("Choose an index from 1 to 9 to write 'X': ");
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