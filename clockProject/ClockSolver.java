public class ClockSolver {
    public Clock clock;
    public static final double ANGLECHANGE = 5.5 / 60;
    public double currentAngle = 0;

    public ClockSolver() {
        this.clock = new Clock();
    }


    public void getAngles() {
        while (clock.getHours() < 12 /*Clock.MAXHOURS ? */) {
            clock.tick();
            System.out.println("Minute: " +  clock.getMinutes());
            System.out.println("Hour: " +  clock.getHours());

            this.currentAngle = (5.5 * clock.getMinutes());
            if (clock.getSeconds() < 0) {
                this.currentAngle = this.currentAngle + (clock.getSeconds() * this.ANGLECHANGE);
            }
            System.out.println(currentAngle);
        /*    if (this.currentAngle == 180) {
                System.out.println(clock.toString());
            }
       */
        }
    }

    public static void main(String args[]) {
        ClockSolver clockSolver = new ClockSolver();
        clockSolver.getAngles();

    }

}
