import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ButtonDemo {
    public String size = "";
    public String flavor = "";
    public String boba = "";

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public ButtonDemo() {
        mainFrame = new JFrame("Button Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));
        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);        
        statusLabel.setSize(350,100);
      
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });    
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        ButtonDemo b = new ButtonDemo();
        b.showEvent();
    }

    private void showEvent() {
        headerLabel.setText("Menu"); 

        JButton largeButton = new JButton("Large");
        JButton mediumButton = new JButton("Medium");
        JButton smallButton = new JButton("Small");
        JButton cmtButton = new JButton("Classic Milk Tea");

        largeButton.setActionCommand("Large");
        mediumButton.setActionCommand("Medium");
        smallButton.setActionCommand("Small");
        cmtButton.setActionCommand("Classic Milk Tea");

        largeButton.addActionListener(new ButtonClickListener()); 
        mediumButton.addActionListener(new ButtonClickListener()); 
        smallButton.addActionListener(new ButtonClickListener()); 
        cmtButton.addActionListener(new ButtonClickListener()); 

        controlPanel.add(largeButton);
        controlPanel.add(mediumButton);
        controlPanel.add(smallButton);   
        controlPanel.add(cmtButton);     

        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();  
         
            if(command.equals("Large"))  {
                size = "Large";
            } else if(command.equals("Medium"))  {
                size = "Medium";
            } else if(command.equals("Small"))  {
                size = "Small";
            } 
            if(command.equals("Classic Milk Tea"))  {
                flavor = "classic milk tea";
            }  
            statusLabel.setText("Your order is " + size + " " + flavor + boba);  
      }     
   }
}