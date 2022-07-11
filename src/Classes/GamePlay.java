package Classes;

import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, AncestorListener, ActionListener{
    private int score = 0;
    private int totalbricks = 21;
    private Timer timer;

    private int PlayerPosX = 310;

    private int BallPosX = 120;
    private int BallPosY = 350;
    private int BalldirX = -2;
    private int BalldirY = -3;

    private MapGenerator map;

    public GamePlay() {

        map = new MapGenerator(3, 7);

        setSize(700, 600);
        addKeyListener((KeyListener) this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(10, this);
        timer.start();
    }

    
    public void paint(Graphics g) {

        super.paint(g);
        
        //background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);

        //map
        map.draw((Graphics2D)g);

        //boarders
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(680, 0, 3, 592);

        //paddle
        g.setColor(Color.cyan);
        g.fillRect(PlayerPosX, 550, 100, 8);

        //ball
        g.setColor(Color.yellow);
        g.fillOval(BallPosX, BallPosY, 20, 20);

        g.dispose();
    }
    @Override
    public void ancestorAdded(AncestorEvent event) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void ancestorRemoved(AncestorEvent event) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void ancestorMoved(AncestorEvent event) {
        // TODO Auto-generated method stub
        
    }
        
    
    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(PlayerPosX >= 600) {
                PlayerPosX = 600;
            }
            else {
                MoveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(PlayerPosX < 10) {
                PlayerPosX = 10;
            }
            else {
                MoveLeft();
                System.out.println("keypress is working");
            }
        }
    }

    public void MoveLeft() {
        PlayerPosX = PlayerPosX - 20;
        System.out.println("move left is working");
    }

    public void MoveRight() {
        PlayerPosX = PlayerPosX + 20;
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("game is running");
        BallPosX = BallPosX + BalldirX;
        BallPosY = BallPosY + BalldirY;

        if (BallPosX < 0){
            BalldirX = -BalldirX;
        }
        if (BallPosY < 0){
            BalldirY = -BalldirY;
        }
        if (BallPosX > 665){
            BalldirX = -BalldirX;
        }
        if (new Rectangle(BallPosX, BallPosY, 20, 20).intersects(new Rectangle(PlayerPosX,550,100,8))){
            BalldirY = -BalldirY;
        }

        outerloop: for (int i = 0; i < map.map.length; i++){
            for (int j = 0; j < map.map[0].length; j++){
                if (map.map[i][j] > 0){
                    int brickX = map.brickWidth * j + 80;
                    int brickY = map.brickHieght * i + 50;

                    int brickWidth = map.brickWidth;
                    int brickHieght = map.brickWidth;

                    Rectangle brickRectangle = new Rectangle(brickX, brickY, brickWidth, brickHieght);
                    Rectangle ballRectangle = new Rectangle(BallPosX, BallPosY, 20, 20);
                    
                    if (ballRectangle.intersects(brickRectangle)){
                        map.setBrickValue(0, i, j);

                        totalbricks = totalbricks - 1;
                        score = score + 1;

                        if(BallPosX + 20 < brickRectangle.x || BallPosX > brickRectangle.x + brickRectangle.width){
                            BalldirX = -BalldirX;
                        }
                        else{
                            BalldirY = -BalldirY;
                        }

                        break outerloop;
                    }
                }
            }
        }
        repaint();
        requestFocus();
    }
}
