public class StringCalculator {
    public int add(String s) {
        int sum = 0;
        int negInd; //Store the index of The  negative sign and use it to reference the next number
        for (char c : s.toCharArray()) {

            if (c >= '0' && c <= '9')
                sum += (int) c - 48;
            else {
                if (c == '-') {
                    negInd = s.indexOf(c);
                    // Throw an Exception and print the number
                    throw new IllegalArgumentException("negatives not allowed " + s.charAt(negInd + 1));
                }
            }
        }
        return sum;
    }

}
