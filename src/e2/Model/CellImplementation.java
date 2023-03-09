package e2.Model;

import e2.Pair;

public class CellImplementation implements Cell{
    
    Pair<Integer,Integer> position;

    Status status;

    int holderMines;

    public Integer getHolderMines() {
        return holderMines;
    }

    public void setHolderMines(Integer holderMines) {
        this.holderMines = holderMines;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + holderMines;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CellImplementation other = (CellImplementation) obj;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        if (status != other.status)
            return false;
        if (holderMines != other.holderMines)
            return false;
        return true;
    }

    public CellImplementation(Pair<Integer, Integer> position) {
        this.position = position;
        this.status = Status.DISARMED;
        this.holderMines = -1;
    }


    public CellImplementation(Pair<Integer, Integer> position, Status status, int holderMines) {
        this.position = position;
        this.status = status;
        this.holderMines = holderMines;
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public void armMine() {
        this.status = Status.ARMED;
    }

    @Override
    public boolean isArmed() {
        return this.status.equals(Status.ARMED);
    }

    @Override
    public String toString() {
        return "CellImplementation [position=" + position + ", status=" + status + ", holderMines=" + holderMines + "]";
    }


}
