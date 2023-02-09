import java.awt.image.*;
import java.io.*;
import java.math.*;
import java.util.*;

import javax.imageio.ImageIO;

public class lab1{
    public static void main(String[] args) throws IOException{
        BufferedImage terrain = null;
        String output_name = args[3];
        int[][] elev = new int[500][395];
        Queue<int[]> toVisit = new LinkedList<int[]>();
        Pixel[][] map = new Pixel[500][395];
        int path_length = 0;

        try {
            terrain = ImageIO.read(new File(args[0]));

            File elevation_file = new File(args[1]);
            Scanner elevSC = new Scanner(elevation_file);
            for(int i = 0; i < 500; i++){
                for(int j = 0; j < 400; j++){
                    int next = new BigDecimal(elevSC.next()).intValue();
                    if(j < 395){
                        elev[i][j] = next;
                    }
                }
            }
            elevSC.close(); 

            for(int i = 0; i < 500; i++){
                for(int j = 0; j < 395; j++){
                    map[i][j] = new Pixel(i, j, elev[i][j], terrain.getRGB(i,j));
                }
            }
            for(int i = 0; i < 500; i++){
                for(int j = 0; j < 395; j++){
                    map[i][j].fillNBS(map);
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
                toVisit.add(point);
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

        int[] startCoords = toVisit.remove();
        while(!toVisit.isEmpty()){
            
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