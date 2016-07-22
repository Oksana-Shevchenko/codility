package com.codility.sort.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.codility.sort.Triangle;

public class TriangleTest {
	private Triangle triangle;
	
	@Before
	public void initialize() {
		triangle = new Triangle();
	}
	
	@Test
	public void shouldReturn0ForArrayWithSizeLess3 () {
		int rez = triangle.find(new int[] {});
		assertEquals(0, rez);
	}
	
	@Test 
	public void shouldReturn1ForArrayWith3EqualsElements111(){
		int rez = triangle.find(new int[] {1,1,1});
		assertEquals(1, rez);
	}
	
	@Test 
	public void shouldReturn1ForArrayWith3EqualsElements222(){
		int rez = triangle.find(new int[] {2,2,2});
		assertEquals(1, rez);
	}
	
	@Test 
	public void shouldReturn1ForArrayWith3EqualsElementsMAX_INTEGER(){
		int rez = triangle.find(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE});
		assertEquals(1, rez);
	}
	
	@Test 
	public void shouldReturn1ForArrayWith3EqualsElementsMIN_INTEGER(){
		int rez = triangle.find(new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE});
		assertEquals(1, rez);
	}
	
	@Test 
	public void shouldReturn0ForArrayWith3Elements123(){
		int rez = triangle.find(new int[] {1,2,3});
		assertEquals(0, rez);
	}
	
	@Test 
	public void shouldReturn0ForArrayWith3Elements321(){
		int rez = triangle.find(new int[] {3,2,1});
		assertEquals(0, rez);
	}

	@Test 
	public void shouldReturn0ForArrayWith4Elements105051(){
		int rez = triangle.find(new int[] {10,50,5,1});
		assertEquals(0, rez);
	}

	@Test 
	public void shouldReturn1ForArrayWith6Elements10251820(){
		int rez = triangle.find(new int[] {10,2,5,1,8,20});
		assertEquals(1, rez);
	}
}
