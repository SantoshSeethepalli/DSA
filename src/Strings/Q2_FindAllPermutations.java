package Strings;

import java.util.ArrayList;
import java.util.HashSet;

public class Q2_FindAllPermutations {
    private void permutate(HashSet<String> set, String s, StringBuilder current) {
        if(s.isEmpty()) {
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            current.append(c);

            StringBuilder variableForRemovingCharacterFromIndex = new StringBuilder(s);
            variableForRemovingCharacterFromIndex.deleteCharAt(i);
            String temp = variableForRemovingCharacterFromIndex.toString();

            set.add(current.toString());
            permutate(set, temp, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
    public ArrayList<String> findPermutation(String s) {
        HashSet<String> set = new HashSet<>();
        StringBuilder curr = new StringBuilder();

        permutate(set, s, curr);

        return new ArrayList<>(set);
    }
}
