package com.codility.sort;

public class MaxProductOfTree {
	private static final int MIN_SIZE_OF_SET_PRODUCTS=3;

	public int find(int[] products) {
		
		int[] minProducts = new int[]{1, 1};
		int[] maxProducts = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

		if(isSizeLessMin(products))
			return 0;
		
		for (int i=0; i<products.length; i++) {
			maxProducts = findMaxValues(products[i], maxProducts);
			minProducts = findMinNegativeValues(products[i], minProducts);
		}
		
		int maxAvrOfSet =  multiplyElements(maxProducts[0],maxProducts[1], maxProducts[2]);
		int maxAvrOfSetWithNegativeValues = multiplyElements(minProducts[0], minProducts[1] , maxProducts[0]);
		
		return redefineMaxAvr(maxAvrOfSet, maxAvrOfSetWithNegativeValues);
	}
	
	private int[] findMaxValues(int product, int[] maxProducts) {
		
		if (product > maxProducts[0]) {
			maxProducts[2] = maxProducts[1];
			maxProducts[1] = maxProducts[0];
			maxProducts[0] = product;
		} else if(product > maxProducts[1]) {
			maxProducts[2] = maxProducts[1];
			maxProducts[1] = product;
		} else if(product > maxProducts[2]) {
			maxProducts[2] =  product;
		}
		
		return maxProducts;
	}

	private int[] findMinNegativeValues(int product, int[] minProducts) {
		
		if (product < minProducts[0]) {
			minProducts[1] = minProducts[0];
	        minProducts[0] = product;
	    } else if (product < minProducts[1]) {
	    	minProducts[1] = product;
	    }
		return minProducts;
	}
	
	private int multiplyElements(int product1, int product2, int product3) {
		return product1*product2*product3;
	}
	
	private int redefineMaxAvr(int maxAvrOfSet, int maxAvrOfSetWithNegativeValues) {
		
		if (maxAvrOfSetWithNegativeValues > maxAvrOfSet)
			maxAvrOfSet = maxAvrOfSetWithNegativeValues;
		
		return maxAvrOfSet;
	}
	
	private boolean isSizeLessMin(int[] products){
		return products.length<MIN_SIZE_OF_SET_PRODUCTS;
	}
}
