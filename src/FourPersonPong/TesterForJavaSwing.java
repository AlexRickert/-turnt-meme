package FourPersonPong;

import java.awt.*;
import javax.swing.JFrame;

import javax.swing.JPanel;

final public class TesterForJavaSwing {

   JFrame frame;
   DrawPanel drawPanel;
   private int BallOneX;
   private int BallOneY;

   private int Paddle1x;
   private int Paddle1Y;

   private int Paddle2x;
   private int Paddle2Y;

   private int Paddle3x;
   private int Paddle3Y;

   private int Paddle4x;
   private int Paddle4Y;

   boolean up = true;
   boolean down = false;
   boolean left = false;
   boolean right = true;

   public static void main(String[] args) {
      new TesterForJavaSwing().go();
   }

   public void go() {
      frame = new JFrame("IT BOUNCES");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      drawPanel = new DrawPanel();
   
      frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setSize(750, 750);
      frame.setLocation(375, 55);
      
      moveIt();
   }

   class DrawPanel extends JPanel {
      public void paintComponent(Graphics g) {
      
         g.setColor(Color.WHITE);
         g.fillRect(6, 6, this.getWidth()-12, this.getHeight()-12);
         g.setColor(Color.orange);
         g.drawOval(BallOneX, BallOneY, 30, 30);
         g.fillPolygon(new int[]{BallOneX +15, BallOneX +24, BallOneX +2, BallOneX +28, BallOneX +6}, new int[]{BallOneY, BallOneY +27, BallOneY +10, BallOneY +10, BallOneY +27}, 5);
      
      }
   }

   private void moveIt() {
      while(true){

         //BALL
         if(BallOneX >= frame.getSize().getWidth()-40){
            right = false;
            left = true;
         }
         if(BallOneX <= 0){
            right = true;
            left = false;
         }
         if(BallOneY >= frame.getSize().getHeight()-60){
            up = true;
            down = false;
         }
         if(BallOneY <= 0){
            up = false;
            down = true;
         }
         if(up){
            BallOneY -=.0035 * frame.getSize().getHeight();
         }
         if(down){
            BallOneY +=.0035 * frame.getSize().getHeight();
         }
         if(left){
            BallOneX -=.0035 * frame.getSize().getWidth();
         }
         if(right){
            BallOneX +=.0035 * frame.getSize().getWidth();
         }
         //BALL

         //PADDLE 1

         //PADDLE 1

         //PADDLE 2

         //PADDLE 2

         //PADDLE 3

         //PADDLE 3

         //PADDLE 4

         //PADDLE 4

         try{
            Thread.sleep(10);
         } 
         catch (Exception exc){}
         frame.repaint();
      }
   }
}