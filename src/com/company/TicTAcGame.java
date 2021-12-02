package com.company;

import java.util.Locale;
import java.util.Scanner;

public class TicTAcGame {

    static char[] board = new char[10];

    public static void main(String[] args){
        System.out.println("Welcome to TicTacToe Game");
        createBoard();
        playerChoice();
        showBoard();
    }
    public static void createBoard(){
        for (int i=0;i<board.length;i++){
            board[i]= ' ';
        }
    }
    public static void playerChoice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose X or O : ");
        char player = ((scanner.next().toUpperCase(Locale.ROOT)).charAt(0));
        char computerPlayer = ' ';

        if (player == 'X'){
            computerPlayer = 'O';
        }else{
            computerPlayer = 'X';
        }
    }
    public static void showBoard(){
        System.out.println(" "+board[1]+" | "+board[2]+" | "+board[3]);
        System.out.println("-----------");
        System.out.println(" "+board[4]+" | "+board[5]+" | "+board[6]);
        System.out.println("-----------");
        System.out.println(" "+board[7]+" | "+board[8]+" | "+board[9]);
    }
}