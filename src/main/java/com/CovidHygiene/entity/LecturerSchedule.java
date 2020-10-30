package com.CovidHygiene.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LecturerSchedule {
    private int classroomNum;
    @Id
    private String lecturerNum;

    public LecturerSchedule() {}

    public LecturerSchedule(Builder builder) {
        this.classroomNum = builder.classroomNum;
        this.lecturerNum = builder.lecturerNum;
    }

    public int getClassroomNum() {
        return classroomNum;
    }

    public String getLecturerNum() {
        return lecturerNum;
    }

   public static class Builder{
       private int classroomNum;
       private String lecturerNum;

       public Builder setClassroomNum(int classroomNum) {
           this.classroomNum = classroomNum;
           return this;
       }

       public Builder setLecturerNum(String lecturerNum) {
           this.lecturerNum = lecturerNum;
           return this;
       }

       public Builder copy(LecturerSchedule schedule){
           this.classroomNum = schedule.classroomNum;
           return this;
       }

       public LecturerSchedule build(){
           return new LecturerSchedule(this);
       }
   }
}
