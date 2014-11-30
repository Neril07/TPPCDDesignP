package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.sensor.TemperatureSensor;

public class CommandeUpdate implements Commande{
	private ISensor TS;
	
	public void setTS(ISensor TS)
	{
		this.TS = TS;
	}
	@Override
	public double execute() throws SensorNotActivatedException
	{
		TS.update();
		return 0;
	}

}
