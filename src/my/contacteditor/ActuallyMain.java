package my.contacteditor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ros_asrickert on 5/29/2015.
 */

public class ActuallyMain {
    private JFrame frame = new JFrame();
    private JPanel mainPanel = new JPanel();
    private ButtonGroup buttonGroup1;
    private JButton jButton1;
    private JCheckBox jCheckBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private boolean speed = false;
    private GroupLayout layout = new GroupLayout(mainPanel);

    public static void main (String[] args) {
        new ActuallyMain().run();
    }

    private void run() {
        mainPanel.setLayout(new GridLayout());
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

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Green Ball");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Blue Ball");

        jCheckBox1.setText("Speed Run");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("4 Person Pong!");

        jLabel2.setText("Settings");

        layout.setHorizontalGroup(
                        (layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(112, 112, 112)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2))
                                                        .addComponent(jRadioButton2)
                                                        .addComponent(jRadioButton1)
                                                        .addComponent(jRadioButton3)
                                                        .addComponent(jCheckBox1)
                                                .addContainerGap(39, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel1)
                                                .addGap(148, 148, 148))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jRadioButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jRadioButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jRadioButton3))
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(86, Short.MAX_VALUE))
        );

        frame.add(mainPanel);

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setVisible(true);

    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         System.out.println("What up");

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
