package eu.telecomnancy;

import java.util.ArrayList;

public abstract class Observable
{
	public ArrayList<Observer> tableauObserver = new ArrayList<>();
	
	public void addObserver(Observer O) {
		// TODO Auto-generated method stub
		this.tableauObserver.add(O);
	}


	public void removeObserver(Observer O) {
		// TODO Auto-generated method stub
		this.tableauObserver.remove(O);
	}


	public void Notify() {
		// TODO Auto-generated method stub
		for (Observer o : this.tableauObserver)
		{
			o.Update();
		}
	}
}
