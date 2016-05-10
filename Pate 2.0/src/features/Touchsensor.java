package features;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;

public class Touchsensor{
	
	private EV3TouchSensor tSensor;
	
	public Touchsensor(EV3TouchSensor sensor){
		this.tSensor = sensor;
		
	}

	public float[] getTouched(){
		float[] touch = new float[tSensor.sampleSize()];
		tSensor.fetchSample(touch, 0);
		return touch;	
	}
	
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
