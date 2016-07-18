package com.codility.sort.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.codility.sort.MaxProductOfTree;

public class MaxProductOfTreeTest {
	private MaxProductOfTree maxSetOfProducts;
	
	@Before
	public void initialize(){
		maxSetOfProducts = new MaxProductOfTree();
	}
	
	@Test
	public void shouldReturn0WhenSizeLess3(){
		int rezult = maxSetOfProducts.find(new int[]{});
		assertEquals(0, rezult);
	}
	
	@Test
	public void shouldReturnNegative6WhenSetContainsNegative312(){
		int rezult = maxSetOfProducts.find(new int[]{-3,1,2});
		assertEquals(-6, rezult);
	}
	
	@Test
	public void shouldReturn12henSetContainsNegative312Negative2(){
		int rezult = maxSetOfProducts.find(new int[]{-3,1,2,-2});
		assertEquals(12, rezult);
	}
	
	@Test
	public void shouldReturn30henSetContainsNegative312Negative25(){
		int rezult = maxSetOfProducts.find(new int[]{-3,1,2,-2,5});
		assertEquals(30, rezult);
	}
	
	@Test
	public void shouldReturn60henSetContainsNegative312Negative256(){
		int rezult = maxSetOfProducts.find(new int[]{-3,1,2,-2,5,6});
		assertEquals(60, rezult);
	}
}
