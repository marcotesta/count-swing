package it.mondogrua.ui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Frame {

	private final JFrame frame;

	public Frame(String aTitle) {
		super();
		this.frame = new JFrame();
		initialize(aTitle);
	}
	
	private void initialize(String aTitle) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				frame.setTitle(aTitle);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setBounds(200, 200, 320, 150);
		//		frame.setSize(320, 100);
		//		frame.setLocationRelativeTo(null);
		
				GridBagLayout gridBagLayout = new GridBagLayout();
				gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
				gridBagLayout.rowHeights = new int[]{35, 59, 0};
				gridBagLayout.columnWeights = new double[]{0.33, 0.33, 0.33, Double.MIN_VALUE};
				gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		
				frame.getContentPane().setLayout(gridBagLayout);
			}
		});
	}

	public void add(Component component, GridBagConstraints gbc) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.getContentPane().add(component, gbc);
			}
		});
	}

	public void setVisible(boolean visible) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.setVisible(visible);;
			}
		});
	}
}
