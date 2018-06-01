package debug;

import character.EncounterCharacter;

public class Test {

	public static EncounterCharacter loadTestCharacter (String name)
	{
		EncounterCharacter testChar = new EncounterCharacter(name, 1);
		testChar.initStats(14, 14, 10, 10, 10, 10);
		testChar.getStats().setAC(15);
		testChar.getStats().setProficiency(1);
		testChar.getStats().setMaxHitpoints(10);
		
		testChar.addWeapon("Greatsword", "simple", 6, 2, 5, 5, "melee", "slashing", false);
		
		return testChar;
	}
}
