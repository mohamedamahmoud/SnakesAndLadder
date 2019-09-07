/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladdergame;

/**
 *
 * @author mohamedamahmoud
 */
public class SnakeSquare extends SorLSquare {
    
    public SnakeSquare(int number, int endSquare) {
        super(number, endSquare);
         if (number <= endSquare) {
            throw new IllegalArgumentException("number can't be greater than endSquare");
        }
    }
    @Override
    public int landOn(){
        return super.landOn();
    }
    @Override
    public String toString(){
        return super.getNumber() + "-" + super.getEndSquare();
    }
    /*public static void main(String[] args) {
        SnakeSquare s = new SnakeSquare(80, 10);
        SnakeSquare m = new SnakeSquare(80, 11);
        SnakeSquare w = new SnakeSquare(80, 10);
        System.out.println(s.equals(m));
        System.out.println(s.equals(w));
    }*/ 
    //testing if equals method is needed. but even if it is not written it functions properly
}
