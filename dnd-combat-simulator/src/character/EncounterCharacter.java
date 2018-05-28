package character;

import java.util.LinkedList;
import java.util.List;

public class EncounterCharacter {

	private String name;
	private int team;
	private CharacterStats stats;
	private List<Weapon> weapons = new LinkedList<Weapon>();
	
	public EncounterCharacter(String n, int t)
	{
		this.name =n;
		this.team = t;
	}
	
	public void addWeapon(String weaponName, String weaponType, int dice, 
			int diceNum, int rangeEff, int rangeMax,
			String attackType, String damageType)
	{
		weapons.add(new Weapon(weaponName, weaponType, dice, diceNum, rangeEff, rangeMax, attackType, damageType));
	}
	
	public Weapon getWeapon (int i)
	{
		System.out.println("Getting weapon");
		if (weapons.size() <= i + 1)
		{
			System.out.println(weapons.get(i).GetType()[0]);
			return weapons.get(i);
		}
		else
		{
			return null;
		}
	}
	
	public List<Weapon> getWeaponList ()
	{
		return this.weapons;
	}
	
}
