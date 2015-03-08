package it.mondogrua.pwf.count.hic;


import it.mondogrua.ui.Button;
import it.mondogrua.ui.DisplayBox;
import it.mondogrua.pwf.count.pdc.Count;
import it.mondogrua.pwf.count.pdc.DateCount;
import it.mondogrua.pwf.count.pdc.IntegerCount;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CountViewContainer {

	private JFrame frame;
	
	private Button buttonIncrement;

	private Button buttonDecrement;

	private Button buttonReset;

	private DisplayBox text;
	

	public CountViewContainer(String aTitle, Count count) {
		initialize(aTitle, count);
	}

	private void initialize(final String aTitle, final Count count) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				frame = new JFrame();
				frame.setTitle(aTitle);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(300,  100);
				frame.setLocationRelativeTo(null);
				frame.setLayout(new GridLayout(2,3));

				buttonIncrement = new Button("Increment", count , "increment");
				buttonIncrement.addTo(frame);
				
				buttonDecrement = new Button("Decrement", count , "decrement");
				buttonDecrement.addTo(frame);
				
				buttonReset = new Button("reset", count , "reset");
				buttonReset.addTo(frame);

				text = new DisplayBox(count, "getValueAsString");
				text.addTo(frame);
				
				frame.setVisible(true);
			}
		});
	}

	public static void main(String[] args) {
		
		Count count = new DateCount();
		
		@SuppressWarnings("unused")
		CountViewContainer frame = new CountViewContainer("Button Example", count);
	}
	
}
