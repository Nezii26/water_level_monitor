import javax.swing.*;
import java.awt.*;

class SMSSender extends WaterLevelObserver {

    private String id;
    private JLabel lblSMSSender;
    

    private static JFrame frame;
    private static JPanel panel;

    SMSSender(String id){
        this.id = id;
		
       
        if (frame == null) {
            frame = new JFrame("SMSSender");
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLocation(750, 100);

            panel = new JPanel(new GridLayout(0, 1, 5, 5));
            frame.add(panel);
        }

        //label sms
        lblSMSSender = new JLabel(id + " --> Water Level", JLabel.CENTER);
        lblSMSSender.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(lblSMSSender);
		frame.setVisible(true);
       
    }

    @Override
    public void update(int waterLevel) {
        lblSMSSender.setText(id+"-->Sending SMS..."+ waterLevel);
    }

    @Override
    public String toString() {
        return id;
    }
}
