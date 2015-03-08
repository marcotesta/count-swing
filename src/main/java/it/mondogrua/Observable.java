package it.mondogrua;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Observable {

	ArrayList<WeakReference<Observer>> observers;
	
	public abstract String getValueAsString();
	
	public void attach(Observer observer) {
		observers.add(new WeakReference<Observer>(observer))	;
	}

	public void updateAll() {
		
	    for (Iterator<WeakReference<Observer>> it = observers.iterator(); it.hasNext(); ) {
            WeakReference<Observer> ref =  it.next();
            if (ref.get() == null) {
            	observers.remove(ref);
            }
            Observer observer = ref.get();
            
            observer.update();
        }

		
	}
}
