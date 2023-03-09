package e2;

import java.util.List;
import java.util.Map;

import e2.Model.Cell;

public interface Logics {
    Map<Pair<Integer, Integer>, Boolean> getMineMap();

    int getActiveMines();

    int getCellClosestNumOfMines(Pair<Integer, Integer> steppedCell);

    Boolean step(Pair<Integer, Integer> steppedCell);

    Cell getCellFromPosition(Pair<Integer, Integer> from);

}
