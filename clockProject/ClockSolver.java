public class ClockSolver {
    public Clock clock;
    public int currentAngle = 0;

    public ClockSolver() {
        this.clock = new Clock();
    }

    public int clockAngle() {
        int minuteHand = ((clock.getMinutes() / 60 ) * 360);
        int hourHand = ( minuteHand / 12 );

        return minuteHand;
    }

    public void getAngles() {
        while (clock.getHours() <= 12 /*Clock.MAXHOURS ? */ ) {
            clock.tick();
            this.currentAngle = clockAngle();
            if (this.currentAngle == 180) {
                System.out.println(clock.toString());
            }

        }
    }

    public static void main(String args[]) {
        ClockSolver clockSolver = new ClockSolver();
        clockSolver.getAngles();

    }

}
