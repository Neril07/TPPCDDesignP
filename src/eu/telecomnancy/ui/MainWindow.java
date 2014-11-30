package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.sensor.TemperatureSensor;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainWindow extends JFrame implements ActionListener{

	private ISensor sensor;
	private SensorView sensorView;

	Properties prop = new  Properties();
	String PropFileName = "commande.properties";


	private JMenuBar BarMenu = new JMenuBar();
	private JMenu Commande = new JMenu("Commande");
	private JMenuItem itemON = new JMenuItem("ON");
	private JMenuItem itemOFF = new JMenuItem("OFF");
	private JMenuItem itemUPDATE = new JMenuItem("UPDATE");
	private JMenuItem itemVALUE = new JMenuItem("VALUE");


	public MainWindow(ISensor sensor) throws IOException
	{
		this.sensor = sensor;
		this.sensorView = new SensorView(this.sensor);

		this.setLayout(new BorderLayout());
		this.add(this.sensorView, BorderLayout.CENTER);

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		InputStream inputStream = new FileInputStream(PropFileName);
		prop.load(inputStream);

		this.setJMenuBar(BarMenu);
		this.BarMenu.add(Commande);

		this.Commande.add(itemON);
		this.Commande.add(itemOFF);
		this.Commande.add(itemUPDATE);
		//this.Commande.add(itemVALUE);

		itemON.addActionListener(this);
		itemOFF.addActionListener(this);
		itemUPDATE.addActionListener(this);
		//itemVALUE.addActionListener(this);



		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		
		try {

			if(source == itemON)
			{

				String classe = prop.getProperty("commandeOn");
				Class cl = Class.forName(classe);
				eu.telecomnancy.Commande o =(eu.telecomnancy.Commande) cl.newInstance();
				o.setTS(this.sensor);
				o.execute();
			}
			
			if(source == itemOFF)
			{

				String classe = prop.getProperty("commandeOff");
				Class cl = Class.forName(classe);
				eu.telecomnancy.Commande o =(eu.telecomnancy.Commande) cl.newInstance();
				o.setTS(this.sensor);
				o.execute();
			}
			
			if(source == itemUPDATE)
			{

				String classe = prop.getProperty("commandeUpdate");
				Class cl = Class.forName(classe);
				eu.telecomnancy.Commande o =(eu.telecomnancy.Commande) cl.newInstance();
				o.setTS(this.sensor);
				o.execute();
			}
			
/*			if(source == itemVALUE)
			{

				String classe = prop.getProperty("commandeGetValue");
				Class cl = Class.forName(classe);
				eu.telecomnancy.Commande o =(eu.telecomnancy.Commande) cl.newInstance();
				o.setTS(this.sensor);
				this.value.setText(Double.toString(o.execute()));
			}
			*/


		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SensorNotActivatedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


}
