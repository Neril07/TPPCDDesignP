package eu.telecomnancy;

import java.io.IOException;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.ui.MainWindow;

public class SwingApp {

    public static void main(String[] args) throws IOException {
        ISensor sensor = new TemperatureSensor();
        new MainWindow(sensor);
    }

}
