package com.CovidHygiene.entity;

public class Cleaner {
    private long cleanerNum;
    private String firstName;
    private String lastName;
    private String address;

    private Cleaner(Cleaner.Builder builder){
        this.cleanerNum = builder.cleanerNum;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
    }

    public long getCleanerNum() {
        return cleanerNum;
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
        return "Cleaner{" +
                "cleanerNum=" + cleanerNum +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder{
        public long cleanerNum;
        private String firstName, lastName, address;

        public Cleaner.Builder setCleanerNum(long CleanerNum){
            this.cleanerNum = cleanerNum;
            return this;
        }

        public Cleaner.Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Cleaner.Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Cleaner.Builder setAddress(String address){
            this.address = address;
            return this;
        }

        public Cleaner build(){
            return new Cleaner(this);
        }

    }

}


