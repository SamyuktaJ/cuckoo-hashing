import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class CuckooHash {
		
	int n=0,m=0;
	
	int p=0; //p= prime >m
	
	int a1=0,a2=0,b1=0,b2=0;//all primes b/w 0 and p-1
	
	int RehashCount=0;
	
	ArrayList<BigInteger> array = new ArrayList<BigInteger>();
	
	Random generator = new Random(23);
	
	int[] T;
	int Z=0;  //Z is size of actual elements of T
	
	//Constructor
	public CuckooHash(int inputN)
	{
		n = inputN;
		m=6*n; 	//n=nos to be hashed, m= no. of buckets
				//or 4n or 6n?
		
		T = new int[m];
		
		BigInteger pTemp = new BigInteger(String.valueOf(m));
		pTemp = pTemp.nextProbablePrime();
		p = pTemp.intValue();
		
		
		BigInteger d = new BigInteger("0");
				
		while(d.compareTo(pTemp) == -1)
		{
			array.add(d);
			d = d.nextProbablePrime();			
		}
	}
	
	public void Hash()
	{
		/**
		 rand a1,b1,a2,b2; //all between 0 and p-1
		 */
		int length = array.size();
		
		int num = generator.nextInt(length);
		a1 = array.get(num).intValue();
		
		int temp = num;
		
		while(temp == num)
		{
		num = generator.nextInt(length);
		}
		a2 = array.get(num).intValue();
		
		int temp2 = num;
		
		while(temp2 == num || temp == num)
		{
		num = generator.nextInt(length);
		}
		b1 = array.get(num).intValue();
		
		int temp3 = num;
		
		while(temp3 == num || temp2 == num || temp == num)
		{
		num = generator.nextInt(length);
		}
		b2 = array.get(num).intValue();
	}
	
	public int Lookup(int x)
	{
		if(T[h1(x)] == x || T[h2(x)] == x)
			return 1;
		else
			return 0;
	}

	public int Swap(int x, int pos)
	{
		int temp=x;
		x=T[pos];
		T[pos]=temp;
		return x;
	}
	
	public void Rehash()
	{
		RehashCount++;
		System.out.println("Rehash!!");
		Hash();
		int ele=Z+1;
		Z=0;
		int[] tempArray = new int[ele];
		int index = 0;
		
		for(int i = 0; i < m; i++)
		{
			if(T[i] != 0)
			{
				tempArray[index] = T[i];
				T[i]=0;
				index++;
			}
		}
		for(int j = 0; j < ele-1; j++)
		{
			Insert(tempArray[j]);
		}
		
		return;
		
	}
	
	//Compute hash positions
	public int h1(int x)
	{
		//return (((a1*x)+b1)%p)%m;
		return ((a1*x)+b1)%m;
	}
	public int h2(int x)
	{
		//return (((a2*x)+b2)%p)%m;
		return ((a2*x)+b2)%m;
	}
	
	public void Insert(int x)
	{
		int pos=0,loop=0;
		
		if(Lookup(x)==1)
		{
			return;
		}
		else
		{
			pos=h1(x);
			
			while(loop<10)//Arbitrary 4-replace by MaxLoop
			{
				if( T[pos] == 0 )
				{ 
					T[pos]=x;
					Z++;
					return;
				}
				else
				{
					x = Swap(x,pos);
				}
				
				if(pos==h1(x))
				{
					pos=h2(x);
				}
				else
				{
					pos=h1(x);
				}
				loop++;
			}
			Rehash();
			Insert(x);
		}
	}
	
	public void printAll()
	{
		for(int i = 0; i < T.length; i++) 
		{
			if(T[i] != 0)
			{
				System.out.print(T[i]);
				System.out.print("|");
			}	
		}
		System.out.println();
	}
	
	
}
