import java.awt.image.*;
import java.io.*;
import java.math.*;
import java.util.*;

import javax.imageio.ImageIO;

public class lab1{
    public static void main(String[] args) throws IOException{
        BufferedImage terrain = null;
        String output_name = args[3];
        Double[][] elev = new Double[500][395];
        Queue<Pixel> toVisit = new LinkedList<Pixel>();
        Pixel[][] map = new Pixel[500][395];
        int path_length = 0;

        try {
            terrain = ImageIO.read(new File(args[0]));

            File elevation_file = new File(args[1]);
            Scanner elevSC = new Scanner(elevation_file);
            for(int y = 0; y < 500; y++){
                for(int x = 0; x < 400; x++){
                    Double next = new BigDecimal(elevSC.next()).doubleValue();
                    if(x < 395){
                        elev[y][x] = next;
                    }
                }
            }
            elevSC.close(); 

            for(int y = 0; y < 500; y++){
                for(int x = 0; x < 395; x++){
                    map[y][x] = new Pixel(x, y, elev[y][x], terrain.getRGB(x, y));
                }
            }
            for(int y = 0; y < 500; y++){
                for(int x = 0; x < 395; x++){
                    map[y][x].fillNBS(map);
                }
            }

            File path_file = new File(args[2]);
            Scanner pathSC = new Scanner(path_file);
            while(pathSC.hasNextLine()){
                String next = pathSC.nextLine();
                String[] temp = next.split(" ");
                int[] point = new int[2];
                point[0] = Integer.parseInt(temp[0]);
                point[1] = Integer.parseInt(temp[1]);
                toVisit.add(map[point[1]][point[0]]);
            }
            pathSC.close();
        } catch (IOException e) {
            System.out.println("Loading files failed");
            e.printStackTrace();
        }

        final int open_land = -486382; //dark orange
        final int rough_meadow = -16384; //light orange
        final int easy_movement_forest = -1; //white
        final int slow_run_forest = -16592836; //light green
        final int walk_forest = -16611288; //green
        final int impassible_vegetation = -16430824; //dark green
        final int lake = -16776961; //blue 
        final int paved_road = -12111101; //brown
        final int footpath = -16777216; //black
        final int out_of_bounds = -3342235; //magenta

        Comparator<Pixel> pixelComparator = new Comparator<Pixel>() {
            @Override
            public int compare(Pixel p1, Pixel p2) {
                return (int) (p1.f - p2.f);
            }
        };

        while(toVisit.size() > 1){
            PriorityQueue<Pixel> queue = new PriorityQueue<Pixel>(pixelComparator);
            Pixel start = toVisit.remove();
            start.f = 0.0;
            queue.add(start);
            Pixel target = toVisit.peek();
            while(!queue.isEmpty()){
                Pixel p = queue.remove();
                p.visited = true;
                Set<Pixel> neighbors = p.neighbors.keySet();
                Iterator<Pixel> iterate = neighbors.iterator();
                while(iterate.hasNext()){}
                    Pixel current = iterate.next();
                    current.predecessor = p;
                    if(current.equals(target)){
                        break;
                    }
                    else{
                        current.g = current.predecessor.g + p.neighbors.get(current);
                        //current.h =
                    }
                }

            }
            
            
        }

        /* 
        BufferedImage out = terrain;

        File output = new File(output_name);
        ImageIO.write(out, "png", output);
        output.createNewFile();
        System.out.println(path_length);
        */
    }
}

/* 
class func{
    public int getG(Pixel pre, Pixel curr){
        return pre.g + 
    }
}*/