package main;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;
import features.IRSCheckerForRemote;
import features.Colorsensor;
import features.Motors;
import features.Touchsensor;

/**
 * 
 * @author Joonas Järvinen
 * @author Joni Niskasaari
 * @author Juho Ranta
 * @author Riku Isola 
 * @version 2.0 10.5.2016
 */
public class Main{
	
	public static void main(String[] args){
		
		EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.A);
		EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.B);
		EV3LargeRegulatedMotor rightHand = new EV3LargeRegulatedMotor(MotorPort.C);
		EV3LargeRegulatedMotor leftHand = new EV3LargeRegulatedMotor(MotorPort.D);
		Motors leftTrack = new Motors(leftMotor);
		Motors rightTrack = new Motors(rightMotor);
		Motors leftCircularsaw = new Motors(leftHand);
		Motors rightCircularsaw = new Motors(rightHand);
		
		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S4);
		IRSCheckerForRemote remoteChecker = new IRSCheckerForRemote(irSensor);
		
		EV3TouchSensor tSensor = new EV3TouchSensor(SensorPort.S1);
		Touchsensor ts = new Touchsensor(tSensor);
		
		EV3ColorSensor cSensor = new EV3ColorSensor(SensorPort.S3);
		Colorsensor ColorS = new Colorsensor(cSensor);
		
		remoteChecker.start();		
		float[] touch = new float[tSensor.sampleSize()];


		String emergency = "EMERGENCY STOP";
		String sun = "Sun is shining!!";
		String ok = "ok";
		if(ColorS.getColorValue() == 3){
			LCD.clear();
			LCD.drawString(sun, 0, 1);
		}else{
			LCD.clear();
			LCD.drawString(ok, 0, 1);
		}
		Button.LEDPattern(0);
		LCD.clear();
		
		while (!Button.ESCAPE.isDown()){
			int cmd = remoteChecker.getRemoteCmd();
			touch = ts.getTouched();
			//lightsensor.getAmbientValue();
			
			if (cmd == 1){
				
				Motors.leftMotorForward(leftTrack, rightTrack);

			} else if (cmd == 3){
				
				Motors.rightMotorForward(leftTrack, rightTrack);

			} else if (cmd == 4){
				
				Motors.rightMotorBackward(leftTrack, rightTrack);
				
			} else if (cmd == 2){
				
				Motors.leftMotorBackward(leftTrack, rightTrack);
				
			} else if (cmd == 6){
				
				Motors.rightBackwardLeftForward(leftTrack, rightTrack);
				
			} else if (cmd == 7){
				
				Motors.rightForwardLeftBackward(leftTrack, rightTrack);
				
			} else if (cmd == 5){
				
				Motors.rightForwardLeftForward(leftTrack, rightTrack);
				
			} else if (cmd == 8){
				
				Motors.rightBackwardLeftBackward(leftTrack, rightTrack);
				
			} else if (cmd == 9){
				
				Motors.rightStopLeftStop(leftTrack, rightTrack);
				
			} else if (cmd == 10){
				
				Motors.SawsOn(leftCircularsaw, rightCircularsaw);
				
			} else if (cmd == 11){
				
				Motors.SawsOff(leftCircularsaw, rightCircularsaw);
				
			}else if(touch[0] == 1){
				
				Touchsensor.goBackward(leftTrack, rightTrack, leftCircularsaw, rightCircularsaw, emergency);
			
			}else if(ColorS.getColorValue() == 7){
				LCD.clear();
				LCD.drawString(sun, 0, 1);
				
			}
			else {
				
				LCD.clear();
				LCD.drawString(ok, 0, 1);
				continue;
			}

		}
			
		remoteChecker.stopSampling();
		leftMotor.close();
		rightMotor.close();
		rightHand.close();
		leftHand.close();
		tSensor.close();
		irSensor.close();
		//ambientmode.close();
	}
}


