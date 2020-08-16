class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1;
        int[] newDigits;
        for(int i=len-1; i>=0; i--){
            int tmp = digits[i] + carry;
            digits[i] = tmp % 10;
            carry = tmp / 10;
        }
        if(carry > 0){
            newDigits = new int[len+1];
            System.arraycopy(digits, 0, newDigits, 1, len);
            newDigits[0] = carry;
            return newDigits;
        }
        else{
            return digits;
        }
    }
}