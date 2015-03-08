package it.mondogrua.ui;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class DisplayBox implements Observer {

	private final JTextField text;
	
	public DisplayBox(Observable count, String action) {
		count.addObserver(this);
		text = new JTextField(10);
		setContent(getContent(count, action));
	}

	public void addTo(JFrame frame) {
		frame.add(text);
	}

	public void setContent(final String value) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				text.setText(value);
			}
		});
	}

	@Override  // Observer
	public void update(Observable observable, Object arg) {
		setContent(getContent(observable, (String) arg));
	}
	
	// Private Methods --------------------------------------------------------
	
	private String getContent(Object model, String action) {
		
		Method method;
		try {
			method = model.getClass().getMethod(action);
			Object ret = method.invoke(model, new Object[]{});
			return ret.toString();
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
		return "";
	}

}