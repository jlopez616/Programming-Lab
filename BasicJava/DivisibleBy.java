public class DivisibleBy {

    public static void main(String[] args) {
        try {
            int argsOne = Integer.parseInt(args[0]);
            int argsTwo = Integer.parseInt(args[1]);
            if (argsOne % argsTwo == 0){
                System.out.println(argsOne + " is divisible by " + argsTwo);
            } else {
                System.out.println(argsOne + " is not divisible by " + argsTwo);
            }
        }
        catch (NumberFormatException nfe) {
            System.out.println("Please only insert integers!");
        }
        catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("No argument provided!");
        }
        catch (Exception e) {
            System.out.println("Exception occured!");
        }
    }
}
