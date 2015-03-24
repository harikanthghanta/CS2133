package com.kyleriedemann;

import sun.nio.ch.sctp.SctpNet;

import java.util.Scanner;

public class Main {

    //Movement constants
    public static final int LAND = 5;
    public static final int ROTATE_LEFT = 7;
    public static final int ROTATE_RIGHT = 9;
    public static final int MOVE_FOREWARD = 8;
    public static final int MOVE_BACKWARD = 2;
    public static final int MOVE_LEFT = 4;
    public static final int MOVE_RIGHT = 6;

    /*
    A positive linear x number tells the
    robot to move forward, negative means backward. Linear y is the left/right dimension, and linear z
    is the up/down (altitude) dimension. All of these values are in meters/second. A positive angular
    z velocity means rotate to the left, negative means to the right, in radians per second
    +/- 0.25 m/s and your angular speed to +/- 1 radian/s.
     */
    public static void printUsage(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Use the numberpad to move the robot in predefined movements.       ");
        System.out.println("[rotate left 90 degrees] [ move forward ] [rotate right 90 degrees]");
        System.out.println("[      move left       ] [   Land/Exit  ] [       move right      ]");
        System.out.println("[          N/A         ] [ move backward] [          N/A          ]");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Enter the desired number followed by the enter key:");
    }

    public static void main(String[] args) throws InterruptedException{
        RobotInstructor robotInstructor = new RobotInstructor();
        robotInstructor.commandTakeoff();

        printUsage();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            switch (scanner.nextInt()){
                case MOVE_FOREWARD:
                    robotInstructor.commandMoveForeward();
                    break;
                case MOVE_BACKWARD:
                    robotInstructor.commandMoveBackward();
                    break;
                case MOVE_LEFT:
                    robotInstructor.commandMoveLeft();
                    break;
                case MOVE_RIGHT:
                    robotInstructor.commandMoveRight();
                    break;
                case ROTATE_LEFT:
                    robotInstructor.commandRotateLeft();
                    break;
                case ROTATE_RIGHT:
                    robotInstructor.commandRotateRight();
                    break;
                case LAND:
                    robotInstructor.commandLand();
                    break;
                default:
                    System.out.println("Not a movement function, refer to the usage statement");
                    break;
            }
        }

        System.exit(0);
    }
}
