
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

final public class TesterForJavaSwing {

   JFrame frame;
   DrawPanel drawPanel;
   private int oneX;
   private int oneY;
   private int frameHeight=0;
   private int frameWidth=0;

   
   int bob = 1;
   int[] jeff = {0,0,0,0};
   int[] jeremy = {0,0,0,0};

   boolean up = true;
   boolean down = false;
   boolean left = false;
   boolean right = true;
   
   public JMenuBar createMenuBar() {
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
      
           //a group of radio button menu items
      menu.addSeparator();
      ButtonGroup group = new ButtonGroup();
      
      rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
      rbMenuItem.setSelected(true);
      rbMenuItem.setMnemonic(KeyEvent.VK_R);
      group.add(rbMenuItem);
      menu.add(rbMenuItem);
      
      rbMenuItem = new JRadioButtonMenuItem("Another one");
      rbMenuItem.setMnemonic(KeyEvent.VK_O);
      group.add(rbMenuItem);
      menu.add(rbMenuItem);
      
           //a group of check box menu items
      menu.addSeparator();
      cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
      cbMenuItem.setMnemonic(KeyEvent.VK_C);
      menu.add(cbMenuItem);
      
      cbMenuItem = new JCheckBoxMenuItem("Another one");
      cbMenuItem.setMnemonic(KeyEvent.VK_H);
      menu.add(cbMenuItem);
      
           //a submenu
      menu.addSeparator();
      submenu = new JMenu("A submenu");
      submenu.setMnemonic(KeyEvent.VK_S);
      
      menuItem = new JMenuItem("An item in the submenu");
      menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
      submenu.add(menuItem);
      
      menuItem = new JMenuItem("Another item");
      submenu.add(menuItem);
      menu.add(submenu);
      
           //Build second menu in the menu bar.
      menu = new JMenu("Another Menu");
      menu.setMnemonic(KeyEvent.VK_N);
      menu.getAccessibleContext().setAccessibleDescription("This menu does nothing");
      menuBar.add(menu);
      
      return menuBar;
   }

   public static void main(String[] args) {
      new TesterForJavaSwing().go();
   }

   private void go() {
      frame = new JFrame("IT BOUNCES");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      TesterForJavaSwing demo = new TesterForJavaSwing();
      frame.setJMenuBar(demo.createMenuBar());
      drawPanel = new DrawPanel();
   
      frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
      //frame.getContentPane().add(BorderLayout.NORTH, drawPanel);
      //frame.getContentPane().add(BorderLayout.SOUTH, drawPanel);
      //frame.getContentPane().add(BorderLayout.EAST, drawPanel);
      //frame.getContentPane().add(BorderLayout.WEST, drawPanel);
      frame.setVisible(true);
      frame.setResizable(true);
      frame.setSize(750, 750);
      frame.setLocation(375, 55);
      
      //frame.getGraphics().fillPolygon(a, b, 4);
      moveIt();
   }

   class DrawPanel extends JPanel {
      public void paintComponent(Graphics g) {
      
         if (frameWidth != frame.getSize().getWidth()) {
            oneX *= (int)((frameWidth - frame.getSize().getWidth()) / frame.getSize().getWidth());
         }
         if (frameHeight != frame.getSize().getHeight()) {
            oneY *= (int)(frameHeight / frame.getSize().getHeight());
         }
         g.setColor(Color.WHITE);
         g.fillRect(6, 6, this.getWidth()-12, this.getHeight()-12);
         if (bob%25 >= 0 && bob%25 <= 5) {
            g.setColor(Color.RED);
         } 
         else if (bob%25 >= 6 && bob%25 <= 10) {
            g.setColor(Color.BLUE);
         } 
         else if (bob%25 >= 11 && bob%25 <= 15) {
            g.setColor(Color.GREEN);
         } 
         else if (bob%25 >= 16 && bob%25 <= 20) {
            g.setColor(Color.YELLOW);
         } 
         else {
            g.setColor(Color.MAGENTA);
         }
         frameHeight = (int)frame.getSize().getHeight();
         frameWidth = (int)frame.getSize().getWidth();
         bob++;
         //jeff = {oneX+5, oneX+10, oneX-5, oneX+5};
         //jeremy = {oneY+5, oneY+10, oneY-5, oneY+5};
         g.drawOval(oneX, oneY, 30, 30);
         g.fillPolygon(new int[]{oneX+15, oneX+24, oneX+2, oneX+28, oneX+6}, new int[]{oneY, oneY+27, oneY+10, oneY+10, oneY+27}, 5);
      
      }
   }

   private void moveIt() {
      while(true){
         if(oneX >= frame.getSize().getWidth()-45){
            right = false;
            left = true;
         }
         if(oneX <= 0){
            right = true;
            left = false;
         }
         if(oneY >= frame.getSize().getHeight()-90){
            up = true;
            down = false;
         }
         if(oneY <= 0){
            up = false;
            down = true;
         }
         if(up){
            oneY-=.0035 * frame.getSize().getHeight();
         }
         if(down){
            oneY+=.0035 * frame.getSize().getHeight();
         }
         if(left){
            oneX-=.0035 * frame.getSize().getWidth();
         }
         if(right){
            oneX+=.0035 * frame.getSize().getWidth();
         }
         try{
            Thread.sleep(10);
         } 
         catch (Exception exc){}
         frame.repaint();
      }
   }
}