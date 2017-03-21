public class BigInteger {

    public static int[] numbers;
    public static boolean isPositive = true;
    /*public BigInteger() {

    } */

    public BigInteger( String value ) {

        this.numbers = new int[value.length()];
        int intValue;
        for (int k = 0; k < value.length(); k++) {
            if (value.charAt(k) == '-') {
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
        System.out.println(x.toString().length());
            System.out.println(this.toString().length());
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



    public static void main(String args[]) {
        BigInteger bigInt = new BigInteger(args[0]);
        System.out.println(bigInt.toString());

    }

}
