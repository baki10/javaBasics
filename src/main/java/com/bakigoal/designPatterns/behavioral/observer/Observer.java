package com.bakigoal.designPatterns.behavioral.observer;

/**
 * Created by ilmir on 21.06.16.
 */
public interface Observer {

	//method to update the observer, used by subject
	void update();

	//attach with subject to observe
	void setSubject(Subject sub);
}
