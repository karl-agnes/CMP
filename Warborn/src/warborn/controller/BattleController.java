package warborn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import warborn.model.Warborn;
import warborn.view.BattleView;

public class BattleController implements ActionListener{
	private Warborn model;
	private BattleView view;	
	
	public BattleController(Warborn model, BattleView view){
		this.model = model;
		this.view = view;
		for(int i=0; i<view.getButtons().length; i++){
			view.getButtons()[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if((e).getSource() == view.getButtons()[0]){
			model.getBattle().fight();
		}
		if((e).getSource() == view.getButtons()[1]){
			while(model.getBattle().getFirstTerritory().getNbrOfUnits() != 0 && (model.getBattle().getSecondTerritory().getNbrOfUnits()) != 0){
				model.getBattle().fight();
			}
		}
		if((e).getSource() == view.getButtons()[2]){
			view.getFrame().setVisible(false);
			model.nextPhase();
			model.getBattle().resetTerritories();
		}
	}
}