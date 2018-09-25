package com.jdayssol.utility;

import java.util.Random;

public class RandomNumber {
	private Random random;
    public RandomNumber(Random random){
        this.random = random;
    }

    public int getRandomInt(){
        return random.nextInt();
    }
}
