
public class Main {

    private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
    private static char[] operators = "+=".toCharArray();
    private static char terminating = ';';
    private static char varStart = '$';

    private static char[] ex1 = "$i=1;$j=2;$kt=$i+$j;".toCharArray();

    public static void main(String[] args) {
        int cnt = 0;
        boolean isValid = true;
        int readHead = 0;
        boolean isReadingVariable = false;

        while (readHead < ex1.length) {
            char currentChar = ex1[readHead];

            if (isReadingVariable) {
                if (isInArray(currentChar, operators) || currentChar == terminating || currentChar == varStart) {
                    isReadingVariable = false;
                    cnt+=2;
                }
            } else {
                if (currentChar == varStart) {
                    isReadingVariable = true;
                } else if (isInArray(currentChar, alphabet) || isInArray(currentChar, operators) || currentChar == terminating) {
                    cnt++;
                } else {
                    isValid = false;
                }
            }
            readHead++;
        }

        System.out.println("Count: " + cnt + ", is valid: " + isValid);
    }

    private static boolean isInArray(char c, char[] arr){
        for(char a: arr){
            if(c == a) return true;
        }
        return false;
    }
}