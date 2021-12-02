package com.company;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicTAcGame {
    static char[] board = new char[10];
    static char player;
    static char computerPlayer;
    static boolean won = false;
    static String line;
    static int turn;
    static int logic1Counter;
    static int emptySlots=9;
    static int winCount;

    public static void main(String[] args){
        System.out.println("Welcome to TicTacToe Game");
        createBoard();
        showBoard();
        playerChoice();
        showBoard();

        while(!won && emptySlots!=0) {
            if (turn==0) {
                computerMove();
                showBoard();
                winConditions();
                if (!won && emptySlots!=0) {
                    makeMove();
                    showBoard();
                    winConditions();
                }
            }
            else if (turn==1){
                makeMove();
                showBoard();
                winConditions();
                if (!won && emptySlots!=0) {
                    computerMove();
                    showBoard();
                    winConditions();
                }
            }
        }
        if (!won && emptySlots==0){
            System.out.println("Its a draw!");
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
            turn=0;
        }else {
            System.out.println("Its tails so You start 1st ");
            turn=1;
        }
    }
    //Method to show the game board
    public static void showBoard(){
        System.out.println(" "+board[1]+" | "+board[2]+" | "+board[3]);
        System.out.println("-----------");
        System.out.println(" "+board[4]+" | "+board[5]+" | "+board[6]);
        System.out.println("-----------");
        System.out.println(" "+board[7]+" | "+board[8]+" | "+board[9]);
        System.out.println("--------------------------------------------");
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
    //Method for computer to make a move
    public static void computerMove() {

        computerLogic();

        if (logic1Counter==0) {
            Random random = new Random();
            int index = random.nextInt(9) + 1;
            if (board[index] == ' ') {
                board[index] = computerPlayer;
            } else {
                computerMove();
            }
        }
    }
    //Methods of logic hierarchy for computerMove
    public static void computerLogic(){
        logic1Counter=0;
        if (logic1Counter==0) {
            logic1(1, 2, 3);
        }if (logic1Counter==0) {
            logic1(4, 5, 6);
        }if (logic1Counter==0) {
            logic1(7, 8, 9);
        }if (logic1Counter==0) {
            logic1(1, 4, 7);
        }if (logic1Counter==0) {
            logic1(2, 5, 8);
        }if (logic1Counter==0) {
            logic1(3, 6, 9);
        }if (logic1Counter==0) {
            logic1(1, 5, 9);
        }if (logic1Counter==0) {
            logic1(3, 5, 7);
        }
    }
    //Method for logic1 in UC8
    public static void logic1(int x,int y, int z){
        if (board[x]==computerPlayer || board[y]==computerPlayer || board[z]==computerPlayer){
            if (board[x]==board[y] && board[z]==' '){
                board[z]=computerPlayer;
                logic1Counter++;
            }else if (board[x]==board[z] && board[y]==' '){
                board[y]=computerPlayer;
                logic1Counter++;
            }else if (board[y]==board[z] && board[x]==' '){
                board[x]=computerPlayer;
                logic1Counter++;
            }
        }
    }
    //Method for checking if any player has won so far.
    public static void winConditions(){
        for (int a = 0; a < 8; a++) {

            winCount = 0;
            switch (a) {
                case 0:
                    line = String.valueOf(board[1]) + String.valueOf(board[2]) + String.valueOf(board[3]);
                    winCount++;
                    break;
                case 1:
                    line = String.valueOf(board[4]) + String.valueOf(board[5]) + String.valueOf(board[6]);
                    winCount++;
                    break;
                case 2:
                    line = String.valueOf(board[7]) + String.valueOf(board[8]) + String.valueOf(board[9]);
                    winCount++;
                    break;
                case 3:
                    line = String.valueOf(board[1]) + String.valueOf(board[4]) + String.valueOf(board[7]);
                    winCount++;
                    break;
                case 4:
                    line = String.valueOf(board[2]) + String.valueOf(board[5]) + String.valueOf(board[8]);
                    winCount++;
                    break;
                case 5:
                    line = String.valueOf(board[3]) + String.valueOf(board[6]) + String.valueOf(board[9]);
                    winCount++;
                    break;
                case 6:
                    line = String.valueOf(board[1]) + String.valueOf(board[5]) + String.valueOf(board[9]);
                    winCount++;
                    break;
                case 7:
                    line = String.valueOf(board[3]) + String.valueOf(board[5]) + String.valueOf(board[7]);
                    winCount++;
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                System.out.println("X has Won");
                won = true;
                break;
            }
            // For O winner
            else if (line.equals("OOO")) {
                System.out.println("O has Won");
                won = true;
                break;
            }
        }
        //Draw condition
        emptySlots = 0;
        for (int x=1;x< board.length;x++){
            if (board[x]==' '){
                emptySlots++;
            }
        }
    }
}