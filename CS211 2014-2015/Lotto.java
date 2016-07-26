package Labs;

public class Lotto 
{
	private static int count = 0;
	public static void main(String[] args)
	{
	int test = 100000;
	int [][] testLotto = new int [test][6];
	
	for(int i = 0; i<test; i++)
	{
		testLotto[i] = lottoGenerator();
		
	}
	double probability = 1.0 - ((double)count/(double)test);
	System.out.println("Probability of no consecutive pairs: " + probability);
	}
	
	public static void sort(int[] x)

	{
		boolean swapped = true;
		while(swapped)
		{
			swapped = false;
			for(int i = 1; i<x.length; i++)
			{
				int temp = 0;
				if(x[i-1] > x[i])
				{
					temp = x[i-1];
					x[i-1] = x[i];
					x[i] = temp;
					swapped = true;
				}
			}
		}
	}
	
	public static int[] lottoGenerator()
	{
		int[] lotto = new int [45];
		for(int i = 0; i< lotto.length; i++)
		{
			lotto[i] = i+1;
		}
		RandomLotto.randomLotto(lotto);
		int [] result = new int [6];
		for(int i=0; i<result.length; i++)
		{
			result[i] = lotto[i];
		}
		sort(result);
		for(int i = 1; i<6; i++)
		{
			if(result[i] == (result[i-1] + 1))
			{
				count++;
			}
		}
		return result;
	}
}












