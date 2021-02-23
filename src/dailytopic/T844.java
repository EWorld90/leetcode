package dailytopic;

public class T844 {
	//栈算法
	//双指针算法 遇到退格符则让指针跳过
	public static boolean backspaceCompare(String S, String T) {
		int pointS = S.length() - 1, pointT = T.length() - 1;
		int skipS = 0, skipT = 0;
		
		while (pointS >= 0 || pointT >= 0) {
			while (pointS >= 0) {
				if (S.charAt(pointS) == '#') {	//退格符 指针跳过
					pointS--;
					skipS++;
				} else if (skipS > 0) {			//退格计数器大于零 指针跳过
					skipS--;
					pointS--;
				} else {
					break;
				}
			}
			while (pointT >= 0) {
				if (T.charAt(pointT) == '#') {
					pointT--;
					skipT++;
				} else if (skipT > 0) {
					skipT--;
					pointT--;
				} else {
					break;
				}
			}
			
			if (pointS >= 0 && pointT >= 0) {
				if (S.charAt(pointS) != T.charAt(pointT)) {
					return false;
				}
			} else if (pointS >= 0 || pointT >= 0) {
                return false;
            }
			
			pointS--;
			pointT--;
		}
		
		return true;
    }

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
