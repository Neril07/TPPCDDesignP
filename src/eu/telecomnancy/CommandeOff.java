package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;

public class CommandeOff implements Commande{
	
	private ISensor TS;
	
	public void setTS(ISensor TS)
	{
		this.TS = TS;
	}
	@Override
	public double execute()
	{
		TS.off();
		return 0;
	}


}
