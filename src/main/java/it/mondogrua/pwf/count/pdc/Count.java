package it.mondogrua.pwf.count.pdc;

import java.util.Observable;

public abstract class Count extends Observable {
	
	private Object _value;
	private Object _resetValue;
	
	protected void initialize() {
		reset();
	}

	public Object getValue() {
		return _value;
	}

	public void setValue(Object aValue) {
		_value = aValue;
		setChanged();
		notifyObservers("getValueAsString");
		clearChanged();
	}

	public Object getResetValue() {
		return _resetValue;
	}

	public void setResetValue(Object aResetValue) {
		_resetValue = aResetValue;
	}

	public void reset() {
		setValue(_resetValue);
	}
	
	abstract public void increment();
	
	abstract public void decrement();

	abstract public String getValueAsString();

}
