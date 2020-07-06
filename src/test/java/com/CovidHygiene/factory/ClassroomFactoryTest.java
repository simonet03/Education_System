/*
    Author:Ethan Petersen(217140807)
    This class contains the testing for ClassroomFactory
 */
package com.CovidHygiene.factory;

import com.CovidHygiene.entity.Classroom;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassroomFactoryTest {

    @Test
    public void createClassroom() {
        Classroom cr = ClassroomFactory.createClassroom(7,true,20,false);

        Assert.assertNotNull(cr);
    }
}