package encounter;

import java.util.ArrayList;
import java.util.Queue;

import character.EncounterCharacter;
import dice.Roll;

public class EncounterHandler {

	private ArrayList<EncounterCharacter> activeCharacters = new ArrayList<EncounterCharacter>();
	private ArrayList<EncounterCharacter> inactiveCharacters = new ArrayList<EncounterCharacter>();
	
	private void rollInitiative(EncounterCharacter character)
	{
		character.setInitiative(Roll.abilityCheck(character.getStats().getBonus("DEX"), 0));
	}
	
	public void addCharacter(EncounterCharacter character)
	{
		rollInitiative(character);
		
		if (activeCharacters.size() == 0)
		{
			activeCharacters.add(character);
		}
		else
		{
			System.out.println(activeCharacters.size());
			int j = activeCharacters.size();
			for (int i = 0; i < j; i++)
			{
				System.out.println(activeCharacters.size() + " : " + i);
				if (character.getInitiative() > activeCharacters.get(i).getInitiative())
				{
					System.out.println("Adding char to loc" + i);
					activeCharacters.add(i, character);
					break;
				}
				else if (i == j - 1)
				{
					activeCharacters.add(character);
				}
			}
		}
		for (int i = 0; i < activeCharacters.size(); i++)
		{
			System.out.println("Name: " + activeCharacters.get(i).getName() + " Init: " + activeCharacters.get(i).getInitiative());
		}
	}
	
}
