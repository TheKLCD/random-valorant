/*
This Program was designed to pick a random agent/weapon in the game Valorant
Please feel free to use this code wherever you want just make sure to give me credit!
Made by KLCD (Twitter: @TheKLCD, Discord: KLCD)
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        ImageIcon icon = new ImageIcon("images\\icon.png");
        frame.setIconImage(icon.getImage());

        //Add the credits
        frame.add(credits);
        credits.setFont(new Font("Arial", Font.PLAIN, 12));
        credits.setForeground(GRAY);
        credits.setLocation(320, 730);
        credits.setSize(200, 15);

        //Make the two panels
        JPanel agentsPanel = new JPanel();
        agentsPanel.setBackground(DARK_VIOLET);
        agentsPanel.setSize(672, 580);
        agentsPanel.setLocation(64, 140);
        agentsPanel.setVisible(false);
        agentsPanel.setLayout(null);

        //Make and store all the agents and their buttons
        String[] agentNames = {"astra", "breach", "brimstone", "chamber", "cypher", "fade", "gecko", "harbor", "jett", "kayo", "killjoy", "neon", "omen", "pheonix", "raze", "reyna", "sage", "skye", "sova", "viper", "yoru"};
        Agent[] agents = new Agent[21];

        //Make the agents
        for(int i = 0; i < agentNames.length; i++){
          agents[i] = new Agent(agentNames[i]);
        }

        //Loop through each agent and make their button
        for(int i = 1; i <= 3; i++){
            for(int j = 0; j < 7; j++){
                int num = (i-1)*7+j;

                JButton button = new JButton(agents[num].getSelectedIcon());
                agentsPanel.add(button);

                button.setSize(96, 96);
                button.setLocation(96*j, 96*(i-1));
                button.setBorderPainted(false);

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        //When the button is pressed, activate the agents press method
                        int num = button.getBounds().x/96+button.getBounds().y/96*7;
                        button.setIcon(agents[num].press());
                    }
                });
            }
        }

        //Add the selected agent
        JLabel selectedAgent = new JLabel();
        agentsPanel.add(selectedAgent);
        selectedAgent.setSize(96, 96);
        selectedAgent.setLocation(340, 350);
        selectedAgent.setBackground(DARK_VIOLET);
        selectedAgent.setVisible(true);
        
        //Add select button
        JButton select = new JButton("Select");
        agentsPanel.add(select);
        select.setBackground(VIOLET);
        select.setForeground(GRAY);
        select.setSize(200, 100);
        select.setLocation(120, 350);
        select.setBorderPainted(false);

        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //When the select button is pressed pick a random agent

                //Count the amount of agents currently selected
                int amountOfSelected = 0;

                for(Agent agent:agents){
                    if(agent.isSelected()){
                        amountOfSelected++;
                    }
                }

                //If there are none selected, show no agent
                if(amountOfSelected == 0){
                    selectedAgent.setIcon(null);
                    return;
                }

                //Pick a random number from 0 to the number of agents selected
                int random = (int)(Math.random()*amountOfSelected);

                //Loop through all the agents
                for(int i = 0; i < 21; i++){
                    if(agents[i].isSelected() && random > 0){
                        //If that agent is selected but random is greater then 0, remove one from random
                        random--;
                    }
                    else if(agents[i].isSelected()){
                        //Otherwise, pick that agent
                        selectedAgent.setIcon(agents[i].getSelectedIcon());;
                        return;
                    }
                }
            }
        });

        //Add the agent panel to the window
        frame.add(agentsPanel);

        //Add weapons panel
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
                agentsPanel.setVisible(true);
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
                    agentsPanel.setVisible(false);
                }

                //Change button to show it's selected
                weaponsButton.setBackground(SELECTED_VIOLET);
                weaponsButton.setForeground(SELECTED_GRAY);
                weapons.setVisible(true);
                selected = 1;
                }
        });

        //Agents button settings
        frame.add(agentsButton);
        agentsButton.setLocation(80, 20);
        agentsButton.setSize(300, 100);
        agentsButton.setBackground(VIOLET);
        agentsButton.setBorderPainted(false);
        agentsButton.setForeground(GRAY);

        //Weapons button settings
        frame.add(weaponsButton);
        weaponsButton.setLocation(420, 20);
        weaponsButton.setSize(300, 100);
        weaponsButton.setBackground(VIOLET);
        weaponsButton.setBorderPainted(false);
        weaponsButton.setForeground(GRAY);
    }
}