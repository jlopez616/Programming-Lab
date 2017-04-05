public class Fibonacci {

    public static BigInteger fib( int val ) {
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");

        for (int i = 3; i <= val; i++) {
            BigInteger c = a.plus( new BigInteger(b.toString()) );
            a = b;
            b = c;
        }

        if (val == 0) {
            return BigInteger.ZERO;
        } else {
            return b;
        }
    }
    public static void main(String[] args) {
        try {
            int degree = Integer.parseInt(args[0]);
            if (degree < 0) {
                throw new Exception();
            } else {
                System.out.println(fib(degree).toString());
            }
        }
        catch (Exception e) {
            System.out.println("Usage instructions: 'java Fibonacci <insert integer greater than or equal to zero>'");
        }
    }
}
