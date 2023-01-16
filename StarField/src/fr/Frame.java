import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    public static final Dimension DEFAULT_DIMENSION = new Dimension(701, 701);
    private Canvas canvas;
    private int numbOfStars = 130;
    private Star[] stars = new Star[numbOfStars];


    public Frame() {
        super();
        this.setSize(DEFAULT_DIMENSION);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("StarField");

        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(DEFAULT_DIMENSION);
        }

        canvas = new Canvas(stars);

        this.add(canvas);
        this.setVisible(true);
    }


    public Canvas getCanvas() {
        return canvas;
    }
}
