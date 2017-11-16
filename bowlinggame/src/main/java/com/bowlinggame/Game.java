package com.bowlinggame;

/* Program to calculate the total score of the bowling game at the end of the game*/


public class Game {

	public int calculateScore(String input) {

		String[] inputValue = input.split("");  //get each character of the string and store into an array
		int score = 0;
		double frame = 1; //Count of two rolls
		
		//Loop through each roll to get the score and calculate the total score
		for (int roll= 0; roll < inputValue.length; roll++) {
			
			score = score + convertToInteger(roll,inputValue); //Score for the roll in a frame
					
			/*Get the integer values of X, /, - and number from the inputValue until the last roll and frame
			 * to calculate the total score
			 */
			if(roll < inputValue.length && frame < 10 ){
				
				/* If the roll is strike, calculate the score for the current roll and the next two rolls
				 * Move to the next frame
				 */
				if (inputValue[roll].equals("X")) {
					score = score + convertToInteger(roll+1, inputValue) + convertToInteger(roll+2, inputValue);
					frame++;
				}
				
				/* If the roll doesn't knock down any pins, 
				 * calculate the total score for the rolls in that frame
				 */
				else if (inputValue[roll].equals("-")){
					score = score + convertToInteger(roll, inputValue);
					frame = frame + 0.5;
				}
				
				/*
				 * If the roll is a spare, calculate the total score from the current frame score and the roll in the next frame
				 */
				else if (inputValue[roll].equals("/")){
					score = score + convertToInteger(roll+1, inputValue);
					frame = frame + 0.5;
				}
				
				/*
				 * If the inputValue is just an integer, move to the next roll
				 */
				else {
					frame = frame + 0.5;
				}
			}
		}
		return score;
	}

	//Return integer values based on the strike, spare, miss or a number
	private int convertToInteger(int roll, String[] inputValue) {
		try{
			String scoreInput = inputValue[roll];
			
			//Check for strike
			if(scoreInput.equals("X")) {
				return 10;
			}
			//Check for miss
			else if(scoreInput.equals("-")) {
				return 0; 
			}
			//Check for spare
			else if(scoreInput.equals("/")) {
				return (10 - Integer.parseInt(inputValue[roll - 1])); 
			}
			else 
				return Integer.parseInt(scoreInput);   
		}
		catch (StringIndexOutOfBoundsException e){ 
			return 0; 
		} 
	}
}
