package Strings;

public class Q11_atoi {
    public int myAtoi(String s) {

        int length = s.length();
        int pointer = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                pointer++;
            }
        }

        // FIND sign
        boolean isPositive = true;
        if(s.charAt(pointer) == '-') {
            isPositive = false;
            pointer++;
        }
        else if(s.charAt(pointer) == '+') {
            pointer++;
        }

        long res = 0;

        while(pointer < length && Character.isDigit(s.charAt(pointer))) {

            res = (res * 10) + (s.charAt(pointer) - '0');
            pointer++;

            if(res >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if(res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        // ADD sign
        if(!isPositive) {
            res = -1 * res;
        }

        return (int) res;
    }
}
