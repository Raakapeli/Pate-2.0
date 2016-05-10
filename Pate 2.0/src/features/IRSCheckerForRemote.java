package features;

import lejos.hardware.Button;
import lejos.hardware.sensor.EV3IRSensor;

public class IRSCheckerForRemote extends Thread{
	
	private EV3IRSensor irSensor;
	private int remoteCmd = 0;
	private boolean stopSampling = false;
	
	
	public IRSCheckerForRemote(EV3IRSensor sensor){
		this.irSensor = sensor;
	}
  
	public int getRemoteCmd(){
		return this.remoteCmd;
  	}

	public void run(){
		while (!this.stopSampling) {
			this.remoteCmd = this.irSensor.getRemoteCommand(0);
		}
	}

	public void stopSampling() {
		this.stopSampling = true;
	}
}
