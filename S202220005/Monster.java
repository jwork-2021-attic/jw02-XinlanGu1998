package S202220005;

public class Monster {
    private final int r,g,b,rank;
    public Monster(int r, int g, int b,int rank){
        this.r = r; this.g = g; this.b = b;
        this.rank = rank;
        
    }

    public int rank() {
        return rank;
    }

    @Override
    public String toString() {
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.rank + "  \033[0m";
    }
}
