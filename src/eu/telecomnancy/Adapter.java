package eu.telecomnancy;

import eu.telecomnancy.sensor.LegacyTemperatureSensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class Adapter implements eu.telecomnancy.sensor.ISensor
{
	private LegacyTemperatureSensor LS;
	private double valeur;
	
	public Adapter(LegacyTemperatureSensor LS)
	{
		this.LS = LS;
	}

	@Override
	public void on()
	{
		// TODO Auto-generated method stub
		if (LS.getStatus()==false)
		{
			LS.onOff();
		}
	}

	@Override
	public void off()
	{
		// TODO Auto-generated method stub
		if (LS.getStatus()==true)
		{
			LS.onOff();
		}
	}

	@Override
	public boolean getStatus()
	{
		// TODO Auto-generated method stub
		return LS.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		if (LS.getStatus() == true)
			this.valeur = LS.getTemperature();
		else 
			throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		if (LS.getStatus()==true)
			return this.valeur;
		else
			throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
	}

}
