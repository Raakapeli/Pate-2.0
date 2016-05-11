package features;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.utility.Delay;

/**
 * ColorSensor object
 * @author Joonas Järvinen
 * @author Joni Niskasaari
 * @author Juho Ranta
 * @author Riku Isola 
 * @version 2.0 10.5.2016
 */
public class Colorsensor{
	
	static EV3LargeRegulatedMotor rightHand = new EV3LargeRegulatedMotor(MotorPort.C);
	static EV3LargeRegulatedMotor leftHand = new EV3LargeRegulatedMotor(MotorPort.D);
	static Motors leftCircularsaw = new Motors(leftHand);
	static Motors rightCircularsaw = new Motors(rightHand);
	
	private EV3ColorSensor cSensor;
	
	/**
	 * Creates ColorSensor object
	 * @param sensor
	 */
	public Colorsensor(EV3ColorSensor sensor){
		this.cSensor = sensor;
	}
	
	/**
	 * Returns color ID number
	 * @return color Integer sensors color id number
	 */
	public int getColorValue(){
		int color = cSensor.getColorID();
		return color;
	}
	
	/**
	 * If color sensor notice color red, it light up a red led light and prints a color name to the screen for 4 seconds
	 */
	public static void showRed(){
		LCD.clear();												
		LCD.drawString("PUNAINEN!", 0, 1);							
		Button.LEDPattern(2);
		Motors.SawsOff(leftCircularsaw, rightCircularsaw);
		Delay.msDelay(4000);		
		LCD.clear();
		Button.LEDPattern(0);
	}

	/**
	 * If color sensor notice color green, it light up a green led light and prints a color name to the screen for 4 seconds
	 */
	public static void showGreen() {
		LCD.clear();
		LCD.drawString("VIHREA!", 0, 1);
		Button.LEDPattern(1);
		Motors.SawsOn(leftCircularsaw, rightCircularsaw);
		Delay.msDelay(4000);
		LCD.clear();
		Button.LEDPattern(0);
	}
	
	/**
	 * If color sensor notice color yellow, it light up a yellow led light and prints a color name to the screen for 4 seconds
	 */
	public static void showYellow(){
		LCD.clear();
		LCD.drawString("KELTAINEN!", 0, 1);
		Button.LEDPattern(3);
		Motors.SawsOff(leftCircularsaw, rightCircularsaw);
		Delay.msDelay(4000);
		LCD.clear();
		Button.LEDPattern(0);
	}
}
