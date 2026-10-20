import javax.swing.*;
import java.awt.*;

class SMSSender extends WaterLevelObserver {

    private String id;
    private JLabel lblSMSSender;
    

    private JFrame frame;
    private JPanel panel;
	static int y=0;
	
    SMSSender(String id){
        this.id = id;
			y=y+100;
       
       
            frame = new JFrame("SMSSender");
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLocation(750, y);

            panel = new JPanel(new GridLayout(0, 1, 5, 5));
            panel.setBackground(new Color(137, 207, 240));
            frame.add(panel);
        

        //label sms
        lblSMSSender = new JLabel(id + " --> Water Level", JLabel.CENTER);
        lblSMSSender.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(lblSMSSender);
		frame.setVisible(true);
       
    }

    @Override
    public void update(int waterLevel) {
        //lblSMSSender.setText(id+"-->Sending SMS..."+ waterLevel);
        
        if (waterLevel <= 25) {
			lblSMSSender.setText("<html>"+id+"-->Sending SMS <br>"+waterLevel+" WaterLevel is Normal"+"<html>" );			
			//panel.setBackground(new Color(76, 175, 80)); // Green
			
		}else if(25 < waterLevel && waterLevel <= 50){
			//panel.setBackground(new Color(255, 235, 59)); // Yellow
			lblSMSSender.setText("<html>"+id+"-->Sending SMS <br>"+waterLevel+" WaterLevel is Moderate :) "+"<html>" );		
			
		}else if(50 < waterLevel && waterLevel <= 75){
			//panel.setBackground(new Color(255, 152, 0)); // Orange
			lblSMSSender.setText("<html>"+id+"-->Sending SMS <br>"+waterLevel+" WaterLevel is High"+"<html>" );	
			
		}else if(75 < waterLevel && waterLevel <= 100){
			//panel.setBackground(new Color(244, 67, 54)); // Red
			lblSMSSender.setText("<html>"+id+"-->Sending SMS <br>"+waterLevel+" WaterLevel is Critical :( "+"<html>" );	
		}
        
        
    }

    @Override
    public String toString() {
        return id;
    }
}
