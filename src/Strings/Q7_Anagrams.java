package Strings;

import java.util.HashMap;
import java.util.Map;

public class Q7_Anagrams {
    public static boolean areAnagrams(String s1, String s2) {
        Map<Character, Integer> hashMap = new HashMap<>();

        for(char c : s1.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < s2.length(); i++) { // kseeg
            char currentCharacter = s2.charAt(i);
            if(!hashMap.containsKey(currentCharacter)) {
                return false;
            } else {

                hashMap.put(currentCharacter, hashMap.get(currentCharacter) - 1);

                if(hashMap.get(currentCharacter) == 0) {
                    hashMap.remove(currentCharacter);
                }
            }
            System.out.println(hashMap);
        }

        if(hashMap.isEmpty()) {
            return true;
        }
        return false;
    }
}
