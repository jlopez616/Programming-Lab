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
        int[] keckel_Denominations = new int[] { 7, 3, 29, 15, 53 };

        Tuple result = DynamicChangemaker.makeChangeWithDynamicProgramming(keckel_Denominations, 99);

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
            displaySuccessIfTrue(1 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void test_SwissFrancs() {
        int[] sFDenominations = new int[] { 5, 10, 20, 50 };

        Tuple result = DynamicChangemaker.makeChangeWithDynamicProgramming(sFDenominations, 95);

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
    }

    public static void test_Euros() {
        int[] euroDenominations = new int[] { 1, 2, 5, 10, 20, 50 };

        Tuple result = DynamicChangemaker.makeChangeWithDynamicProgramming(euroDenominations, 99);

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


    }

    public static void test_USA() {
        int[] usaDenominations = new int[] { 25, 10, 5, 1 };

        Tuple result = DynamicChangemaker.makeChangeWithDynamicProgramming(usaDenominations, 99);
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
    }

}
