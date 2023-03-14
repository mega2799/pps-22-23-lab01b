package e1;

import e1.Models.ChessUnit;

public class LogicPawn extends ChessUnit {

    public LogicPawn(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    public boolean cannotMove(Pair<Integer, Integer> whereTo) {
        throw new UnsupportedOperationException("Unimplemented method 'cannotMove'");
    }

    @Override
    public Pair<Integer, Integer> changePosition(Pair<Integer, Integer> whereTo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changePosition'");
    }

}
