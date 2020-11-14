package it.unibo.oop.lab04.robot.arms;

public class BasicArm {
	private static final double CONSUMO_MOVIMENTO = 0.2;
	private static final double CONSUMO_RITIRO = 0.1;
	private boolean grabbing;
	private final String name;

	public BasicArm(final String name) {
		this.name = name;
	}
	
	public boolean isGrabbing() {
		return this.grabbing;
	}
	
	public void pickUp() {
		this.grabbing = true;
	}

	public void dropDown() {
		this.grabbing = false;
	}
	
	public double getConsuptionForPickUp() {
		return CONSUMO_MOVIMENTO + CONSUMO_RITIRO;
	}
	
	public double getConsuptionForDropDown() {
		return CONSUMO_MOVIMENTO;
	}

	public String toString() {
		return "BasicArm [name=" + name + "]";
	}
	
}

