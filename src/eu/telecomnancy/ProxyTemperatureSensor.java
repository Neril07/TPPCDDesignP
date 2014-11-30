package eu.telecomnancy;

import java.util.Random;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.sensor.TemperatureSensor;

public class ProxyTemperatureSensor implements ISensor
{

    TemperatureSensor TS;
    
    
    public ProxyTemperatureSensor()
    {
    	this.TS =new TemperatureSensor();
    }

    
    public void on()
    {
        this.TS.on();
        System.out.println("Date : "+ new java.util.Date().toString());
        System.out.println("Methode : on() ");
    }

    
    public void off()
    {
    	this.TS.off();
        System.out.println("Date : "+ new java.util.Date().toString());
        System.out.println("Methode : off() ");
    }

   
    public boolean getStatus() {
    	
    	boolean tmpstate = this.TS.getStatus();
        System.out.println("Date : "+ new java.util.Date().toString());
        System.out.println("Methode : getStatus() ");
        System.out.println("retour : "+ tmpstate);
        
        return tmpstate;
    }

    
    public void update() throws SensorNotActivatedException 
    {
        System.out.println("Date : "+ new java.util.Date().toString());
        System.out.println("Methode : update() ");
    	this.TS.update();
    }

    
    public double getValue() throws SensorNotActivatedException 
    {
    	double tmpvalue = this.TS.getValue();
        System.out.println("Date : "+ new java.util.Date().toString());
        System.out.println("Methode : getStatus() ");
        System.out.println("retour : "+ tmpvalue);
        
    	return tmpvalue;
    }
}
