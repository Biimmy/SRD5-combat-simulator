package main;

import character.*;
import debug.Test;
import encounter.EncounterHandler;
import actor.*;

public class Main {
	
	public static void main(String[] args)
	{
		EncounterHandler encounter = new EncounterHandler();
		EncounterCharacter test;
		
		for (int i = 0; i < 8; i++)
		{
			test = Test.loadTestCharacter("Character" + Integer.toString(i));
			encounter.addCharacter(test);
		}
		
		EncounterCharacter test1 = Test.loadTestCharacter("AttackerTest");
		EncounterCharacter test2 = Test.loadTestCharacter("TargetTest");
		
		
		
		//Attack.weaponAttack(test2, test1, test1.getWeapon(0));
		

		
	}
	
}
