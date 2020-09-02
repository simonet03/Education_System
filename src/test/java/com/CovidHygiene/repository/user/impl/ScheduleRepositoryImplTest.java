package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Schedule;
import com.CovidHygiene.factory.ScheduleFactory;
import com.CovidHygiene.repository.user.ScheduleRepository;
import com.CovidHygiene.repository.user.impl.ScheduleRepositoryImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScheduleRepositoryImplTest {

    private static ScheduleRepository repository =
            ScheduleRepositoryImpl.getScheduleRepository();
    private static Schedule schedule= ScheduleFactory.buildSchedule(30, LocalTime.of(10,30),LocalTime.of(16,30),true,false);

    @Test
    public void a_create() {
        Schedule created = repository.create(schedule);
        assertEquals(schedule.getClassroomNum(), created.getClassroomNum());
    }

    @Test
    public void b_read() {
        Schedule read = repository.read(schedule.getClassroomNum());
        assertEquals(schedule.getClassroomNum(), read.getClassroomNum());
    }

    @Test
    public void c_update() {
        Schedule updated = new Schedule.ScheduleBuilder().copy(schedule).
                setBookedForTeach(false).build();

        updated = repository.update(updated);
        assertEquals(schedule.getClassroomNum(), updated.getClassroomNum());
    }

    @Test
    public void e_delete() {
        repository.delete(schedule.getClassroomNum());
        assertNull(repository.read(schedule.getClassroomNum()));
    }

    @Test
    public void d_getAll() {
        List<Schedule> schedules = repository.getAll();
        assertEquals(1, schedules.size());
    }
}
