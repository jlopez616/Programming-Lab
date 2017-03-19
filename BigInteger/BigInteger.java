public class BigInteger {

    public static int[] numbers;
    /*public BigInteger() {

    } */

    public BigInteger( String value ) {

        this.numbers = new int[value.length()];
        for (int k = 0; k < value.length(); k++) {
            int intValue = Character.getNumericValue(value.charAt(k));
            numbers[k] = intValue;
        }
    }

    public String toString() {
        String bigNumber = "";
        for (int k = 0; k < this.numbers.length; k++) {
            bigNumber += Integer.toString(numbers[k]);
        }
        return bigNumber;
    }

    public static void main(String args[]) {
        BigInteger bigInt = new BigInteger(args[0]);
        System.out.println(bigInt.toString());

    }

}
