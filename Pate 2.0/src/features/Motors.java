package features;

import lejos.hardware.motor.EV3LargeRegulatedMotor;

public class Motors {
	
	private EV3LargeRegulatedMotor motor;
	
	public Motors(EV3LargeRegulatedMotor motor){
		this.motor = motor;
	}
	public void motorForward(){
		motor.forward();
	}
	public void motorBackward(){
		motor.backward();
	}
	public void motorStop(){
		motor.stop();
	}
}
