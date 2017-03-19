public class BigInteger {

    public static int[] numbers;
    /*public BigInteger() {

    } */

    public BigInteger( String value ) {

        this.numbers = new int[value.length()];
        for (int k = 0; k < value.length(); k++) {
            int intValue = Character.getNumericValue(value.charAt(k));
            if (intValue <= 9) {
                numbers[k] = intValue;
            } else {
                throw new IllegalArgumentException();
            }

        }
    }


    public String toString() {
        String bigNumber = "";
        Boolean zeroFilter = true;
        for (int k = 0; k < this.numbers.length; k++) {
            if (numbers[k] > 0) {
                zeroFilter = false;
            }
            if (zeroFilter == false) {
                bigNumber += Integer.toString(numbers[k]);
            }
        }
        if ((numbers[0] == 0) && (this.numbers.length == 1)) {
            bigNumber = "0";
        }
        return bigNumber;
    }

    public static void main(String args[]) {
        BigInteger bigInt = new BigInteger(args[0]);
        System.out.println(bigInt.toString());

    }

}
