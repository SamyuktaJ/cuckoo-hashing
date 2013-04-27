import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class HashTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException 
	{
		long startTime, endTime, CHTime=0, SHTime=0;
		int num;
		System.out.print("Enter the size of the hash table:  ");
		Scanner input = new Scanner(System.in);
		
		int size = input.nextInt();
		
		CuckooHash CH = new CuckooHash(size);
		CH.Hash();
		
		StandardHash SH=new StandardHash(size);
		SH.Hash();
		
		input = new Scanner(new FileReader("file.txt"));
		
		for(int i = 0; i < size; i++)
		{
			num=input.nextInt();
			startTime = System.currentTimeMillis();
			CH.Insert(num);
			endTime = System.currentTimeMillis();
			CHTime=CHTime+(endTime - startTime);
			
			startTime = System.currentTimeMillis();
			SH.Insert(num);
			endTime = System.currentTimeMillis();
			SHTime=SHTime+(endTime - startTime);
			
		if(i%2 == 0)
			{
				CH.printAll();
				SH.printAll();
		    }
		}
				
		CH.printAll();
		SH.printAll();
		
		System.out.println("Time to hash"+size+"values"+"\n Cuckoo Hash:"+CHTime+"\n Standard Hash:"+SHTime);
		System.out.println("Number of Rehashes"+CH.RehashCount);
	}
}
