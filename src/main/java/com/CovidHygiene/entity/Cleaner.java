package com.CovidHygiene.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
public class Cleaner implements Serializable {

    @Id
    private long cleanerNum;
    private String firstName;
    private String lastName;
    private String address;

    protected Cleaner(){

    }

    public Cleaner(Cleaner.Builder builder){
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
        private long cleanerNum;
        private String firstName, lastName, address;

        public Cleaner.Builder setCleanerNum(long number){
            this.cleanerNum = number;
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

        public Builder copy(Cleaner cleaner) {
            this.cleanerNum = cleaner.cleanerNum;
            return this;
        }
    }

}


