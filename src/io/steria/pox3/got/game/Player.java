package io.steria.pox3.got.game;

import io.steria.pox3.got.objectives.ObjectiveCard;
import io.steria.pox3.got.story.House;

public class Player {
	String name;
	House house;
	ObjectiveCard card;
	PlayerState state = PlayerState.PLAYING;
	RoundState roundState = RoundState.WAITING;
	
	//Bidirection, argh !
	Game game;
	Round currentRound;
	
	int moves = 3;
	
	public Player(String name, House house) {
		this.name = name;
		this.house = house;
		//argh, bidirection handling
		this.house.setPlayer(this);
		//but this linj never moves. Not so bad.
	}

	boolean chooseName(String pName) {
		this.name = pName; // mets le nom rentré dans une case mémoire distincte
							// pour chaque nom
		return true;
	}

	boolean chooseHouse(House pHouse) {// booléen car la maison a des chances
										// d'avoir déjà été prise
		this.house = pHouse;
		return true;
	}

	ObjectiveCard selectCard() {
		return null;
	}

	public void decreaseMoves() {
		if(this.roundState == RoundState.WAITING){
			throw new PlayerRoundEndedException();
		}
		this.moves --;	
		
	}
	
	
}
