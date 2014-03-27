package com.jasonradcliffe.coinflip;

import java.util.Random;

public class Coin {
	//Variables
	
	String[] listOfResults = new String[] {"Heads","Tails"};
	
	//Methods
	
	public String flip(){
		String result = "";
		
		Random gen = new Random();
		int randomNumber = gen.nextInt(2);
		
		if(randomNumber == 0){
			result = listOfResults[0];
		}
		else{
			result = listOfResults[1];
		}
		return result;
	}
	
	
	

}
