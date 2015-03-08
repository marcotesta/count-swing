package it.mondogrua.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Button {
	
	private final JButton button;
	
	private final Object model;

	private final String action;

	public Button(String text, Object model, String anAction) {
		this.model = model;
		this.action = anAction;
		button = new JButton(text);
		button.addActionListener(creatActionListener());
	}

	public void addTo(JFrame frame) {
		frame.add(button);
	}
	
	// Private Methods --------------------------------------------------------
	
	private ActionListener creatActionListener() {
		return new ActionListener(){

			public void actionPerformed(ActionEvent event) {
				Method method;
				try {
					method = model.getClass().getMethod(action);
					method.invoke(model, new Object[]{});
				} catch (SecurityException e) {
					// ...
				} catch (NoSuchMethodException e) {
					// ...
				} catch (IllegalAccessException e) {
					// ...
				} catch (IllegalArgumentException e) {
					// ...
				} catch (InvocationTargetException e) {
					// ...
				}

			}
		};
	}

}
