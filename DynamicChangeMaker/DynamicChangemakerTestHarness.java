public class DynamicChangemakerTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_USA();
        test_Euros();
        test_SwissFrancs();
        test_Keckels(); // 7,3,29,15,53 (Made-up currency with non-standard denominations)



        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void test_Keckels() {
        int[] keckelDenominations = new int[] { 7, 3, 29, 15, 53 };

        Tuple result = DynamicChangemaker.makeChangeWithDynamicProgramming(keckelDenominations, 99);

        System.out.println("Testing Keckel Denominations, 99 cents...");

        try {
            displaySuccessIfTrue(2 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        keckelDenominations = new int[] {3, 7, 15, 29, 53 };

        result = DynamicChangemaker.makeChangeWithDynamicProgramming(keckelDenominations, 99);

        System.out.println("Testing Keckel Denominations, 99 cents (but the denominations are in numerical order)...");

        try {
            displaySuccessIfTrue(1 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }


        try {
            displaySuccessIfTrue(1 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        keckelDenominations = new int[] { 7, 3, 29, 15, 53 };
        result = DynamicChangemaker.makeChangeWithDynamicProgramming(keckelDenominations, 29);
        System.out.println("Testing Keckel Denominations, 29 cents...");

        try {
            displaySuccessIfTrue(0 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void test_SwissFrancs() {
        int[] sFDenominations = new int[] { 5, 10, 20, 50 };

        Tuple result = DynamicChangemaker.makeChangeWithDynamicProgramming(sFDenominations, 95);

        System.out.println("Testing Swiss Franc Denominations, 95 cents...");

        try {
            displaySuccessIfTrue(1 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

       System.out.println("Testing Swiss Franc Denominations, 2 cents....");
       result = DynamicChangemaker.makeChangeWithDynamicProgramming(sFDenominations, 2);
       try {
           displaySuccessIfTrue(result.isImpossible());
       } catch (Exception e) {
           e.printStackTrace();
           displayFailure();
       }
    }

    public static void test_Euros() {
        int[] euroDenominations = new int[] { 1, 2, 5, 10, 20, 50 };

        Tuple result = DynamicChangemaker.makeChangeWithDynamicProgramming(euroDenominations, 99);

        System.out.println("Testing Euro Denominations, 99 cents...");

        try {
            displaySuccessIfTrue(0 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        result = DynamicChangemaker.makeChangeWithDynamicProgramming(euroDenominations, 5243);
        System.out.println("Testing Euro Denominations, 5,243 cents...");

        try {
            displaySuccessIfTrue(1 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        try {
            displaySuccessIfTrue(1 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(104 == result.getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }


    }

    public static void test_USA() {
        int[] usaDenominations = new int[] { 25, 10, 5, 1 };

        Tuple result = DynamicChangemaker.makeChangeWithDynamicProgramming(usaDenominations, 99);
        System.out.println("Testing USA Denominations, 99 cents...");

        try {
            displaySuccessIfTrue(3 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(4 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        System.out.println("Testing USA Denominations, 99 cents (but the denominations are mixed up)...");

        usaDenominations = new int[] { 10, 25, 1, 5 };
        result = DynamicChangemaker.makeChangeWithDynamicProgramming(usaDenominations, 99);

        try {
            displaySuccessIfTrue(2 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(3 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(4 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        usaDenominations = new int[] { 25, 10, 5, 1 };
        result = DynamicChangemaker.makeChangeWithDynamicProgramming(usaDenominations, 5216);
        System.out.println("Testing USA Denominations, 5,216 cents...");

        try {
            displaySuccessIfTrue(208 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }


    }

}
