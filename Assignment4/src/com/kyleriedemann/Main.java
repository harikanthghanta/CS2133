package com.kyleriedemann;

public class Main {

    /*
    A positive linear x number tells the
    robot to move forward, negative means backward. Linear y is the left/right dimension, and linear z
    is the up/down (altitude) dimension. All of these values are in meters/second. A positive angular
    z velocity means rotate to the left, negative means to the right, in radians per second
    +/- 0.25 m/s and your angular speed to +/- 1 radian/s.
     */
    public static void printUsage(){
        System.out.println("Enter coordinates for movement as follows");
        System.out.println("[forward/backwards movement] [strafe left/right] [acend/decend] [rotation degrees]");
        System.out.println("Note: movement is limited to +/- 0.25 m/s and rotation is limited to +/- 1 radian/s");
        System.out.println("      values are expected as whole numbers 0-25 for movement, and 0-100 for rotation");
    }

    public static void main(String[] args) throws InterruptedException{
        RobotInstructor robotInstructor = new RobotInstructor();
        //robotInstructor.createSocket();
        if(robotInstructor.commandTakeoff() == 1) {
            System.out.println("takeoff");
        }
        Thread.sleep(10000);
        if(robotInstructor.commandLand() == 1){
            System.out.println("land");
        }
        System.exit(0);
    }
}
