package pobj.tme5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MultiSetParser 
{
	public static MultiSet<String> parse(String filename) throws InvalidMultiSetFormat
	{
		String file = filename;
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			MultiSet<String> ms=new HashMultiSet<String>();
			while ((line = br.readLine())!=null) 
			{	
				String[] output = line.split(":");
				String e=output[0];
				int count=Integer.decode(output[1]);
				ms.add(e, count);
			}
			br.close();
			return ms;
		}
		catch (FileNotFoundException e)
		{
			throw new InvalidMultiSetFormat("File not found");
		}
		catch (NumberFormatException e2)
		{
			throw new InvalidMultiSetFormat("Number format Exception");
		}
		catch (IOException e3)
		{
			throw new InvalidMultiSetFormat("IO Exception");
		}
	}
}
