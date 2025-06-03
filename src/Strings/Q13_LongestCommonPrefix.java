package Strings;

public class Q13_LongestCommonPrefix {
    // |g|e|ek
    // |g|e|ss
    // |g|e|ng
    // iterate and compare each character
    public String longestCommonPrefix(String[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        StringBuilder res = new StringBuilder();

        int prefixPointer = 0;
        char current = arr[0].charAt(prefixPointer);

        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (current != arr[j].charAt(prefixPointer)) {
                    return res.toString();
                }
            }
            res.append(current);
            prefixPointer++;
            current = arr[0].charAt(prefixPointer);
        }

        return res.toString();
    }
}
