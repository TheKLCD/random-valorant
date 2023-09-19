import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.color.*;
import javax.swing.*;


public class Main{
    public static void main(String[] args){
        //Make Colors
        Color VIOLET = new Color(103, 89, 122);
        Color DARK_VIOLET = new Color(84, 78, 97);
        Color GRAY = new Color(207, 212, 197);

        //Create window
        JFrame frame = new JFrame("Random Valorant");
        JLabel credits = new JLabel("Made with NO LOVE >:( by KLCD");
        JButton agents = new JButton("Agents");
        JButton weapons = new JButton("Weapons");

        //Window Settings
        frame.setSize(820, 800);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(DARK_VIOLET);
        
        ImageIcon icon = new ImageIcon("images\\icon.png");
        frame.setIconImage(icon.getImage());

        //Add the credits
        frame.add(credits);
        credits.setFont(new Font("Arial", Font.PLAIN, 12));
        credits.setForeground(GRAY);
        credits.setLocation(320, 730);
        credits.setSize(200, 15);

        //Add the two menu selection buttons
        boolean selected = true; //True = Agents, False = Weapons

        agents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                credits.setText("Agents Button clicked.");
            }
        });

        weapons.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                credits.setText("Weapons Button clicked.");
            }
        });

        frame.add(agents);
        agents.setLocation(80, 20);
        agents.setSize(300, 100);
        agents.setBackground(VIOLET);
        agents.setBorderPainted(false);
        agents.setForeground(GRAY);

        frame.add(weapons);
        weapons.setLocation(420, 20);
        weapons.setSize(300, 100);
        weapons.setBackground(VIOLET);
        weapons.setBorderPainted(false);
        weapons.setForeground(GRAY);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}