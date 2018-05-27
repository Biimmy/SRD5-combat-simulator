package character;

public class CharacterStats {

	//Gen Stats (0=Str, 1=Dex, 2 = Con, 3 = Int, 4 = Wis, 5 = Cha)
	private Integer[] abilityScores = new Integer[6];
	private Integer[] abilityBonus = new Integer[6];
	
	//Skills Implementation
	private Integer passivePerception;
	
	//Proficiency Bonus
	private Integer proficiency;
	
	//Saving Throws implementation
	
	//Gen Combat Stats
	private Integer hitpointsMax;
	private Integer currentHitpoints;
	private Integer ac;
	private Integer speed;
	private Integer initiative;
	
	//Death saves (to implement later)
	private Integer deathSuccess;
	private Integer deathfailure;
	private Boolean deceased;
	
	CharacterStats()
	{
		this.deceased = false;
		this.deathSuccess = 0;
		this.deathfailure = 0;
	}
	
	//All functions used to set and initial values are located below
	public void InitiateAbilityScores(Integer strength, Integer dexterity, Integer constitution,
			Integer intelligence, Integer wisdom, Integer charisma)
	{
		this.abilityScores[0] = strength;
		this.abilityScores[1] = dexterity;
		this.abilityScores[2] = constitution;
		this.abilityScores[3] = intelligence;
		this.abilityScores[4] = wisdom;
		this.abilityScores[5] = charisma;		
		
		CalculateBonus();
	}
	
	public void SetAC (Integer ArmorClass)
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
	
	public void setInitiative (Integer initBonus)
	{
		this.initiative = GetBonus(1) + initBonus;
	}
	
	public void SetSpeed (Integer speed)
	{
		this.speed = speed;
	}
	
	public void SetMaxHitpoints(Integer hp)
	{
		if (this.hitpointsMax == null || this.currentHitpoints > hp)
		{
			this.currentHitpoints = hp;
		}
		this.hitpointsMax = hp;
	}
	
	//Functions to pull stats located below
	
	//Pulls the ability bonus based on provided stat number (0=Str, 1=Dex, 2 = Con, 3 = Int, 4 = Wis, 5 = Cha)
	public Integer GetBonus(Integer statNum)
	{
		return this.abilityBonus[statNum];
	}
	
	private void CalculateBonus()
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
