package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.ui.ConsoleUI;

public class App4 
{
    public static void main(String[] args)
    {
        ISensor sensor = new ProxyTemperatureSensor();
        new ConsoleUI(sensor);
    }
}
