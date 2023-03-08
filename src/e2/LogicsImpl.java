package e2;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LogicsImpl implements Logics {
    private int numOfMines; 
    private Map<Pair<Integer,Integer>, Boolean> mineMap;
    private int randomNumberBound;
    private int width, height;

    public LogicsImpl(final int numOfMines) {
        this.height = numOfMines;
        this.width = numOfMines;
        this.numOfMines = numOfMines;
        this.mineMap= IntStream.range(0, numOfMines)
                    .boxed()
                    .flatMap((dimension) -> IntStream.range(0, numOfMines)
                    .mapToObj((dimensionB) -> new Pair<>(dimension, dimensionB)))
                    .collect(Collectors.toMap(Function.identity(), pair -> false));
        this.randomNumberBound = (numOfMines * numOfMines) - 1;
        interrateMines(false);
    }

    private void interrateMines(boolean randomic) {
        if(randomic){
            for (int randomInt : 
                    new Random(new Date().getTime())
                    .ints(numOfMines, 0, randomNumberBound)
                    .distinct()
                    .boxed()
                    .collect(Collectors.toSet())) {
                        this.mineMap.replace(this.mineMap.keySet().stream().toList().get(randomInt), 
                        true);
     }
    }else{

        this.mineMap.replace(new Pair<>(0, 0), true);
    }
     System.out.println(mineMap);
    }

    @Override
    public Map<Pair<Integer, Integer>, Boolean> getMineMap() {
        return this.mineMap;
    }

    @Override
    public int getActiveMines() {
        // a long can contiain an int, so safe cast
        return (int)this.mineMap
        .values()
        .stream()
        .filter((isThereAMine)-> isThereAMine.equals(true))
        .count();
    }

    @Override
    public int getCellClosestMines(Pair<Integer, Integer> steppedCell) {
    int result = 0;
    Pair<Integer, Integer> min = new Pair<Integer,Integer>( 
        (steppedCell.getX() <= 0 ? 0 : steppedCell.getX() - 1),
        (steppedCell.getY() <= 0 ? 0 : steppedCell.getY() - 1));
    Pair<Integer, Integer> max = new Pair<Integer,Integer>(
      (steppedCell.getX() >= width - 1 ? width : steppedCell.getX() + 2),
      (steppedCell.getY() >= height - 1 ? height : steppedCell.getY() + 2));   
 
     // Check all immediate neighbours for mines
     for (int i = min.getX(); i < max.getX(); i++) {
       for (int j = min.getX(); j < max.getY(); j++) {
         if (this.mineMap.get(new Pair<>(i, j))) {
           result++;
         }
       }
     }
     return result;
    }

    
}
