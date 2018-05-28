package character;

import java.util.Random;

public class Weapon {

	private String name;
	private String weaponType;			//Used for proficency bonus calculation
	private int weaponDice;
	private int diceNumber;
	private int rangeEffective;
	private int rangeMax;
	
	//Determines modifier to apply
	private String attackType;
	//Damage type for resistance calculation
	private String damageType;
	
	Weapon(String n, String t, int dice, int diceNum, int rngEff, int rngMax, String aType, String dType)
	{
		this.name = n;
		this.weaponType = t;
		this.weaponDice = dice;
		this.diceNumber = diceNum;
		this.rangeEffective = rngEff;
		this.rangeMax = rngMax;
		this.attackType = aType;
		this.damageType = dType;
	}
	
	public void setAttackType(String type)
	{
		this.attackType = type;
	}
	
	public void SetDamageType(String type)
	{
		this.damageType = type;
	}
	
	public int getDamageRoll()
	{
		int damage = 0;
		Random rand = new Random();
		
		for (int i = 0; i < this.diceNumber; i++)
		{
			damage = damage + rand.nextInt(this.weaponDice) + 1;
		}
		System.out.println(damage);
		return damage;
	}
	
	public int[] GetRange()
	{
		return new int[]{this.rangeEffective, this.rangeMax};
	}
	
	public String[] GetType()
	{
		return new String[] {this.attackType, this.damageType};
	}
}
