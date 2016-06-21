package com.bakigoal.designPatterns.behavioral.templateMethod;

/**
 * Created by ilmir on 21.06.16.
 */
public abstract class HouseTemplate {

	/**
	 * template method and defines the order of execution for performing several steps.
	 */
	public final void buildHouse() {
		buildFoundation();
		buildWalls();
		buildWindows();
		System.out.println("House is built.");
	}

	//default implementation
	private void buildFoundation() {
		System.out.println("Building foundation with cement,iron rods and sand");
	}

	private void buildWindows() {
		System.out.println("Building Glass Windows");
	}

	//methods to be implemented by subclasses
	protected abstract void buildWalls();

}
