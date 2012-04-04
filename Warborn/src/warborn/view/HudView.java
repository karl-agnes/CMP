package warborn.view;

import java.util.Observable;
import java.util.Observer;
import warborn.model.Warborn;
import javax.swing.*;

public class HudView extends JPanel implements Observer{
	
	private static final long serialVersionUID = 1L;
	private JButton[] buttons;
	private JButton next, useCards;
	private JLabel currentPlayer, territoryData, currentState;
	//private JLabel[] PlayerStats;
	private JLabel reinforcements;
	
	public HudView(Warborn model){

		this.setLayout(null);
		this.setSize(model.getWidth(), (int)(model.getHeight()*0.25));
		this.setLocation(0, 0);
		
		buttons = new JButton[2];
		
		next = new JButton("Next");
		next.setBounds((int)(this.getWidth()*0.8), (int)(this.getHeight()*0.25), 200, 150);
		this.add(next);
		buttons[0] = next;
		
		useCards = new JButton("Souls");
		useCards.setBounds((int)(this.getWidth()*0.1), (int)(this.getHeight()*0.25), 200, 150);
		this.add(useCards);
		buttons[1] = useCards;
		
		reinforcements = new JLabel("Reinforcements");
		reinforcements.setBounds((int)(this.getWidth()*0.5), (int)(this.getHeight()*0.1), 400, 50);
		this.add(reinforcements);
		
		currentPlayer = new JLabel();
		currentPlayer.setBounds((int)(this.getWidth()*0.5), (int)(this.getHeight()*0.2), 400, 50);
		this.add(currentPlayer);
		
		currentState = new JLabel();
		currentState.setBounds((int)(this.getWidth()*0.5), (int)(this.getHeight()*0.3), 400, 50);
		this.add(currentState);
		
		this.setVisible(true);
	}
	
	public JButton[] getButtons(){
		return buttons;
	}
	
	@Override
	public void update(Observable ml, Object e) {
		Warborn model = (Warborn)ml;
		
		currentPlayer.setText(model.getCurrentPlayer().getName());
		currentState.setText("Battle Phase");
		reinforcements.setVisible(false);
		if (model.getState() == 3){
			next.setText("End Turn");
			currentState.setText("Troop Movement");
		}else{
			next.setText("next");
		}
		if (model.getState()==1){
			if (model.getCurrentPlayer().canExchangeCards()){
				useCards.setEnabled(true);
			}
			reinforcements.setText("Reinforcements: " + model.getNbrOfReinforcements());
			reinforcements.setVisible(true);
			currentState.setText("Reinforce your Troops");
			//TODO display "troops" in a fitting fashion
		}
		
	}
}
