package Classes;

import java.awt.*;

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

    private void drawBallBorders(Graphics2D g, Rectangle ballRectangle) {
        // float[] dashingPattern1 = { 2f, 2f };
        // Stroke stroke2 = new BasicStroke(2f, BasicStroke.CAP_BUTT,
        //         BasicStroke.JOIN_MITER, 1.0f, dashingPattern1, 2.0f);
        // g.setStroke(stroke2);
        g.setStroke(new BasicStroke(1));
        g.setColor(Color.RED);
        g.drawRect(ballRectangle.x - 1, ballRectangle.y - 1, 21, 21);
    }

    private void drawBrickBorders(Graphics2D g, Rectangle brickRectangle) {
        // float[] dashingPattern1 = { 2f, 2f };
        // Stroke stroke2 = new BasicStroke(2f, BasicStroke.CAP_BUTT,
        //         BasicStroke.JOIN_MITER, 1.0f, dashingPattern1, 2.0f);
        // g.setStroke(stroke2);
        g.setStroke(new BasicStroke(1));
        g.setColor(Color.RED);
        g.drawRect(brickRectangle.x - 1, brickRectangle.y - 1, brickRectangle.width + 1, brickRectangle.height + 1);
    }

    /**
     * @param g
     * @param ballRectangle
     */
    public void draw(Graphics2D g, Rectangle ballRectangle) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                // map[i][j] = 1;
                if (map[i][j] == 1) {
                    g.setColor(Color.white);
                    g.fillRect(j * brickWidth + 80, i * brickHieght + 50, brickWidth, brickHieght);

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 80, i * brickHieght + 50, brickWidth, brickHieght);

                    // drawBallBorders(g, ballRectangle);
                    // drawBrickBorders(g, new Rectangle(j * brickWidth + 80, i * brickHieght + 50, brickWidth, brickHieght));
                }
            }
        }
    }

    public void setBrickValue(int value, int i, int j) {
        map[i][j] = value;

    }
}
