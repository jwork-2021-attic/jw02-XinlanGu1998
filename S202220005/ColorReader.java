package S202220005;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ColorReader {
    private BufferedImage image;
    int row, columns;
    int xStart, yStart;
    int xOffset, yOffset;
    public ColorReader(String filepath, int rows, int columns) throws IOException{
        image = ImageIO.read(new File(filepath));
        int width = image.getWidth();
        int height = image.getHeight();
        xOffset = width / columns;
        yOffset = height / rows;
        xStart = xOffset / 2;
        yStart = yOffset / 2;
    }

    public int[] GetColor(int r, int c){
        int color = image.getRGB(xStart + c * xOffset, yStart + r * yOffset);
        int[] rgb = new int[3];
        rgb[0] = (color>>16)&0xff;
        rgb[1] = (color>>8)&0xff;
        rgb[2] = color&0xff;
        return rgb;
    }
}
