public class ReplaceOddWords {
    public static void main(String[] args) {
        int numOfArgs = args.length;
        for (int i = 0; i < numOfArgs; i++) {
            if (isOdd(i)) {
                args[i] = "and";
            }
            System.out.print(args[i] + " ");
        }
    }
    public static boolean isOdd(int input) {
        return input % 2 == 1;
    }
}
