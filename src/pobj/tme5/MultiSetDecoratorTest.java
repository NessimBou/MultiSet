package pobj.tme5;


public class MultiSetDecoratorTest 
{
	public static void main(String[] args)
	{
		@SuppressWarnings("rawtypes")
		HashMultiSet a = new HashMultiSet();
		@SuppressWarnings("unchecked")
		MultiSet<String> b = new MultiSetDecorator<String> (a);
		b.add("Bonjour",100);
		System.out.println(b.toString());
	}
}
