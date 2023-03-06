package test;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import e1.Logics;
import e1.LogicsImpl;
import e1.Pair;

public class TestLogic1 {
    private Logics logics;
    private static final int GUI_SIZE = 5; 
    

    private final int nextHitX = 2; // -1
    private final int nextHitY = 2; // +2 
    public void init(){
        this.logics = new LogicsImpl(GUI_SIZE);
    }
    
    @Test
    public void outOfBoudThrows(){
        init();
        assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(GUI_SIZE + 1, GUI_SIZE));
    }


    public void initPosition(){
        this.logics = new LogicsImpl(GUI_SIZE, new Pair<Integer, Integer>(nextHitY, nextHitX), new Pair<Integer, Integer>(nextHitY + 2, nextHitX -1));
    }

    @Test
    public void pieceIsThere(){
        this.initPosition();
        assertTrue(logics.hasKnight(nextHitY, nextHitX));   
        assertTrue(logics.hasPawn(nextHitY + 2, nextHitX - 1));
    }

    @Test
    public void nextHit(){
        this.initPosition();
        assertTrue(logics.hit(nextHitY + 2, nextHitX -1 ));
    }


}
