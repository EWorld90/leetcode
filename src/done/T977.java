package done;

public class T977 {
	//双指针法
    public static int[] sortedSquares(int[] A) {
    	int lenA = A.length;
    	int posIndex = -1;
    	//确认正负数分界
    	for(int i = 0; i < lenA; i++) {
    		if (A[i] >= 0) {
    			posIndex = i;
    			break;
    		}
    		
    		//无正数，将正数指针指向末尾
    		posIndex = lenA;
    	}
    	
    	int[] result = new int[lenA];
    	int resIndex = 0;
    	int posPoint = posIndex, negPoint = posIndex - 1;
    	//双指针排序，正数指针到末尾并且非正数指针到开头时 结束循环
    	while(posPoint < lenA || negPoint >= 0) {
    		if (posPoint == lenA) {
    			result[resIndex] = A[negPoint] * A[negPoint];
    			negPoint--;
    		} else if (negPoint < 0) {
    			result[resIndex] = A[posPoint] * A[posPoint];
    			posPoint++;
    		} else if (A[negPoint] * A[negPoint] < A[posPoint] * A[posPoint]) {
    			result[resIndex] = A[negPoint] * A[negPoint];
    			negPoint--;
    		} else {
    			result[resIndex] = A[posPoint] * A[posPoint];
    			posPoint++;
    		}
    		
    		resIndex++;
    	}
    	
		return result;
    }
    

	public static void main(String[] args) {
		int[] a = {-112, -87, -23, -11, -4};
		
		int[] result = sortedSquares(a);
		
		for(int i : result) {
			System.out.print(i + " ");
		}

	}

}
