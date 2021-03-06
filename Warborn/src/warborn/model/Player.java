package warborn.model;

import java.awt.Color;
import java.io.IOException;

import warborn.SupportClasses.PlayerData;
import warborn.model.spells.*;

public class Player {

	private int id, nbrOfTerritories = 0, mana = 2;
	private String name;
	private int race, background;
	private Color color;
	private Card[] cards = new Card[5];
	private boolean hasConquered;
	private Spellbook spellbook;
	
	public Player(String name, int id, Color color, int race, int background){
		this.name = name;
		this.id = id;
		Color copiedColor = new Color(color.getRed(), color.getGreen(), color.getBlue());
		this.color = copiedColor;
		this.race = race;
		this.background = background;
		this.spellbook = new Spellbook();
		try {
			spellbook.fill(background);
		} catch (IOException e) {
			System.out.println(PlayerData.getBackgroundName(background) + ".txt file not found!");
			e.printStackTrace();
		}
	}
	
	public int getID(){
		return id;
	}
	
	public int getNbrOfTerritories(){
		return nbrOfTerritories;
	}
	
	public Color getColor(){
		Color copiedColor = new Color(color.getRed(), color.getGreen(), color.getBlue());
		return copiedColor;
	}
	
	public String getName(){
		return name;
	}
	
	public int getRaceIndex(){
		return race;
	}
	
	public int getBackgroundIndex(){
		return background;
	}
	
	public Card[] getCards(){
		return cards;
	}

	public int getNumberOfCards(){
		for(int i = 0; i < cards.length; i++){
			if(cards[i] == null){
				return i;
			}
		}
		return cards.length;
	}
	
	public Card getCard(int index){
		return cards[index];
	}
	
	public int getMana(){
		return mana;
	}
	
	public Spellbook getSpelbook(){
		return spellbook;
	}
	
	public void setColor(Color color){
		Color copiedColor = new Color(color.getRed(), color.getGreen(), color.getBlue());
		this.color = copiedColor;
	}
	
	public boolean hasConquered(){
		return hasConquered;
	}

	public void addTerritory(Territory toAdd){
		toAdd.setOwner(this);
		nbrOfTerritories++;
	}
	
	public void removeTerritory(){
		nbrOfTerritories--;
	}
	
	
	public void addCard(Card newCard){
		for(int i = 0; i < cards.length; i++){
			if(cards[i] == null){
				cards[i] = newCard;
				break;
			}
		}
	}


	public void removeCard(int id){
		for(int i = 0; i < getNumberOfCards(); i++){
			if(cards[i].getIndex() == id){
				for(int j = i; j < getNumberOfCards()-1; j++){
					cards[j] = cards[j+1];
				}
				cards[getNumberOfCards()-1] = null;
				break;
			}
		}
	}

	
	public boolean canExchangeCards(){
		int[] nbrOfCards = new int[CardDeck.getMaxValue()];
		for (int i = 0; i < getNumberOfCards(); i++){
			nbrOfCards[cards[i].getIndex()]++;
			if(nbrOfCards[cards[i].getIndex()] > 2){
				return true;
			}
		}
		for(int i = 0; i < nbrOfCards.length; i++){
			if(nbrOfCards[i] < 1){
				return false;
			}
		}
		return true;
	}
	
	public void conquered(boolean b){
		hasConquered = b;
	}
	
	public void changeMana(int mana){
		this.mana = this.mana + mana;
	}
}
