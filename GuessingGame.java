package task2;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingGame extends JFrame implements ActionListener {
    Random random=new Random();
    int compInput=random.nextInt(101)+1;

    JLabel label1=new JLabel();
    JLabel label2=new JLabel();
    JLabel label3=new JLabel();
    JTextField text=new JTextField();
    JButton button=new JButton();
    JButton button2=new JButton();
    JButton button3=new JButton();
    static int count=0;
    public GuessingGame(){
        label1.setText("Welcome to Game");
        label1.setBounds(200,-20,500,140);
        label1.setFont(new Font(null,Font.BOLD,40));
        label1.setForeground(Color.GREEN);

        ImageIcon i1=new ImageIcon("ggame2.png");
        Image i2=i1.getImage().getScaledInstance(160,130,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);


        label2.setText("Enter your Number:");
        label2.setBounds(40,100,200,200);
        label2.setFont(new Font(null,Font.PLAIN,20));
        label2.setForeground(Color.white);

        label3.setIcon(i3);
        label3.setBounds(30,10,200,80);


        text.setBounds(225,185,150,30);

        button.setText("Play");
        button.setBounds(225,250,120,50);
        button.setBackground(Color.blue);
        button.setFont(new Font(null,Font.PLAIN,15));
        button.setForeground(Color.white);
        button.setFocusable(false);
        button.addActionListener(this);
        button.setVisible(true);

        button2.setText("Play Again");
        button2.setBounds(225,250,120,50);
        button2.setVisible(false);
        button2.setBackground(Color.blue);
        button2.setFont(new Font(null,Font.PLAIN,15));
        button2.setForeground(Color.white);
        button2.setFocusable(false);
        button2.addActionListener(this);

        button3.setText("Give up?");
        button3.setBounds(370,250,128,50);
        button3.setBackground(Color.red);
        button3.setFont(new Font(null,Font.PLAIN,15));
        button3.setForeground(Color.white);
        button3.setFocusable(false);
        button3.setVisible(true);
        button3.addActionListener(this);

        this.setTitle("Guessing Game");
        this.setSize(800,600);
        this.setLocation(300,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
        this.setLayout(null);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(text);
        this.add(button);
        this.add(button2);
        this.add(button3);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            boolean ans=false;
            if (e.getSource() == button) {
                int userInput = Integer.parseInt(text.getText());
                count++;
                int attempts=5-count;

                if (userInput == compInput) {
                    JOptionPane.showMessageDialog(this, "You have guessed correct no in " + count + " attempts");
                    button.setVisible(false);
                    button2.setVisible(true);
                    ans=true;
                }
                if(count>=5 && ans==false) {
                    JOptionPane.showMessageDialog(this, "You have exhausted all your attempts.Starting new game.....");
                    count=0;
                    this.dispose();
                    new GuessingGame();
                }
                else if (userInput > compInput && userInput<101) {
                    JOptionPane.showMessageDialog(this, "Wrong answer.No of attempts left="+attempts +"\n**Hint:Enter smaller no than " + userInput);
                } else if (userInput < compInput && userInput>=0 ) {
                    JOptionPane.showMessageDialog(this, "Wrong answer.No of attempts left="+attempts+"\n**Hint:Enter bigger no than " + userInput);
                }
                if(userInput>100 && userInput>compInput) {
                    JOptionPane.showMessageDialog(this, "Please enter number less than 101");
                }
                if(userInput<0 && userInput<compInput){
                    JOptionPane.showMessageDialog(this,"Please enter number greater than 0");
                }
            }
            if (e.getSource() == button2) {
                this.dispose();
                new GuessingGame();
            }
            if (e.getSource() == button3) {
                JOptionPane.showMessageDialog(this, compInput);
                button.setVisible(true);
                button2.setVisible(false);
                button3.setVisible(false);
            }
        }
        catch(NumberFormatException excp) {
            JOptionPane.showMessageDialog(this,"Please enter a valid Number");
        }
    }
}
