package S202220005;

public class Line {

    public int sideLen, totalLen;

    public Line(int length) {
        sideLen = length;
        totalLen = sideLen * sideLen;
        this.positions = new Position[totalLen];
        
    }

    private Position[] positions;

    public void putRandomly(Linable linable){
        int i = (int) (Math.random()*totalLen); 
        while (this.positions[i] != null){
            i = (i+1)%totalLen;
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
        String lineString = "";
        for (int i = 0; i < sideLen; i++){
            for (int j = 0; j < sideLen; j++){
                lineString += positions[i*sideLen+j].linable.toString();
            }
            lineString += "\n";
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
