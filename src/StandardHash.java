import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class StandardHash {
		
	int n=0,m=0;
	
	int p=0; //p= prime >m
	
	int a1=0,b1=0;//all primes b/w 0 and p-1
	
	ArrayList<BigInteger> array = new ArrayList<BigInteger>();
	
	Random generator = new Random(23);
	
	ArrayList<ArrayList<Integer>> T = new ArrayList<ArrayList<Integer>>();
	int Z=0;  //Z is size of actual elements of T
	
	//Constructor
	public StandardHash(int inputN)
	{
		n = inputN;
		m=n; 	//n=nos to be hashed, m= no. of buckets
				//or 4n or 6n?
		
		BigInteger pTemp = new BigInteger(String.valueOf(m));
		pTemp = pTemp.nextProbablePrime();
		p = pTemp.intValue();
		
		
		BigInteger d = new BigInteger("0");
				
		while(d.compareTo(pTemp) == -1)
		{
			array.add(d);
			d = d.nextProbablePrime();			
		}
		
		for(int i = 0; i < m; i++)
		{
			T.add(new ArrayList<Integer>());
		}
	}
	
	public void Hash()
	{
		/**
		 rand a1,b1; //all between 0 and p-1
		 */
		int length = array.size();
		
		int num = generator.nextInt(length);
		a1 = array.get(num).intValue();
		
		int temp = num;
		
		while(temp == num)
		{
		num = generator.nextInt(length);
		}
		b1 = array.get(num).intValue();
	}
	
	public int Lookup(int x)
	{
		if(!T.isEmpty())
		{
			if(T.get(h1(x)).contains(x))
				return 1;
			else
				return 0;
		}
		else
		{
			return 0;
		}
	}

	//Compute hash positions
	public int h1(int x)
	{
		return (((a1*x)+b1)%p)%m;
	}
		
	public void Insert(int x)
	{
		int pos=0;
		
		if(Lookup(x)==1)
		{
			return;
		}
		else
		{
			pos=h1(x);
			T.get(pos).add(x); 			
		}
	}
	
	public void printAll()
	{
		for( ArrayList<Integer> x : T)  
		{
			for(int i = 0; i < x.size(); i++)
			{
				if(x.get(i) != 0)
					{
				System.out.print(x.get(i));
				System.out.print("|");
					}
			}
		}
		System.out.println();
	}
	
	
}
