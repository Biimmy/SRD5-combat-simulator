package character;

public class CharacterStats {

	//Gen Stats (0=Str, 1=Dex, 2 = Con, 3 = Int, 4 = Wis, 5 = Cha)
	private int[] abilityScores = new int[6];
	private int[] abilityBonus = new int[6];
	

	//Proficiency Bonus
	private int proficiency;
	
	//Saving Throws implementation
	
	//Gen Combat Stats
	private int hitpointsMax;
	private int currentHitpoints;
	private int ac;
	private int speed;
	private int initiative;
	
	//Death saves (to implement later)
	private int deathSuccess;
	private int deathfailure;
	private Boolean deceased;
	
	CharacterStats()
	{
		this.deceased = false;
		this.deathSuccess = 0;
		this.deathfailure = 0;
		this.hitpointsMax = -1;
	}
	
	//All functions used to set and initial values are located below
	public void initiateAbilityScores(int strength, int dexterity, int constitution,
			int intelligence, int wisdom, int charisma)
	{
		this.abilityScores[0] = strength;
		this.abilityScores[1] = dexterity;
		this.abilityScores[2] = constitution;
		this.abilityScores[3] = intelligence;
		this.abilityScores[4] = wisdom;
		this.abilityScores[5] = charisma;		
		
		calculateBonus();
	}
	
	public void setAC (int ArmorClass)
	{
		if (ArmorClass < 0)
		{
			this.ac = 0;
		}
		else
		{
		this.ac = ArmorClass;
		}
	}
	
	public int getAC()
	{
		return this.ac;
	}
	
	public void setInitiative (int initBonus)
	{
		this.initiative = getBonus("DEX") + initBonus;
	}
	
	public void setSpeed (int speed)
	{
		this.speed = speed;
	}
	
	//Value of -1 means that hitpoint max is not set yet
	public void setMaxHitpoints(int hp)
	{
		if (this.hitpointsMax == -1 || this.currentHitpoints > hp)
		{
			this.currentHitpoints = hp;
		}
		this.hitpointsMax = hp;
	}
	
	//Functions to pull stats located below
	
	//Pulls the ability bonus based on provided stat number (0=STR, 1=DEX, 2 =CON, 3 =INT, 4 =WIS, 5 =CHA)
	public int getBonus(String stat)
	{
		int statNum = 0;
		switch (stat)
		{
		case "STR": statNum = 0;
		break;
		case "DEX": statNum = 1;
		break;
		case "CON": statNum = 2;
		break;
		case "INT": statNum = 3;
		break;
		case "WIS": statNum = 4;
		break;
		case "CHA": statNum = 5;
		break;
		default: statNum = 1;
		break;
		}

		return this.abilityBonus[statNum];
	}
	
	private void calculateBonus()
	{
		for (int i = 0; i < 6; i++)
		{
			if (this.abilityScores[i] < 10)
			{
				this.abilityBonus[i] =  -1 * (Math.abs(this.abilityScores[i] - 10) / 2);
			}
			else
			{
				this.abilityBonus[i] = (this.abilityScores[i] - 10) / 2;
			}
		}
	}
}
