package it.mondogrua.counts;

import it.mondogrua.utils.Date;


public class DateCount extends Count {

	public DateCount() {
		initialize();
	}

	@Override
	protected void initialize() {
		setResetValue(new Date());
		super.initialize();
	};

	@Override
	public void increment() {
		setValue(((Date)getValue()).addDays(1));
	}

	@Override
	public void decrement() {
		setValue(((Date)getValue()).addDays(-1));
	}

}
