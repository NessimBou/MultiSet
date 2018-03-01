package pobj.tme5.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pobj.tme5.HashMultiSet;
import pobj.tme5.MultiSet;
import static org.junit.Assert.*;

public class HashMultiSetTest2 
{
	private HashMultiSet<String> m;
	
	@Before
	public void before() 
	{
		m = new HashMultiSet<String>();
	}
	@Test 
	public void testRemove()
	{
		m.add("toto",5);
		m.remove("toto");
		assertEquals(4, m.count("toto"));
		assertEquals(4,m.size());
	}
	@Test
	public void testSize()
	{
		m.add("toto",5);
		assertEquals(5, m.size());
	}
	@Test
	public void testtoString()
	{
		m.add("toto",1);
		m.add("tata",1);
		assertEquals("[toto:1; tata:1]",m.toString());
	}
	@Test
	public void testclear()
	{
		m.add("toto",5);
		m.clear();
		assertEquals(0,m.size());
	}
	@Test
	public void testSeq()
	{
		m.add("toto",5);
		m.add("tata",4);
		assertEquals(9,m.size());
		m.remove("toto");
		assertEquals(8,m.size());
	}
	@Test
	public void cas1()
	{
		m.add("toto",0);
		assertEquals(0,m.size());
		m.remove("tata",0);
		assertEquals(0,m.size());
	}
	@Test
	public void cas2()
	{
		m.add("toto",5);
		m.remove("toto",5);
		assertEquals(0,m.size());
	}
	@Test
	public void cas3()
	{
		m.add("toto",5);
		m.remove("titi",2);
		assertEquals(5,m.size());
	}
	
}

