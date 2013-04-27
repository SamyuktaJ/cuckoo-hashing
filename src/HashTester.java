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
			startTime = System.currentTimeMillis();
			CH.Insert(input.nextInt());
			endTime = System.currentTimeMillis();
			CHTime=CHTime+(endTime - startTime);
			
			startTime = System.currentTimeMillis();
			SH.Insert(input.nextInt());
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
		
		System.out.print("Time to hash"+n+"values"+"\n Cuckoo Hash:"+CHTime+"\n Standard Hash:"+SHTime);
	}
}
