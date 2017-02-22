import java.util.Arrays;

public class decrypt 
{

    public static void main(String[]args)
    {
    	FileIO reader = new FileIO();
       	int[]ASCIIarray = new int[256]; //create array with a slot for every ASCII value
    	String[] inputs = reader.load("C:\\Users\\Cieran\\Desktop\\encoded1.txt");
    	String word = Arrays.toString(inputs);

System.out.println(word);
    	for(int i=0; i<word.length(); i++) //loops from 0 to the length of the String
    	{
    		int numWord = (int)word.charAt(i); //Sets numWord equal to the decimal value of the ASCII character
    		ASCIIarray[numWord]++; //Increments the slot of the corresponding ASCII character
    	}
    	for(int i=0; i<ASCIIarray.length; i++)
    	{ //go through frequency array
           if(ASCIIarray[i]>0)
           { //print out non-zero frequencies - cast to a char
                System.out.println("'"+(char)i+"' appeared "+ASCIIarray[i]+((ASCIIarray[i] == 1) ? " time" : " times")); 
           }
        }   
    }
}