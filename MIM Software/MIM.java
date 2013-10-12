import java.util.Arrays;

/**
 * A class to output the three tests requested by MIM Software
 * @author davidaghassi
 *
 */
public class MIM {
	static private String[] inputArray = {"test", 
			"This is a test.", 
			"This will-", "be awesome",
			"This is a test case.",
			"What a wonderfuL DaY",
			"NoW The first of Dec",
			"I said a hip to the hop to the hippidy hiP HoP",
			"Now - a -",
			"days-"};
	static private int index = 0;


	public static void main (String[] args){
		for(String s : inputArray){
			s = hyphenAppend(s, index);
			s = isDivFour(s);
			s = isDivFive(s);
			s = numOfUC(s);
			System.out.print(s + "\n");
			index++;
		}
	}
	/**
	 * Checks to see if the length of the input string is a 
	 * multiple of four. If it is, it reverses the string.
	 * @param input
	 * @return The string either reversed or normal depending on length
	 */
	private static String isDivFour(String input){
		if(input.length()%4 ==0){
			StringBuilder builder = new StringBuilder(input).reverse();
			return builder.toString();
		}
		else{
			return input;
		}
	}
	
	/**
	 * A method to check and see if a string is divisible by five. 
	 * Trims the string to five characters if it is.
	 * @param input
	 * @return The trim string if it divisible by five
	 */
	private static String isDivFive(String input){
		if(input.length()%5 == 0){
			 return input.substring(0,5);
		}
		else{
			return input;
		}
	}
	
	/**
	 * Changes the whole string to uppercase if 3 of the first 5
	 * characters are uppercase.
	 * @param input
	 * @return An uppercase string, or a normal string if not enough characters are
	 * uppercase
	 */
	private static String numOfUC(String input){
		int numberOfUC = 0;
		int count = 0;
		for(char c : input.toCharArray()){
			if(Character.isUpperCase(c) && count<=5){
				numberOfUC++;
				if(numberOfUC == 3){
					return input.toUpperCase();
				}
				count++;
			}
			else if(count>5){
				break;
			}
		}
		return input;
		
	}
	
	/**
	 * If the string ends if a hyphen, append the next string in the list
	 * @param input
	 * @return The string appended with the next string.
	 */
	private static String hyphenAppend(String input, int spot){
		char hyp = '-';
		if(input.charAt(input.length()-1) == hyp){
			if(spot + 1 > inputArray.length-1){
				return input;
			}
			input = input.substring(0,input.length()-2);
			return input + inputArray[spot+1];
		}
		return input;
	}
}
