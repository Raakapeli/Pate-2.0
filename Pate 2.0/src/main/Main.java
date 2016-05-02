package main;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;
import features.IRSCheckerForRemote;


public class Main{
	
	public static void main(String[] args){
		
		EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.A);
		EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.B);
		EV3LargeRegulatedMotor righthand = new EV3LargeRegulatedMotor(MotorPort.C);
		EV3LargeRegulatedMotor lefthand = new EV3LargeRegulatedMotor(MotorPort.D);
		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S4);
		IRSCheckerForRemote remoteChecker = new IRSCheckerForRemote(irSensor);
		EV3TouchSensor ts = new EV3TouchSensor(SensorPort.S1);
		
		remoteChecker.start();		
		String leftMotorStatus = "Vasen seis";
		String rightMotorStatus = "Oikea seis";
		float[] sample = new float[ts.sampleSize()];
		
		while (!Button.ESCAPE.isDown()){
			int cmd = remoteChecker.getRemoteCmd();
			ts.fetchSample(sample, 0);
			
			switch (cmd){
				case 3: //oikea eteen, vasen seis
		        leftMotor.stop(true);
		        rightMotor.stop();
		        rightMotor.forward();
		        break;
				case 1: //vasen eteen, oikea seis
		        rightMotor.stop(true);
		        leftMotor.stop();
		        leftMotor.forward();
		        break;
				case 4: //oikea taakse, vasen seis
			    leftMotor.stop(true);
			    rightMotor.stop();
			    rightMotor.backward();
			    break;
				case 2: //vasen taakse, oikea seis
			    rightMotor.stop(true);
			    leftMotor.stop();
			    leftMotor.backward();
			    break;
				case 6: //oikea taakse, vasen eteen
				leftMotor.stop(true);
				leftMotor.forward();
				rightMotor.stop();
				rightMotor.backward();
				break;
				case 7: //vasen taakse, oikea eteen
				rightMotor.stop(true);
				rightMotor.forward();
				leftMotor.stop();
				leftMotor.backward();
				break;
				case 5:  //molemmat eteen
		        leftMotor.stop(true);
		        rightMotor.stop();
		        leftMotor.forward();
		        rightMotor.forward();
		        break;
				case 8:  //molemmat taakse
		        leftMotor.stop(true);
		        rightMotor.stop();
		        leftMotor.backward();
		        rightMotor.backward();
		        break;
				case 9: //stop, oli case 9
		        leftMotor.stop(true);
		        rightMotor.stop();
		        break;
				case 10:
				lefthand.stop(true);
				righthand.stop();
				lefthand.forward();
				righthand.forward();
				break;
				case 11:
				lefthand.stop(true);
				righthand.stop();
				break;
				}				
					LCD.drawString(leftMotorStatus, 0, 1);
					LCD.drawString(rightMotorStatus, 0, 2);
					
				if (sample[0] == 1){
					leftMotor.stop();
					rightMotor.stop();
					lefthand.stop();
					righthand.stop();
					Delay.msDelay(500);
					leftMotor.backward();
					rightMotor.backward();
					Delay.msDelay(1000);
					leftMotor.stop();
					rightMotor.stop();
					
					Delay.msDelay(500);
					rightMotor.stop(true);
					rightMotor.forward();
					leftMotor.stop();
					leftMotor.backward();
					Delay.msDelay(1000);
					
					leftMotor.stop();
					rightMotor.stop();
				} else {
					continue;				
				}
			}
				
			remoteChecker.stopSampling();
			leftMotor.close();
			rightMotor.close();
			righthand.close();
			lefthand.close();
			ts.close();
		}
	}


