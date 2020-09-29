package com.CovidHygiene.entity;

//Damien Mally - 216279585

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {

    private String studentNum, firstName, lastName, address;

    //constructor created for springboot
private Student(){}

    private Student(Builder builder){
        this.studentNum = builder.studentNum;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;

    }

    public String getStudentNum() {
        return studentNum;
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
        return "Student{" +
                "studentNum=" + studentNum +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentNum, student.studentNum) &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNum, firstName, lastName, address);
    }





    //=================================================
    public static class Builder{
        private String studentNum, firstName, lastName, address;


        public Builder setStudentNum(String studentNum){
            this.studentNum = studentNum;
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


        //==============copy method=================
        public Builder copy(Student newStudent){
            this.studentNum = newStudent.studentNum;
            this.firstName = newStudent.firstName;
            this.lastName = newStudent.lastName;
            this.address = newStudent.address;
            return this;
        }

        public Student build(){
            return new Student(this);
        }

    }
}
