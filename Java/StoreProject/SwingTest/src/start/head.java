package start;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class head extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JMenuBar menu;
	JLabel label;
	JButton button, button2;
	JTextArea text;
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
		button.setText("Good");
		
		button2 = new JButton();
		button2.setBackground(new Color(150, 200, 200));
		button2.setPreferredSize(new Dimension(100, 40));
		button2.setText("Evil");
		
		button.addActionListener(this);
		button2.addActionListener(this);
		
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
	
	private static void createAndShowGUI2() {
		JFrame frame = new JFrame("frame");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea text = new JTextArea();
		text.setPreferredSize(new Dimension(200,100));
		if (i > 0) {
			text.setText("Good is Winning\nGood: +" + i);
		} else if (i < 0) {
			text.setText("Evil is Winning\nEvil: " + i);
		} else {
			text.setText("Good and Evil are tied");
		}
		text.setEditable(false);
		
		frame.add(text);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button)) {
			i += 1;
			if (i > 0)
				text.setText("Good is rapidly advancing!\nGood: +" + i);
			else if (i < 0)
				text.setText("Evil reigns, but Good fights back!\nEvil: " + i);
			else
				text.setText("Good has tied the game.\nGood: +0\nEvil: -0");
		} else if (e.getSource().equals(button2)) {
			i -= 1;
			if (i > 0)
				text.setText("Good is losing ground!\nGood: +" + i);
			else if (i < 0)
				text.setText("Evil will prevail!\nEvil: " + i);
			else
				text.setText("Evil has tied the game.\nGood: +0\nEvil: -0");
		}		
	}
}
