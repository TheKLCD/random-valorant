import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;

public class Main{
    static int selected = -1; //0 = Agents, 1 = Weapons, -1 neither
  
    public static void main(String[] args){
        //Make Colors
        Color VIOLET = new Color(103, 89, 122);
        Color SELECTED_VIOLET = new Color(71, 61, 84);
        Color DARK_VIOLET = new Color(84, 78, 97);
        Color GRAY = new Color(207, 212, 197);
        Color SELECTED_GRAY = new Color(207, 212, 197);

        //Create window
        JFrame frame = new JFrame("Random Valorant");
        JLabel credits = new JLabel("Made with NO LOVE >:( by KLCD");
        JButton agentsButton = new JButton("Agents");
        JButton weaponsButton = new JButton("Weapons");

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

        //Make the two pannels
        JPanel agents = new JPanel();
        agents.setBackground(GRAY);
        agents.setSize(672, 580);
        agents.setLocation(64, 140);
        agents.setVisible(false);
        agents.setLayout(null);

        File[] agentIcons = new File("images/agent-icons").listFiles();

        JButton[] agentProfiles = new JButton[21];
        Boolean[] agentSelected = new Boolean[21];

        for(int i = 1; i <= 3; i++){
            for(int j = 0; j < 7; j++){
                int num = (i-1)*7+j;

                JButton button = new JButton(new ImageIcon(agentIcons[num*2].getPath()));
                agentProfiles[num] = button;
                agents.add(agentProfiles[num]);

                button.setSize(96, 96);
                button.setLocation(96*j, 96*(i-1));
                button.setBorderPainted(false);

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        int num = button.getBounds().x/96+button.getBounds().y/96*7;
                        if(agentSelected[num]){
                            button.setIcon(new ImageIcon(agentIcons[num*2+1].getPath()));
                        }
                        else{
                            button.setIcon(new ImageIcon(agentIcons[num*2].getPath()));
                        }

                        agentSelected[num] = !agentSelected[num];
                    }
                    });

                agentSelected[num] = true;
            }
        }
        

        frame.add(agents);

        JPanel weapons = new JPanel();
        weapons.setBackground(SELECTED_VIOLET);
        weapons.setSize(644, 580);
        weapons.setLocation(78, 140);
        weapons.setVisible(false);

        frame.add(weapons);

        //Add the two menu selection buttons
        agentsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //Check if this option was already selected
                if(selected == 0){
                    return;
                }
                
                //Check if the other option was selected, if it was change it back
                if(selected == 1){
                    weaponsButton.setBackground(VIOLET);
                    weaponsButton.setForeground(GRAY);
                    weapons.setVisible(false);
                }

                //Change button to show it's selected
                agentsButton.setBackground(SELECTED_VIOLET);
                agentsButton.setForeground(SELECTED_GRAY);
                agents.setVisible(true);
                selected = 0;
                }
        });

        weaponsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //Check if this option was already selected
                if(selected == 1){
                    return;
                }
                
                //Check if the other option was selected, if it was change it back
                if(selected == 0){
                    agentsButton.setBackground(VIOLET);
                    agentsButton.setForeground(GRAY);
                    agents.setVisible(false);
                }

                //Change button to show it's selected
                weaponsButton.setBackground(SELECTED_VIOLET);
                weaponsButton.setForeground(SELECTED_GRAY);
                weapons.setVisible(true);
                selected = 1;
                }
        });

        frame.add(agentsButton);
        agentsButton.setLocation(80, 20);
        agentsButton.setSize(300, 100);
        agentsButton.setBackground(VIOLET);
        agentsButton.setBorderPainted(false);
        agentsButton.setForeground(GRAY);

        frame.add(weaponsButton);
        weaponsButton.setLocation(420, 20);
        weaponsButton.setSize(300, 100);
        weaponsButton.setBackground(VIOLET);
        weaponsButton.setBorderPainted(false);
        weaponsButton.setForeground(GRAY);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}