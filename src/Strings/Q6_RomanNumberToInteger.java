package Strings;

import java.util.Map;
import java.util.HashMap;

public class Q6_RomanNumberToInteger {
    public int romanToDecimal(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int length = s.length();

        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int res = hashMap.get(s.charAt(length - 1));

        for(int i = 0; i < length - 1; i++) {
            int currentValue = hashMap.get(s.charAt(i));
            int nextValue = hashMap.get(s.charAt(i + 1));

            if(currentValue < nextValue) {
                res -= currentValue;
            } else {
                res += currentValue;
            }
        }

        return res;
    }
}
