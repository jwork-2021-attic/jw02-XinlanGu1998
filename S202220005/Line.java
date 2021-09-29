package S202220005;

public class Line {

    public int length;

    public Line(int length) {
        this.positions = new Position[length];
        this.length = length;
    }

    private Position[] positions;

    public void putRandomly(Linable linable){
        int i = (int) (Math.random()*length); 
        while (this.positions[i] != null){
            i = (i+1)%length;
        }
        this.positions[i] = new Position(linable);
    }

    public void put(Linable linable, int i) {
        if (this.positions[i] == null) {
            this.positions[i] = new Position(null);
        }
        this.positions[i].setLinable(linable);
    }

    public Linable get(int i) {
        if ((i < 0) || (i > positions.length)) {
            return null;
        } else {
            return positions[i].linable;
        }
    }

    class Position {

        private Linable linable;

        Position(Linable linable) {
            this.linable = linable;
            linable.setPosition(this);
        }

        public void setLinable(Linable linable) {
            this.linable = linable;
            linable.setPosition(this);
        }

    }

    @Override
    public String toString() {
        String lineString = "\t";
        for (Position p : positions) {
            lineString += p.linable.toString();
        }
        return lineString;
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[this.positions.length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = positions[i].linable;
        }

        return linables;

    }

}
