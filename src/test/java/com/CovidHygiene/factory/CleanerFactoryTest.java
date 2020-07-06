package com.CovidHygiene.factory;

import com.CovidHygiene.entity.Cleaner;
import org.junit.Assert;
import org.junit.Test;

public class CleanerFactoryTest {
    @Test
    public void buildCleaner() {
        Cleaner clean = CleanerFactory.buildCleaner(10, "Nazeerah", "Carr",
                "2 Newfields Road");
        Assert.assertNotNull(clean);
    }
}
