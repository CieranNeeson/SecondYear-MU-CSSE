package Labs;
import java.util.Random;
public class RandomTriangle 
{
	private static int count = 0;
	public static void main(String[] args)
	{
		int test = 100000;
		for(int i = 0; i<test; i++)
		{
			randomTriangle(1.0);
		}
		double probability = ((double) count / (double) test);
		System.out.println(probability);
	}
	public static void randomTriangle(double stick)
	{
			double first = new Random().nextDouble();
			double side = stick*first;
			stick = stick - side;
			double second = new Random().nextDouble();
			double thirdside = side*second;
			side -= thirdside;
			//stick = a, side = b, third = c
			if((stick + side > thirdside) && (side + thirdside > stick) && (thirdside + stick > side))
			{
				count++;
			}
	}
}
