package eu.telecomnancy.ui;

import eu.telecomnancy.Observable;
import eu.telecomnancy.Observer;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.sensor.TemperatureSensor;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SensorView extends JPanel implements Observer {
	private ISensor sensor;

	private JLabel value = new JLabel("N/A °C");
	private JButton on = new JButton("On");
	private JButton off = new JButton("Off");
	private JButton update = new JButton("Acquire");

	public SensorView(ISensor c) {
		this.sensor = c;
		 ((Observable) this.sensor).addObserver((Observer)this);
		this.setLayout(new BorderLayout());

		value.setHorizontalAlignment(SwingConstants.CENTER);
		Font sensorValueFont = new Font("Sans Serif", Font.BOLD, 18);
		value.setFont(sensorValueFont);

		this.add(value, BorderLayout.CENTER);


		on.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sensor.on();
			}
		});

		off.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sensor.off();
			}
		});

		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					sensor.update();
				} catch (SensorNotActivatedException sensorNotActivatedException) {
					sensorNotActivatedException.printStackTrace();
				}
			}
		});

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1, 3));
		buttonsPanel.add(update);
		buttonsPanel.add(on);
		buttonsPanel.add(off);

		this.add(buttonsPanel, BorderLayout.SOUTH);
		
	}

	@Override
	public void Update()
	{
		// TODO Auto-generated method stub

		try
			{
			this.value.setText(Double.toString(this.sensor.getValue()));
		} catch (SensorNotActivatedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
