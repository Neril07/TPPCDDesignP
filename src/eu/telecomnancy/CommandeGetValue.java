package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class CommandeGetValue implements Commande
{
	private ISensor TS;
	
	public void setTS(ISensor TS)
	{
		this.TS = TS;
	}
	@Override
	public double execute() throws SensorNotActivatedException
	{
		return TS.getValue();
	}

}
