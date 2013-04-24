import java.math.BigInteger;
import java.util.ArrayList;


public class CuckooHash {
	//ArrayList<BigInteger> T = new ArrayList<BigInteger>();
	
	//BigInteger a1=new BigInteger("0");
	//BigInteger a2=new BigInteger("0");
	//BigInteger b1=new BigInteger("0");
	//BigInteger b2=new BigInteger("0");
	
	int n=0,m=0;
	
	int p=0; //p= prime >m
	
	int a1=0,a2=0,b1=0,b2=0;//all primes b/w 0 and p-1
	
	/**
	 * @param args
	 */
	
	//Constructor
	CuckooHash(int n)
	{
		m=2*n; //n=nos to be hashed, m= no. of buckets
		//or 4n or 6n?		
	}
	
	public void Hash()
	{
		/**
		 rand p //such that p>m
		 rand a1,b1,a2,b2; //all between 0 and p-1
		 */
	}
	
	public int Lookup(int x)
	{
		//if(T[h1(x)]==x || T[h2(x)]==x)
			return 0;
		//else
			//return 1;
	}

	public void Swap(int x, int pos)
	{
		int y=x;
		//x=T[pos];
		//T[pos]=y;
	}
	
	public void Rehash()
	{
		//A NewList=all elements from T
		int Z=0;//Z is size of actual elements of T
		
		//?Use Hash again or other method for setting a1,a2,b1,b2
		
		for(int i=0;i<Z;i++)
		{
			//insert(A(Z));
		}
		
	}
	
	//Compute hash positions
	public int h1(int x)
	{
		return (((a1*x)+b1)%p)%m;
	}
	public int h2(int x)
	{
		return (((a2*x)+b2)%p)%m;
	}
	
	public void Insert(int x)
	{
		int pos=0,loop=0;
		if(Lookup(x)==0)
			return;
		else
		{
			pos=h1(x);
			while(loop<4)//Arbitrary 4-replace by MaxLoop
			{
				//if(T[pos]=="\0")
				//{ T[pos]=x;
				//	return;}
				//else
				//swap(x,pos);
				
				/**
				if(pos==h1(x))
					pos=h2(x);
				else
					pos=h1(x);
				 */
			}
			Rehash();
			Insert(x);
		}
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//PUT main in another class
		//Take user input of size-N
		//Create Object of CuckooHash "CH" say
		//CuckooHash CH=new CuckooHash(N);

		//CH.Hash();
		//CH.Insert(); different set o values
		
	}

}
