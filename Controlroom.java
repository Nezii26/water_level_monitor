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


	String[] idArray = new String[0];

	public void addToIdArray(String id){
		String[] temp = new String[idArray.length+1];
		for(int i=0 ; i<idArray.length ; i++){
			temp[i]=idArray[i];
		}
		temp[idArray.length]=id;
		idArray=temp;
	}

    Controlroom() {
        setTitle("Water_Level Control");
        setSize(450, 200);
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
        
       crc = new ControlCollection();
       
	   btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				
				String id = txtId.getText().trim();
				
				for(int i=0 ; i<idArray.length ; i++){
					if(id.equals(idArray[i])){
					JOptionPane.showMessageDialog(null, "This ID Already Exits ,\n Please Enter new ID." );
						
						return;
					}
				}
				addToIdArray(id);
				
				
				
				
				//GetId[] idexits = new GetID[0];
				//
				//GetId[] temp=new GetId[idexits.length+1];
				//for (int i = 0; i < idexits.length; i++){
				//	temp[i]=idexits[i];
				//}
				//idexits=temp;
				//idexits[idexits.length-1] = id;
				//
				
				if(id.isEmpty()){
					
					JOptionPane.showMessageDialog(null, "Please Enter ID & Get This Guide ,\n \n Alarm -> A0001 \n Display -> D0001 \n SMSsender -> SM001 \n Splitter -> S0001");
					return;
				
				}else{
					
					if(id.length() != 5){
						
						JOptionPane.showMessageDialog(null, "Your Id Length Invalid, Get This Guide ,\n \n Alarm -> A0001 \n Display -> D0001 \n SMSsender -> SM001 \n Splitter -> S0001");
						return;
						
					}else{
					
						JOptionPane.showMessageDialog(null, "Added Successfully");
						
						//int count = id.length();			
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
					}
				}
					
			}
		});
		
		
		panel.setBackground(new Color(30, 144, 255));
		slider.setForeground(new Color(255, 255, 255));
		
		

        slider.addChangeListener(e -> {
            int value = slider.getValue();
            crc.setWaterLevel(value);
            
            if ( value <= 25) {
				slider.setBackground(new Color(76, 175, 80)); // Green
				
			}else if(25 < value && value <= 50){
				slider.setBackground(new Color(255, 235, 59)); // Yellow
				
			}else if(50 < value && value <= 75){
				slider.setBackground(new Color(255, 152, 0)); // Orange
				
			}else if(75 < value && value <= 100){
				slider.setBackground(new Color(244, 67, 54)); // Red
	
			}
			

        });
        
       
	
    }
    
   
    
}
	
	
		
	
		
	
		



	
	
	

