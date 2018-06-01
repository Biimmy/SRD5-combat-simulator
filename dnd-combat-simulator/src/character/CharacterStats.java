package character;

public class CharacterStats {

	boolean active; //Determines if character is currently active in init order
	
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
	private boolean deceased;
	
	CharacterStats()
	{
		this.deceased = false;
		this.hitpointsMax = -1;
		this.active = true;
	}
	
	//All functions used to set and initial values are located below
	public void initiateAbilityScores(int strength, int dexterity, int constitution,
			int intelligence, int wisdom, int charisma)
	{
		int[] aScoreInput = {strength, dexterity, constitution, intelligence, wisdom, charisma};
		
		for (int i = 0; i < 6; i++)
		{
			if (aScoreInput[i] >= 0)
				this.abilityScores[i] = aScoreInput[i];
			else
				this.abilityScores[i] = 0;
		}
		calculateBonus();
	}
	
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
		default: statNum = 0;
		break;
		}

		return this.abilityBonus[statNum];
	}
	
	public void setProficiency(int prof)
	{
		if (prof >= 0)
			this.proficiency = prof;
		else
			this.proficiency = 0;
	}
	
	public int getProficiency()
	{
			return this.proficiency;		
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
	
	public void setInitiativeBonus (int initBonus)
	{
		this.initiative = getBonus("DEX") + initBonus;
	}
	
	public int getInitiativeBonus()
	{
		return this.initiative;
	}
	
	public void setSpeed (int speed)
	{
		if (speed >= 0)
			this.speed = speed;
		else
			this.speed = 0;
		
	}
	
	public int getSpeed ()
	{
		return this.speed;
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
	
	public int getMaxHitpoints ()
	{
		return this.hitpointsMax;
	}
	
	public void changeHitpoints (int change)
	{
		System.out.println("Making change of: " + change + " to hitpoint value of " + this.currentHitpoints);
		this.currentHitpoints = this.currentHitpoints + change;
		System.out.println("New Hitpoint value: " + this.currentHitpoints);
		//Check for death after change
		hitpointCheck();
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
	
	private void hitpointCheck()
	{
		if (this.currentHitpoints <= 0)
		{
			this.deceased = true;
			this.active = false;
		}
	}
}
