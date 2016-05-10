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
			switch (cmd){
				case 3: //oikea eteen, vasen seis
				LCD.clear();
				Button.LEDPattern(0);
		        leftTrack.motorStop();
		        rightTrack.motorStop();
		        rightTrack.motorForward();
		        break;
				case 1: //vasen eteen, oikea seis
				LCD.clear();
				Button.LEDPattern(0);
		        rightTrack.motorStop();
		        leftTrack.motorStop();
		        leftTrack.motorForward();
		        break;
				case 4: //oikea taakse, vasen seis
				LCD.clear();
				Button.LEDPattern(0);
			    leftTrack.motorStop();
			    rightTrack.motorStop();
			    rightTrack.motorBackward();
			    break;
				case 2: //vasen taakse, oikea seis
				LCD.clear();	
				Button.LEDPattern(0);
			    rightTrack.motorStop();
			    leftTrack.motorStop();
			    leftTrack.motorBackward();
			    break;
				case 6: //oikea taakse, vasen eteen
				LCD.clear();
				Button.LEDPattern(0);
				leftTrack.motorStop();
				leftTrack.motorForward();
				rightTrack.motorStop();
				rightTrack.motorBackward();
				break;
				case 7: //vasen taakse, oikea eteen
				LCD.clear();
				Button.LEDPattern(0);
				rightTrack.motorStop();
				rightTrack.motorForward();
				leftTrack.motorStop();
				leftTrack.motorBackward();
				break;
				case 5:  //molemmat eteen
				LCD.clear();
				Button.LEDPattern(0);
		        leftTrack.motorStop();
		        rightTrack.motorStop();
		        leftTrack.motorForward();
		        rightTrack.motorForward();
		        break;
				case 8:  //molemmat taakse
				LCD.clear();
				Button.LEDPattern(0);
		        leftTrack.motorStop();
		        rightTrack.motorStop();
		        leftTrack.motorBackward();
		        rightTrack.motorBackward();
		        break;
				case 9: //stop
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
					Button.LEDPattern(8);
					LCD.clear();
					LCD.drawString(emergency, 0, 3);
					leftCircularsaw.motorStop();
					rightCircularsaw.motorStop();
					leftTrack.motorStop();
					rightTrack.motorStop();
					Delay.msDelay(500);
					leftTrack.motorBackward();
					rightTrack.motorBackward();
					Delay.msDelay(3000);
					leftTrack.motorStop();
					rightTrack.motorStop();
					
					Delay.msDelay(500);
//					leftTrack.motorStop();      //Vaihdoin paikkaa
//					rightTrack.motorStop();		//			
					rightTrack.motorForward();
					leftTrack.motorBackward();
					Delay.msDelay(2000);
					
					leftTrack.motorStop();
					rightTrack.motorStop();
				} else {
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
			ambientmode.close();
		}
		
	}


