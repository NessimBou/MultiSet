package pobj.tme5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Collections;
import pobj.util.Chrono;

public class WordCount
{
	public static void main (String [] args) throws IOException
	{
		HashMultiSet<String> hash=new HashMultiSet<String>();
		//NaiveMultiSet<String> tab=new NaiveMultiSet<String>();
		Chrono chrono = new Chrono();
		wordcount(hash);
		chrono.stop();
		//Chrono chrono2 = new Chrono();
		//wordcount(tab);
		//chrono2.stop();
		System.out.println(chrono);
		//System.out.println(chrono2);
	}
	
	public static void wordcount(MultiSet<String> ms) throws IOException
	{
		String file = "data/WarAndPeace.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine())!=null) 
		{ 
			for (String word : line.split("\\P{L}+"))
			{ 
				if (word.equals("")) continue;
				ms.add(word);
			}
		}
		br.close();	
		System.out.println(ms.toString());
		//System.out.println("\n");
		//List<String> maliste = ms.elements();
		//System.out.println(maliste);
		//for (int i=0;i<10;i++)
		//{
		//	System.out.println(maliste.get(i));
		//}	
	}
	
}
