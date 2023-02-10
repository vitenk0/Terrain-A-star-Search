import java.util.*;
import java.math.*;

public class Pixel{
    int x;
    int y;
    Double z;
    int color;
    boolean visited;
    HashMap<Pixel, Double> neighbors;
    Pixel predecessor;
    Double f;
    Double g;
    Double h;

    Pixel(int x, int y, Double z, int color){
        this.x = x;
        this.y = y;
        this.z = z;
        this.color = color;
        this.visited = false;
        this.neighbors = new HashMap<Pixel, Double>();
        this.predecessor = null;
    }

    public void fillNBS(Pixel[][] map){
        if(this.x > 0 && this.y > 0)
            this.neighbors.put(map[this.y-1][this.x-1], Math.sqrt(Math.pow(10.29, 2) + Math.pow(7.55, 2)));
        if(this.y > 0)
            this.neighbors.put(map[this.y-1][this.x], 7.55);
        if(this.x < 394 && this.y > 0)
            this.neighbors.put(map[this.y-1][this.x+1], Math.sqrt(Math.pow(10.29, 2) + Math.pow(7.55, 2)));
        if(this.x > 0)
            this.neighbors.put(map[this.y][this.x-1], 10.29);
        if(this.x < 394)
            this.neighbors.put(map[this.y][this.x+1], 10.29);
        if(this.x > 0 && this.y < 499)
            this.neighbors.put(map[this.y+1][this.x-1], Math.sqrt(Math.pow(10.29, 2) + Math.pow(7.55, 2)));
        if(this.y < 499)
            this.neighbors.put(map[this.y+1][this.x], 7.55);
        if(this.x < 394 && this.y < 499)
            this.neighbors.put(map[this.y+1][this.x+1], Math.sqrt(Math.pow(10.29, 2) + Math.pow(7.55, 2)));
    }
}
