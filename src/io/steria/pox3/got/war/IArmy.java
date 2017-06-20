package io.steria.pox3.got.war;

import io.steria.pox3.got.game.Player;
import io.steria.pox3.got.story.House;
import io.steria.pox3.got.tile.Tile;

public interface IArmy {
	
	int getTotalTroops();
	int getMovedTroops();
	int getReadyTroops(); //les troupes qui n'ont pas bougées
	
	void move(int troops, Direction direction);
	
	/**
	 * Move all the army
	 * @param domain
	 */
	
	void move(Direction direction);
		
	boolean attack(IArmy ennemy);		
	
	Tile getPosition();
	House getHouse();
	
	ArmyState getState();
	
	Player getPlayer();
}
