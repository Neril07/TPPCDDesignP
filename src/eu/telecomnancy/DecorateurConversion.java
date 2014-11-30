package eu.telecomnancy;

import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.ui.SensorView;

public class DecorateurConversion implements Decorator
{
	private SensorView SV;
	public DecorateurConversion(SensorView sV) {
		super();
		SV = sV;
	}
	@Override
	public void Update() throws SensorNotActivatedException
	{
		
		this.SV.value.setText(Double.toString(this.SV.getISensor().getValue()*1.8+32));	
	}
	
}
