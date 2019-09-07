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
public class LadderSquare extends SorLSquare {
    
    public LadderSquare(int number, int endSquare) {
        super(number, endSquare);
        if (number >= endSquare) {
            throw new IllegalArgumentException("number can't be smaller than endSquare");
        }
    }
    @Override
    public int landOn(){
        return super.landOn();
    }
    @Override
    public String toString(){
        return super.getNumber() + "+" + super.getEndSquare();
    }
    
}
