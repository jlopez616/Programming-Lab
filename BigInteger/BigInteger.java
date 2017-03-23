public class BigInteger {

    public int[] numbers;
    public boolean isPositive = true;
    /*public BigInteger() {

    } */

    public static final BigInteger ZERO = new BigInteger("0");
    public static final BigInteger ONE = new BigInteger("1");
    public static final BigInteger TEN = new BigInteger("10");

    public BigInteger( String value ) {

        value = value.trim();
        this.numbers = new int[value.length()];
        int intValue;
        for (int k = 0; k < value.length(); k++) {
            if (value.charAt(0) == '-') {
                this.isPositive = false;
            }
            intValue = Character.getNumericValue(value.charAt(k));
            if (intValue <= 9) {
                numbers[k] = intValue;
                //System.out.println(intValue);
            } else {
                throw new IllegalArgumentException();
            }

        }
    }

    public boolean equals( Object x ) {
        boolean isSame = true;
        if (x.toString().length() != this.toString().length()) {
            isSame = false;
        } else {
            for (int k = 0; k < x.toString().length(); k++) {
                if (x.toString().charAt(k) != this.toString().charAt(k)) {
                    isSame = false;
                }
            }
        }

        return isSame;
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

        if (this.isPositive == false) {
            return "-" + bigNumber;
        } else {
            return bigNumber;
        }
    }

    public BigInteger plus(BigInteger val) {
        for (int k = 0; k < this.numbers.length / 2; k++) {
            int temp = this.numbers[k];
            this.numbers[k] = this.numbers[this.numbers.length - k - 1];
            this.numbers[this.numbers.length - k - 1] = temp;
        }
        for (int k = 0; k < val.length / 2; k++) {
            int temp = val.numbers[k];
            val.numbers[k] = val.numbers[val.numbers.length - k - 1];
            val.numbers[val.numbers.length - k - 1] = temp;
        }

        int[] sum = new int[];
    }



    public static void main(String args[]) {
        BigInteger bigInt = new BigInteger(args[0]);
        System.out.println(bigInt.toString());

    }

}
