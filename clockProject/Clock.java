public class Clock  {
    public double secondsPassed;
    public int minutesPassed;
    public int hoursPassed;
    public double forwardBySeconds; //similar in purpose
    public static final int DEFAULT_TIMESLICE = 60; //similar in purpose
    public static final int MAXHOURS = 12;

    public Clock(){
        this.secondsPassed = 0;
        this.minutesPassed = 0;
        this.hoursPassed = 0;
        this.forwardBySeconds = DEFAULT_TIMESLICE;

    }

    public Clock(double timeSlice){
        this.secondsPassed = 0;
        this.minutesPassed = 0;
        this.hoursPassed = 0;
        this.forwardBySeconds = timeSlice;

    }

    public String toString(){
        return this.hoursPassed + ":" + this.minutesPassed + ":" + this.secondsPassed;

    }


    public int getHours(){


    return this.hoursPassed;

    /*    int hours = 0;
        int minutes = 0;
        int seconds = 0;
        while ((seconds < secondsPassed) || (minutes < minutesPassed) || (hours < hoursPassed)) {
            seconds++;
            while (seconds > timeSlice) {
                seconds = 0;
                minutes++;
                while (minutes > timeSlice) {
                    hours++;
                    minutes = 0;
                    seconds = 0;
                    }
                }
            }
        return hours;
        */


    }



    public int getMinutes(){

        return this.minutesPassed;

        /* int minutes = 0;
        int seconds = 0;
        while ((seconds < secondsPassed) || (minutes < minutesPassed)){
            seconds++;
            while (seconds > timeSlice) {
                seconds = 0;
                minutes++;
                }
            }
        return minutes;
        */

    }

    public double getSeconds(){

        return this.secondsPassed;
/*
        int seconds = 0;
        while (seconds < secondsPassed){
            seconds++;
        } */

    }

    public void tick(long tickBy){

        //we go forward by the timeSlice

        //adding the timeslice to the timepassed
        //then clean up
        return;
    }

    public static void main(String args[]) {
        Clock clock = new Clock();
        System.out.println(clock.toString());
    }
}
