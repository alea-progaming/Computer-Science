package permutation;
import java.io.*;

public class Purugganan_Permutation {
    public static void main(String[] args) {
        String str = "ABCDEF";
        int n = str.length();
        Purugganan_Permutation permutation = new Purugganan_Permutation();
        permutation.mutation(str, 0, n - 1);
    }

    

    void mutation(String str, int l, int r) {
        if (l == r) {
            int ind1 = 0, ind2 = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'A')
                    ind1 = i;
            }
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'D')
                    ind2 = i;
            }
            if (ind1 < ind2)
                System.out.println(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swapping(str, l, i);
                mutation(str, l + 1, r);
                str = swapping(str, l, i);
            }
        }
    }
    /*
     * permutation function
     * str string to calculate permutation for
     * l starting index
     * r end index
     /
    /
    * Swap Characters at position
    *  a string value
    *  i position 1
    *  j position 2
    *  swapped string   (RETURN)
    */

    public String swapping(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}