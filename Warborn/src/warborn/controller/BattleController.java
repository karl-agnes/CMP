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
			view.logUpdate(model.getBattle().fight());
		}
		if((e).getSource() == view.getButtons()[1]){
			while(model.getBattle().getFirstTerritory().getNbrOfUnits() > 1 && (model.getBattle().getSecondTerritory().getNbrOfUnits()) != 0){
				view.logUpdate(model.getBattle().fight());
			}
		}
		if((e).getSource() == view.getButtons()[2]){
			view.getFrame().setVisible(false);
			view.logClean();
			if(view.getHeaderText().equalsIgnoreCase("Victory!")){
				model.getBattle().move();
			}else{
				model.getBattle().resetTerritories();
				model.getMove().resetTerritories();
			}
			model.nextPhase();
		}
	}
}