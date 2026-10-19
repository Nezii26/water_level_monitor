import javax.swing.*; 
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.awt.Color;

class Controlroom extends JFrame{
	
	private JSlider slider;
	private JTextField txtId;
	private JButton btnSearch;
	private static JFrame frame;
    private ControlCollection crc;

    Controlroom() {
        setTitle("Water_Level System");
        setSize(350, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
		
		slider = new JSlider(0, 100, 0);
		slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);
        
        txtId = new JTextField();
        
        JPanel panel = new JPanel();
		btnSearch = new JButton("Add Device");
		txtId.setPreferredSize(new Dimension(200, 50));
		btnSearch.setPreferredSize(new Dimension(100, 50));
		
		txtId.setFont(new Font("", 1, 20));
		
		panel.add(txtId);
		panel.add(btnSearch);
		
		

        add(slider, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
        //add(txtId, BorderLayout.NORTH);
        
       ControlCollection crc = new ControlCollection();
       
	   btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				
				String id = txtId.getText().trim();
				int count = id.length();
				
				
				
								
					String findId = id.substring(0,2);
					
					if(findId.equals("A0")){
						crc.addwaterLevel(new Alarm(id));
					}
					if(findId.equals("D0")){
						crc.addwaterLevel(new Display(id));
					}
					if(findId.equals("SM")){
						crc.addwaterLevel(new SMSSender(id));	
					}
					if(findId.equals("S0")){
						crc.addwaterLevel(new Splitter(id));
					}
					
				
				
				
				//crc.addwaterLevel(new Display("D002"));
				
			}
		});
		
		

        slider.addChangeListener(e -> {
            int value = slider.getValue();
            crc.setWaterLevel(value);
            
			

        });
        
        
        
     
    }
}
	
	
		
	
		
	
		



	
	
	
	

