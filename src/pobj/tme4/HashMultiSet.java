package pobj.tme4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class HashMultiSet<T> implements MultiSet<T>
{
	private HashMap<T,Integer> map;
	private Iterator <T> valeur;
	
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
		T a = (T) e;
		map.remove(a);
		return true;
	}
	
	@Override
	public boolean remove(Object e, int count) 
	{
		int value = map.get(e).intValue();
		value=value-count;
		T a = (T) e;
		map.put(a,value);
		return false;
	}
	
	@Override
	public int count(T o) 
	{
		int value = map.get(o).intValue();
		return value;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public int size() {
		return map.size();
	}
	
	@Override
	public HashMultiSetIterator iterator() {
		Iterator <T> a = valeur;
		return new HashMultiSetIterator(a);
	}
	
	public class HashMultiSetIterator implements Iterator<T>
	{		
		private int nb_occurence;
		private int cpt=0;
		
		public HashMultiSetIterator (Iterator<T> a)
		{
			valeur=a;
			this.nb_occurence=map.get(valeur.next());
			cpt++;
		}
		
		@Override
		public boolean hasNext() 
		{
			return cpt<map.size();
		}

		@Override
		public T next()
		{
			if (nb_occurence>0)
			{
				nb_occurence--;
				return valeur.next();
			}
			else
			{
				valeur.next();
				cpt++;
				nb_occurence=map.get(valeur.next());
				return valeur.next();
			}
		}
	}
}
