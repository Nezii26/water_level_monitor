import javax.swing.*;
import java.awt.*;

class Display extends WaterLevelObserver {

    private String id;
    private JLabel lblDisplay;
    

    private static JFrame frame;
    private static JPanel panel;

    Display(String id){
        this.id = id;
		
       
        if (frame == null) {
            frame = new JFrame("Display");
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLocation(400, 100);

            panel = new JPanel(new GridLayout(0, 1, 5, 5));
            frame.add(panel);
        }

        //label display
        lblDisplay = new JLabel(id + " --> Water Level", JLabel.CENTER);
        lblDisplay.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(lblDisplay);
		frame.setVisible(true);
       
    }

    @Override
    public void update(int waterLevel) {
        lblDisplay.setText(id+"-->Water Level : "+waterLevel);
    }

    @Override
    public String toString() {
        return id;
    }
}
