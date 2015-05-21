import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;
 
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
public class MainMenu {
   
   JFrame frame;
   DrawPanel drawPanel;
   
   public static void main (String[] args) {
      new MainMenu().theMenu();
   }
   
   public void theMenu() {
      frame = new JFrame("4 PERSON PONG MAIN MENU");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      MainMenu demo = new MainMenu();
      frame.setJMenuBar(demo.createMenuBar());
      drawPanel = new DrawPanel();
   
      frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
      frame.setVisible(true);
      frame.setResizable(true);
      frame.setSize(400,400);
      frame.setLocation(450, 350);
      
      JButton button = new JButton("Begin Game");
      button.addActionListener(
            new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  System.out.println("thingIWantToUse");
               }
            });
      frame.add(button);
   }
   
   public JMenuBar createMenuBar() {
   
      JMenuBar menuBar;
      JMenu menu, submenu;
      JMenuItem menuItem;
      JRadioButtonMenuItem rbMenuItem;
      JCheckBoxMenuItem cbMenuItem;
      
        //Create the menu bar.
      menuBar = new JMenuBar();
      
        //Build the first menu.
      menu = new JMenu("Settings");
      
         //menu.setMnemonic(KeyEvent.VK_A);
      menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
      menuBar.add(menu);
         
         //a group of check box menu items
      menu.addSeparator();
      cbMenuItem = new JCheckBoxMenuItem("Super Fast Mode");
      cbMenuItem.setMnemonic(KeyEvent.VK_C);
      cbMenuItem.addActionListener(
            new ActionListener() {  
               public void actionPerformed(ItemEvent e) {
                  System.out.println("MAKE IT FASST");
               }
            });
      //MAKE THIS ONE DOUBLE THE SPEED SOMEHOW
      
      menu.add(cbMenuItem);
      
      //a group of radio button menu items
      menu.addSeparator();
      ButtonGroup group = new ButtonGroup();
      rbMenuItem = new JRadioButtonMenuItem("RED BALL"); //SET THE BALL COLOR TO RED
      rbMenuItem.addActionListener(
            new ActionListener() {  
               public void actionPerformed(ActionEvent e) {
                  System.out.println("IS THE BALL RED NOW");
               }
            });
      rbMenuItem.setSelected(true);
      rbMenuItem.setMnemonic(KeyEvent.VK_R);
      group.add(rbMenuItem);
      menu.add(rbMenuItem);
   
      rbMenuItem  = new JRadioButtonMenuItem("GREEN BALL"); //SET THE BALL COLOR TO GREEN
      
      rbMenuItem.addActionListener(
            new ActionListener() {  
               public void actionPerformed(ActionEvent e) {
                  System.out.println("THE BALL IS NOW GREEN");
               }
            });
      
      rbMenuItem.setSelected(true);
      rbMenuItem.setMnemonic(KeyEvent.VK_G);
      group.add(rbMenuItem);
      menu.add(rbMenuItem);
      
      rbMenuItem = new JRadioButtonMenuItem("BLUE BALL");//SET THE BALL COLOR TO BLUE
      
      rbMenuItem.addActionListener(
            new ActionListener() {  
               public void actionPerformed(ActionEvent e) {
                  System.out.println("THE BALL IS NOW BLUE! BLUE BALLS");
               }
            });
      
      rbMenuItem.setMnemonic(KeyEvent.VK_B);
      group.add(rbMenuItem);
      menu.add(rbMenuItem);
      
   
      
      return menuBar;
   }
   class DrawPanel extends JPanel {
   }

}