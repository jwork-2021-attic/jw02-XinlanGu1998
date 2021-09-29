package example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {

    public static void main(String[] args) throws IOException {
        //创建一条有七个点的line，为7个gourd随机分配位置
        Line line = new Line(7);
        line.put(Gourd.ONE, 6);
        line.put(Gourd.TWO, 3);
        line.put(Gourd.THREE, 1);
        line.put(Gourd.FOUR, 5);
        line.put(Gourd.FIVE, 2);
        line.put(Gourd.SIX, 4);
        line.put(Gourd.SEVEN, 0);

        //获取爷爷单例
        Geezer theGeezer = Geezer.getTheGeezer();
        //创建排序器
        Sorter sorter = new BubbleSorter();
        //为爷爷配置排序器
        theGeezer.setSorter(sorter);

        String log = theGeezer.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
