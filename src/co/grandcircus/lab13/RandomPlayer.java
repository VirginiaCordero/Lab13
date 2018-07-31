package co.grandcircus.lab13;

import java.util.Random;

public class RandomPlayer extends Player {

	public RandomPlayer(String name) {
		super(name);
		
	}

	@Override
	public Roshambo generateRoshambo() {
		Random random =  new Random();
		int index = random.nextInt(Roshambo.values().length);
		return Roshambo.values()[index] ;
		
	}

	
}
