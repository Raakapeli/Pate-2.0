package features;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import features.IRSCheckerForRemote;

/**
 * Motor object
 * @author Joonas Järvinen
 * @author Joni Niskasaari
 * @author Juho Ranta
 * @author Riku Isola 
 * @version 2.0 10.5.2016
 */
public class Motors {
	
	private EV3LargeRegulatedMotor motor;
	
	/**
	 * Motor objects constructor
	 * @param motor
	 */
	public Motors(EV3LargeRegulatedMotor motor){
		this.motor = motor;
	}
	
	/**
	 * Moves the motor forward
	 */
	public void motorForward(){
		motor.forward();
	}
	
	/**
	 * Moves motor backward
	 */
	public void motorBackward(){
		motor.backward();
	}
	
	/**
	 * Stops motor
	 */
	public void motorStop(){
		motor.stop();
	}
	
	/**
	 * Stop all the motors and sensors                         POISTA!!!! JOS EI KÄYTETÄ!!!!
	 * @param remCheck											
	 * @param leftM															^
	 * @param rightM													   / \
	 * @param rightH														|
	 * @param leftH															|
	 * @param tSen															|
	 * @param irSen
	 * @param ambientM
	 */
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
	
	/**
	 * Moves left motor forward
	 * @param leftT
	 * @param rightT
	 */
	public static void leftMotorForward(Motors leftT, Motors rightT){
		LCD.clear();
		Button.LEDPattern(0);
        leftT.motorStop();
        rightT.motorStop();
        leftT.motorForward();
	}
	
	/**
	 * Moves right motor forward
	 * @param leftT
	 * @param rightT
	 */
	public static void rightMotorForward(Motors leftT, Motors rightT){
		LCD.clear();
		Button.LEDPattern(0);
        leftT.motorStop();
        rightT.motorStop();
        rightT.motorForward();
	}
	
	/**
	 * Moves right motor backward
	 * @param leftT
	 * @param rightT
	 */
	public static void rightMotorBackward(Motors leftT, Motors rightT){
		LCD.clear();
		Button.LEDPattern(0);
	    leftT.motorStop();
	    rightT.motorStop();
	    rightT.motorBackward();		
	}
	
	/**
	 * Moves left motor backward
	 * @param leftT
	 * @param rightT
	 */
	public static void leftMotorBackward(Motors leftT, Motors rightT){
		LCD.clear();	
		Button.LEDPattern(0);
	    rightT.motorStop();
	    leftT.motorStop();
	    leftT.motorBackward();
	}
	
	/**
	 * Moves right motor backwards and left motor forward
	 * @param leftT
	 * @param rightT
	 */
	public static void rightBackwardLeftForward(Motors leftT, Motors rightT){
		LCD.clear();
		Button.LEDPattern(0);
		leftT.motorStop();
		leftT.motorForward();
		rightT.motorStop();
		rightT.motorBackward();
	}
	
	/**
	 * Moves right motor forward and left motor backward
	 * @param leftT
	 * @param rightT
	 */
	public static void rightForwardLeftBackward(Motors leftT, Motors rightT){
		LCD.clear();
		Button.LEDPattern(0);
		rightT.motorStop();
		leftT.motorStop();
		rightT.motorForward();
		leftT.motorBackward();
	}
	
	/**
	 * Moves right and left motor forward
	 * @param leftT
	 * @param rightT
	 */
	public static void rightForwardLeftForward(Motors leftT, Motors rightT){
		LCD.clear();
		Button.LEDPattern(0);
        leftT.motorStop();
        rightT.motorStop();
        leftT.motorForward();
        rightT.motorForward();
	}
	
	/**
	 * Moves right and left motor backward
	 * @param leftT
	 * @param rightT
	 */
	public static void rightBackwardLeftBackward(Motors leftT, Motors rightT){
		LCD.clear();
		Button.LEDPattern(0);
        leftT.motorStop();
        rightT.motorStop();
        leftT.motorBackward();
        rightT.motorBackward();
	}
	
	/**
	 * Stops both left and right motor
	 * @param leftT
	 * @param rightT
	 */
	public static void rightStopLeftStop(Motors leftT, Motors rightT){
		LCD.clear();
		Button.LEDPattern(0);
        leftT.motorStop();
        rightT.motorStop();
	}
	
	/**
	 * Starts to rotate both circular saws
	 * @param leftH
	 * @param rightH
	 */
	public static void SawsOn(Motors leftH, Motors rightH){
		LCD.clear();
		Button.LEDPattern(0);
		leftH.motorStop();
		rightH.motorStop();
		leftH.motorForward();
		rightH.motorForward();
	}
	
	/**
	 * Stops both circular saws
	 * @param leftH
	 * @param rightH
	 */
	public static void SawsOff(Motors leftH, Motors rightH){
		LCD.clear();
		Button.LEDPattern(0);
		leftH.motorStop();
		rightH.motorStop();
	}
}
