package eu.telecomnancy;


import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class TemperatureSensorWithState implements ISensor
{

    State state;
    double value = 0;
    public TemperatureSensorWithState()
    {
    	 this.state = new StateOFF();
	}
    @Override
    public void on() {
        state.On(this);
    }



	@Override
    public void off() {
        state.Off(this);
    }

    @Override
    public boolean getStatus() {
        return state.getStatuts();
    }

    @Override
    public void update() throws SensorNotActivatedException
    {
    	this.state.update(this);
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        if (getStatus())
            return value;
        else throw new SensorNotActivatedException("Sensor must be activated to get its value.");
    }

}
