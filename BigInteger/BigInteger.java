public class BigInteger {

    public int[] numbers;
    public boolean isPositive = true;
    /*public BigInteger() {

    } */

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
                //System.out.println(intValue);
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
            throw new IllegalArgumentException(); //ask about this
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
       System.out.println("Smaller number length:" + this.numbers.length);

       this.numbers = new int[big.numbers.length];
       System.out.println("Smaller number length:" + this.numbers.length);


       for (int k = 0; k < placeHolder.length; k++) {
           this.numbers[k] = placeHolder[k];
       }
   }

   public BigInteger abs(BigInteger val){
      // System.out.print("Before absolute value:" + val.toString());
       BigInteger falseThis = new BigInteger(val.toString());
       if (!val.isPositive) {
           BigInteger placeHolder = new BigInteger(val.toString());
           falseThis.numbers = new int[placeHolder.numbers.length - 1];
           for (int k = 0; k < falseThis.numbers.length; k++) {
               falseThis.numbers[k] = placeHolder.numbers[k + 1];
           }
           falseThis.isPositive = true;
            //System.out.print("After absolute value:" + falseThis.toString());
           return falseThis;
       } else {
           return val;

       }
   }

   public BigInteger plus(BigInteger val) {

        //System.out.println("1. Abs of Inverse: " + val.toString());

        BigInteger value = new BigInteger(val.toString());

    if (abs(value).greaterThan(abs(this))) {
           BigInteger placeHolder = new BigInteger(this.toString());
           placeHolder.isPositive = this.isPositive;
         //  System.out.println("2. Abs of Inverse: " + val.toString());
           this.numbers = value.numbers;
           this.isPositive = value.isPositive;
           //System.out.println(this.toString() + " = This");
           value.numbers = placeHolder.numbers;
           value.isPositive = placeHolder.isPositive;
        //  System.out.println("Option 1: " + this.toString() + " : " + val.toString());
    } else if ((abs(value).equals(abs(this))) && (!this.isPositive)) {
           BigInteger placeHolder = new BigInteger(this.toString());
           placeHolder.isPositive = this.isPositive;
           //System.out.println("Placeholder: " + placeHolder);
           this.numbers = value.numbers;
           this.isPositive = value.isPositive;
           //System.out.println(this.toString() + " = This");
           value.numbers = placeHolder.numbers;
           value.isPositive = placeHolder.isPositive;
    //    System.out.println("Option 2: " + this.toString() + " : " + val.toString());
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
        //System.out.println(this.toString());
        //System.out.println(val.toString());


        BigInteger sum = new BigInteger();

        if ((!this.isPositive) && (!val.isPositive)) {
            sum.isPositive = false;
            //this.isPositive = true;
            this.numbers[0] = 0;
            //val.isPositive = true;
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

        // System.out.println("First:" + this.toString());
        // System.out.println("Second:" + val.toString());




        if (this.numbers.length > val.numbers.length) {
            val.fillZeroes(this);
        } else if (this.numbers.length < val.numbers.length) {
            this.fillZeroes(val);
        }

        sum.numbers = new int[this.numbers.length + 1];
        int carry;




        for (int k = 0; k < sum.numbers.length - 1; k++) {

            if(val.numbers[k] == -1) {
                val.numbers[k] = 0;
            }
            //System.out.println("Top"  + this.numbers[k]);
            //System.out.println("Bottom" + val.numbers[k]);
            sum.numbers[k] += (this.numbers[k] + val.numbers[k]);
            if (sum.numbers[k] > 9) {
                carry = sum.numbers[k] / 10;
                //System.out.println("Carry: " + carry);
                sum.numbers[k] = sum.numbers[k] % 10;
                //System.out.println("Sum: "+ sum.numbers[k]);

                sum.numbers[k + 1] += carry;

            }
            // System.out.println("Sum1: "+ sum.numbers[k]);
            // System.out.println("Sum String:" + sum.toString());

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
        System.out.println("Inverse: " + inverse.toString());

        return this.plus(inverse);



        /* if (abs(val).greaterThan(abs(this))){
            BigInteger placeHolder = new BigInteger(this.toString());
            placeHolder.isPositive = this.isPositive;
            this.numbers = val.numbers;
            this.isPositive = val.isPositive;
            val.numbers = placeHolder.numbers;
            val.isPositive = this.isPositive;
            System.out.println("Minus Option 1: " + this.toString() + " : " + val.toString());
        }  /*else if ((abs(val).equals(abs(this))) && (!this.isPositive)) {
            BigInteger placeHolder = new BigInteger(this.toString());
            placeHolder.isPositive = this.isPositive;
            //System.out.println("Placeholder: " + placeHolder);
            this.numbers = val.numbers;
            this.isPositive = val.isPositive;
            //System.out.println(this.toString() + " = This");
            val.numbers = placeHolder.numbers;
            val.isPositive = placeHolder.isPositive;
         System.out.println("Option 2: " + this.toString() + " : " + val.toString());
 } */

        /*if ((this.isPositive == false) && (val.isPositive == false)) {
            return this.subtractFrom(val);
        } else if ((this.isPositive == true) && (val.isPositive == false)) {
            return this.plus(val);
        } else if ((this.isPositive == false) && (val.isPositive == true)){
            return this.plus(val);
        } else {
            return this.subtractFrom(val);
        } */
        //return this.subtractFrom(val);
    }

    public BigInteger subtractFrom(BigInteger val) {
        //Reverses the array
        BigInteger difference = new BigInteger();



        // System.out.println("Top" + this.toString());
        // System.out.println("Bottom " + val.toString());


        for (int k = 0; k < this.numbers.length / 2; k++) {
            int temp = this.numbers[k];
            this.numbers[k] = this.numbers[this.numbers.length - k - 1];
            this.numbers[this.numbers.length - k - 1] = temp;
            System.out.println("The current number: " + Integer.toString(temp));
        }
        for (int k = 0; k < val.numbers.length / 2; k++) {
            int temp = val.numbers[k];
            val.numbers[k] = val.numbers[val.numbers.length - k - 1];
            val.numbers[val.numbers.length - k - 1] = temp;
            System.out.println("The current number: " + Integer.toString(temp));
        }


        // System.out.println("After zero Top" + this.toString());
        // System.out.println("After zero Bottom " + val.toString());



        if (this.greaterThan(val)) {
            val.fillZeroes(this);
        } else if (val.greaterThan(this)) {
            this.fillZeroes(val);
        }

        System.out.println("After zero Top" + this.toString());
        System.out.println("After zero Bottom " + val.toString());


        difference.numbers = new int[this.numbers.length + 1];
        int carry;

        //  System.out.println(this.toString());
        //  System.out.println(val.toString());
        System.out.println("Top" + this.toString());
        // System.out.println("Bottom " + val.toString());

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

    //    System.out.println(difference.toString());

        for (int k = 0; k < difference.numbers.length / 2; k++) {
            int temp = difference.numbers[k];
            difference.numbers[k] = difference.numbers[difference.numbers.length - k - 1];
            difference.numbers[difference.numbers.length - k - 1] = temp;

        }

        //System.out.println("Difference: "+ difference.numbers[0]);


        if (abs(this).greaterThan(abs(val))) {
            difference.isPositive = this.isPositive;
        }

    /*if (val.greaterThan(this)) {
        difference.isPositive = !this.isPositive;
    } */
        if ((difference.numbers[1] == 0) && (difference.numbers[difference.numbers.length - 1] == 0)) {
        //    System.out.println(difference.numbers[1]);
            //System.out.println(difference.numbers[difference.numbers.length - 1]);
            return ZERO;
        } else {
            System.out.println(difference.isPositive);
            return new BigInteger(difference.toString());
        }
        //return difference;
    }


    public BigInteger times (BigInteger val) {
        BigInteger product = new BigInteger("24");

        if (!this.isPositive && val.isPositive) {
            product.isPositive = false;
        } else if (this.isPositive && !val.isPositive) {
            product.isPositive = false;
        } else {
            product.isPositive = true;
        }

        this.numbers = abs(this).numbers;
        this.isPositive = abs(this).isPositive;
        val = abs(val);


        System.out.println(val.toString());

        return product;



    //    throw new UnsupportedOperationException();

    }

    public BigInteger divideBy( BigInteger val ) {
        BigInteger quotient = new BigInteger("24");

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


        System.out.println(val.toString());

        return quotient;
    }

    public BigInteger remainder ( BigInteger val) {
        throw new UnsupportedOperationException();
    }

    public static BigInteger valueOf ( long val ) {

        String input =  String.valueOf(val);
        return new BigInteger(input);


      }







    public static void main(String args[]) {
        BigInteger bigInt = new BigInteger(args[0]);
        BigInteger test = new BigInteger(args[1]);
        System.out.println(bigInt.minus(test).toString());

    }

}
