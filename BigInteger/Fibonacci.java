public class Fibonacci {

    public static BigInteger fib( int val ) {
        BigInteger fib = new BigInteger(Integer.toString(val));
        return fib;


    }
    public static void main(String[] args) {

        int degree = Integer.parseInt(args[0]);
        System.out.println(fib(degree).toString());


    }
}
