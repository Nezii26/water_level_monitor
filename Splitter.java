import javax.swing.*;
import java.awt.*;

class Splitter extends WaterLevelObserver {

    private String id;
    private JLabel lblSplitter;
    

    private JFrame frame;
    private JPanel panel;
    static int y=0;

    Splitter(String id) {
        this.id = id;
			y=y+100;
      
        
            frame = new JFrame("Splitter");
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLocation(1100, y);
            frame.setVisible(true);

            panel = new JPanel(new GridLayout(0, 1, 5, 5));
            panel.setBackground(new Color(137, 207, 240));
            frame.add(panel);
        

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
        
        //if (waterLevel <= 25) {
		//	panel.setBackground(new Color(76, 175, 80)); // Green
		//}else if(25 < waterLevel && waterLevel <= 50){
		//	panel.setBackground(new Color(255, 235, 59)); // Yellow
		//}else if(50 < waterLevel && waterLevel <= 75){
		//	panel.setBackground(new Color(255, 152, 0)); // Orange
		//}else if(75 < waterLevel && waterLevel <= 100){
		//	panel.setBackground(new Color(244, 67, 54)); // Red
		//}
        
    }

    @Override
    public String toString() {
        return id;
    }
}






















