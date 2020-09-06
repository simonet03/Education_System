package com.CovidHygiene.factory;

        import com.CovidHygiene.entity.Lecturer;
        import org.junit.Test;

        import static org.junit.Assert.*;

public class LecturerFactoryTest {

    @Test
    public void buildLecturer() {
        Lecturer lect = LecturerFactory.buildLecturer("12345678","Leon", "Small", "02, Adderley St");
        assertNotNull(lect);
    }
}