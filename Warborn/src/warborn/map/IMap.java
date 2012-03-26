package warborn.map;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public interface IMap extends Observer{
	public JPanel getMapPanel();
	public void addObserver(Observer controller);
}	
