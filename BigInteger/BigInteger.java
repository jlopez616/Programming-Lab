public class BigInteger {

    public static int numbers;
    public BigInteger() {

    }

    public BigInteger( String value ) {
        this.numbers = Integer.parseInt(value);
    }

    public String toString() {
        return Integer.toString(this.numbers);
    }

    public static void main(String args[]) {
        BigInteger bigInt = new BigInteger(args[0]);
        System.out.println(bigInt.toString());

    }

}
