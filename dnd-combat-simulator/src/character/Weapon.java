package character;

import java.util.Random;

public class Weapon {

	private String name;
	private String weaponType;			//Used for proficency bonus calculation
	private Integer weaponDice;
	private Integer diceNumber;
	private Integer rangeEffective;
	private Integer rangeMax;
	
	//Determines modifier to apply
	private String attackType;
	//Damage type for resistance calculation
	private String damageType;
	
	Weapon(String n, String t, Integer dice, Integer diceNum, Integer rngEff, Integer rngMax, String aType, String dType)
	{
		this.name = n;
		this.weaponType = t;
		this.weaponDice = dice;
		this.diceNumber = diceNum;
		this.rangeEffective = rngEff;
		this.rangeMax = rngMax;
	}
	
	public void setAttackType(String type)
	{
		this.attackType = type;
	}
	
	public void SetDamageType(String type)
	{
		this.damageType = type;
	}
	
	public Integer getDamageRoll()
	{
		Integer damage = 0;
		Random rand = new Random();
		
		for (int i = 0; i < this.diceNumber; i++)
		{
			damage = damage + rand.nextInt(this.weaponDice) + 1;
		}
		
		return damage;
	}
	
	public Integer[] GetRange()
	{
		return new Integer[]{this.rangeEffective, this.rangeMax};
	}
	
	public String[] GetType()
	{
		return new String[] {this.attackType, this.damageType};
	}
}
