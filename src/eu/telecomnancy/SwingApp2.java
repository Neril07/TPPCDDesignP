package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.LegacyTemperatureSensor;
import eu.telecomnancy.ui.MainWindow;

public class SwingApp2 
{
    public static void main(String[] args) {
        ISensor sensor = new Adapter(new LegacyTemperatureSensor());
        new MainWindow(sensor);
    }
}
