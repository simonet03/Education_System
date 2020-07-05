package com.CovidHygiene.entity;

public class Student {
    private long studentNum;
    private String firstName, lastName, address;


    private Student(Builder builder){
        this.studentNum = builder.studentNum;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;

    }

    public long getStudentNum() {
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




    //=================================================
    public static class Builder{
        private long studentNum;
        private String firstName, lastName, address;


        public Builder setStudentNum(long studentNum){
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

        public Student build(){
            return new Student(this);
        }

    }
}
