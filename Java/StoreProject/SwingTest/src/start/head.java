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
	JButton button;
	JTextArea text;
	JSplitPane splitPane, splitPane2;
	JPanel bottomPane, topPane;
	int i = 0;
	
	
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
		
		button = new JButton();
		button.setBackground(new Color(150, 150, 200));
		button.setPreferredSize(new Dimension(100, 30));
		button.setText("Button!");
		
		button.addActionListener(this);
		
		text = new JTextArea ();
		text.setOpaque(true);
		text.setBackground(new Color(150, 200, 150));
		text.setPreferredSize(new Dimension(200,60));
		text.setText("Don't Press the Button");
		text.setEditable(false);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, text, button);
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
        JFrame frame = new JFrame("MultiListener");
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
		text.setText("Button Presses: ");
		text.setEditable(false);
		
		frame.add(text);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		i += 1;
		System.out.println(i);
		switch(i%4) {
		case 1:
			text.setText("I told you not to press the button.");
			break;
		case 2:
			text.setText("You did it again!");
			break;
		case 3:
			text.setText("I've given up.");
			break;
		case 0:
			text.setText("Please don't press the button.");
			break;
		}
		createAndShowGUI2();
	}
}
