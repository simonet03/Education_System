package com.CovidHygiene.entity;

public class Admin {
    private String adminNum, firstName, lastName, address;

    public Admin(){

    }

    private Admin(Builder builder){
        this.adminNum = builder.adminNum;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
    }

    public String getAdminNum() {
        return adminNum;
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
        return "Admin{" +
                "adminNum='" + adminNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private String adminNum, firstName, lastName, address;


        public Builder setAdminNum(String adminNum) {
            this.adminNum = adminNum;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }

        public Builder copy(Admin admin) {
            this.adminNum = admin.adminNum;
            this.firstName = admin.firstName;
            this.lastName = admin.lastName;
            this.address = admin.address;
            return this;
        }
    }
}
