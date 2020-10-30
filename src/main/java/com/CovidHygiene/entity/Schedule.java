package com.CovidHygiene.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Schedule {
    @Id
    private int classroomNum;
    private LocalDate dayPicked;
    private LocalTime statTime;
    private LocalTime endTime;
    private boolean bookedForTeach;
    private boolean bookedForSanti;

    protected Schedule(){}

    protected Schedule(ScheduleBuilder scheduleBuilder){
        this.classroomNum = scheduleBuilder.classroomNum;
        this.dayPicked = scheduleBuilder.dayPicked;
        this.statTime = scheduleBuilder.statTime;
        this.endTime = scheduleBuilder.endTime;
        this.bookedForSanti = scheduleBuilder.bookedForSanti;
        this.bookedForTeach = scheduleBuilder.bookedForTeach;
    }

    public int getClassroomNum() {
        return classroomNum;
    }

    public LocalDate getDayPicked() {
        return dayPicked;
    }

    public LocalTime getStatTime() {
        return statTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean isBookedForTeach() {
        return bookedForTeach;
    }

    public boolean isBookedForSanti() {
        return bookedForSanti;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "classroomNum=" + classroomNum +
                ", dayPicked=" + dayPicked +
                ", statTime=" + statTime +
                ", endTime=" + endTime +
                ", bookedForTeach=" + bookedForTeach +
                ", bookedForSanti=" + bookedForSanti +
                '}';
    }

    public static class ScheduleBuilder{
        private int classroomNum;
        private LocalDate dayPicked;
        private LocalTime statTime;
        private LocalTime endTime;
        private boolean bookedForTeach;
        private boolean bookedForSanti;

        public ScheduleBuilder setClassroomNum(int classroomNum) {
            this.classroomNum = classroomNum;
            return this;
        }

        public ScheduleBuilder setDayPicked(LocalDate dayPicked) {
            this.dayPicked = dayPicked;
            return this;
        }

        public ScheduleBuilder setStatTime(LocalTime statTime) {
            this.statTime = statTime;
            return this;
        }

        public ScheduleBuilder setEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public ScheduleBuilder setBookedForTeach(boolean bookedForTeach) {
            this.bookedForTeach = bookedForTeach;
            return this;
        }

        public ScheduleBuilder setBookedForSanti(boolean bookedForSanti) {
            this.bookedForSanti = bookedForSanti;
            return this;
        }

        public ScheduleBuilder copy(Schedule schedule){
            this.classroomNum = schedule.classroomNum;
            this.dayPicked = schedule.dayPicked;
            this.statTime = schedule.statTime;
            this.endTime = schedule.endTime;
            this.bookedForSanti = schedule.bookedForSanti;
            this.bookedForTeach = schedule.bookedForTeach;
            return this;
        }

        public Schedule build(){
            return new Schedule(this);
        }
    }

}
