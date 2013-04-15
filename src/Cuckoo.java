import java.math.BigInteger;


public class Cuckoo {

	public static BigInteger getNextPrime(BigInteger b)
	{
		return b.nextProbablePrime();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger b = new BigInteger("500");
		BigInteger c = new BigInteger("500");
		
		for( int i = 0; i < 10; i++)
		{
		c = getNextPrime(c);
		System.out.println(b);
		c = c.add(c.subtract(b));
		b = c;
		}

	}

}
