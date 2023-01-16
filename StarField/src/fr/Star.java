import java.awt.Dimension;
import java.util.Random;

public class Star {
    private final int divisor = 6;
    private final float tail_length = 1.4f, origin_speed = 0.2f, acceleration = 0.03f, vector_length = 10;
    private float head_x = 0, head_y = 0, tail_x = 0, tail_y = 0, speed, origin_x, origin_y, middle_x, middle_y;
    private Dimension canvas;
    private Vector head_vector;
    private Random random;


    public Star(Dimension canvas) {
        random = new Random();
        this.canvas = canvas;
        middle_x = canvas.width / 2 + 1;
        middle_y = canvas.height / 2 + 1;
        reset();
    }


    public void move() {
        if (offCanvas()) {
            reset();
        }

        head_x += head_vector.getX() * speed;
        head_y += head_vector.getY() * speed;

        tail_x = origin_x + (head_x - origin_x) / tail_length;
        tail_y = origin_y + (head_y - origin_y) / tail_length;

        speed += acceleration;
    }


    private boolean offCanvas() {
        if (canvas.width < tail_x || tail_x < 0 || canvas.height < tail_y || tail_y < 0) {
            return true;
        }
        return false;
    }


    public float[] getCoor() {
        return new float[]{head_x, head_y, tail_x, tail_y};
    }


    private void reset() {
        speed = origin_speed;
        origin_x = (random.nextFloat() * canvas.width / divisor) + ((divisor - 1) * (canvas.width / divisor)) / 2;
        origin_y = (random.nextFloat() * canvas.height / divisor) + ((divisor - 1) * (canvas.height / divisor)) / 2;
        head_x = origin_x;
        head_y = origin_y;
        head_vector = new Vector(origin_x - middle_x, origin_y - middle_y);
        head_vector.normalize(vector_length / (head_vector.getMagnitud()));
    }


    @Override
    public String toString() {
        return "x : "+ head_x +", y : "+ head_y +", "+ head_vector;
    }
}
