package it.mondogrua.count_views;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import it.mondogrua.counts.Count;
import it.mondogrua.counts.DateCount;
import it.mondogrua.counts.IntegerCount;
import it.mondogrua.ui.Button;
import it.mondogrua.ui.DisplayBox;
import it.mondogrua.ui.Frame;
import it.mondogrua.utils.PluggableAdaptor;

@SuppressWarnings("serial")
public class CountViewContainer extends JPanel {

	public CountViewContainer() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{35, 59, 0};
		gridBagLayout.columnWeights = new double[]{0.33, 0.33, 0.33, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};

		setLayout(gridBagLayout);
	}

	public void openOn(final Count count, String aTitle ) {
		buildViewsOn(count);
		Frame frame = new Frame(aTitle);
		GridBagConstraints gbc =  new GridBagConstraints();
		frame.add(this, gbc);
		frame.setVisible(true);
	}
	
	// Private Methods --------------------------------------------------------

	private void buildViewsOn(final Count count) {
		addDisplayBoxOn(count);
		addIncrementButtonOn(count);
		addDecrementButtonOn(count);
		addResetButtonOn(count);
	}

	private void addDisplayBoxOn(final Count count) {
		DisplayBox displayBox = makeDisplayBoxOn(count, "getValue");
		GridBagConstraints constraintFrame = makeConstraintFrame(1, 1);
		add(displayBox, constraintFrame);
	}

	private void addResetButtonOn(final Count count) {
		Button button = makeButtonOn(count, "Reset", "reset");
		GridBagConstraints constraintFrame = makeConstraintFrame(2, 0);
		add(button, constraintFrame);
	}

	private void addDecrementButtonOn(final Count count) {
		Button button = makeButtonOn(count, "Decrement", "decrement");
		GridBagConstraints constraintFrame = makeConstraintFrame(1, 0);
		add(button, constraintFrame);
	}

	private void addIncrementButtonOn(final Count count) {
		Button button = makeButtonOn(count, "Increment", "increment");
		GridBagConstraints constraintFrame = makeConstraintFrame(0, 0);
		add(button, constraintFrame);
	}

	private Button makeButtonOn(final Count count, String label, String action) {
		return new Button(label, new PluggableAdaptor(count , action, new Object[]{}));
	}
	
	private DisplayBox makeDisplayBoxOn(final Count count, String action) {
		return new DisplayBox(count, action);
	}
	
	private GridBagConstraints makeConstraintFrame(int x, int y) {
		GridBagConstraints constraintFrame = new GridBagConstraints();
		constraintFrame.insets = new Insets(5, 5, 5, 5);
		constraintFrame.gridx = x;
		constraintFrame.gridy = y;
		return constraintFrame;
	}
	
	public static void main(String[] args) {
		
		CountViewContainer frame = new CountViewContainer();
		frame.openOn(new DateCount(), "DateCount Example");
		
		CountViewContainer frame2 = new CountViewContainer();
		frame2.openOn(new IntegerCount(), "IntegerCount Example");
	}
	
}
