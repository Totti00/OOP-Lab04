package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms{

	private BasicArm manoSinistra;
	private BasicArm manoDestra;
	
	public RobotWithTwoArms(String robotName) {
		super(robotName);
	}
	
	

	public boolean pickUp() {
		if(manoSinistra.isGrabbing()) {
			if(manoDestra.isGrabbing()) {
				return false;
			}
			controlloPickUp(manoDestra);
			this.consumeBattery(manoDestra.getConsuptionForPickUp());
		}
		else {
			manoSinistra.pickUp();
		}
		return true;
	}
	
	private void controlloPickUp(final BasicArm mano) {
		if(!mano.isGrabbing() && this.isBatteryEnough(mano.getConsuptionForPickUp())) {
			mano.pickUp();
			this.consumeBattery(mano.getConsuptionForPickUp());
			System.out.println("Ho preso l'oggetto");
		}
		else {
			System.out.println("Non è possibile prendere l'oggetto");
		}
	}

	
	private void controlloDropDown(final BasicArm mano) {
		if(mano.isGrabbing() && this.isBatteryEnough(mano.getConsuptionForDropDown())) {
			mano.dropDown();
			this.consumeBattery(mano.getConsuptionForDropDown());
			System.out.println("Ho lasciato l'oggetto");
		}
		else {
			System.out.println("Non è possibile lasciare l'oggetto");
		}
	}
	
	public boolean dropDown() {
		if(manoSinistra.isGrabbing()) {
			controlloDropDown(manoSinistra);
			return true;
		}
		if(manoDestra.isGrabbing()) {
			controlloDropDown(manoDestra);
			return true;
		}
		return false;
	}

	public int getCarriedItemsCount() {
		return (manoSinistra.isGrabbing() ? 1 : 0) + (manoDestra.isGrabbing() ? 1 : 0);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private static final double CONSUMO_TRASPORTO_OGGETTO = 0.1;
	private BasicArm leftArm;
	private BasicArm rightArm;
	
	public RobotWithTwoArms(final String robotName) {
		super(robotName);
		leftArm = new BasicArm("Reft Arm");
		rightArm = new BasicArm("Right Arm");
	}

	
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
	}*/

}
