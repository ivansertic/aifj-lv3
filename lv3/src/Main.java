
public class Main {

    private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static char[] numbers = "0123456789".toCharArray();
    private static char[] operators = "+=".toCharArray();
    private static char terminating = ';';
    private static char varStart = '$';

    private static char[] ex1 = "$i=1;$j=2;$kt=$i+$j;".toCharArray(); //one char variables and numbers | 14 and valid
    private static char[] ex2 = "$marica1=29;$ivica2=40;".toCharArray(); //multiple char variables and numbers | 8 and valid
    private static char[] ex3 = "$marica*1=29;".toCharArray(); //invalid because *
    private static char[] ex4 = "kristijan=1;".toCharArray(); //invalid because alphabet chars without $
    private static char[] ex5 = "123456".toCharArray(); //1 and valid
    private static char[] ex6 = "$jakodugackoimevarijable;".toCharArray(); //2 and valid
    private static char[] ex7 = "$ivica=2;$x=i;".toCharArray(); //invalid because alphabet char without $
    private static char[] ex8 = "$var;$var2;".toCharArray(); //4 and valid

    public static void main(String[] args) {
        int cnt = 0;
        boolean isValid = true;
        boolean isReadingVariable = false;
        boolean isReadingNumber = false;

        char[] arr = ex8;
        int readHead = 0;
        while (readHead < arr.length) {
            char curr = arr[readHead];

            if (isReadingVariable) {
                if (isInArray(curr, operators) || curr == terminating || curr == varStart) {
                    isReadingVariable = false;
                    cnt+=2;
                } else if (!(isInArray(curr, alphabet) || isInArray(curr, numbers))){
                    isValid = false;
                    break;
                }
            } else if(isReadingNumber){
                if(isInArray(curr, operators) || isInArray(curr, alphabet) || curr == terminating || curr == varStart){
                    isReadingNumber = false;
                    cnt+=2;
                } else if (!(isInArray(curr, alphabet) || isInArray(curr, numbers))){
                    isValid = false;
                    break;
                }
            } else {
                if (curr == varStart) {
                    isReadingVariable = true;
                } else if(isInArray(curr, numbers)){
                    isReadingNumber = true;
                } else if (isInArray(curr, operators) || curr == terminating) {
                    cnt++;
                } else {
                    isValid = false;
                    break;
                }
            }
            readHead++;
        }

        if(isValid && cnt == 0) cnt = 1;
        System.out.println("Count: " + cnt + ", is valid: " + isValid);
    }

    private static boolean isInArray(char c, char[] arr){
        for(char a: arr){
            if(c == a) return true;
        }
        return false;
    }
}