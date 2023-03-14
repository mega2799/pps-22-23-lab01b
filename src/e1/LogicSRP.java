package e1;

public class LogicSRP implements Logics {

    private LogicKnight logicKnight;
    private LogicPawn logicPawn;
    private int size;


    public LogicSRP(int guiSize) {
    	this.size = guiSize;
    }

    public LogicSRP(int guiSize, Pair<Integer, Integer> knight, Pair<Integer, Integer> pawn) {
    	this.size = guiSize;
        this.logicKnight = new LogicKnight(knight);
        this.logicPawn = new LogicPawn(pawn);
	}

	@Override
    public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
        System.out.println("Knight: " + this.logicKnight.moveUnit(new Pair<Integer,Integer>(row,col)).toString());
        System.out.println("Pawn: " + this.logicPawn.getPosition().toString());
        return this.logicKnight.moveUnit(new Pair<Integer,Integer>(row,col)).equals(this.logicPawn.getPosition());
    }

    @Override
    public boolean hasKnight(int row, int col) {
        throw new UnsupportedOperationException("Unimplemented method 'hasKnight'");
    }

    @Override
    public boolean hasPawn(int row, int col) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasPawn'");
    }
}