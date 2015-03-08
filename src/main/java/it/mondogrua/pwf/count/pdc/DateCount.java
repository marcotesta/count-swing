package it.mondogrua.pwf.count.pdc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCount extends Count {

	public DateCount() {
		initialize();
	}

	protected void initialize() {
		setResetValue(new Date());
		super.initialize();
	};

	@Override
	public void increment() {
		setValue(addDays((Date)getValue(), 1));
	}

	@Override
	public void decrement() {
		setValue(addDays((Date)getValue(), -1));
	}

	@Override
	public String getValueAsString() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return format1.format(((Date)getValue()).getTime());
	}

	
	public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
}
