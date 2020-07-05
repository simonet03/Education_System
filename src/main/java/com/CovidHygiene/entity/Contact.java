package com.CovidHygiene.entity;

//Damien Mally - 216279585



public class Contact {
    private long cellPhone, homePhone;
    private String email;


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

        //======returns new Contact=======
        public Contact build(){
            return new Contact(this);
        }
    }
 }
