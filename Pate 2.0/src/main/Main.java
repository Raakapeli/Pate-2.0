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
		
		EV3ColorSensor ambientmode = new EV3ColorSensor(SensorPort.S3);
		Colorsensor lightsensor = new Colorsensor(ambientmode);
		
		remoteChecker.start();		
		float[] touch = new float[tSensor.sampleSize()];
//		float[] ambient = new float[ambientmode.sampleSize()];
//		double ambient = ambientmode.fetchsample(ambient,0);
		String emergency = "EMERGENCY STOP";
//		String sun = "Sun is shining!!";
//		if(ambient > 0.2){
//			LCD.clear();
//			LCD.drawString(sun, 0, 1);
//		}
		Button.LEDPattern(0);
		LCD.clear();
		
		while (!Button.ESCAPE.isDown()){
			int cmd = remoteChecker.getRemoteCmd();
			touch = ts.getTouched();
			lightsensor.getAmbientValue();
			
//			if (cmd == 1){
//				
//				Motors.leftMotorForward(leftTrack, rightTrack);
//				LCD.clear();
//				Button.LEDPattern(0);
//		        rightTrack.motorStop();
//		        leftTrack.motorStop();
//		        leftTrack.motorForward();
//			} else if (cmd == 3){
//				
//				Motors.rightMotorForward(leftTrack, rightTrack);
//				LCD.clear();
//				Button.LEDPattern(0);
//		        leftTrack.motorStop();
//		        rightTrack.motorStop();
//		        rightTrack.motorForward();
//			} else if (cmd == 4){
//				LCD.clear();
//				Button.LEDPattern(0);
//			    leftTrack.motorStop();
//			    rightTrack.motorStop();
//			    rightTrack.motorBackward();
//			} else if (cmd == 2){
//				LCD.clear();	
//				Button.LEDPattern(0);
//			    rightTrack.motorStop();
//			    leftTrack.motorStop();
//			    leftTrack.motorBackward();
//			} else if (cmd == 6){
//				LCD.clear();
//				Button.LEDPattern(0);
//				leftTrack.motorStop();
//				leftTrack.motorForward();
//				rightTrack.motorStop();
//				rightTrack.motorBackward();
//			} else if (cmd == 7){
//				LCD.clear();
//				Button.LEDPattern(0);
//				rightTrack.motorStop();
//				rightTrack.motorForward();
//				leftTrack.motorStop();
//				leftTrack.motorBackward();
//			} else if (cmd == 5){
//				LCD.clear();
//				Button.LEDPattern(0);
//		        leftTrack.motorStop();
//		        rightTrack.motorStop();
//		        leftTrack.motorForward();
//		        rightTrack.motorForward();
//			} else if (cmd == 8){
//				LCD.clear();
//				Button.LEDPattern(0);
//		        leftTrack.motorStop();
//		        rightTrack.motorStop();
//		        leftTrack.motorBackward();
//		        rightTrack.motorBackward();
//			} else if (cmd == 9){
//				LCD.clear();
//				Button.LEDPattern(0);
//		        leftTrack.motorStop();
//		        rightTrack.motorStop();
//			} else if (cmd == 10){
//				LCD.clear();
//				Button.LEDPattern(0);
//				leftCircularsaw.motorStop();
//				rightCircularsaw.motorStop();
//				leftCircularsaw.motorForward();
//				rightCircularsaw.motorForward();
//			} else if (cmd == 11){
//				LCD.clear();
//				Button.LEDPattern(0);
//				leftCircularsaw.motorStop();
//				rightCircularsaw.motorStop();
//			} else {
//				continue;
//			}
			
			switch (cmd){
				case 3: 						//right forward, left stop
					
				Motors.rightMotorForward(leftTrack, rightTrack);
//				LCD.clear();
//				Button.LEDPattern(0);
//		        leftTrack.motorStop();
//		        rightTrack.motorStop();
//		        rightTrack.motorForward();
		        break;
				case 1: 						//left forward, right stop
					
				Motors.leftMotorForward(leftTrack, rightTrack);
//				LCD.clear();
//				Button.LEDPattern(0);
//		        rightTrack.motorStop();
//		        leftTrack.motorStop();
//		        leftTrack.motorForward();
		        break;
				case 4: 						//right backward, left stop
					
				Motors.rightMotorBackward(leftTrack, rightTrack);
//				LCD.clear();
//				Button.LEDPattern(0);
//			    leftTrack.motorStop();
//			    rightTrack.motorStop();
//			    rightTrack.motorBackward();
			    break;
				case 2: 						//left backward, right stop
					
				Motors.leftMotorBackward(leftTrack, rightTrack);
//				LCD.clear();	
//				Button.LEDPattern(0);
//			    rightTrack.motorStop();
//			    leftTrack.motorStop();
//			    leftTrack.motorBackward();
			    break;
				case 6: 						//right backward, left forward
					
				Motors.rightBackwardLeftForward(leftTrack, rightTrack);
//				LCD.clear();
//				Button.LEDPattern(0);
//				leftTrack.motorStop();
//				leftTrack.motorForward();
//				rightTrack.motorStop();
//				rightTrack.motorBackward();
				break;
				case 7: 						//left backward, right forward
				LCD.clear();
				Button.LEDPattern(0);
				rightTrack.motorStop();
				rightTrack.motorForward();
				leftTrack.motorStop();
				leftTrack.motorBackward();
				break;
				case 5:  						// both forward
				LCD.clear();
				Button.LEDPattern(0);
		        leftTrack.motorStop();
		        rightTrack.motorStop();
		        leftTrack.motorForward();
		        rightTrack.motorForward();
		        break;
				case 8:  						// both backward
				LCD.clear();
				Button.LEDPattern(0);
		        leftTrack.motorStop();
		        rightTrack.motorStop();
		        leftTrack.motorBackward();
		        rightTrack.motorBackward();
		        break;
				case 9: 						//stop
				LCD.clear();
				Button.LEDPattern(0);
		        leftTrack.motorStop();
		        rightTrack.motorStop();
		        break;
				case 10:
				LCD.clear();
				Button.LEDPattern(0);
				leftCircularsaw.motorStop();
				rightCircularsaw.motorStop();
				leftCircularsaw.motorForward();
				rightCircularsaw.motorForward();
				break;
				case 11:
				LCD.clear();
				Button.LEDPattern(0);
				leftCircularsaw.motorStop();
				rightCircularsaw.motorStop();
				break;
				}				
				
				if (touch[0] == 1){
					
					Touchsensor.goBackward(leftTrack, rightTrack, leftCircularsaw, rightCircularsaw, emergency);
					
//					Button.LEDPattern(8);
//					LCD.clear();
//					LCD.drawString(emergency, 0, 3);
//					leftCircularsaw.motorStop();
//					rightCircularsaw.motorStop();
//					leftTrack.motorStop();
//					rightTrack.motorStop();
//					Delay.msDelay(500);
//					leftTrack.motorBackward();
//					rightTrack.motorBackward();
//					Delay.msDelay(3000);
//					leftTrack.motorStop();
//					rightTrack.motorStop();
//					
//					Delay.msDelay(500);			
//					rightTrack.motorForward();
//					leftTrack.motorBackward();
//					Delay.msDelay(2000);
//					
//					leftTrack.motorStop();
//					rightTrack.motorStop();
				} else {
					continue;				
				}
			}
				
			Motors.stopMotor(remoteChecker, leftMotor, rightMotor, rightHand, leftHand, tSensor, irSensor, ambientmode);
			
//			remoteChecker.stopSampling();
//			leftMotor.close();
//			rightMotor.close();
//			rightHand.close();
//			leftHand.close();
//			tSensor.close();
//			irSensor.close();
//			ambientmode.close();
		}
	}



