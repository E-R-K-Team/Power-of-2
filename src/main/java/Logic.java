import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Logic extends JPanel implements ActionListener, KeyListener {
    private Timer time;
    private enum coordinates{

    };
    public Logic(){
        addKeyListener(this);
        time = new Timer(35, this);
        setFocusable(true);
        time.start();
    }
    private int TileX = 400;
    private int TileY = 400;
    private static final Color BG_COLOR = new Color(0xbbada0);
    // set the font of the numbers, the size and font style can be changed here
    private static final Font STR_FONT = new Font(Font.SERIF, Font.BOLD, 32);
    @Override
    public void paint(Graphics g) {
        g.setColor(BG_COLOR);
        //window background
        g.fillRect(0, 0, 600, 600);
        g.setColor(Color.WHITE);
        //square
        g.drawLine(100,100,500,100);
        g.drawLine(100,100,100,500);
        g.drawLine(100,500,500,500);
        g.drawLine(500,500,500,100);
        //vertical lines
        g.drawLine(200,100,200,500);
        g.drawLine(300,100,300,500);
        g.drawLine(400,100,400,500);
        //horizontal lines
        g.drawLine(100,200,500,200);
        g.drawLine(100,300,500,300);
        g.drawLine(100,400,500,400);
        //Tile
        g.setColor(Color.gray);
        g.fillRect(TileX, TileY, 100,100);
        g.setColor(Color.CYAN);
        g.setFont(STR_FONT);
        g.drawString("2",TileX + 45, TileY + 60);

    }



    private Tile[] tiles;



    /*public static class Tile{
        public int value;
        public static int TileX;
        public static int TileY;
        Tile(){
            value = 2;
            TileX = 450;
            TileY = 100;
        }
    }*/



    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A){
            TileX -= 100;
            if(TileX < 100)
                TileX = 100;

        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            TileY -= 100;
            if(TileY < 100)
                TileY = 100;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            TileX += 100;
            if(TileX > 400)
                TileX = 400;
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            TileY += 100;
            if(TileY > 400)
                TileY = 400;
        }
    }
}
