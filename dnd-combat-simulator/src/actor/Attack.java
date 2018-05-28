package actor;

import java.util.Arrays;
import java.util.Collections;

import character.*;
import dice.Roll;

public class Attack {

	public static void weaponAttack(EncounterCharacter target, EncounterCharacter attacker, Weapon weapon)
	{
		int attackRoll;
		String attackModifierStat;
		int attackModifier = 0;
		boolean crit = false;
		CharacterStats attackerStats = attacker.getStats();
		CharacterStats targetStats = target.getStats();
		
		switch (weapon.getModifier())
		{
		case 1: attackModifierStat = "STR";
		break;
		case 2: attackModifierStat = "DEX";
		break;
		case 3: attackModifierStat = compareModifiers(attackerStats);
		break;
		default: attackModifierStat = "STR";
		break;
		}
		
		System.out.println("Rolling with " + attackModifierStat);
		attackModifier = attackerStats.getBonus(attackModifierStat);
		
		attackRoll = Roll.AbilityCheck(attackModifier, 0);
		
		attackRoll = 22;
		System.out.println(attacker.getName() + " attacks with " + weapon.getName() + ": "+ attackRoll);
		System.out.println("Comparing " + attackRoll + " to AC of " + targetStats.getAC());
		
		//Check for critical Hit
		if (attackRoll - attackModifier == 20)
		{
			System.out.println("CRIT AUTOMATIC HIT");
			crit = true;
			System.out.println("Hit for : " + weapon.getDamageRoll(attackModifier, crit));
		}
		else if (attackRoll >= targetStats.getAC())
		{
			System.out.println("Hit! Calculating damage");
			System.out.println("Hit for : " + weapon.getDamageRoll(attackModifier, crit));
			
		}
		else
		{
			System.out.println("Attack Missed");
		}

		
	}
	
	private static String compareModifiers (CharacterStats attackerStats)
	{
		int strMod = attackerStats.getBonus("STR");
		int dexMod = attackerStats.getBonus("DEX");
		
		if (strMod < dexMod)
			return "DEX";
		else
			return "STR";
	}
	
}
