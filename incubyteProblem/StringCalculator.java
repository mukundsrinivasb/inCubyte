package comp1110.homework.LoL;

public class StringCalculator {
    public int add(String s) {
        int sum = 0;
        int negInd = 0; //Store the index of The a negative sign and use if to reference the next number
        for (char c : s.toCharArray()) {
            try {
                if (c >= '0' && c <= '9')
                    sum += (int) c - 48;
                else {
                    if (c == '-') {
                        negInd = s.indexOf(c);
                        throw new IllegalArgumentException(); // Throw an Exception
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("negatives not allowed " + s.charAt(negInd+1));
            }
        }
        return sum;
    }

    void pString(String s) {
        for (char c : s.toCharArray()) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        StringCalculator scal = new StringCalculator();
        scal.pString("1;-1;1");
    }

}
