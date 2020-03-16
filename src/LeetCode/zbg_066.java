package LeetCode;

import java.util.Arrays;

//数组加1
public class zbg_066 {
    public static void main(String[] args) {
        int [] digits = {9,9,9,9};
        zbg_66 text = new zbg_66();
        int[] res = text.plusOne(digits);
        System.out.println(Arrays.toString(res));
    }
}

class zbg_66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
