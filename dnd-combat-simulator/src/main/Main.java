package main;

import character.*;

public class Main {
	
	public static void main(String[] args)
	{
		EncounterCharacter test = new EncounterCharacter("Test1", 1);
		test.addWeapon("test wep", "test type", 6, 2, 5, 5, "test attack type", "test damage type");
		
		Weapon testWep = test.getWeapon(0);
		
		System.out.println(testWep.getDamageRoll());
		
		
	}
	
}
