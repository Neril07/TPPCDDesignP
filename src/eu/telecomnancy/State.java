package eu.telecomnancy;

import eu.telecomnancy.sensor.SensorNotActivatedException;


public abstract class State
{
	public void setState(TemperatureSensorWithState TS,State etat)
	{
		TS.state = etat;
	}
	
	public abstract void update(TemperatureSensorWithState TS) throws SensorNotActivatedException;
	
	public void On(TemperatureSensorWithState TS)
	{
		setState(TS, new StateON());
	}
	
	public void Off(TemperatureSensorWithState TS)
	{
		setState(TS, new StateOFF());
	}
	
	public abstract Boolean getStatuts();
}
