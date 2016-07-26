package Labs;
import java.util.*;
public class Huffman {

    public static void main(String[]args)
    {
       	int[]ASCIIarray = new int[256]; //create array with a slot for every ASCII value
    	Scanner sc = new Scanner(System.in); //Initialised a scanner
    	String word = new String(""); //empty String
    	System.out.println("Please enter a String");
    	word = sc.nextLine();
    	sc.close();
    	 //String equals the users input


    	for(int i=0; i<word.length(); i++) //loops from 0 to the length of the String
    	{
    		int numWord = (int)word.charAt(i); //Sets numWord equal to the decimal value of the ASCII character
    		ASCIIarray[numWord]++; //Increments the slot of the corresponding ASCII character
    		int bin = Integer.parseInt(Integer.toBinaryString(numWord)); //Converts the decimal value of the ASCII character into binary
    		String binary = new String(""+bin); //converts binary number to String
    		if(binary.length()==6)
    		{
    			System.out.print("0" + binary + " "); //Prints the binary number to the screen
    		}
    		else
    		{
    			System.out.print(binary + " "); //Prints the binary number to the screen
    		}


    	}
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");

		PriorityQueue < Tree >  PQ = new PriorityQueue < Tree >() ;  //make a priority queue to hold the forest of trees


       for(int i=0; i<ASCIIarray.length; i++){ //go through frequency array
           if(ASCIIarray[i]>0){ //print out non-zero frequencies - cast to a char
                System.out.println("'"+(char)i+"' appeared "+ASCIIarray[i]+((ASCIIarray[i] == 1) ? " time" : " times"));

               //FILL THIS IN:

               //MAKE THE FOREST OF TREES AND ADD THEM TO THE PQ

               //create a new Tree
               //set the cumulative frequency of that Tree
               //insert the letter as the root node
               //add the Tree into the PQ
               Tree myTree= new Tree();
               myTree.frequency=ASCIIarray[i];
               myTree.root= new Node();
               myTree.root.letter = (char)i;
               PQ.add(myTree);

            }
        }


        while(PQ.size()>1)
        {
        	Tree firstTree = PQ.poll();

        	Tree secondTree = PQ.poll();
        	Tree comboTree = new Tree();
        	comboTree.frequency = firstTree.frequency + secondTree.frequency;

        	comboTree.root = new Node();

        	comboTree.root.leftChild = firstTree.root;

        	comboTree.root.rightChild = secondTree.root;

        	PQ.add(comboTree);
        }

		System.out.println("");

        Tree HuffmanTree = PQ.poll();   //one tree remains

        int totalLength=0;

        String theCode = new String("");
        for(int i=0; i<word.length();i++)
        {
        	theCode=HuffmanTree.getCode(word.charAt(i));
        	System.out.print(theCode+" ");

        	totalLength+=theCode.length();

        }
        System.out.println("");
        int num1 = (totalLength);
        int num2 = (word.length()*7);
        double compression = (((double)num1/(double)num2)*100);

        System.out.println("");

        System.out.println("Compressed size is: " +  num1 + " bits / " +  num2  + " bits = " + (int)compression  + "%");

    }


}