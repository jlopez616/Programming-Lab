public class ClockSolver {
    public Clock clock;
    public static final double ANGLECHANGE = 5.5 / 60;
    public double currentAngle = 0;
    public double adjacentAngle = 0;

    public ClockSolver() {
        this.clock = new Clock();
    }

    public ClockSolver( double timeSlice ) {
        this.clock = new Clock(timeSlice);
    }


    public void getAngles( double degree ) {
        double difference;
        while (clock.getHours() <= 12 /*Clock.MAXHOURS ? */) {
            clock.tick();
        //    System.out.println("Minute: " +  clock.getMinutes());
        //    System.out.println("Hour: " +  clock.getHours());
           difference = ANGLECHANGE * clock.getTimeSlice();
           this.currentAngle += difference;
           if (this.currentAngle > 360) {
               this.currentAngle = this.currentAngle - 360;
           }
           this.adjacentAngle = 360 - this.currentAngle;
        /*    if (clock.getSeconds() < 0) {
                this.currentAngle = this.currentAngle + (clock.getSeconds() * this.ANGLECHANGE);
            }
        */

          // this.currentAngle = this.currentAngle + (clock.getSeconds() * this.ANGLECHANGE);
            //System.out.println(currentAngle);

            if ((degree - (difference / 2) < this.currentAngle) && (this.currentAngle <  degree + (difference / 2))
                    || (degree - (difference / 2) < this.adjacentAngle) && (this.adjacentAngle <  degree + (difference / 2))) {
                System.out.println(clock.toString());
            }
        }
    }

    public static void main(String args[]) {
        try {
            double degree = Double.parseDouble(args[0]);
            double timeSlice;
            ClockSolver clockSolver;
            if (args.length == 1) {
                clockSolver = new ClockSolver();
            } else {
                timeSlice = Double.parseDouble(args[1]);
                if ((timeSlice > 0) && (timeSlice < 1800)) {
                    clockSolver = new ClockSolver(timeSlice);
                } else {
                    throw new IllegalArgumentException();
                }
            }

            if (degree < 0) {
                throw new IllegalArgumentException();
            } else if (degree > 360) {
                throw new IllegalArgumentException();
            } else {
                clockSolver.getAngles(degree);
            }
        }
        catch (Exception e) {
            System.out.println("Usage instructions: java Clocksolver <angle in degrees> <(optional)timeslice in seconds must be greater than 0 and less than 1800>");
        }
    }
}
