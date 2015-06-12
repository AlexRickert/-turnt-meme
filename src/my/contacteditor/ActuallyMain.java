package my.contacteditor;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

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
    listener heyListen;
    JLayeredPane mainPanel = new JLayeredPane();
    private boolean red = true;
    private boolean blue = false;
    private boolean green = false;
    private int BallOneX = 150;
    private int BallOneY = 250;
    private int Player1Points = 0;
    private int Player2Points = 0;
    private int Player3Points = 0;
    private int Player4Points = 0;

    private int Paddle1x = 150;
    private int Paddle1Right = 0;

    private int Paddle2Y = 200;
    private int Paddle2Up = 0;

    private int Paddle3x = 550;
    private int Paddle3Right = 0;

    private int Paddle4Y = 400;
    private int Paddle4Up = 0;

    private int randomSlope;

    boolean up = false;
    boolean down = true;
    boolean left = false;
    boolean right = true;

    public static void main (String[] args) {
        new ActuallyMain().run();
    }

    public class listener extends JPanel {
        public listener() {
            KeyListener tom = new IsKeyListener();
            addKeyListener(tom);
            setFocusable(true);
        }

        public class IsKeyListener implements KeyListener {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    Paddle1Right = 1;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    Paddle1Right = -1;
                }

                if (e.getKeyCode() == KeyEvent.VK_U) {
                    Paddle2Up = 1;
                }
                if (e.getKeyCode() == KeyEvent.VK_J) {
                    Paddle2Up = -1;
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    Paddle3Right = 1;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    Paddle3Right = -1;
                }

                if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
                    Paddle4Up = -1;
                }
                if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
                    Paddle4Up = 1;
                }
//a
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    Paddle1Right = 0;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    Paddle1Right = 0;
                }

                if (e.getKeyCode() == KeyEvent.VK_U) {
                    Paddle2Up = 0;
                }
                if (e.getKeyCode() == KeyEvent.VK_J) {
                    Paddle2Up = 0;
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    Paddle3Right = 0;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    Paddle3Right = 0;
                }

                if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
                    Paddle4Up = 0;
                }
                if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
                    Paddle4Up = 0;
                }
            }
        }
    }

    private void moveIt() {
        while(true) {


            //BALL
            if (BallOneX >= 715) {
                Player2Points += 1;
                System.out.println("Player Two Loses!!!");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
            if (BallOneX <= 0) {
                Player4Points += 1;
                System.out.println("Player Four Loses!!!");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
            if (BallOneY >= 695) {
                Player3Points += 1;
                System.out.println("Player Three Loses!!!");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
            if (BallOneY <= 0) {
                Player1Points += 1;
                System.out.println("Player One Loses!!!");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }

            //BOUNCY SHIT
            if (BallOneX >= 655 && BallOneY >= Paddle2Y && BallOneY <= Paddle2Y + 175) {
                right = false;
                left = true;
                randomSlope = ((int) (Math.random() * 10)) /2;
            }
            if (BallOneX <= 45 && BallOneY >= Paddle4Y && BallOneY <= Paddle4Y + 175) {
                right = true;
                left = false;
                randomSlope = ((int) (Math.random() * 10)) /2;
            }
            if (BallOneY >= 645 && BallOneX >= Paddle3x && BallOneX <= Paddle3x + 175) {
                up = true;
                down = false;
                randomSlope = ((int) (Math.random() * 10)) /2;
            }
            if (BallOneY <= 45 && BallOneX >= Paddle1x && BallOneX <= Paddle3x + 175) {
                up = false;
                down = true;
                randomSlope = ((int) (Math.random() * 10)) / 2;
            }
            System.out.println(randomSlope);
            if (up) {
                if (speed) {
                    BallOneY -= 6;
                } else {
                    BallOneY -= 2;
                    BallOneY -= randomSlope;
                }
            }
            if (down) {
                if (speed) {
                    BallOneY += 6;
                } else {
                    BallOneY += 2;
                    BallOneY += randomSlope;
                }
            }
            if (left) {
                if (speed) {
                    BallOneX -= 6;
                } else {
                    BallOneX -= 2;
                    BallOneX -= randomSlope;
                }
            }
            if (right) {
                if (speed) {
                    BallOneX += 6;
                } else {
                    BallOneX += 2;
                    BallOneX += randomSlope;
                }
            }
            //BALL
//
            //PADDLE 1
            if (Paddle1x >= 570) {
                Paddle1Right = -1;
            }
            if (Paddle1x <= 0) {
                Paddle1Right = 1;
            }
            //PADDLE 1
            if (Paddle1Right == 1) {
                Paddle1x += 4;
            } else if (Paddle1Right == 0){} else {
                Paddle1x -= 4;
            }

            //PADDLE 2
            if(Paddle2Y >= 570){
                Paddle2Up = 1;
            }
            if(Paddle2Y <= 0){
                Paddle2Up = -1;
            }

            //PADDLE 2
            if (Paddle2Up == 1) {
                Paddle2Y -= 4;
            } else if (Paddle2Up == 0){}
            else {
                Paddle2Y += 4;
            }

            //PADDLE 3
            if(Paddle3x >= 570){
                Paddle3Right = -1;
            }
            if(Paddle3x <= 0){
                Paddle3Right = 1;
            }
            //PADDLE 3
            if (Paddle3Right == 1) {
                Paddle3x += 4;
            } else if (Paddle3Right == 0){}
            else {
                Paddle3x -= 4;
            }

            //PADDLE 4
            if(Paddle4Y >= 570){
                Paddle4Up = 1;
            }
            if(Paddle4Y <= 0){
                Paddle4Up = -1;
            }

            //PADDLE 4
            if (Paddle4Up == 1) {
                Paddle4Y -= 4;
            } else if (Paddle4Up == 0){}
            else {
                Paddle4Y += 4;
            }

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
            g.fillRect(Paddle1x , 30, 175, 20);
            g.fillRect(685, Paddle2Y, 20, 175);
            g.fillRect(Paddle3x , 685, 175, 20);
            g.fillRect(30, Paddle4Y, 20, 175);

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
    //    mainPanel.add(jRadioButton1,0);

        jRadioButton2.setBounds(0,80,100,40);
        jRadioButton2.setBackground(Color.green);
    //    mainPanel.add(jRadioButton2,0);

        jRadioButton3.setBounds(0,120,100,40);
        jRadioButton3.setBackground(Color.cyan);
    //    mainPanel.add(jRadioButton3,0);

        jCheckBox1.setBounds(0,160,100,40);
        jCheckBox1.setBackground(Color.ORANGE);
    //    mainPanel.add(jCheckBox1,0);

        jButton1.setBounds(175, 125, 500, 500);
    //    mainPanel.add(jButton1,0);
        mainPanel.setVisible(true);
        frame.add(mainPanel, 0);
        dP = new DrawPanel();
        dP.setVisible(true);
        dP.setBackground(Color.WHITE);
        heyListen = new listener();
        frame.add(heyListen);
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
