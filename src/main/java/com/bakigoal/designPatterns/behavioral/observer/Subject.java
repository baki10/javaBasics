package com.bakigoal.designPatterns.behavioral.observer;

/**
 * Created by ilmir on 21.06.16.
 */
public interface Subject {

	//methods to register and unregister observers
	void register(Observer obj);
	void unregister(Observer obj);

	//method to notify observers of change
	void notifyObservers();

	//method to get updates from subject
	Object getUpdate(Observer obj);

}
