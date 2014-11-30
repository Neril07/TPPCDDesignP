package eu.telecomnancy;

import java.text.ParseException;

import eu.telecomnancy.sensor.SensorNotActivatedException;

public interface Decorator
{
	public void Update() throws SensorNotActivatedException;
	
}
