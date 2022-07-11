package Classes;

import java.awt.*;
//Farbod
public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHieght;

    public MapGenerator(int row, int col) {
        map = new int[row][col];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;
            }
        }

        brickWidth = 540 / col;
        brickHieght = 150 / row;
    }


    public void draw(Graphics2D g, Rectangle ballRectangle) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    g.setColor(Color.white);
                    g.fillRect(j * brickWidth + 80, i * brickHieght + 50, brickWidth, brickHieght);

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 80, i * brickHieght + 50, brickWidth, brickHieght);
                }
            }
        }
    }

    public void setBrickValue(int value, int i, int j) {
        map[i][j] = value;

    }
}
