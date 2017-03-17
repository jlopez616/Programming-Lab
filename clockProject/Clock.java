public class Clock  {
    public double secondsPassed;
    public int minutesPassed;
    public int hoursPassed;
    public double forwardBySeconds;
    public static final int DEFAULT_TIMESLICE = 60;
    public static final int MAXHOURS = 12;

    public Clock() {
        this.secondsPassed = 0;
        this.minutesPassed = 0;
        this.hoursPassed = 0;
        this.forwardBySeconds = DEFAULT_TIMESLICE;
    }

    public Clock(double timeSlice) {
        this.secondsPassed = 0;
        this.minutesPassed = 0;
        this.hoursPassed = 0;
        this.forwardBySeconds = timeSlice;
    }

    public String toString() {
        return this.hoursPassed + ":" + this.minutesPassed + ":" + this.secondsPassed;
    }

    public int getHours() {
        return this.hoursPassed;
    }

    public int getMinutes() {
        return this.minutesPassed;
    }

    public double getSeconds() {
        return this.secondsPassed;
    }

    public double getTimeSlice() {
        return forwardBySeconds;
    }

    public void tick() {

        this.secondsPassed += this.forwardBySeconds;

        if (getSeconds() >= 60) {
            this.minutesPassed += getSeconds() / 60;
            this.secondsPassed = getSeconds() % 60;
                if (getMinutes() >= 60) {
                    this.hoursPassed += getMinutes() / 60;
                    this.minutesPassed = getMinutes() % 60;
                }
        }
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            Clock clock = new Clock();
        } else {
            Clock clock = new Clock(Double.parseDouble(args[0]));
        }
    }
}
