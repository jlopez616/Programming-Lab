public class ClockSolver {
    public Clock clock;
    public static final double ANGLECHANGE = 5.5 / 60;
    public double currentAngle = 0;

    public ClockSolver() {
        this.clock = new Clock();
    }


    public void getAngles( double degree, double timeSlice) {
        while (clock.getHours() <= 12 /*Clock.MAXHOURS ? */) {
            clock.tick(timeSlice);
        //    System.out.println("Minute: " +  clock.getMinutes());
        //    System.out.println("Hour: " +  clock.getHours());
        /*    this.currentAngle = (5.5 * clock.getMinutes());
            if (clock.getSeconds() < 0) {
                this.currentAngle = this.currentAngle + (clock.getSeconds() * this.ANGLECHANGE);
            }
        */
           this.currentAngle = this.currentAngle + (clock.getSeconds() * this.ANGLECHANGE);
            System.out.println(currentAngle);
            if (this.currentAngle == degree) {
                System.out.println(clock.toString());
            }

        }
    }

    public static void main(String args[]) {
        try {
            double degree = Double.parseDouble(args[0]);
            double timeSlice = Double.parseDouble(args[1]);
            ClockSolver clockSolver = new ClockSolver();
            if (degree > 0) {
                clockSolver.getAngles(degree, timeSlice);
            } else {
                System.out.println("Usage instructions: java Clocksolver <angle in degrees> <(optional)timeslice in seconds>");
            }
        }
        catch (Exception e) {
            System.out.println("Usage instructions: java Clocksolver <angle in degrees> <(optional)timeslice in seconds>");
        }
    }
}
