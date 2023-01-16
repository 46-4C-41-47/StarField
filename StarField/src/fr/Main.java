import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Timer timer = new Timer(true);
        DrawTask task = new DrawTask(frame);
        timer.scheduleAtFixedRate(task, 0, 10);
    }
}