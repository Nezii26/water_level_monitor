import javax.swing.*;
import java.awt.*;

class Alarm extends WaterLevelObserver {

    private String id;
    private JLabel lblAlarm;
    

    private  JFrame frame;
    private JPanel panel;
	static int y=0;
	
    Alarm(String id) {
        this.id = id;
			y=y+100;
      
        
            frame = new JFrame("Alarm");
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLocation(50, y);
            frame.setVisible(true);
           
			
			
            panel = new JPanel(new GridLayout(0, 1, 5, 5));
            panel.setBackground(new Color(137, 207, 240));
            frame.add(panel);
			if(frame != frame){
				frame.setLocation(50, 100);
			}

        //label alarm
        lblAlarm = new JLabel(id + " --> Alarm OFF", JLabel.CENTER);
        lblAlarm.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(lblAlarm);
		frame.setVisible(true);
		
		
		
		
		
       
    }

    @Override
    public void update(int waterLevel) {
		
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





















