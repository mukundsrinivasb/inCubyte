public class StringCalculator {
    public int add(String s) {
        int sum = 0;
        int negInd ; //Store the index of The  negative sign and use it to reference the next number
        boolean negFlag = false; //Check the presence of a negative number;
        StringBuilder ErrorMessage = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9')
                sum += (int) c - 48;
            else {
                if (c == '-') {
                    negInd = s.indexOf(c) + 1;
                    ErrorMessage.append("-").append(s.charAt(negInd)).append(",");
                    //Set negFlag to true
                    negFlag = true;
                }
            }
        }
        if (negFlag) {
            // Throw an Exception and print the number
            throw new IllegalArgumentException("negatives not allowed " + ErrorMessage);
        }
        return sum;
    }

}
