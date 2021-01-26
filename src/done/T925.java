package done;

public class T925 {
	public boolean isLongPressedName(String name, String typed) {
		int i = 0, j = 0;
		
		while (j < typed.length()) {
			if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
				i++;
				j++;
			} else if (j > 0 && typed.charAt(j - 1) == typed.charAt(j)) {
				j++;
			} else {
				return false;
			}
		}
		
		return i == name.length();
    }


	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
