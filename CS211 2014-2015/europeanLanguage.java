package Labs;
import java.util.*;

public class europeanLanguage 
{
	 public static void main(String[]args)
	    {
		 	FileIO reader = new FileIO();
		 	String[] inputs = reader.load("C:\\Users\\Cieran\\Desktop\\encoded1.txt");
		 	String word = Arrays.toString(inputs);
	       	int[]ASCIIarray = new int[256]; //create array with a slot for every ASCII value
	       	/*
	       	 * Create arrays and fill them with the top 10 percentage frequencies for each language
	       	 */
	    	double[]Finnish = {12.22, 10.82, 8.83, 8.75, 7.97, 7.86, 5.76, 5.61, 5.01, 4.97};
	    	double[]English = {12.10, 8.94, 8.55, 7.47, 7.33, 7.17, 6.73, 6.33, 4.96, 4.21};
	    	double[]German = {15.99, 9.59, 7.71, 7.60, 6.43, 6.41, 6.34, 4.92, 4.11, 3.76};
	    	double[]Swedish = {10.15, 9.38, 8.54, 8.43, 7.69, 6.59, 5.82, 5.28, 4.70, 4.48};
	    	double[]Russian = {10.61, 8.21, 8.04, 7.98, 6.72, 5.83, 5.71, 5.38, 4.75, 4.32};
	    	double[]French = {14.47, 7.98, 7.60, 7.32, 7.21, 7.11, 6.86, 5.86, 5.55, 5.39};
	       	double[]Danish = {15.45, 8.96, 7.24, 6.86, 6.03, 6.00, 5.86, 5.81, 5.23, 4.64};
	    	double[]Icelandic = {10.11, 8.58, 7.71, 7.58, 6.42, 5.63, 4.95, 4.56, 4.53, 4.39};
	    	double[]Polish = {9.02, 8.09, 7.90, 7.51, 5.81, 5.17, 5.06, 4.78, 4.46, 3.96};
	       	int count = 0;
	       	int newCount = 0;
	       	
	    	for(int i=0; i<word.length(); i++) //loops from 0 to the length of the String
	    	{
	    		int numWord = (int)word.charAt(i); //Sets numWord equal to the decimal value of the ASCII character
	    		ASCIIarray[numWord]++;
	    		count++;
	    	}
	    	for(int i=32; i<ASCIIarray.length; i++)
	    	{ //go through frequency array
	           if(ASCIIarray[i]>0)
	    	   {
	               newCount++;
	           }
	        }
	    	System.out.println(newCount + " unique characters");
	    	System.out.println(count + " total characters");
	    	System.out.println("+++++++++++++++++++++++++++++");
	    	double[] freq = new double[count];
	    	for(int i=0; i<ASCIIarray.length; i++)
	    	{
	    		double percent = ((double)ASCIIarray[i]/(double)count) * 100;
	    		if(percent > 0.0)
	    		{
	    			System.out.println((char)i + " | " + percent + "%");
	    		}
	    		freq[i] = percent;
	    		
	    	}
	    	System.out.println("+++++++++++++++++++++++++++++");
	    	Double[] doubleArray = new Double[freq.length];
	    	for(int i = 0; i<freq.length; i++)
	    	{
	    		doubleArray[i] = new Double(freq[i]);	
	    	}
	    	Arrays.sort(doubleArray, Collections.reverseOrder());
	    	double[] allSums = new double[9];

	    	for(int i = 0; i<allSums.length; i++)
	    	{
	    		allSums[0] += doubleArray[i] - English[i];
	    		allSums[1] += doubleArray[i] - Finnish[i];
	    		allSums[2] += doubleArray[i] - German[i];
	    		allSums[3] += doubleArray[i] - Swedish[i];
	    		allSums[4] += doubleArray[i] - Russian[i];
	    		allSums[5] += doubleArray[i] - French[i];
	    		allSums[6] += doubleArray[i] - Danish[i];
	    		allSums[7] += doubleArray[i] - Icelandic[i];
	    		allSums[8] += doubleArray[i] - Polish[i];
	    	}
	    	
	    	double smallest = allSums[0];
	    	for(int i=1; i< allSums.length; i++)
            {
	    		if(allSums[i] < smallest)
	    		{
	    			smallest = allSums[i];
	    		}
            }
	    	System.out.println("Most likely match: ");
	    	if(smallest == allSums[0])
	    	{
	    		System.out.println("ENGLISH");
	    	}
	    	else if(smallest == allSums[1])
	    	{
	    		System.out.println("FINNISH");
	    	}
	    	else if(smallest == allSums[2])
	    	{
	    		System.out.println("GERMAN");
	    	}
	    	else if(smallest == allSums[3])
	    	{
	    		System.out.println("SWEDISH");
	    	}
	    	else if(smallest == allSums[4])
	    	{
	    		System.out.println("RUSSIAN");
	    	}
	    	else if(smallest == allSums[5])
	    	{
	    		System.out.println("FRENCH");
	    	}
	    	else if(smallest == allSums[6])
	    	{
	    		System.out.println("DANISH");
	    	}
	    	else if(smallest == allSums[7])
	    	{
	    		System.out.println("ICELANDIC");
	    	}
	    	else if(smallest == allSums[8])
	    	{
	    		System.out.println("POLISH");
	    	}
	    	System.out.println("+++++++++++++++++++++++++++++");
	    }
}
