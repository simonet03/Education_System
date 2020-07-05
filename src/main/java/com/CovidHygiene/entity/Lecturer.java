package com.CovidHygiene.entity;

public class Lecturer {
    private long lecturerNum;
    private String firstName, lastName, address;

    //    public Lecturer(long lecturerNum, String firstName, String lastName, String address) {
//        this.lecturerNum = lecturerNum;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.address = address;
//    }
    private Lecturer(Builder builder){
        this.lecturerNum = builder.lecturerNum;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
    }

    public long getLecturerNum() {
        return lecturerNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturerNum=" + lecturerNum +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder{
        public long lecturerNum;
        public String firstName, lastName, address;

        public Builder setLecturerNum(long lecturerNum){
            this.lecturerNum = lecturerNum;
            return this;
        }
        public Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder setAddress(String address){
            this.address = address;
            return this;
        }

        public Lecturer build(){
            return new Lecturer(this);
        }
    }
}
