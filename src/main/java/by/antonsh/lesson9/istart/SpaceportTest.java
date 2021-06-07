package by.antonsh.lesson9.istart;

import org.junit.Assert;

public class SpaceportTest {

    @org.junit.Test
    public void start() {
        Shuttle shuttle = new Shuttle();
        Spaceport spaceport = new Spaceport();
        spaceport.start(shuttle);
        Assert.assertEquals(true, true);
    }
}