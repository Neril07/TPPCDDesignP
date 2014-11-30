package eu.telecomnancy;

import java.util.Random;

public class StateON extends State
{
	public void update(TemperatureSensorWithState TS)
	{
			TS.value = (new Random()).nextDouble() * 100;
	}

	@Override
	public Boolean getStatuts()
	{
		return true;
	}

}
