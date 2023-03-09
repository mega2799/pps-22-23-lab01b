package e2.Model;

import e2.Pair;

public interface Cell {

    Pair<Integer, Integer> getPosition();

    Status getStatus();

    boolean isArmed();

    void armMine();


    Integer getHolderMines();

    void setHolderMines(Integer holderMines);

}
