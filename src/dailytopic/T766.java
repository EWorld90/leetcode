package dailytopic;

public class T766 {
	public boolean isToeplitzMatrix(int[][] matrix) {
		
		//每个元素都跟其右下角元素相等即符合题意
        for (int i = 0; i < matrix.length - 1; ++i) {
            for (int j = 0; j < matrix[0].length - 1; ++j) {
                if (matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
            }
        }
        return true;
    }
}
