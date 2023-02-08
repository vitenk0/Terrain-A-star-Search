import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

public class lab1{
    public static void main(String[] args){
        BufferedImage terrain = null;
        String elevation_file = args[1];
        String path_file = args[2]; 
        String output_image_filename = args[3];

        try {
            terrain = ImageIO.read(new File(args[0]));
        } catch (IOException e) {
            System.out.println("Loading terrain failed");
            e.printStackTrace();
        }

    }
}