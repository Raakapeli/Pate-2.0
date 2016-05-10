package features;

import lejos.hardware.sensor.EV3TouchSensor;

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
	
}
