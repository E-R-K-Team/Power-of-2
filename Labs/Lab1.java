package com.company;

import java.util.Scanner;

public class Lab1 {

    private static final byte MAX_DOTS_COUNT = 100;
    private static final short MAX_COORDINATE = 1000;
    private static final short MIN_COORDINATE = -1000;

    public static void main(String[] args) {
        System.out.println("This program calculates the radius of circle , which contains all dots .");
        System.out.print("Insert dots count (from 1 to "+MAX_DOTS_COUNT+" ): ");
        boolean isIncorrect;
        Scanner scanner = new Scanner(System.in);
        byte dotsCount=0;
        do {
            if (scanner.hasNextByte()) {
                dotsCount = scanner.nextByte();
                if (dotsCount < 1 || dotsCount > MAX_DOTS_COUNT) {
                    System.out.print("Value must be from 1 to " + MAX_DOTS_COUNT + " .");
                    isIncorrect = true;
                } else {
                    isIncorrect = false;
                }
            } else {
                System.out.print("Value must be a number from 1 to " + MAX_DOTS_COUNT + " .");
                scanner.next();
                isIncorrect = true;
            }
        } while (isIncorrect);
        float[] yCoordinates = new float[dotsCount];
        float[] xCoordinates = new float[dotsCount];
        float coordinate= 0;
        System.out.println("Insert coordinates (from "+MIN_COORDINATE+" to "+ MAX_COORDINATE+ " ): ");
        for(int i = 0; i<dotsCount;i++){
            System.out.print("Insert y coordinate : ");
            do {
                if (scanner.hasNextFloat()) {
                    coordinate = scanner.nextFloat();
                    if (coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE) {
                        System.out.print("Value must be from "+MIN_COORDINATE+ " to " + MAX_COORDINATE + " .");
                        isIncorrect = true;
                    } else {
                        isIncorrect = false;
                    }
                } else {
                    System.out.print("Value must be a number from "+MIN_COORDINATE+ " to " + MAX_COORDINATE + " .");
                    scanner.next();
                    isIncorrect = true;
                }
            } while (isIncorrect);
            yCoordinates[i]=coordinate;
            System.out.print("Insert x coordinate : ");
            do {
                if (scanner.hasNextFloat()) {
                    coordinate = scanner.nextFloat();
                    if (coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE) {
                        System.out.print("Value must be from "+MIN_COORDINATE+ " to " + MAX_COORDINATE + " .");
                        isIncorrect = true;
                    } else {
                        isIncorrect = false;
                    }
                } else {
                    System.out.print("Value must be a number from "+MIN_COORDINATE+ " to " + MAX_COORDINATE + " .");
                    scanner.next();
                    isIncorrect = true;
                }
            } while (isIncorrect);
            xCoordinates[i]=coordinate;
        }
        scanner.close();
        float radius = 0;
        float currentDistance;
        for(int i = 0; i<dotsCount;i++){
            currentDistance= (float) Math.sqrt(Math.pow(yCoordinates[i],2)+Math.pow(xCoordinates[i],2));
            if(currentDistance>radius){
                radius=currentDistance;
            }
        }
        System.out.println("Radius is "+radius+" .");

    }
}
