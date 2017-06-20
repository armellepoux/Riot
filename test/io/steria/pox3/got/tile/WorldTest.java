package io.steria.pox3.got.tile;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import io.steria.pox3.got.story.House;
import io.steria.pox3.got.story.HouseFactory;

public class WorldTest {
	
	World world;

	@Before
	public void setUp() throws Exception {
		world=new World();
	}


	@Test
	public void testGenerate() {
		world.generate();// not needed, done by constructor
		assertTrue(world.tiles.length==12);
		assertTrue(world.tiles[0].length==11);
	}
	
	@Test
	public void testAssignFreeDomain(){
		world.assignFreeDomain(1, 0, 4, 2, "North");
		assertTrue(world.tiles[1][0] instanceof Domain);
		Domain north1=(Domain)world.tiles[1][0];//instanceof: objet de type Domain
		assertTrue(north1.name.equals("North-1"));
		
		world.assignFreeDomain(8, 6, 2, 2, "Volantis");
		assertTrue(world.tiles[8][6] instanceof Domain);
		Domain volantis2=(Domain)world.tiles[9][6];//instanceof: objet de type Domain
		assertTrue(volantis2.name.equals("Volantis-2"));
	}
	
	@Test
	public void testAssignDomainWithHouse(){
		
		House stark=new HouseFactory().getStark();
		
		world.assignDomainWithHouse(1, 2, 4, 2, "Winterfell", stark);
		assertTrue(world.tiles[1][2] instanceof Domain);
		Domain winterfell6=(Domain)world.tiles[2][3];
		winterfell6.house.equals(stark);
		assertTrue(winterfell6.name.equals("Winterfell-6"));
		assertTrue(winterfell6.house.equals(Optional.of(stark)));
		
		House martell=new HouseFactory().getMartell();
		
		world.assignDomainWithHouse(3, 8, 2, 2, "Dorne", martell);
		assertTrue(world.tiles[3][8] instanceof Domain);
		Domain dorne3=(Domain)world.tiles[3][9];
		dorne3.house.equals(martell);
		assertTrue(dorne3.name.equals("Dorne-3"));
		assertTrue(dorne3.house.equals(Optional.of(martell)));
	}

	@Test
	public void testFillWater(){
		House stark=new HouseFactory().getStark();
		world.assignDomainWithHouse(1, 2, 4, 2, "Winterfell", stark);
		
		world.fillWater();
		
		Domain winterfell6=(Domain)world.tiles[2][3];
		assertTrue(winterfell6.name.equals("Winterfell-6"));
	
		assertTrue(world.tiles[6][6] instanceof WaterTile);
	}
	

	@Test
	public void testAllowMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsWinter() {
		assertFalse(world.winter);//equivalent à assertTrue(map.winter==false)
		world.startWinter();
		assertTrue(world.winter);
	}

}
