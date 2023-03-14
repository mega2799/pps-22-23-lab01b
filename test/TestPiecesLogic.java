package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import e1.LogicSRP;
import e1.Logics;
import e1.Pair;

public class TestPiecesLogic implements TestLogic{
    private Logics logics;
    private static final int GUI_SIZE = 10; 


    private final int nextHitX = 2; // -1
    private final int nextHitY = 2; // +2 

    @Test
    @Override
    public void init() {
        this.logics = new LogicSRP(GUI_SIZE);
    }

    @Test
    @Override
    public void outOfBoudThrows() {
        initPosition();
        assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(GUI_SIZE + 1, GUI_SIZE));
    }

    @Test
    public void knightMoveNoHit(){
        initPosition();
        Pair<Integer, Integer> positionWhereTo = new Pair<Integer,Integer>(2, 1);
        //assertDoesNotThrow(() -> logics.hit(positionWhereTo.getY(), positionWhereTo.getX()));
        assertFalse(this.logics.hit(positionWhereTo.getY(), positionWhereTo.getX()));
    }

    @Test
    @Override
    public void initPosition() {
        this.logics = new LogicSRP(GUI_SIZE, new Pair<Integer, Integer>(2, 2), new Pair<Integer, Integer>(1, 1));
    }

    @Override
    public void pieceIsThere() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pieceIsThere'");
    }

    @Test
    @Override
    public void nextHit() {
        initPosition();
        //Pair<Integer, Integer> positionWhereTo = new Pair<Integer,Integer>(4, 3);
        assertFalse(this.logics.hit(3, 0));
        Pair<Integer, Integer> nextHit = new Pair<Integer,Integer>(1, 1);
        assertTrue(this.logics.hit(nextHit.getY(), nextHit.getX()));
    }
    
}
