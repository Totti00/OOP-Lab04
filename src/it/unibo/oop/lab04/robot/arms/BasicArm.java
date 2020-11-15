package it.unibo.oop.lab04.robot.arms;

public class BasicArm {
	
	private static final double CONSUMO_PICKUP = 0.2;
	private static final double CONSUMO_DROPDOWN = 0.1;
	
	private boolean grabbing;
	private final String name;
	
	public BasicArm(final String name) {
		this.name = name;
	}
	
	public boolean isGrabbing() {  //sta afferrando
		return this.grabbing;
	}
	
	public void pickUp() {    //raccogliere l'oggetto
		this.grabbing = true;
	}
	
	public void dropDown() {  //lasciare l'oggetto
		this.grabbing = false;
	}
	
	public double getConsuptionForPickUp() {
		return CONSUMO_PICKUP;	
	}
	
	public double getConsuptionForDropDown() {
		return CONSUMO_DROPDOWN;
	}

	public String toString() {
		return "BasicArm [name=" + name + "]";
	}
}

