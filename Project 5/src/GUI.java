import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

public class GUI extends JFrame {
    
	private static final long serialVersionUID = 1L;
	private Field<Block> field;
	private JComboBox<String> comboBox;
	private JTextArea textArea;
	private JButton loadButton;
	private JButton runButton;
	private JPanel contentPanel;
    
    public GUI() {
	    super("Game");
	    setPreferredSize(new Dimension(600, 400));
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    comboBox = new JComboBox<>(new String[]{"Entire Field", "Obstacles Only", "Passages Only"});
	    textArea = new JTextArea();
	    loadButton = new JButton("Load Data");
	    runButton = new JButton("Run Iteration");
	    
	    loadButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            JFileChooser fileChooser = new JFileChooser();
	            int result = fileChooser.showOpenDialog(GUI.this);
	            if (result == JFileChooser.APPROVE_OPTION) {
	                field = FieldGenerator.loadDataFromFile(fileChooser.getSelectedFile().getPath());
					textArea.append("Data loaded from file.\n");
	            }
	        }
	    });
	    
	    runButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (field == null) {
	                textArea.append("Error: No data loaded.\n");
	                return;
	            }
	            String selectedOption = (String) comboBox.getSelectedItem();
	            if (selectedOption.equals("Entire Field")) {
	                textArea.append("Running iteration on entire field...\n");
	                ArrayList<Block> bestRoute = Game.bestRoute(field, Game.bestStartingPoint(field).startingColumn);
	                StringBuilder sb = new StringBuilder();
	                for (Block block : bestRoute) {
	                    sb.append(block.toString() + "\n");
	                }
	                textArea.append("Best Route:\n" + sb.toString());
	            } else if (selectedOption.equals("Obstacles Only")) {
	                textArea.append("Running iteration on obstacles only...\n");
	                Iterator<Block> it = field.iterator("Obstacle");
	                while (it.hasNext()) {
	                    Block block = it.next();
	                    int points = Game.bestStartingPoint(field).totalPoints;
	                    textArea.append("Obstacle at " + block.toString() + " has " + points + " points.\n");
	                }
	            } else if (selectedOption.equals("Passages Only")) {
	                textArea.append("Running iteration on passages only...\n");
	                Iterator<Block> it = field.iterator("Passage");
	                while (it.hasNext()) {
	                    Block block = it.next();
	                    int points = Game.bestStartingPoint(field).totalPoints;
	                    textArea.append("Passage at " + block.toString() + " has " + points + " points.\n");
	                }
	            }
	        }
	    });
	    
	    contentPanel = new JPanel(new BorderLayout());
	    JPanel controlPanel = new JPanel(new FlowLayout());
	    controlPanel.add(loadButton);
	    controlPanel.add(comboBox);
	    controlPanel.add(runButton);
	    contentPanel.add(controlPanel, BorderLayout.NORTH);
	    contentPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
	    
	    setContentPane(contentPanel);
	    pack();
	    setLocationRelativeTo(null);
	    setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }
}

