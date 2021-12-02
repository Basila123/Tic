package com.company;

public class TicTAcGame {

       import java.util.Locale;
import java.util.Scanner;

    public class TicTacToeGame {
        public static void main(String[] args){
            System.out.println("Welcome to TicTacToe Game");
            createBoard();
            playerChoice();
        }
        public static void createBoard(){
            char[] board = new char[10];
            for (int i=0;i<board.length;i++){
                board[i]=' ';
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
            System.out.println("player choice is: "+player+" computer choice is: "+ computerPlayer);
        }
    }
    }

