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
      frame.setSize(200, 50);
      frame.setLocation(500, 500);
      
   }
   
   public JMenuBar createMenuBar() {
      //JButton okButton = new JButton("OK");
   
      JButton button = new JButton("Click");
      button.addActionListener(
            new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  System.out.println("thingIWantToUse");
               }
            });
      JMenuBar menuBar;
      JMenu menu, submenu;
      JMenuItem menuItem;
      JRadioButtonMenuItem rbMenuItem;
      JCheckBoxMenuItem cbMenuItem;
      
        //Create the menu bar.
      menuBar = new JMenuBar();
      
        //Build the first menu.
      menu = new JMenu("A Menu");
      
         //menu.setMnemonic(KeyEvent.VK_A);
      menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
      menuBar.add(menu);
      
         //a group of JMenuItems
      menuItem = new JMenuItem("A text-only menu item", KeyEvent.VK_T);
      menuItem.addActionListener(
            new ActionListener() {  
            
            });
      
         //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
      menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
      menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
      menu.add(menuItem);
      
         //ImageIcon icon = createImageIcon("images/middle.gif");
         //menuItem = new JMenuItem("Both text and icon", icon);
      menuItem.setMnemonic(KeyEvent.VK_B);
      menu.add(menuItem);
      
         //menuItem = new JMenuItem(icon);
      menuItem.setMnemonic(KeyEvent.VK_D);
      menu.add(menuItem);
      
           //a group of check box menu items
      menu.addSeparator();
      cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
      cbMenuItem.setMnemonic(KeyEvent.VK_C);
      menu.add(cbMenuItem);
      
      cbMenuItem = new JCheckBoxMenuItem("Another one");
      cbMenuItem.setMnemonic(KeyEvent.VK_H);
      menu.add(cbMenuItem);
      
           //Build second menu in the menu bar.
      menu = new JMenu("Another Menu");
      menu.setMnemonic(KeyEvent.VK_N);
      menu.getAccessibleContext().setAccessibleDescription("This menu does nothing");
      menuBar.add(menu);
      
      return menuBar;
   }
   class DrawPanel extends JPanel {
   }

}