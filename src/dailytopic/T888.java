package dailytopic;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class T888 {
	
	@Test
	public void test() {
		int[] A = {1, 2};
		int[] B = {2, 3};
		
		assertEquals(fairCandySwap(A, B)[0], 1);
	}
	
	/*
	 * 设A需要交换的糖果为x，b为y
	 * sumA - x + y = sumB + x - y
	 * x = y + (sumA - sumB) / 2
	 */
	public int[] fairCandySwap(int[] A, int[] B) {
		int[] res = new int[2];
		
		int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int middleSum = (sumA - sumB) / 2;
        
        Set<Integer> mapA = new HashSet<Integer>();
        for(int a : A) {
        	mapA.add(a);
        }
        
        for(int b : B) {
        	if(mapA.contains(b + middleSum)) {
        		res[0] = b + middleSum;
        		res[1] = b;
        		break;
        	}
        }
		
		return res;
    }
	
}
