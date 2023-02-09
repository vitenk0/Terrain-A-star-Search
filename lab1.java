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

        BufferedImage out = terrain;

        File output = new File(output_name);
        ImageIO.write(out, "png", output);
        output.createNewFile();
        System.out.println(path_length);

    }
}