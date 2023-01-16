import java.util.TimerTask;


public class DrawTask extends TimerTask {
    Frame frame;


    public DrawTask(Frame frame) {
        this.frame = frame;
    }


    @Override
    public void run() {
        frame.getCanvas().update(frame.getCanvas().getGraphics());
    }
}
