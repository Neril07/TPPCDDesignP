package eu.telecomnancy;

import java.text.NumberFormat;
import java.text.ParseException;

import eu.telecomnancy.ui.SensorView;

public class DecorateurArrondi implements Decorator
{
	private SensorView SV;
	public DecorateurArrondi(SensorView sV) {
		super();
		SV = sV;
	}
	@Override
	public void Update()   
	{
		NumberFormat NF = NumberFormat.getInstance();
		try {
			Double valeur = (double) Math.round((NF.parse(this.SV.value.getText()).doubleValue()));
			SV.value.setText(Double.toString(valeur));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
