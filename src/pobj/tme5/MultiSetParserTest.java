package pobj.tme5;

public class MultiSetParserTest {

	public static void main(String[] args) throws InvalidMultiSetFormat
	{
		//MultiSetParser msp = new MultiSetParser();
		HashMultiSet <String> a = new HashMultiSet<String> ();
		MultiSet <String> b = (MultiSet <String>) a;
		b = MultiSetParser.parse("monfichier");
		b= (HashMultiSet <String>) b;
		System.out.println(b.toString());
	}
}
