package eu.telecomnancy.ui;

import eu.telecomnancy.DecorateurArrondi;
import eu.telecomnancy.DecorateurConversion;
import eu.telecomnancy.Decorator;
import eu.telecomnancy.Observable;
import eu.telecomnancy.Observer;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.sensor.TemperatureSensor;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SensorView extends JPanel implements Observer, ActionListener
{
	private ISensor sensor;
	public ArrayList <Decorator> tabDeco;
	public JLabel value = new JLabel("N/A °C");
	private JButton on = new JButton("On");
	private JButton off = new JButton("Off");
	private JButton update = new JButton("Acquire");
	private JButton conversion = new JButton("Conversion");
	private JButton arrondi = new JButton("Arrondi");
	private DecorateurArrondi DA = new DecorateurArrondi(this);
	private DecorateurConversion DC = new DecorateurConversion(this);
	
	
	

	public SensorView(ISensor c)
	{
		
		this.tabDeco = new ArrayList <Decorator> ();
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
		buttonsPanel.add(arrondi);
		buttonsPanel.add(conversion);
		arrondi.addActionListener(this);
		conversion.addActionListener(this);

		this.add(buttonsPanel, BorderLayout.SOUTH);



	}

	@Override
	public void Update()
	{
		// TODO Auto-generated method stub

		try
		{
			this.value.setText(Double.toString(this.sensor.getValue()));
			if (tabDeco.contains(DC)) DC.Update(); 
			if (tabDeco.contains(DA)) DA.Update(); 
			
			
		} catch (SensorNotActivatedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public void actionPerformed(ActionEvent e) // gestion des events 
	{
		Object source = e.getSource();
		if(source == conversion)
		{
			if (tabDeco.contains(DC))
				tabDeco.remove(DC);
			else
				tabDeco.add(DC);
		}
		
		if (source == arrondi)
		{
			if (tabDeco.contains(DA))
				tabDeco.remove(DA);
			else
				tabDeco.add(DA);
		}
		

	}
	
	public ISensor getISensor()
	{
		return this.sensor;
	}
}
