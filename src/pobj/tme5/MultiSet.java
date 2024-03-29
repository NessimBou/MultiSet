package pobj.tme5;

import java.util.List;
import java.util.Collection;

public interface MultiSet<T> extends Iterable<T>,Collection<T>{
	public boolean add(T e, int count);
	public boolean add(T e);
	public boolean remove(Object e);
	public boolean remove(Object e, int count);
	public int count(T o);
	public void clear();	
	public int size();
	public List<T> elements();
}
