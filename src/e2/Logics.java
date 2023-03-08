package e2;

import java.util.List;
import java.util.Map;

public interface Logics {
    Map<Pair<Integer, Integer>, Boolean> getMineMap();

    int getActiveMines();

    int getCellClosestMines(Pair<Integer, Integer> steppedCell);
}
