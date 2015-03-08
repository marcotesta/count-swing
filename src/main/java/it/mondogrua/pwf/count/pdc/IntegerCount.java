package it.mondogrua.pwf.count.pdc;

public class IntegerCount extends Count {
	
	public IntegerCount() {
		initialize();
	}

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
	
	@Override
	public String getValueAsString() {
		return getValue().toString();
	}
	
	public static void main(String[] args) {
		IntegerCount integerCount = new IntegerCount();
		integerCount.increment();
		System.out.println(integerCount.getValue());
		integerCount.increment();
		System.out.println(integerCount.getValue());
	}

	
}
