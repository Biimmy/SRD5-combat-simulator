package character;

import java.util.LinkedList;
import java.util.List;

import entity.Entity;

public class EncounterCharacter extends Entity {

	private int playerCharacter;
	private int team;
	private int initiative;
	private CharacterStats stats = null;
	private List<Weapon> weapons = new LinkedList<Weapon>();
	
	public EncounterCharacter(String n, int t)
	{
		super.name = n;
		this.team = t;
	}
	
	public void initStats (int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma)
	{
		stats = new CharacterStats();
		stats.initiateAbilityScores(strength, dexterity, constitution, intelligence, wisdom, charisma);
	}
	
	public CharacterStats getStats()
	{
		return this.stats;
	}
	
	public void addWeapon(String weaponName, String weaponType, int dice, 
			int diceNum, int rangeEff, int rangeMax,
			String attackType, String damageType, boolean finesse)
	{
		weapons.add(new Weapon(weaponName, weaponType, dice, diceNum, rangeEff, rangeMax, attackType, damageType, finesse));
	}
	
	public Weapon getWeapon (int i)
	{
		System.out.println("Getting weapon");
		if (weapons.size() <= i + 1)
		{
			System.out.println(weapons.get(i).getType()[0]);
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
	
	public int getInitiative()
	{
		return this.initiative;
	}
	
	public void setInitiative(int init)
	{
		this.initiative = init;
	}
	
}
