package done;

public class T977 {
	//˫ָ�뷨
    public static int[] sortedSquares(int[] A) {
    	int lenA = A.length;
    	int posIndex = -1;
    	//ȷ���������ֽ�
    	for(int i = 0; i < lenA; i++) {
    		if (A[i] >= 0) {
    			posIndex = i;
    			break;
    		}
    		
    		//��������������ָ��ָ��ĩβ
    		posIndex = lenA;
    	}
    	
    	int[] result = new int[lenA];
    	int resIndex = 0;
    	int posPoint = posIndex, negPoint = posIndex - 1;
    	//˫ָ����������ָ�뵽ĩβ���ҷ�����ָ�뵽��ͷʱ ����ѭ��
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
