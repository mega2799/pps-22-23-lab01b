package e2;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import e2.Model.Cell;
import e2.Model.CellImplementation;


public class LogicsImpl implements Logics {
    private int numOfMines; 
    private Map<Pair<Integer,Integer>, Boolean> mineMap;
    private List<Cell> cellsList;
    private int randomNumberBound;
    private int width, height;

    public LogicsImpl(final int numOfMines) {
        this.height = numOfMines;
        this.width = numOfMines;
        this.numOfMines = numOfMines;
        this.cellsList = IntStream.range(0, numOfMines)
                .boxed()
                .flatMap((dimension) -> IntStream.range(0, numOfMines)
                .mapToObj((dimensionB) -> new CellImplementation(new Pair<>(dimension, dimensionB))))
                .collect(Collectors.toList());
        this.randomNumberBound = (numOfMines * numOfMines) - 1;
        interrateMines(true);
    }

    private void interrateMines(boolean randomic) {

        if(randomic){
            List<Integer> randomator = IntStream
            .range(0, numOfMines * numOfMines)
            .boxed()
            .collect(Collectors.toList());
            Collections.shuffle(randomator);

            for (int randomInt : 
            randomator.stream()
            .limit(numOfMines)
            .collect(Collectors.toList())
                    ) {
                        this.cellsList.get(randomInt).armMine();
     }
    }else{
        this.cellsList.get(0).armMine();
    }
    }

    @Override
    public Map<Pair<Integer, Integer>, Boolean> getMineMap() {
        return this.mineMap;
    }

    @Override
    public int getActiveMines() {
        // a long can contiain an int, so safe cast
        return (int)this.cellsList
        .stream()
        .filter((cell)-> cell.isArmed())
        .count();
    }

    @Override
    public int getCellClosestNumOfMines(Pair<Integer, Integer> steppedCell) {
    return this.adjacentCells(steppedCell)
    .stream()
    .filter((pair) -> this.cellsList.stream().filter((cell) -> cell.getPosition().equals(pair)).anyMatch((adjacent) -> adjacent.isArmed()))
    .collect(Collectors.counting()).intValue();
    }

    private List<Pair<Integer, Integer>> adjacentCells(Pair<Integer, Integer> steppedCell) {
        List<Pair<Integer, Integer>> adjacentCells = new ArrayList<>();
        Pair<Integer, Integer> min = new Pair<Integer,Integer>( 
            (steppedCell.getX() <= 0 ? 0 : steppedCell.getX() - 1),
            (steppedCell.getY() <= 0 ? 0 : steppedCell.getY() - 1));
        Pair<Integer, Integer> max = new Pair<Integer,Integer>(
          (steppedCell.getX() == width - 1 ? width - 1: steppedCell.getX() + 1),
          (steppedCell.getY() == height - 1 ? height - 1: steppedCell.getY() + 1));   


         // Check all immediate neighbours for mines
         for (int i = min.getX(); i <= max.getX(); i++) {
           for (int j = min.getY(); j <= max.getY(); j++) {
             adjacentCells.add(new Pair<>(i, j));
           }
         }

         return adjacentCells;
    }

    @Override
    public Boolean step(Pair<Integer, Integer> steppedCell) {
        List<Pair<Integer, Integer>> adjacentCells = this.adjacentCells(steppedCell);
        int minesAround = this.getCellClosestNumOfMines(steppedCell);
        Cell effectiveSteppedCell = this.getCellFromPosition(steppedCell);
        if(effectiveSteppedCell.isArmed()) return true;
        this.getCellFromPosition(steppedCell).setHolderMines(minesAround);
        if(minesAround == 0 && effectiveSteppedCell.getHolderMines() != -1){
            for (Pair<Integer,Integer> pair : adjacentCells) {
                this.step(pair);
            }
            // adjacentCells.forEach((cell) -> this.step(cell));
        }
        return false;
    }

    @Override
    public Cell getCellFromPosition(Pair<Integer, Integer> from) {
        Iterator<Cell> iterator = this.cellsList.iterator();
            while(iterator.hasNext()){
                Cell current = iterator.next();
                if(current.getPosition().equals(from)){
                    return current;
                }
            }
            return null;
    }

}
