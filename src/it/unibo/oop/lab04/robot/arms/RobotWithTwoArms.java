package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms{

	private static final double CONSUMO_TRASPORTO_OGGETTO = 0.1;
	private BasicArm leftArm;
	private BasicArm rightArm;
	
	public RobotWithTwoArms(final String robotName) {
		super(robotName);
		leftArm = new BasicArm("Reft Arm");
		rightArm = new BasicArm("Right Arm");
	}
	
	/*protected double getBatteryRequirementForMovement() {
		return super.getBatteryRequirementForMovement + getCarriedItemsCount() * CONSUMO_TRASPORTO_OGGETTO;
	}*/
	
	private void doPick(final BasicArm arm) {
		if(isBatteryEnough(arm.getConsuptionForPickUp()) && !arm.isGrabbing()) {
			log(arm + " is picking an object");
			arm.pickUp();
			consumeBattery(arm.getConsuptionForPickUp());
		}
		else {
			log("Can not grab (battery=" + this.getBatteryLevel() + "," + arm + "isGrabbing=" + arm.isGrabbing() + ")");
		}
	}
	
	private void doRemove(final BasicArm arm) {
		if(isBatteryEnough(arm.getConsuptionForPickUp()) && arm.isGrabbing()) {
			this.log(arm + " is removing an object");
			arm.dropDown();
		}
		else {
			log("Cannot remove (battery level= " + this.getBatteryLevel() + ", " + arm+ " is Grabbing "+ arm.isGrabbing() + " )");
		}
	}

	public boolean pickUp() {
		if(leftArm.isGrabbing()) {
			if(rightArm.isGrabbing()) {
				return false;
			}
			doPick(rightArm);
		}
		else {
			doPick(leftArm);
		}
		return true;
	}

	public boolean dropDown() {
		if(leftArm.isGrabbing()) {
			doRemove(leftArm);
			return true;
		}
		if(rightArm.isGrabbing()) {
			doRemove(rightArm);
			return true;
		}
		return false;
	}

	public int getCarriedItemsCount() {
		
		return ((leftArm.isGrabbing() ? 1 : 0 )+(rightArm.isGrabbing() ? 1 : 0));
	}

}
