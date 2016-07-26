package Labs;
import java.util.Scanner;
/* Program to find next power of 2 to an inputted number
 * This program calculates the next power using purely
 * Bit manipulation.
*/

public class bitShiftPower 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = scan.nextInt();
		scan.close();
		
		n--;
		n = n | n>>1;
		n = n | n>>2;
		n = n | n>>4;
		n = n | n>>8;
		n = n | n>>16;	
		n++;
		System.out.println("Next power of 2: " + n);
	}
}
