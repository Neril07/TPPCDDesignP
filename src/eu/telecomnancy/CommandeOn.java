package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.TemperatureSensor;

public class CommandeOn implements Commande
{
	private ISensor TS;
	

	@Override
	public double execute()
	{
		TS.on();
		return 0;
	}
	
	public void setTS(ISensor sensor)
	{
		this.TS = (TemperatureSensor) sensor;
	}



}
