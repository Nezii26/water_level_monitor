import javax.swing.*;
import java.awt.*;

class Display extends WaterLevelObserver {

    private String id;
    private JLabel lblDisplay;
    

    private JFrame frame;
    private JPanel panel;

    Display(String id){
        this.id = id;
		
       
        
            frame = new JFrame("Display");
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLocation(400, 100);

            panel = new JPanel(new GridLayout(0, 1, 5, 5));
            frame.add(panel);
        

        //label display
        lblDisplay = new JLabel(id + " --> Water Level", JLabel.CENTER);
        lblDisplay.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(lblDisplay);
		frame.setVisible(true);
       
    }

    @Override
    public void update(int waterLevel) {
        lblDisplay.setText(id+"-->Water Level : "+waterLevel);
        
        if (waterLevel <= 25) {
			panel.setBackground(new Color(76, 175, 80)); // Green
		}else if(25 < waterLevel && waterLevel <= 50){
			panel.setBackground(new Color(255, 235, 59)); // Yellow
		}else if(50 < waterLevel && waterLevel <= 75){
			panel.setBackground(new Color(255, 152, 0)); // Orange
		}else if(75 < waterLevel && waterLevel <= 100){
			panel.setBackground(new Color(244, 67, 54)); // Red
		}
        
    }

    @Override
    public String toString() {
        return id;
    }
}
