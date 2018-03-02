package pobj.tme5;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MultiSetDecorator<T> implements MultiSet<T>
{
	private MultiSet<T> decorated;
	
	public MultiSetDecorator(MultiSet<T> decorated)
	{
		this.decorated=decorated;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return decorated.iterator();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return decorated.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return decorated.contains(o);
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return decorated.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return decorated.toArray(a);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return decorated.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return decorated.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return decorated.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return decorated.retainAll(c);
	}

	@Override
	public boolean add(T e, int count) {
		boolean b=decorated.add(e, count);
		assert isConsistent();
		return b;
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return decorated.add(e);
	}

	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		return decorated.remove(e);
	}

	@Override
	public boolean remove(Object e, int count) {
		boolean b= decorated.remove(e, count);
		assert isConsistent();
		return b;
	}

	@Override
	public int count(T o) {
		// TODO Auto-generated method stub
		return decorated.count(o);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		decorated.clear();
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return decorated.size();
	}

	@Override
	public List<T> elements() {
		// TODO Auto-generated method stub
		return decorated.elements();
	}
	
	public boolean isConsistent()
	{
		boolean bool=true;
		int all=0;
		for (int i: decorated.map.values())
		{
			if (i<=0)
				bool=false;
			all=all+i;
		}
		if (all!=this.size())
			bool=false;
		return bool;
	}
	
	
}
