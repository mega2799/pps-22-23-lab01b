package e2.Model;

import e2.Pair;

public class CellImplementation implements Cell{
    
    Pair<Integer,Integer> position;

    Status status;

    public CellImplementation(Pair<Integer, Integer> position) {
        this.position = position;
        this.status = Status.DISARMED;
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "CellImplementation [position=" + position + ", status=" + status + "]";
    }

    @Override
    public void armMine() {
        this.status = Status.ARMED;
    }

    @Override
    public boolean isArmed() {
        return this.status.equals(Status.ARMED);
    }


}
