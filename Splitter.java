import javax.swing.*;
import java.awt.*;

class Splitter extends WaterLevelObserver {

    private String id;
    private JLabel lblSplitter;
    

    private static JFrame frame;
    private static JPanel panel;

    Splitter(String id) {
        this.id = id;
		
      
        if (frame == null) {
            frame = new JFrame("Splitter");
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLocation(1100, 100);
            frame.setVisible(true);

            panel = new JPanel(new GridLayout(0, 1, 5, 5));
            frame.add(panel);
        }

        //label alarm
        lblSplitter = new JLabel(id + " --> Splitter Off", JLabel.CENTER);
        lblSplitter.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(lblSplitter);
		frame.setVisible(true);
       
    }

    @Override
    public void update(int waterLevel) {
        if (waterLevel > 75) {
            lblSplitter.setText(id + " --> Splitter Open");
        } else {
            lblSplitter.setText(id + " --> Splitter Close");
        }
    }

    @Override
    public String toString() {
        return id;
    }
}






















