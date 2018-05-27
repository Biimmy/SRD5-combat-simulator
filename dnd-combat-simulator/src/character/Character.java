package character;

import java.util.LinkedList;
import java.util.List;

public class Character {

	private String name;
	private Integer team;
	private CharacterStats stats;
	private List<Weapon> weapons = new LinkedList<Weapon>();
	
	public Character(String n, Integer t)
	{
		this.name =n;
		this.team = t;
	}
	
	public void addWeapon(String weaponName, String weaponType, Integer dice, 
			Integer diceNum, Integer rangeEff, Integer rangeMax,
			String attackType, String damageType)
	{
		weapons.add(new Weapon(weaponName, weaponType, dice, diceNum, rangeEff, rangeMax, attackType, damageType));
	}
	
	
	
}
