package snakeandladdergame;
import java.lang.Math;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohamedamahmoud
 */
public class SnakesAndLadders {
    public static int NUM_PLAYERS;
    public static int NUM_SQUARES = 100;
    private SnLSquare[] board;
    private int[] players;
    private Dice dice;
     
    
    public SnakesAndLadders(){
        this(2);
    }
    
    public SnakesAndLadders(int nPlayers){
        NUM_PLAYERS = nPlayers;
        dice = new Dice();
        this.players = new int[NUM_PLAYERS];
        for (int i = 0; i < NUM_PLAYERS; i++) {
            players[i] = 1; 
        }
        this.board = new SnLSquare[NUM_SQUARES];
        for (int i = 0; i < NUM_SQUARES; i++) {
            this.board[i] = new SnLSquare(i+1);
        }
        this.board[3] = new LadderSquare(4, 14);
        this.board[8] = new LadderSquare(9, 31);
        this.board[19] = new LadderSquare(20, 38);
        this.board[27] = new LadderSquare(28, 84);
        this.board[39] = new LadderSquare(40, 59);
        this.board[62] = new LadderSquare(63, 81);  // setting the number and endSquare values to the start and 
        this.board[70] = new LadderSquare(71, 91);  // the end squares of all laders
        this.board[27] = new LadderSquare(28, 84);
        // same thing for snakes is done below
        this.board[16] = new SnakeSquare(17, 7);
        this.board[53] = new SnakeSquare(54, 34);
        this.board[61] = new SnakeSquare(62, 18);
        this.board[63] = new SnakeSquare(64, 60);
        this.board[86] = new SnakeSquare(87, 24);
        this.board[92] = new SnakeSquare(93, 73);
        this.board[94] = new SnakeSquare(95, 75);
        this.board[98] = new SnakeSquare(99, 78);
    }
    
    public boolean takeTurn(int player){
        int a = dice.roll();
        players[player] +=  a ;
        //players[player] = board[position].landOn();
        /*if (players[player] > 100) {
            players[player] = 200 - players[player];
        }*/
        if (players[player] > 100) {
            this.players[player] = 200 - this.players[player];
        }
        if (this.dice.hasDoubles() ) {
            return true;
        }
        return false;
    }
    
    public boolean isPlayerWinner(int player){
        return players[player] == 100;
    }
    public int getWinner() {
        for (int i = 0; i < NUM_PLAYERS; i++) {
            if (players[i] == 100) {
                return i;
            }
        }
        return -1;
    }
    
    public int getPlayerPosition(int player) {
        return players[player];
    }
    
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < board.length; i++) {
            result += "| " + board[i].toString() + " ";
            if ((i+1) % 10 == 0 && i != 0) {
                result += "\n";
            }
        }
        return result;
    }
    
    
    
    public String toStringCurrentPositions() {
        String result = "";
        for (int i = 0; i < players.length; i++) {
            result += i + ":" + players[i] + " ";
        }
        return result;
    }
    public static void main(String[] args) {
        SnakesAndLadders game = new SnakesAndLadders();
        System.out.println(game.toString());
        int a = 0;
        int arr[];
        while(game.getWinner() == -1 && a == 0){   // no winner 
            for (int i = 0; i < game.players.length; i++) {
                game.takeTurn(i);   // each player stars one by one 
                arr = game.dice.getDieValues();
                if (game.getPlayerPosition(i) == 100) {
                    System.out.print("player " + i + " rolled "  + arr[0 + arr[1]]);
                    System.out.println(game.getPlayerPosition(a));
                    a = 1;
                    break;
                }
                System.out.print("player " + i + " rolled ");
                System.out.println(arr[0] + arr[1]);
                System.out.println(game.toStringCurrentPositions());
                
                if (game.takeTurn(i)) {
                    game.takeTurn(i);
                    arr = game.dice.getDieValues();
                    System.out.print("player " + i + " rolled " );
                    System.out.println(arr[0] + arr[1]);
                    System.out.println(game.toStringCurrentPositions());
                }
                
                
            }
            
        }
        System.out.println("player " + game.getWinner() + " won");
                
  
    }  

}
