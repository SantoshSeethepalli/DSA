package StacksAndQueues;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Q8_First_non_Repeating_Character_in_a_SubString {

    public String FirstNonRepeating(String s) {

        Queue<Character> firstUniqueCharacterInTheSubStringQueue = new LinkedList<>();
        HashSet<Character> hashSet = new HashSet<>();

        StringBuilder result = new StringBuilder();

        char uniqueCharacter = s.charAt(0);
        firstUniqueCharacterInTheSubStringQueue.add(uniqueCharacter);

        hashSet.add(uniqueCharacter);
        result.append(uniqueCharacter);

        for(int i = 1; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);

            if(!firstUniqueCharacterInTheSubStringQueue.isEmpty()) {
                if (currentCharacter == firstUniqueCharacterInTheSubStringQueue.peek()) {

                    firstUniqueCharacterInTheSubStringQueue.poll();

                } else if (!hashSet.contains(currentCharacter)) {

                    firstUniqueCharacterInTheSubStringQueue.add(currentCharacter);
                    hashSet.add(currentCharacter);
                }
            } else {
                result.append('#');
                continue;
            }

            result.append(firstUniqueCharacterInTheSubStringQueue.peek());
        }

        return result.toString();
    }

/*

aba

a b

a a
 */










    public String BruteForceFirstNonRepeating(String s) {

        char firstUniqueCharacterInTheSubString = s.charAt(0);
        boolean isFirstUniqueCharacterInTheSubStringUnique = true;

        StringBuilder result = new StringBuilder();
        result.append(firstUniqueCharacterInTheSubString);

        for(int i = 1; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);

            if(currentCharacter == firstUniqueCharacterInTheSubString) {

                isFirstUniqueCharacterInTheSubStringUnique = false;
                result.append('#');

            } else if(!isFirstUniqueCharacterInTheSubStringUnique) {

                firstUniqueCharacterInTheSubString = currentCharacter;

                isFirstUniqueCharacterInTheSubStringUnique = true;

                result.append(currentCharacter);

            } else {
                result.append(firstUniqueCharacterInTheSubString);
            }
        }

        return result.toString();
    }
}
