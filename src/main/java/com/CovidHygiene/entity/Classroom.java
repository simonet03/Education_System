/*
    Author:Ethan Petersen(217140807)
    This class contains classroom entity using Builder Pattern
 */

package com.CovidHygiene.entity;

public class Classroom {
    private Boolean booked, sanitizingStation;
    private int classroomNum, numOfSeats;

    private Classroom(Builder builder){
        this.classroomNum = builder.classroomNum;
        this.booked = builder.booked;
        this.numOfSeats = builder.numOfSeats;
        this.sanitizingStation = builder.sanitizingStation;

    }

    public Boolean getBooked() {
        return booked;
    }

    public Boolean getSanitizingStation() {
        return sanitizingStation;
    }

    public int getClassroomNum() {
        return classroomNum;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomNum=" + classroomNum +
                ", booked=" + booked +
                ", numOfSeats=" + numOfSeats +
                ", sanitizingStation=" + sanitizingStation +
                '}';
    }

    public static class Builder{
        private Boolean booked, sanitizingStation;
        private int classroomNum, numOfSeats;

        public Builder setClassroomNum(int classroomNum){
            this.classroomNum = classroomNum;
            return this;
        }

        public Builder setBooked(boolean booked){
            this.booked = booked;
            return this;

        }
        public Builder setNumOfSeats(int numOfSeats){
            this.numOfSeats = numOfSeats;
            return this;
        }

        public Builder setSanitizingStation(boolean sanitizingStation){
            this.sanitizingStation = sanitizingStation;
            return this;
        }

        public Classroom build(){
            return new Classroom(this);
        }

    }
}