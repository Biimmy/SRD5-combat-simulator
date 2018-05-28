package main;

public class Main {
	
	public static void main(String[] args)
	{
		character.Character test = new character.Character("Test1", 1);
		test.addWeapon("test wep", "test type", 6, 2, 5, 5, "test attack type", "test damage type");
		
		character.Weapon testWep = test.getWeapon(0);
		
		System.out.println(testWep.getDamageRoll());
		
		
	}
	
}
