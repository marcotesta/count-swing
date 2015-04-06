package it.mondogrua.ui;


import it.mondogrua.utils.PluggableAdaptor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton {
	
	public Button(String label, PluggableAdaptor aPluggableAdaptor) {
		super(label);
		addActionListener(createActionListener(aPluggableAdaptor));
	}

	// Private Methods --------------------------------------------------------
	
	private ActionListener createActionListener(PluggableAdaptor pluggableAdaptor) {
		return new ActionListener(){

			public void actionPerformed(ActionEvent event) {
				pluggableAdaptor.execute();
			}
		};
	}

}
