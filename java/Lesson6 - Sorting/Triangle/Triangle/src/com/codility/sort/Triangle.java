package com.codility.sort;

import java.util.Arrays;

public class Triangle {
	
	private static final int MIN_SIZE_OF_SET_PRODUCTS = 3;
	
	public int find(int[] array) {
		if (isSizeLessMin(array))
			return 0;
		array = new SortArray().sort(array);
		
		for (int i=0; i<array.length-2; i++) 
			if (isTriangle(array[i],array[i+1],array[i+2]))
				return 1;
		
		return 0;
	}
	
	private boolean isSizeLessMin(int[] array){
		return array.length<MIN_SIZE_OF_SET_PRODUCTS;
	}
	
	private boolean isTriangle(int firstLine, int secondLine, int thirdLine) {
		if (isMaxValues(firstLine, secondLine, thirdLine)|| isMinValues(firstLine, secondLine, thirdLine))
				return true;
		return firstLine + secondLine > thirdLine;
	}
	
	private boolean isMaxValues(int firstLine, int secondLine, int thirdLine){
		return (firstLine == secondLine) && (firstLine == thirdLine) && (firstLine == Integer.MAX_VALUE);
	}
	
	private boolean isMinValues(int firstLine, int secondLine, int thirdLine){
		return (firstLine == secondLine) && (firstLine == thirdLine) && (firstLine == Integer.MIN_VALUE);
	}
	
	
	private class SortArray {
		
		private int fullSizeOfArray;
		private int lengthOfPart;
		
		public int[] sort(int[] array) {
			setFullSizeOfArray(array.length);
			setLengthOfPart(1);
			
			//while array A is splitted more than on two part
			//recurs(0, getLengthOfPart(), array);
			while (getLengthOfPart() < getFullSizeOfArray()) {
				int startPozFirst = 0;
				int startPozSecond = getLengthOfPart();

				for (int i=0; i<getFullSizeOfArray(); i+=getLengthOfPart()) {
					
					array = sortParts(startPozFirst, startPozSecond, array);
					startPozFirst = startPozSecond + getLengthOfPart();
					startPozSecond = startPozFirst + getLengthOfPart();
					
					if(startPozSecond >= getFullSizeOfArray()){
						break;
					}
				}
				
				increaseLengthOfPart();
			}
			return array;
		}

		private int[] sortParts(int startPozFirst, int startPozSecond, int[] A) {
			int length = getLengthOfPart();
			int[] B = new int[length*2];
			int counter = 0;
			int i = startPozFirst;
			int poz = startPozSecond;
			boolean isEndOfSecondArr = false;
			
			while (i<startPozSecond) {
				//when element form second part more than from first
				if ((A[i] > A[poz]) && (!isEndOfSecondArr)) {
					B[counter] = A[poz];
					if ((poz==(getFullSizeOfArray()-1))){
						isEndOfSecondArr = true;
					}
					if ((poz<(getFullSizeOfArray()-1))) {
						poz++;
					}
					if ((poz==(startPozSecond+length))) {
						isEndOfSecondArr = true;
					}
				} else {
					B[counter] = A[i];
					i++;
				}
				counter++;
			}
			
			int end = countEndPozitionOfSecondPart(startPozSecond);
			//Rest of second part is moving
			if (counter < (length*2)) {
				for (int j=poz; j<end; j++){
					B[counter] = A[j];
					counter++;
				}
			}
			counter=0;
			for(int j=startPozFirst;j<end;j++){
				A[j] = B[counter];
				counter++;
			}
			return A;
		}
		
		private int countEndPozitionOfSecondPart(int startPozSecond) {
			int endPozSecond = startPozSecond  + getLengthOfPart();
			
			if (endPozSecond > fullSizeOfArray) 
				return getFullSizeOfArray();
			
			return  endPozSecond;
		}
		
		private void increaseLengthOfPart(){
			setLengthOfPart(getLengthOfPart()*2);
		}

		public void setFullSizeOfArray(int fullSizeOfArray) {
			this.fullSizeOfArray = fullSizeOfArray;
		}

		public int getFullSizeOfArray() {
			return fullSizeOfArray;
		}

		public void setLengthOfPart(int lengthOfPart) {
			this.lengthOfPart = lengthOfPart;
		}

		public int getLengthOfPart() {
			return lengthOfPart;
		}
	}
}
