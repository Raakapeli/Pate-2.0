package features;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import features.IRSCheckerForRemote;

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
	
	public static void stopMotor(IRSCheckerForRemote remCheck, EV3LargeRegulatedMotor leftM,
			EV3LargeRegulatedMotor rightM, EV3LargeRegulatedMotor rightH, EV3LargeRegulatedMotor leftH,
			EV3TouchSensor tSen, EV3IRSensor irSen, EV3ColorSensor ambientM) {
		
		remCheck.stopSampling();
		leftM.close();
		rightM.close();
		rightH.close();
		leftH.close();
		tSen.close();
		irSen.close();
		ambientM.close();		
	}
	
	public static void leftMotorForward(Motors leftT, Motors rightT){
		

		LCD.clear();
		Button.LEDPattern(0);
        leftT.motorStop();
        rightT.motorStop();
        leftT.motorForward();
	}
	
	public static void rightMotorForward(Motors leftT, Motors rightT){
		LCD.clear();
		Button.LEDPattern(0);
        leftT.motorStop();
        rightT.motorStop();
        rightT.motorForward();
	}
	
	public static void rightMotorBackward(Motors leftT, Motors rightT){
		LCD.clear();
		Button.LEDPattern(0);
	    leftT.motorStop();
	    rightT.motorStop();
	    rightT.motorBackward();		
	}
	
	public static void leftMotorBackward(Motors leftT, Motors rightT){
		LCD.clear();	
		Button.LEDPattern(0);
	    rightT.motorStop();
	    leftT.motorStop();
	    leftT.motorBackward();
	}
	
	public static void rightBackwardLeftForward(Motors leftT, Motors rightT){
		LCD.clear();
		Button.LEDPattern(0);
		leftT.motorStop();
		leftT.motorForward();
		rightT.motorStop();
		rightT.motorBackward();
	}
}







