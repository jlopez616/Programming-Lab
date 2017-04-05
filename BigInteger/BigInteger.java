public class BigInteger {

    public int[] numbers;
    public boolean isPositive = true;

    public static final BigInteger ZERO = new BigInteger("0");
    public static final BigInteger ONE = new BigInteger("1");
    public static final BigInteger TEN = new BigInteger("10");

    public BigInteger() {
    }

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
            } else {
                throw new IllegalArgumentException();
            }

        }
    }

    public boolean equals( Object x ) {
        if (x.getClass() == this.getClass()) {
            if (x.toString().length() != this.toString().length()) {
                return false;
            } else {
                for (int k = 0; k < x.toString().length(); k++) {
                    if (x.toString().charAt(k) != this.toString().charAt(k)) {
                        return false;
                    }
                }
            }
        return true;
        } else {
            throw new IllegalArgumentException();
        }
    }


    public String toString() {
        String bigNumber = "";
        boolean zeroFilter = true;
        for (int k = 0; k < this.numbers.length; k++) {
            if (numbers[k] > 0) {
                zeroFilter = false;
            }
            if (zeroFilter == false) {
                bigNumber += Integer.toString(numbers[k]);
            }
        }
        if (bigNumber.equals("")) {
            bigNumber = "0";
        }

        if (this.isPositive == false) {
            return "-" + bigNumber;
        } else {
            return bigNumber;
        }
    }

    public boolean greaterThan ( BigInteger val ) {

        if ((this.isPositive == true) && (val.isPositive != true)) {
            return true;
        } else if ((this.isPositive != true) && (val.isPositive == true)) {
            return false;
        } else if ((this.isPositive == true) && (val.isPositive == true)){
            if ((this.toString().length() > val.toString().length())) {
                return true;
            } else if((this.toString().length() < val.toString().length())) {
                return false;
            } else {
                for (int k = 0; k < this.toString().length(); k++) {
                    if (this.toString().charAt(k) > val.toString().charAt(k)) {
                        return true;
                    } else if (this.toString().charAt(k) < val.toString().charAt(k)) {
                        return false;
                    }
                }
                return false;
            }
        } else {
            if ((this.toString().length() < val.toString().length())) {
                return true;
            } else if((this.toString().length() > val.toString().length())) {
                return false;
            } else {
                for (int k = 0; k < this.toString().length(); k++) {
                    if (this.toString().charAt(k) < val.toString().charAt(k)) {
                        return true;
                    } else if (this.toString().charAt(k) > val.toString().charAt(k)) {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean lessThan ( BigInteger val ) {

        if ((this.isPositive == true) && (val.isPositive != true)) {
            return false;
        } else if ((this.isPositive != true) && (val.isPositive == true)) {
            return true;
        } else if ((this.isPositive == true) && (val.isPositive == true)){
            if ((this.toString().length() > val.toString().length())) {
                return false;
            } else if((this.toString().length() < val.toString().length())) {
                return true;
            } else {
                for (int k = 0; k < this.toString().length(); k++) {
                    if (this.toString().charAt(k) > val.toString().charAt(k)) {
                        return false;
                    } else if (this.toString().charAt(k) < val.toString().charAt(k)) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            if ((this.toString().length() < val.toString().length())) {
                return false;
            } else if((this.toString().length() > val.toString().length())) {
                return true;
            } else {
                for (int k = 0; k < this.toString().length(); k++) {
                    if (this.toString().charAt(k) < val.toString().charAt(k)) {
                        return false;
                    } else if (this.toString().charAt(k) > val.toString().charAt(k)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

   public void fillZeroes(BigInteger big) {

       int[] placeHolder = this.numbers;

       this.numbers = new int[big.numbers.length];

       for (int k = 0; k < placeHolder.length; k++) {
           this.numbers[k] = placeHolder[k];
       }
   }

   public BigInteger abs(BigInteger val){

       BigInteger falseThis = new BigInteger(val.toString());
       if (!val.isPositive) {
           BigInteger placeHolder = new BigInteger(val.toString());
           falseThis.numbers = new int[placeHolder.numbers.length - 1];
           for (int k = 0; k < falseThis.numbers.length; k++) {
               falseThis.numbers[k] = placeHolder.numbers[k + 1];
           }
           falseThis.isPositive = true;
           return falseThis;
       } else {
           return val;

       }
   }

   public BigInteger plus(BigInteger val) {
        BigInteger value = new BigInteger(val.toString());

    if (abs(value).greaterThan(abs(this))) {
           BigInteger placeHolder = new BigInteger(this.toString());
           placeHolder.isPositive = this.isPositive;
           this.numbers = value.numbers;
           this.isPositive = value.isPositive;
           value.numbers = placeHolder.numbers;
           value.isPositive = placeHolder.isPositive;
    } else if ((abs(value).equals(abs(this))) && (!this.isPositive)) {
           BigInteger placeHolder = new BigInteger(this.toString());
           placeHolder.isPositive = this.isPositive;
           this.numbers = value.numbers;
           this.isPositive = value.isPositive;
           value.numbers = placeHolder.numbers;
           value.isPositive = placeHolder.isPositive;
}

       if ((this.isPositive == false) && (value.isPositive == false)) {
           return this.addTo(value);
       } else if ((this.isPositive == true) && (value.isPositive == false)) {
           value.isPositive = true;
           return this.subtractFrom(value);
       } else if ((this.isPositive == false) && (value.isPositive == true)) {
           return this.subtractFrom(value);

       } else {
           return this.addTo(value);
       }
   }

    public BigInteger addTo(BigInteger val) {
        BigInteger sum = new BigInteger();

        if ((!this.isPositive) && (!val.isPositive)) {
            sum.isPositive = false;
            this.numbers[0] = 0;
            val.numbers[0] = 0;
        }


        for (int k = 0; k < this.numbers.length / 2; k++) {
            int temp = this.numbers[k];
            this.numbers[k] = this.numbers[this.numbers.length - k - 1];
            this.numbers[this.numbers.length - k - 1] = temp;
        }
        for (int k = 0; k < val.numbers.length / 2; k++) {
            int temp = val.numbers[k];
            val.numbers[k] = val.numbers[val.numbers.length - k - 1];
            val.numbers[val.numbers.length - k - 1] = temp;
        }

        if (abs(this).greaterThan(val)) {
            val.fillZeroes(this);
        } else if (abs(val).greaterThan(this)) {
            this.fillZeroes(val);
        }

        sum.numbers = new int[this.numbers.length + 1];
        int carry;




        for (int k = 0; k < sum.numbers.length - 1; k++) {

            if(val.numbers[k] == -1) {
                val.numbers[k] = 0;
            }

            sum.numbers[k] += (this.numbers[k] + val.numbers[k]);
            if (sum.numbers[k] > 9) {
                carry = sum.numbers[k] / 10;
                sum.numbers[k] = sum.numbers[k] % 10;
                sum.numbers[k + 1] += carry;

            }
        }

        for (int k = 0; k < sum.numbers.length / 2; k++) {
            int temp = sum.numbers[k];
            sum.numbers[k] = sum.numbers[sum.numbers.length - k - 1];
            sum.numbers[sum.numbers.length - k - 1] = temp;
        }

        if (sum == ZERO) {
            return ZERO;
        } else {
            return sum;
        }
    }

    public BigInteger minus(BigInteger val) {

        BigInteger inverse = new BigInteger(val.toString());
        inverse.isPositive = !inverse.isPositive;

        return this.plus(inverse);
    }

    public BigInteger subtractFrom(BigInteger val) {

        BigInteger difference = new BigInteger();

        for (int k = 0; k < this.numbers.length / 2; k++) {
            int temp = this.numbers[k];
            this.numbers[k] = this.numbers[this.numbers.length - k - 1];
            this.numbers[this.numbers.length - k - 1] = temp;
        }
        for (int k = 0; k < val.numbers.length / 2; k++) {
            int temp = val.numbers[k];
            val.numbers[k] = val.numbers[val.numbers.length - k - 1];
            val.numbers[val.numbers.length - k - 1] = temp;
        }

        if (abs(this).greaterThan(val)) {
            val.fillZeroes(this);
        } else if (abs(val).greaterThan(this)) {
            this.fillZeroes(val);
        }

        difference.numbers = new int[this.numbers.length + 1];
        int carry;

        for (int k = 0; k < difference.numbers.length - 1; k++) {

            if(val.numbers[k] == -1) {
                val.numbers[k] = 0;
            }

            if ((this.numbers[k] < val.numbers[k]) && (this.numbers[k] > 0)){
                this.numbers[k] += 10;
                this.numbers[k + 1] -= 1;
                difference.numbers[k] += (this.numbers[k] - val.numbers[k]);
            } else {
                difference.numbers[k] += (this.numbers[k] - val.numbers[k]);
            }
        }

        for (int k = 0; k < difference.numbers.length / 2; k++) {
            int temp = difference.numbers[k];
            difference.numbers[k] = difference.numbers[difference.numbers.length - k - 1];
            difference.numbers[difference.numbers.length - k - 1] = temp;
        }

        if (abs(this).greaterThan(abs(val))) {
            difference.isPositive = this.isPositive;
        }

        if ((difference.numbers[1] == 0) && (difference.numbers[difference.numbers.length - 1] == 0)) {
            return ZERO;
        } else {
            return new BigInteger(difference.toString());
        }
    }

    public boolean isEven () {

        if (this.numbers[this.numbers.length - 1] == 0 || this.numbers[this.numbers.length - 1] == 2
        || this.numbers[this.numbers.length - 1] == 4 || this.numbers[this.numbers.length - 1] == 6 ||
        this.numbers[this.numbers.length - 1] == 8) {
            return true;
        } else {
            return false;
        }
    }


    public BigInteger times (BigInteger val) {
        BigInteger product = new BigInteger();

        if (!this.isPositive && val.isPositive) {
            product.isPositive = false;
        } else if (this.isPositive && !val.isPositive) {
            product.isPositive = false;
        } else {
            product.isPositive = true;
        }

        BigInteger a = new BigInteger(this.toString());
        BigInteger b = abs(val);

        BigInteger temp = new BigInteger();

        while (a.greaterThan(new BigInteger("0"))) {
            if (a.isEven()) {
                a = a.divideBy(new BigInteger("2"));
                b = b.times(new BigInteger("2"));
            } else {
                a = a.minus(new BigInteger("1"));
                temp = b;
            }
        }

        product = temp;

        if (product == new BigInteger("1")) {
            return product;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public BigInteger divideBy( BigInteger val ) {
        BigInteger quotient = new BigInteger();

        if (!this.isPositive && val.isPositive) {
            quotient.isPositive = false;
        } else if (this.isPositive && !val.isPositive) {
            quotient.isPositive = false;
        } else {
            quotient.isPositive = true;
        }
        this.numbers = abs(this).numbers;
        this.isPositive = abs(this).isPositive;
        val = abs(val);

        BigInteger result = new BigInteger("1");
        BigInteger intermediate = val;

        if (val.greaterThan(this)) {
            return new BigInteger("0");
        } else {
            while ( (intermediate.times( new BigInteger("10") ) ).lessThan(this)
            || (intermediate.times( new BigInteger("10") ) ).equals(this)) {
                intermediate = intermediate.times(new BigInteger("10"));
                result = result.times(new BigInteger("10"));
            }
        }
        quotient = (result.plus((this.minus(intermediate)).divideBy(val)));

        if (quotient == new BigInteger("1")) {
            return quotient;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public BigInteger remainder ( BigInteger val) {
        throw new UnsupportedOperationException();
    }

    public static BigInteger valueOf ( long val ) {

        String input =  String.valueOf(val);
        return new BigInteger(input);

      }
}
