

import javax.swing.JFrame;
import Classes.GamePlay;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.pack();
        frame.setBounds(10,10,700,600);
        frame.setTitle("Brick Breaker");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        GamePlay gameplay = new GamePlay();
        frame.add(gameplay);
        
    }

    private static void extracted(JFrame frame) {
        frame.setLocationRelativeTo(null);
    }
}
