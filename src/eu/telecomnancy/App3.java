package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.LegacyTemperatureSensor;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.ui.ConsoleUI;

public class App3
{
	public static void main(String[] args) 
	{
        ISensor sensor = new TemperatureSensorWithState();
        new ConsoleUI(sensor);

	}

}
