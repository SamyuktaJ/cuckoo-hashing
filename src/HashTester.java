import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class HashTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException 
	{
		System.out.print("Enter the size of the hash table:  ");
		Scanner input = new Scanner(System.in);
		
		int size = input.nextInt();
		
		CuckooHash CH = new CuckooHash(size);
		CH.Hash();
		
		input = new Scanner(new FileReader("file.txt"));
		
		for(int i = 0; i < size; i++)
		{
			CH.Insert(input.nextInt());
			
		if(i%2 == 0)
			{
				CH.printAll();
		    }
		}
		
		
		CH.printAll();
									
		StandardHash SH=new StandardHash(size);
		SH.Hash();
			
		input = new Scanner(new FileReader("file.txt"));
			
		for(int i = 0; i < size; i++)
			{
				SH.Insert(input.nextInt());
				
			if(i%2 == 0)
				{
					SH.printAll();
			    }
			}
				
			SH.printAll();
	}
}
