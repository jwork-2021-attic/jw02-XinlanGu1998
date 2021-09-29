package S202220005;

import java.util.*;
import S202220005.Line.Position;;

public class Monster implements Linable {
    private final int r,g,b, rank;

    private Position position;
    private static HashMap<Integer, Monster> map = new HashMap<Integer, Monster>(); 

    public Monster(int r, int g, int b, int rank){
        this.r = r; this.g = g; this.b = b;
        this.rank = rank;
        map.put(rank, this);
    }

    public int rank() {
        return rank;
    }

    public static Monster getGourdByRank(int rank) {
        return map.get(rank);
    }

    @Override
    public String toString() {
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2m    \033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public void swapPosition(Monster another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int getValue() {
        return this.rank();
    }
}
