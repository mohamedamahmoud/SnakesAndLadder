package snakeandladdergame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohamedamahmoud
 */
public class SorLSquare extends SnLSquare{
    private int endSquare;
    
    public SorLSquare(int number, int endSquare){
        super(number);
        this.endSquare = endSquare;
        if (endSquare == super.getNumber()) {
            throw new IllegalArgumentException("Can't be the same");
        }
    }
    public int getEndSquare(){
        return endSquare;
    }
    @Override
    public int landOn(){
        return this.endSquare;
    }
    @Override
    public String toString(){
        return super.toString() + ":" + this.endSquare;
    }
    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()){
            return false;
        }
        SorLSquare S = (SorLSquare)o;
        return (endSquare == S.endSquare && super.equals(S));
    }
    
}