package com.CovidHygiene.entity;

public class Lecturer {
    //private long lecturerNum;
    private String lecturerNum, firstName, lastName, address;


    private Lecturer(Builder builder){
        this.lecturerNum = builder.lecturerNum;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
    }

    public String getLecturerNum() {
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
        public String lecturerNum;
        public String firstName, lastName, address;

        public Builder setLecturerNum(String lecturerNum){
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

        public Builder copy(Lecturer newLecturer){
            this.lecturerNum = newLecturer.lecturerNum;
            this.firstName = newLecturer.firstName;
            this.lastName = newLecturer.lastName;
            this.address = newLecturer.address;
                    return this;
        }

        public Lecturer build(){
            return new Lecturer(this);
        }
    }
}
