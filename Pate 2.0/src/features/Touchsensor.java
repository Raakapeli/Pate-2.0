package features;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;

/**
 * Creates object for touch sensor
 * @author Joonas Järvinen
 * @author Joni Niskasaari
 * @author Juho Ranta
 * @author Riku Isola 
 * @version 2.0 10.5.2016
 */
public class Touchsensor{
	
	private EV3TouchSensor tSensor;
	
	/**
	 * Touch sensor constructor
	 * @param sensor
	 */
	public Touchsensor(EV3TouchSensor sensor){
		this.tSensor = sensor;
		
	}

	/**
	 *  ??    TARVIIKO TÄTÄ    ??
	 * @return
	 */
	public float[] getTouched(){
		float[] touch = new float[tSensor.sampleSize()];
		tSensor.fetchSample(touch, 0);
		return touch;	
	}
	
	/**
	 * When the touch sensor is pressed the robot will go backwards and then turn another way
	 * @param vasentrack
	 * @param oikeatrack
	 * @param vasensaha
	 * @param oikeasaha
	 * @param emer
	 */
	public static void goBackward(Motors vasentrack, Motors oikeatrack, Motors vasensaha, Motors oikeasaha, String emer){
		Button.LEDPattern(8);
		LCD.clear();
		LCD.drawString(emer, 0, 3);
		vasensaha.motorStop();
		oikeasaha.motorStop();
		vasentrack.motorStop();
		oikeatrack.motorStop();
		Delay.msDelay(500);
		vasentrack.motorBackward();
		oikeatrack.motorBackward();
		Delay.msDelay(3000);
		vasentrack.motorStop();
		oikeatrack.motorStop();
		
		Delay.msDelay(500);			
		oikeatrack.motorForward();
		vasentrack.motorBackward();
		Delay.msDelay(2000);
		
		vasentrack.motorStop();
		oikeatrack.motorStop();
	}
	
}
