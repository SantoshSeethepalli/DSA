package Arrays;

public class Q21_Last_Index_of_1 {
    public int lastIndex(String s) {
        int oneIndex = -1;

        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '1') {
                oneIndex = i;
                break;
            }
        }

        return oneIndex;
    }
}
