package pobj.tme4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class HashMultiSet<T> implements MultiSet<T>
{
	private HashMap<T,Integer> map;
	
	public HashMultiSet()
	{
		map=new HashMap<T,Integer>();
	}
	
	public HashMultiSet(Collection<T> col)
	{
		map=new HashMap<T,Integer>();
		for (T t : col)
			add(t);
	}
	
	@Override
	public boolean add(T e) 
	{
		int value=1;
		if (!map.containsKey(e))
			map.put(e, value);
		else
			value=map.get(e).intValue()+1;
			map.put(e, value);			
		return true;
	}

	@Override
	public boolean add(T e, int count) 
	{
		map.put(e,count);
		return true;
	}

	@Override
	public boolean remove(Object e) 
	{
		map.remove(e);
		return true;
	}
	
	//à coder
	@Override
	public boolean remove(Object e, int count) 
	{
		return false;
	}
	//à coder
	@Override
	public int count(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public int size() {
		return map.size();
	}
	
	public class HashMultiSetIterator implements Iterator<T>
	{
		private Iterator <T> valeur;				
		private int nb_occurence;
		
		public HashMultiSetIterator (Iterator<T> valeur)
		{
			this.valeur=valeur;
			this.nb_occurence=map.get(valeur.next());
		}
		
		@Override
		public boolean hasNext() 
		{
			return false;
		}

		@Override
		public T next() 
		{
			if (nb_occurence>0)
			{
				nb_occurence--;
				return valeur;
			}
		}
	}
	
	

}
