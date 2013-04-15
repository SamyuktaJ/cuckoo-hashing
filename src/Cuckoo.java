import java.math.BigInteger;
import java.util.ArrayList;


public class Cuckoo {

	private static BigInteger getNextPrime(BigInteger b)
	{
		return b.nextProbablePrime();
	}
	
	public static ArrayList<BigInteger> getNext2Primes(ArrayList<BigInteger> b)
	{
		ArrayList<BigInteger> a = new ArrayList<BigInteger>();
		
		a.add(b.get(1).nextProbablePrime());
		a.add(a.get(0).nextProbablePrime());
		
		return a;
	}
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger b = new BigInteger("500");
		BigInteger c = new BigInteger("503");
		
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		list.add(b);
		list.add(c);
		
		System.out.println(list.get(0) + " and " + list.get(1));
		System.out.println("Then!");
		list = getNext2Primes(list);
		System.out.println(list.get(0) + " and " + list.get(1));
		
		
		

	}

}
