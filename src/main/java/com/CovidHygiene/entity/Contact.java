package com.CovidHygiene.entity;

//Damien Mally - 216279585


import java.io.Serializable;
import java.util.Objects;

public class Contact implements Serializable {
    private long cellPhone, homePhone;
    private String email;


    private Contact(){}

    private Contact(Builder builder){
        this.cellPhone = builder.cellPhone;
        this.homePhone = builder.homePhone;
        this.email = builder.email;
    }

    public long getCellPhone() {
        return cellPhone;
    }

    public long getHomePhone() {
        return homePhone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "cellPhone=" + cellPhone +
                ", homePhone=" + homePhone +
                ", email='" + email + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return cellPhone == contact.cellPhone &&
                homePhone == contact.homePhone &&
                Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellPhone, homePhone, email);
    }

    //===========Builder class==============
    //===========Same variables=============
    public static class Builder{
        private long cellPhone, homePhone;
        private String email;

        //=======setters============
        public Builder setCellPhone(long cellPhone){
            this.cellPhone = cellPhone;
            return this;
        }

        public Builder setHomePhone(long homePhone){
            this.homePhone = homePhone;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        //===============copy method===================
        public Builder copy(Contact newContact) {
            this.cellPhone = newContact.cellPhone;
            this.homePhone = newContact.homePhone;
            this.email = newContact.email;

            return this;
        }


        //======returns new Contact=======
        public Contact build(){
            return new Contact(this);
        }
    }
 }
