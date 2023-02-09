import java.util.*;

public class Pixel{
    int x;
    int y;
    int z;
    int color;
    boolean visited;
    ArrayList<Pixel> neighbors;

    Pixel(int x, int y, int z, int color){
        this.x = x;
        this.y = y;
        this.z = z;
        this.color = color;
        this.visited = false;
        this.neighbors = new ArrayList<Pixel>();
    }

    public void fillNBS(Pixel[][] map){
        if(this.x > 0 && this.y > 0)
            this.neighbors.add(map[this.x-1][this.y-1]);
        if(this.y > 0)
            this.neighbors.add(map[this.x][this.y-1]);
        if(this.x < 395 && this.y > 0)
            this.neighbors.add(map[this.x+1][this.y-1]);
        if(this.x > 0)
            this.neighbors.add(map[this.x-1][this.y]);
        if(this.x < 395)
            this.neighbors.add(map[this.x+1][this.y]);
        if(this.x > 0 && this.y < 500)
            this.neighbors.add(map[this.x-1][this.y+1]);
        if(this.y < 500)
            this.neighbors.add(map[this.x][this.y+1]);
        if(this.x < 395 && this.y < 500)
            this.neighbors.add(map[this.x+1][this.y+1]);
    }
}
