package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.sensor.TemperatureSensor;

public interface Commande
{
	public  double execute() throws SensorNotActivatedException;
	public void setTS(ISensor sensor);
}
