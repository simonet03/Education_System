package com.CovidHygiene.service.impl;

import com.CovidHygiene.entity.Schedule;
import com.CovidHygiene.factory.ScheduleFactory;
import com.CovidHygiene.service.user.ScheduleService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScheduleServiceImplTest {

    private static ScheduleService service = ScheduleServiceImpl.getService();
    private static Schedule schedule = ScheduleFactory.buildSchedule(30, LocalTime.of(10,30),LocalTime.of(16,30),true,false);

    @Test
    public void a_create() {
        Schedule created = service.create(schedule);
        assertEquals(schedule.getClassroomNum(), created.getClassroomNum());
    }

    @Test
    public void b_read() {
        Schedule read = service.read(schedule.getClassroomNum());
        assertEquals(schedule.getClassroomNum(), read.getClassroomNum());
    }

    @Test
    public void c_update() {
        Schedule updated = new Schedule.ScheduleBuilder().copy(schedule).
                setBookedForTeach(false).build();

        updated = service.update(updated);
        assertEquals(schedule.getClassroomNum(), updated.getClassroomNum());
    }

    @Test
    public void e_delete() {
        service.delete(schedule.getClassroomNum());
        assertNull(service.read(schedule.getClassroomNum()));
    }

    @Test
    public void d_getAll() {
        List<Schedule> schedules = service.getAll();
        assertEquals(1, schedules.size());
    }

}
