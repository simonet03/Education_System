package com.CovidHygiene.factory;

import com.CovidHygiene.entity.Admin;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminFactoryTest {

    @Test
    public void buildAdmin() {
       Admin adm = AdminFactory.buildAdmin("A001","Daphney","Kgosiejang",
                "Cput, Cape Town, 7925");
        Assert.assertNotNull(adm);

    }
}