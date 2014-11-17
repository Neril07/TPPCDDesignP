package eu.telecomnancy.sensor;

import java.util.ArrayList;
import java.util.Random;

import eu.telecomnancy.Observable;
import eu.telecomnancy.Observer;

public class TemperatureSensor extends Observable implements ISensor
{
	
    boolean state;
    double value = 0;

    @Override
    public void on() {
        state = true;
    }

    @Override
    public void off() {
        state = false;
    }

    @Override
    public boolean getStatus() {
        return state;
    }

    @Override
    public void update() throws SensorNotActivatedException {
        if (state)
        {
            value = (new Random()).nextDouble() * 100;
        	this.Notify();
        }
        else throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        if (state)
            return value;
        else throw new SensorNotActivatedException("Sensor must be activated to get its value.");
    }



}
