package FourPersonPong;

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
   
   //public  color

   
   int bob = 1;

   boolean up = true;
   boolean down = false;
   boolean left = false;
   boolean right = true;
/*
   public static void main(String[] args) {
      new TesterForJavaSwing().go();
   }
*/
   public void go() {
      frame = new JFrame("IT BOUNCES");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      TesterForJavaSwing demo = new TesterForJavaSwing();;
      drawPanel = new DrawPanel();
   
      frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
      frame.setVisible(true);
      frame.setResizable(true);
      frame.setSize(750, 750);
      frame.setLocation(375, 55);
      
      moveIt();
   }

   class DrawPanel extends JPanel {
      public void paintComponent(Graphics g) {
      
         g.setColor(Color.WHITE);
         g.fillRect(6, 6, this.getWidth()-12, this.getHeight()-12);
         /*
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
         
         */
         bob++;
         g.drawOval(oneX, oneY, 30, 30);
         g.fillPolygon(new int[]{oneX+15, oneX+24, oneX+2, oneX+28, oneX+6}, new int[]{oneY, oneY+27, oneY+10, oneY+10, oneY+27}, 5);
      
      }
   }

   private void moveIt() {
      while(true){
         if(oneX >= frame.getSize().getWidth()-40){
            right = false;
            left = true;
         }
         if(oneX <= 0){
            right = true;
            left = false;
         }
         if(oneY >= frame.getSize().getHeight()-60){
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