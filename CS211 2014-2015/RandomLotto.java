package Labs;
import java.util.Random;

public class RandomLotto 
{
	public static void randomLotto(int [] lottoNum)
	{
		Random rnd = new Random();
        for (int i = 0; i < lottoNum.length; i++)
        {
            int index = rnd.nextInt(i + 1);
            // Swap
            int a = lottoNum[index];
            lottoNum[index] = lottoNum[i];
            lottoNum[i] = a;
        }
        
	}
}
