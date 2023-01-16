public class Vector {
    private float x, y;
    private float magnitud;


    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
        calculateMagnitud();
    }


    private void calculateMagnitud() {
        magnitud =  (float) Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
    }


    public void normalize(float ratio) {
        x = x * ratio;
        y = y * ratio;
        calculateMagnitud();
    }


    public void setX(float x) {
        this.x = x;
    }


    public void setY(float y) {
        this.y = y;
    }


    public float getX() {
        return x;
    }


    public float getY() {
        return y;
    }


    public float getMagnitud() {
        return magnitud;
    }


    @Override
    public String toString() {
        return x+", "+y;
    }
}
