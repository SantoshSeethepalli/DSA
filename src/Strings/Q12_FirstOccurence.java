package Strings;

public class Q12_FirstOccurence {
    int firstOccurence(String txt, String pat) {
        char[] txtArr = txt.toCharArray();
        char[] patArr = pat.toCharArray();

        int possibleFirstOccurence = -1;
        int txtPointer = 0;

        while(txtPointer < txtArr.length) {
            if(txtArr[txtPointer] == patArr[0]) {
                possibleFirstOccurence = txtPointer;

                for(int i = 0; i < patArr.length; i++) {
                    if(patArr[i] != txtArr[txtPointer + i]) {
                        possibleFirstOccurence = -1;
                        break;
                    }
                }
                if(possibleFirstOccurence != -1) {
                    return possibleFirstOccurence;
                }
            }
            txtPointer++;
        }

        return possibleFirstOccurence;
    }
}
