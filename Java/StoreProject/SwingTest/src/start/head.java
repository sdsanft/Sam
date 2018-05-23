package start;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class head extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame, addFrame;
	JMenuBar menu;
	JLabel label;
	JButton button, button2;
	JTextArea text, addText, addTextName, addTextId;
	JSplitPane splitPane, splitPane2, splitPane3;
	JPanel bottomPane, topPane, rightPane;
	static int i = 0;
	
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run () {
				createAndShowGUI();
			}
		});
	}

	public head() {
		menu = new JMenuBar ();
		menu.setOpaque(true);
		menu.setBackground(new Color(150, 200, 150));
		menu.setPreferredSize(new Dimension(200, 40));
		
		label = new JLabel ();
		label.setOpaque(true);
		label.setBackground(new Color(250, 250, 200));
		label.setPreferredSize(new Dimension(300, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("Good vs. Evil");
		
		button = new JButton();
		button.setBackground(new Color(150, 150, 200));
		button.setPreferredSize(new Dimension(100, 40));
		button.setText("Add item");
		
		button2 = new JButton();
		button2.setBackground(new Color(150, 150, 200));
		button2.setPreferredSize(new Dimension(100, 40));
		button2.setText("Sell item");
				
		button.addActionListener(this);
		
		text = new JTextArea ();
		text.setOpaque(true);
		text.setBackground(new Color(150, 200, 150));
		text.setPreferredSize(new Dimension(200,80));
		text.setText("Press a button to begin the game");
		text.setEditable(false);
		
		splitPane3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, button, button2);
		rightPane = new JPanel(new GridLayout(1, 0));
		rightPane.add(splitPane3);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, text, rightPane);
		splitPane.setResizeWeight(0.5);
		bottomPane = new JPanel(new GridLayout(1, 0));
		bottomPane.add(splitPane);
		
		splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, label, bottomPane);
		topPane = new JPanel(new GridLayout(1, 0));
		topPane.add(splitPane2);
		
		//setMenuPanel(menu);
		add(topPane);
	}
	
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Good vs. Evil");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new head();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	private void addItems() {
		addFrame = new JFrame("frame");
		
		addText = new JTextArea();
		addText.setBackground (new Color(180, 220, 180));
		addText.setText("Add Items");
		addText.setEditable(false);
		
		addTextName = new JTextArea("item name");
		addTextName.setBackground(new Color(200, 200, 200));
		addTextName.setEditable(true);
		
		addTextId = new JTextArea("id");
		addTextId.setBackground(new Color(180, 180, 180));
		addTextId.setEditable(true);
				
		addFrame.pack();
		addFrame.setVisible(true);
	}
	
	private static void sellItems() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button)) {
			addItems();
		} else if (e.getSource().equals(button2)) {
			sellItems();
		}
	}
}
