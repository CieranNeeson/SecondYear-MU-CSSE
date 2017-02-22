
import java.util.Scanner;
import java.util.Arrays;

public class Countdown 
{
	public static void main(String args[])
	{
		
        FileIO reader = new FileIO();
        String[] inputs = reader.load("C:\\Users\\Cieran\\Desktop\\College\\dictionary.txt");
        String[] altInputs = new String[inputs.length];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string of letters:");
        String letters = scan.nextLine();
        scan.close();
        char[] chars = letters.toCharArray();
        Arrays.sort(chars);
        String newLetters = String.valueOf(chars);
        char[] chars1;

        for(int i = 0; i < inputs.length; i++)
        {
        	String original = inputs[i];
        	chars1 = original.toCharArray();
        	Arrays.sort(chars1);
        	String update = String.valueOf(chars1);
        	altInputs[i] = update;
        }
        for(int i = 0; i < altInputs.length; i++)
        {
        	if(altInputs[i].trim().equals(newLetters) && (inputs[i].trim().equals(letters)))
        	{
        		System.out.println("INPUT STRING IS IN DICTIONARY: " + inputs[i]);
        	}
        	else if(altInputs[i].trim().equals(newLetters) && (!inputs[i].trim().equals(letters)))
        	{
        		System.out.println("ANAGRAM FOUND: " + inputs[i]);
        	}
        }
        System.out.println("END OF DICTIONARY REACHED");
        
    }

}
