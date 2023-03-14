package e1;

import e1.Models.ChessUnit;

public class LogicKnight extends ChessUnit{

    public LogicKnight(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    public boolean cannotMove(Pair<Integer, Integer> whereTo) {
		return !(whereTo.getX()!=0 && whereTo.getY()!=0 && Math.abs(whereTo.getX())+Math.abs(whereTo.getY())==3);
    }

    @Override
    public Pair<Integer, Integer> changePosition(Pair<Integer, Integer> whereTo) {
        var go =
        new Pair<Integer,Integer>(
            whereTo.getY() - this.position.getY(),
            whereTo.getX() - this.position.getX());
       return go;
    }

}
