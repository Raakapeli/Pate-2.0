package features;

import lejos.hardware.Button;
import lejos.hardware.sensor.EV3IRSensor;

/**
 * Creates the object for controller
 * @author Joonas Järvinen
 * @author Joni Niskasaari
 * @author Juho Ranta
 * @author Riku Isola 
 * @version 2.0 10.5.2016
 */
public class IRSCheckerForRemote extends Thread{
	
	private EV3IRSensor irSensor;
	private int remoteCmd = 0;
	private boolean stopSampling = false;
	
	/**
	 * Controller objects constructor
	 * @param sensor
	 */
	public IRSCheckerForRemote(EV3IRSensor sensor){
		this.irSensor = sensor;
	}
  
	/**
	 * Reads the commands from the controller
	 * @return
	 */
	public int getRemoteCmd(){
		return this.remoteCmd;
  	}

	/**
	 * Starts up the remote controller
	 */
	public void run(){
		while (!this.stopSampling) {
			this.remoteCmd = this.irSensor.getRemoteCommand(0);
		}
	}
	
	/**
	 * Shuts down the controller
	 */
	public void stopSampling() {
		this.stopSampling = true;
	}
}
