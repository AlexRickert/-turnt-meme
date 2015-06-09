package my.contacteditor;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ros_asrickert on 5/29/2015.
 */

public class ActuallyMain {
    private JFrame frame = new JFrame("Four Person Pong");
    private DrawPanel dP;
    private ButtonGroup buttonGroup1;
    private JButton jButton1;
    private JCheckBox jCheckBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private boolean speed = false;
    JLayeredPane mainPanel = new JLayeredPane();
    private boolean red = true;
    private boolean blue = false;
    private boolean green = false;
    private int BallOneX;
    private int BallOneY;

    private int Paddle1x;
    private boolean Paddle1Right = true;

    private int Paddle2Y;
    private boolean Paddle2Up = true;

    private int Paddle3x;
    private boolean Paddle3Right = true;

    private int Paddle4Y;
    private boolean Paddle4Up = true;

    boolean up = true;
    boolean down = false;
    boolean left = false;
    boolean right = true;

    public static void main (String[] args) {
        new ActuallyMain().run();
    }



    public void keyPressed(KeyEvent e) {
        System.out.println(e);
    }

    private void moveIt() {
        while(true){
            //BALL
            if(BallOneX >= 715){
                right = false;
                left = true;
            }
            if(BallOneX <= 0){
                right = true;
                left = false;
            }
            if(BallOneY >= 695){
                up = true;
                down = false;
            }
            if(BallOneY <= 0){
                up = false;
                down = true;
            }
            if(up){
                if(speed) {
                    BallOneY -= 10;
                } else {
                    BallOneY -= 5;
                }
            }
            if(down){
                if(speed) {
                    BallOneY += 10;
                } else {
                BallOneY += 5;
                }
            }
            if(left){
                if(speed) {
                    BallOneX -= 10;
                } else {
                    BallOneX -= 5;
                }
            }
            if(right){
                if(speed) {
                    BallOneX += 10;
                } else {
                    BallOneX += 5;
                }
            }
            //BALL

            //PADDLE 1
            if(Paddle1x >= 720){
                Paddle1Right = false;
            }
            if(Paddle1x <= 0){
                Paddle1Right = true;
            }
            //PADDLE 1

            //PADDLE 2
            //ADD IN LATER
            //PADDLE 2

            //PADDLE 3
            if(Paddle3x >= 645){
                Paddle3Right = false;
            }
            if(Paddle3x <= 10){
                Paddle3Right = true;
            }
            //PADDLE 3

            //PADDLE 4
            //ADD IN LATER
            //PADDLE 4

            try{
                Thread.sleep(10);
            }
            catch (Exception exc){}
            frame.repaint();
        }
    }

    class DrawPanel extends JPanel {

        public void paintComponent(Graphics g) {

            g.setColor(Color.WHITE);
            g.fillRect(6, 6, this.getWidth()-12, this.getHeight()-12);

            g.setColor(Color.BLACK);
            g.fillRect(Paddle1x + 200, 30, 175, 20);
            //ADD PADDLE 2
            g.fillRect(Paddle3x + 350, 685, 175, 20);
            //ADD PADDLE 4

            g.setColor(Color.RED);

            g.drawOval(BallOneX, BallOneY, 30, 30);
            g.fillPolygon(new int[]{BallOneX +15, BallOneX +24, BallOneX +2, BallOneX +28, BallOneX +6}, new int[]{BallOneY, BallOneY +27, BallOneY +10, BallOneY +10, BallOneY +27}, 5);


        }
    }

    private void run() {
        mainPanel.setLayout(null);
        buttonGroup1 = new ButtonGroup();
        jButton1 = new JButton();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        jCheckBox1 = new JCheckBox();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        jButton1.setText("Play Game!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Red Ball");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Green Ball");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Blue Ball");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Speed Run");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("4 Person Pong!");

        jLabel2.setText("Settings");

        mainPanel.setMaximumSize(new Dimension(1280, 1024));

    //ADDING SHIT TO THE THING

        jLabel1.setBounds(300,0,100,50);
        mainPanel.add(jLabel1,0);

        jLabel2.setBounds(0,0,75,50 );
        mainPanel.add(jLabel2,0);

        jRadioButton1.setBounds(0,40,100,40);
        jRadioButton1.setBackground(Color.red);
        mainPanel.add(jRadioButton1,0);

        jRadioButton2.setBounds(0,80,100,40);
        jRadioButton2.setBackground(Color.green);
        mainPanel.add(jRadioButton2,0);

        jRadioButton3.setBounds(0,120,100,40);
        jRadioButton3.setBackground(Color.cyan);
        mainPanel.add(jRadioButton3,0);

        jCheckBox1.setBounds(0,160,100,40);
        jCheckBox1.setBackground(Color.ORANGE);
        mainPanel.add(jCheckBox1,0);

        //mainPanel.addKeyListener(KeyListener);

        jButton1.setBounds(175,125,500,500);
        mainPanel.add(jButton1,0);
        mainPanel.setVisible(true);
        frame.add(mainPanel, 1);
        dP = new DrawPanel();
        dP.setVisible(false);
        dP.setBackground(Color.WHITE);
        frame.add(dP, 0);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setVisible(true);
        frame.setResizable(false);

        moveIt();

    }

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        green = false;
        blue = false;
        red = true;
        System.out.println("red");
    }

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        green = true;
        blue = false;
        red = false;
        System.out.println("green");
    }

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        green = false;
        blue = true;
        red = false;
        System.out.println("blue");
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         System.out.println("What up");

        jButton1.setVisible(false);
        jRadioButton1.setVisible(false);
        jRadioButton2.setVisible(false);
        jRadioButton3.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jCheckBox1.setVisible(false);
        dP.setVisible(true);




        //new FourPersonPong.TesterForJavaSwing().go();
    }

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        if (speed) {
            speed = false;
            System.out.println(speed);
        } else {
            speed = true;
            System.out.println(speed);
        }

    }
}
