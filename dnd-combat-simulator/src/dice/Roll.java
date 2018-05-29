package dice;

import java.util.Random;

public class Roll {
	
	public static int abilityCheck (int modifier, int advantage)
	{
		Random rand = new Random();
		int rollmax = rand.nextInt(20) + 1; 
		int rollmin = 0;
		if (advantage == 0)
		{
			System.out.println("Roll of: " + rollmax + " + modifier: " + modifier);
			return rollmax + modifier;
		}
		else
		{
			rollmin = rand.nextInt(20) + 1;
			if (rollmin > rollmax)
			{
				rollmax = rollmax + rollmin;
				rollmin = rollmax - rollmin;
				rollmax = rollmax - rollmin;
			}
			if (advantage == 1)
				return rollmax + modifier;
			else if (advantage == -1)
				return rollmin + modifier;
			else
			{
				System.out.println("invalid advantage value");
				return 0;
			}

		}
	}

}
