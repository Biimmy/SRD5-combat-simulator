package main;

import character.*;
import debug.Test;
import actor.*;

public class Main {
	
	public static void main(String[] args)
	{
		EncounterCharacter test1 = Test.loadTestCharacter("AttackerTest");
		EncounterCharacter test2 = Test.loadTestCharacter("TargetTest");
		
		Attack.weaponAttack(test2, test1, test1.getWeapon(0));
		

		
	}
	
}
