package Labs;
import java.math.BigInteger;
import java.util.Hashtable;
import java.util.NoSuchElementException;

public class keyBreaker
{
	static final BigInteger ONE=new BigInteger("1");
	
	public static void main(String args[])
	{
		BigInteger a = new BigInteger("24852977");
		BigInteger b = new BigInteger("2744");
		BigInteger c = new BigInteger("8414508");
		
		BigInteger key = BabyStep(b,c,a);
		System.out.println("Private Key: " + key);
		
		BigInteger C1 = new BigInteger("15268076");
		BigInteger C2 = new BigInteger("743675");
		
		BigInteger c1x = C1.modPow(a.subtract(key.add(ONE)), a);
		BigInteger message = C2.multiply(c1x);
		message = message.mod(a);
		System.out.println("Message: " + message);
	}

	//Wikipedia's algorithm for Baby Steps Giant Steps
	public static BigInteger BabyStep(BigInteger base, BigInteger residue, BigInteger modulus) 
	{
	      BigInteger modRoot = new BigInteger("292839"); //root of modulus rounded up
	      
	      Hashtable myTable=new Hashtable();
	      BigInteger basePow=BigInteger.valueOf(1);

	      for (BigInteger j=BigInteger.valueOf(0);j.compareTo(modRoot)<0;j=j.add(ONE)) 
	      {
	         myTable.put(basePow,j);
	         basePow=basePow.multiply(base).mod(modulus);
	      }

	      BigInteger basetotheminv=base.modPow(modRoot,modulus).modInverse(modulus);
	      BigInteger y=new BigInteger(residue.toByteArray());

	      BigInteger target;
	      for (BigInteger i=BigInteger.valueOf(0);i.compareTo(modRoot)<0;i=i.add(ONE)) 
	      {
	         target = (BigInteger)myTable.get(y);
	         if (target!=null) 
	         {
	        	 return i.multiply(modRoot).add(target);
	         }
	         y=y.multiply(basetotheminv).mod(modulus);
	      }
	      throw new NoSuchElementException("No solution");
	   }
}