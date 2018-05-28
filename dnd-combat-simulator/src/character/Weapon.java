package character;

import java.util.Random;

public class Weapon {

	private String name;
	private String weaponProficiencyType;			//Used for proficiency bonus calculation
	private int weaponDice;
	private int diceNumber;
	private int rangeEffective;
	private int rangeMax;
	private boolean finesse;
	
	//Determines modifier to apply
	private String attackType;
	//Damage type for resistance calculation
	private String damageType;
	
	Weapon(String n, String t, int dice, int diceNum, int rngEff, int rngMax, String aType, String dType, boolean finesse)
	{
		this.name = n;
		this.weaponProficiencyType = t;
		this.weaponDice = dice;
		this.diceNumber = diceNum;
		this.rangeEffective = rngEff;
		this.rangeMax = rngMax;
		this.attackType = aType;
		this.damageType = dType;
		this.finesse = finesse;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setAttackType(String type)
	{
		this.attackType = type;
	}
	
	public void SetDamageType(String type)
	{
		this.damageType = type;
	}
	
	public int getDamageRoll(int modifier, boolean crit)
	{
		int damage = 0;
		Random rand = new Random();
		int diceRolled = this.diceNumber;
		
		if (crit)
		{
			diceRolled = diceRolled * 2;
		}
		
		for (int i = 0; i < diceRolled; i++)
		{
			damage = damage + rand.nextInt(this.weaponDice) + 1;
			System.out.println(damage);
		}
		return damage + modifier;
	}
	
	public int[] getRange()
	{
		return new int[]{this.rangeEffective, this.rangeMax};
	}
	
	public String[] getType()
	{
		return new String[] {this.attackType, this.damageType};
	}
	
	// 1 = str based attack, 2 = ranged based attack, 3 = finesse weapon (need to check dex vs str stat)
	public int getModifier ()
	{
		if (this.attackType.equals("melee"))
		{
			if (finesse)
				return 3;
			else
				return 1;
		}
		else if (this.attackType.equals("ranged"))
			return 2;
		else
			return 0;
	}
}
