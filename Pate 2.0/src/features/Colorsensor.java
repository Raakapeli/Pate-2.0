package features;

import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;

public class Colorsensor{
	
	private EV3ColorSensor cSensor;
	//SensorMode ambientmode = cSensor.getAmbientMode();
	
	public Colorsensor(EV3ColorSensor sensor){
		this.cSensor = sensor;
	}
	public float[] getAmbientValue(){
		float[] ambient = new float[cSensor.sampleSize()];
		cSensor.fetchSample(ambient, 0);
		return ambient;
	}
	
	
}
