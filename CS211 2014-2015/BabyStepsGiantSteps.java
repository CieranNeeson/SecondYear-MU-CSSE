package Labs;

import java.math.BigInteger;

public class BabyStepsGiantSteps
{
	static int important = 292838;
	static BigInteger[] workSpace = new BigInteger[important];
	public static void main(String args[])
	{

		BigInteger p = new BigInteger("24852977");
		BigInteger g = new BigInteger("2744");
		BigInteger y = new BigInteger("8414508");
		BigInteger privateKey = keyFinder(p, g, y);
		
		BigInteger c1 = new BigInteger("15268076");
		BigInteger c2 = new BigInteger("743675");


		BigInteger one = new BigInteger("1");
		BigInteger c1x = c1.modPow(p.subtract(privateKey.add(one)), p);
		System.out.println("c1x is: " + c1x);
		BigInteger message = c2.multiply(c1x);
		message = message.mod(p);
		System.out.println("The private key is: " + privateKey);
		System.out.println("The message is: " + message);
	}


	public static BigInteger keyFinder(BigInteger p, BigInteger g, BigInteger y)
	{
		BigInteger m = new BigInteger("" + important);
		BigInteger[] bigIntArray = new BigInteger[important];
		int k = 0;
		workSpace = new BigInteger[important];
		BigInteger j = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		while(k < important)
		{
			bigIntArray[k] = g.modPow(j, p);
			k ++;
			j = j.add(one);
		}

		BigInteger[] copy = new BigInteger[important];
		for(int z = 0; z < bigIntArray.length; z ++)
		{
			copy[z] = bigIntArray[z];
		}
		bigIntArray = mergeSort(bigIntArray, 0, bigIntArray.length - 1);
		bigIntArray = reverse(bigIntArray);


		// Key is the private key, which I shall now find
		BigInteger key = new BigInteger("0");
		// In the notes you need c, which is defined as c = g^-m mod p
		BigInteger c = (g.modPow(m.negate(), p));
		// You also need t, which is just y
		BigInteger t = y;


		//power of i and bigIntArray
		for(int i = 0; i < important; i ++)
		{
			// If we find t in the sorted bigIntArray array
			if(recFind(bigIntArray, t, 0, bigIntArray.length - 1) != -1)
			{
				// Then we find the power of j used in that value by searching the copy of the original array, whatever index it finds it as will be the power of j
				for(int find = 0; find < copy.length; find ++)
				{
					// So if it finds it it then uses these values to work out x
					if(copy[find].equals(t))
					{

						// x = m.i + j
						BigInteger part1 = new BigInteger("" + i);
						BigInteger part2 = new BigInteger("" + find);
						key =(m.multiply(part1)).add(part2);
						// Then we need to break out of this nested loop
						break;
					}

				}
				// And break again to get out of it's parent
				break;
			}
			else
			{
				// If the value for t wasn't in the array, redefine it and search again
				// When you redefine t it will be t = t.c mod p
				t = (t.multiply(c)).mod(p);
			}
		}
		// Found that shit!
		return key;
	}

	public static BigInteger[] mergeSort(BigInteger[] array, int left, int right) {
		int mid = (left + right) / 2; // computes midpoint
		if (left == right)
			return null;
		mergeSort(array, left, mid);
		mergeSort(array, mid + 1, right);
		for (int i = left; i <= right; i++)
			workSpace[i] = array[i];
		int i1 = left;
		int i2 = mid + 1;
		
		for (int curr = left; curr <= right; curr++) { // merge workspace
			if (i1 > mid) {
				array[curr] = workSpace[i2++];
			} else if (i2 > right) {
				array[curr] = workSpace[i1++];
			} else if (workSpace[i1].compareTo(workSpace[i2]) < 0) {
				array[curr] = workSpace[i1++];
			} else {
				array[curr] = workSpace[i2++];
			}
		}
		return array;
	}
	public static BigInteger[] reverse(BigInteger[] array) {
		BigInteger[] temp = new BigInteger[array.length];

		for (int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}
		int reversing = 0;

		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = temp[reversing];
			reversing++;
		}
		return array;
	}
	public static int recFind(BigInteger[] array, BigInteger searchKey,
			int lowerBound, int upperBound) {

		int middle = (lowerBound + upperBound) / 2;

		if (array[middle].compareTo(searchKey) == 0)
			return middle;
		else if (lowerBound > upperBound)
			return -1;
		else 
		{
			// divide range
			if (array[middle].compareTo(searchKey) > 0)
			{
				return recFind(array, searchKey, middle + 1, upperBound);
			}
			else
			{
				return recFind(array, searchKey, lowerBound, middle - 1);
			}
		}
	}
}