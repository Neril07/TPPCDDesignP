package eu.telecomnancy;

import eu.telecomnancy.sensor.SensorNotActivatedException;

public class StateOFF extends State
{
	public void update(TemperatureSensorWithState TS) throws SensorNotActivatedException
	{
		throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
	}

	@Override
	public Boolean getStatuts()
	{
		return false;
	}

}
