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
		int damage;
		CharacterStats attackerStats = attacker.getStats();
		CharacterStats targetStats = target.getStats();
		
		//Select which modifier to use based on weapon type
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
		attackModifier = attackModifier + attackerStats.getProficiency();
		
		attackRoll = Roll.abilityCheck(attackModifier, 0);
		
		System.out.println(attacker.getName() + " attacks with " + weapon.getName() + ": "+ attackRoll);
		System.out.println("Comparing " + attackRoll + " to AC of " + targetStats.getAC());
		
		//Check for critical Hit
		if (attackRoll - attackModifier == 20)
		{
			System.out.println("CRIT AUTOMATIC HIT");
			crit = true;
			damage = weapon.getDamageRoll(attackModifier, crit);
			target.getStats().changeHitpoints(-damage);
		}
		else if (attackRoll >= targetStats.getAC())
		{
			System.out.println("Hit! Calculating damage");
			damage = weapon.getDamageRoll(attackModifier, crit);
			target.getStats().changeHitpoints(-damage);
			
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
