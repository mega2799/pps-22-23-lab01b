package e1.Models;

import e1.Pair;

public abstract class ChessUnit {
    public Pair<Integer, Integer> position;

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    public Pair<Integer, Integer> moveUnit(Pair<Integer, Integer> whereTo){
       Pair<Integer, Integer> checkPosition = this.changePosition(whereTo);
       if(cannotMove(checkPosition)) throw new UnsupportedOperationException("You can't move there");
       System.out.println("BEFORE: " + this.position.toString());
       this.position = whereTo;
       System.out.println("AFTER: " + this.position.toString());
       return this.position;
    }

    public abstract boolean cannotMove(Pair<Integer, Integer> whereTo);

    public abstract Pair<Integer, Integer> changePosition(Pair<Integer, Integer> whereTo);

    public ChessUnit(Pair<Integer, Integer> position){
        this.position = position;
    }
}
