import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {
    private BufferedImage offscreen;
    private Graphics2D offscreenGraphics;
    private Star[] stars;


    public Canvas(Star[] s) {
        super();
        stars = s;
        offscreen = new BufferedImage(Frame.DEFAULT_DIMENSION.width, Frame.DEFAULT_DIMENSION.height, BufferedImage.TYPE_INT_RGB);
        offscreenGraphics = (Graphics2D) offscreen.getGraphics();
        this.setBackground(Color.BLACK);
    }


    @Override
    public void update(Graphics g) {
        paint(g);
    }


    @Override
    public void paint(Graphics g) {
        offscreenGraphics.setColor(Color.BLACK);
        offscreenGraphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        drawStars(offscreenGraphics);
        g.drawImage(offscreen, 0, 0, null);
    }


    private void drawStars(Graphics2D g) {
        float[] coor;

        g.setColor(Color.WHITE);

        for (int i = 0; i < stars.length; i++) {
            coor = stars[i].getCoor();
            g.drawLine((int)coor[0], (int)coor[1], (int)coor[2], (int)coor[3]);
            stars[i].move();
        }
    }
}
