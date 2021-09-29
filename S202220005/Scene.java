package S202220005;

import java.io.IOException;

public class Scene {
    public static void main(String[] args){
        try{
            ColorReader colorReader = new ColorReader("c256.png",16,16);
            for (int i = 0; i < 16; i++){
                for (int j = 0; j < 16; j++){
                    int[] rgb = colorReader.GetColor(i,j);
                    System.out.println(String.format("%d, %d, %d",rgb[0],rgb[1],rgb[2]));
                }
            }
        }catch(IOException exception){
            System.out.println("Fail to open png file!");
        }


    }
}
