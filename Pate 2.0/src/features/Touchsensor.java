package features;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3TouchSensor;

public class Touchsensor {
	
	private EV3TouchSensor touchsensor;
	int touchCount = 100;
	int pushed = 0;

	int sampleSize = touchsensor.sampleSize();
	float[] sample = new float[sampleSize];
    
	public Touchsensor(EV3TouchSensor sensor) {
		this.touchsensor = sensor;
	}
	
	public int getTouched(){
    	while ((touchCount > 0) && (!Button.ESCAPE.isDown())){	
    		do{
    			touchsensor.fetchSample(sample, 0);
    		}
    		while (sample[0] == 0);
				pushed = 1;
    		}
		return this.pushed;	
    }
}
