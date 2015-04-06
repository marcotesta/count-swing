package it.mondogrua.counts;

public class IntegerCount extends Count {
	
	public IntegerCount() {
		initialize();
	}

	@Override
	protected void initialize() {
		setResetValue(0);
		super.initialize();
	};
	
	@Override
	public void increment() {
		setValue((Integer)getValue() + 1);
	}

	@Override
	public void decrement() {
		setValue((Integer)getValue() - 1);
	}
	
}
