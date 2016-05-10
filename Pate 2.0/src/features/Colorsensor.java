package features;

import lejos.hardware.sensor.EV3ColorSensor;

public class Colorsensor{
	
	private EV3ColorSensor cSensor;
	
	
	public Colorsensor(EV3ColorSensor sensor){
		this.cSensor = sensor;
	}
	public int getColorValue(){
		int color = cSensor.getColorID();
		return color;
	}
	
	
}
