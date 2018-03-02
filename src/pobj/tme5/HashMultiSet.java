package pobj.tme5;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	public boolean add(T e) throws IllegalArgumentException
	{
		return add(e,1);
	}

	@Override
	public boolean add(T e, int count) throws IllegalArgumentException
	{
		if (!map.containsKey(e))
		{
			map.put(e,count);
		}
		else
		{
			int value=map.get(e);
			map.put(e,value+count);
		}
		size=size+count;
		//assert isConsistent();
		return true;
	}

	@Override
	public boolean remove(Object e) throws IllegalArgumentException
	{
		return remove(e,1);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object e, int count) throws IllegalArgumentException
	{
		Integer value = map.get(e);
		if (value==null)
			return false;
		value=value-count;
		if (value<=0)
		{
			size=size-count;
			map.put((T) e, null);
			//assert isConsistent();
			return true;
		}
		else
		{
			size=size-count;
			map.put((T) e,value);
			//assert isConsistent();
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
		return size;
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
		
		public HashMultiSetIterator (HashMap<T,Integer>list)
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
	public List<T> elements() 
	{
		Set<T> a = new HashSet<T>(this);
		List <T> liste= new ArrayList<T>(a);	
		Collections.sort(liste, Collections.reverseOrder((x,y) -> map.get(x).compareTo(map.get(y))));
		//System.out.println(liste);
		return liste;
	}
	
	public String toString()
	{
		StringBuilder b =new StringBuilder();
		b.append("[");
		for (T e: map.keySet())
		{
			b.append(e+":"+map.get(e)+"; ");
		}
		b.delete(b.length()-2, b.length());

		b.append("]");
		return b.toString();
	}
	
//	public boolean isConsistent()
//	{
//		boolean bool=true;
//		int all=0;
//		for (int i: map.values())
//		{
//			if (i<=0)
//				bool=false;
//			all=all+i;
//		}
//		if (all!=this.size())
//			bool=false;
//		return bool;
//	}
}
