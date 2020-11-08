package com.CovidHygiene.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity

public class Lecturer {

    @Id
    private String lecturerNum;
    private String firstName;
    private String lastName;
    private String address;

    protected  Lecturer(){}

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
        private String lecturerNum;
        private String firstName, lastName, address;

        public Builder setLecturerNum(String id){
            this.lecturerNum = id;
            return this;
        }
        public Builder setFirstName(String name){
            this.firstName = name;
            return this;
        }
        public Builder setLastName(String surname){
            this.lastName = surname;
            return this;
        }
        public Builder setAddress(String addr){
            this.address = addr;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecturer lecturer = (Lecturer) o;
        return lecturerNum.equals(lecturer.lecturerNum) &&
                firstName.equals(lecturer.firstName) &&
                lastName.equals(lecturer.lastName) &&
                address.equals(lecturer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lecturerNum, firstName, lastName, address);
    }
}
