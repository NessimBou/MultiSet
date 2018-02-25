package pobj.tme4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class NaiveMultiSet<T> extends AbstractCollection <T> implements MultiSet<T>
{
	private ArrayList <String> mytab;

	@Override
	public boolean add(T e, int count) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object e, int count) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> elements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
