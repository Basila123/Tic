package com.company;

public class TicTAcGame {

        public static void main(String[] args){
            System.out.println("Welcome to TicTacToe Game");
            createBoard();
        }
        public static void createBoard(){
            char[] board = new char[10];
            for (int i=0;i<board.length;i++){
                board[i]=' ';
            }
        }
    }

