package e2;

import java.util.List;
import java.util.Map;

public interface Logics {
    Map<Pair<Integer, Integer>, Boolean> getMineMap();

    int getActiveMines();

    int getCellClosestNumOfMines(Pair<Integer, Integer> steppedCell);

    void step(Pair<Integer, Integer> steppedCell);

}
