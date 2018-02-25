package pobj.tme4;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMultiSet<T> extends AbstractCollection <T> implements MultiSet<T> 
{
	private HashMap<T,Integer> map;
	private int size;
	
	public HashMultiSet()
	{
		map=new HashMap<T,Integer>();
		size=0;
	}
	
	public HashMultiSet(Collection<T> col)
	{
		map=new HashMap<T,Integer>();
		size=0;
		for (T t : col)
			add(t);
	}
	
	@Override
	public boolean add(T e) 
	{
		return add(e,1);
	}

	@Override
	public boolean add(T e, int count) 
	{
		if (!map.containsKey(e))
			map.put(e,count);
		else
		{
			int value=map.get(e);
			map.put(e,value+count);
		}
		return true;
	}

	@Override
	public boolean remove(Object e) 
	{
		return remove(e,1);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object e, int count) 
	{
		Integer value = map.get(e);
		if (value==null)
			return false;
		value=value-count;
		if (value<=0)
		{
			size=size-value;
			map.put((T) e, null);
			return true;
		}
		else
		{
			size=size-value;
			map.put((T) e,value);
			return true;
		}
	}
	
	@Override
	public int count(T o) 
	{
		return map.get(o);
	}

	@Override
	public void clear() {
		size=0;
		map.clear();
	}

	@Override
	public int size() {
		return size();
	}
	
	@Override
	public Iterator<T> iterator() {
		return new HashMultiSetIterator(map);
	}
	
	public class HashMultiSetIterator implements Iterator<T>
	{	
		private Iterator<Map.Entry<T, Integer>> listit;
		private Map.Entry<T, Integer> courant;
		private int cpt = 0;
		
		public HashMultiSetIterator (HashMap<T, Integer> list)
		{
			listit=list.entrySet().iterator();
			courant=listit.next();
		}
		
		@Override
		public boolean hasNext() 
		{
			int compte=this.courant.getValue();
			if (cpt<compte)
				return true;
			else
				return listit.hasNext();
		}

		@Override
		public T next()
		{
			int compte=this.courant.getValue();
			if (cpt<compte)
			{
				cpt++;
				return courant.getKey();
			}
			else
			{
				cpt=1;
				courant=listit.next();
				return courant.getKey();
			}
		}
	}

	@Override
	public java.util.List<T> elements() {
		// TODO Auto-generated method stub
		return null;
	}
}
