public class Fibonacci {

    public static BigInteger fib( int val ) {
        BigInteger fib = new BigInteger(Integer.toString(val));
        fib = fib.plus( new BigInteger(fib.toString()) );
        return fib;


    }
    public static void main(String[] args) {

        int degree = Integer.parseInt(args[0]);
        System.out.println(fib(degree).toString());


    }
}
