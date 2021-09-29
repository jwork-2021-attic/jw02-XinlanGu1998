package S202220005;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {
    public static void main(String[] args) throws IOException {
        int row = 16, col = 16;
            
        Line line = new Line(row);
        ColorReader colorReader = new ColorReader("c256.png",16,16);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                int k = i*col + j;
                int[] rgb = colorReader.GetColor(k);
                Linable m = new Monster(rgb[0], rgb[1], rgb[2], k);
                line.putRandomly(m);
                //System.out.println(String.format("%d, %d, %d",rgb[0],rgb[1],rgb[2]));
            }
        }

        Snake snake = new Snake();

        snake.setSorter(new QuickSorter());

        String log = snake.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }
}
