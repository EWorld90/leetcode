package done;

public class T844 {
	//ջ�㷨
	//˫ָ���㷨 �����˸������ָ������
	public static boolean backspaceCompare(String S, String T) {
		int pointS = S.length() - 1, pointT = T.length() - 1;
		int skipS = 0, skipT = 0;
		
		while (pointS >= 0 || pointT >= 0) {
			while (pointS >= 0) {
				if (S.charAt(pointS) == '#') {	//�˸�� ָ������
					pointS--;
					skipS++;
				} else if (skipS > 0) {			//�˸������������ ָ������
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
		// TODO �Զ����ɵķ������

	}

}
