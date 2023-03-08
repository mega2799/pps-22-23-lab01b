package test.e2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.stream.Collector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import e2.Logics;
import e2.LogicsImpl;
import e2.Pair;

public class SetupTesting {
    private static final int MINES = 7;
    private Logics setupLogic;

    @BeforeEach
    public void init(){
        setupLogic = new LogicsImpl(MINES);
    }

    @Test
    public void checkNumberOfMines(){
        assertEquals(MINES, this.setupLogic.getActiveMines());
    } 

    @Test
    public void randomIsOff(){
        assertEquals(1, this.setupLogic.getActiveMines());
    }
    
    @Test
    public void checkAdjacentCells(){
        this.randomIsOff(); // im sure is off
        assertEquals(1, this.setupLogic.getCellClosestMines(new Pair<Integer,Integer>(0,1)));
    }
}
