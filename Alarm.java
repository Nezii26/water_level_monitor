import javax.swing.*;
import java.awt.*;

class Alarm extends WaterLevelObserver {

    private String id;
    private JLabel lblAlarm;
    

    private  JFrame frame;
    private JPanel panel;

    Alarm(String id) {
        this.id = id;
		
      
        
            frame = new JFrame("Alarm");
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLocation(50, 100);
            frame.setVisible(true);

            panel = new JPanel(new GridLayout(0, 1, 5, 5));
            frame.add(panel);
        

        //label alarm
        lblAlarm = new JLabel(id + " --> Alarm OFF", JLabel.CENTER);
        lblAlarm.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(lblAlarm);
		frame.setVisible(true);
		
		
		
		
		
       
    }

    @Override
    public void update(int waterLevel) {
		
		
		if (waterLevel <= 25) {
			panel.setBackground(new Color(76, 175, 80)); // Green
			
		}else if(25 < waterLevel && waterLevel <= 50){
			panel.setBackground(new Color(255, 235, 59)); // Yellow
			
		}else if(50 < waterLevel && waterLevel <= 75){
			panel.setBackground(new Color(255, 152, 0)); // Orange
			
		}else if(75 < waterLevel && waterLevel <= 100){
			panel.setBackground(new Color(244, 67, 54)); // Red
		}
		
		
        if (waterLevel > 50) {
            lblAlarm.setText(id + " --> Alarm ON");
        } else {
            lblAlarm.setText(id + " --> Alarm OFF");
        }
        
        
    }

    @Override
    public String toString() {
        return id;
    }
}





















