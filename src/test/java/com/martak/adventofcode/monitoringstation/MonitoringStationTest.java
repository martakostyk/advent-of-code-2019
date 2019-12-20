package com.martak.adventofcode.monitoringstation;

import com.martak.adventofcode.monitoringstation.model.Asteroid;
import com.martak.adventofcode.monitoringstation.model.AsteroidMapParser;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class MonitoringStationTest {

    @Test
    public void test() {
        // given
        List<Asteroid> asteroids = AsteroidMapParser.parse(List.of(".#..#", ".....", "#####", "....#", "...##"));
        MonitoringStation monitoringStation = new MonitoringStation(asteroids);
        // when
        Asteroid theBestLocation = monitoringStation.findTheBestLocation();
        // then
        Assertions.assertThat(theBestLocation).isNotNull();
        Assertions.assertThat(theBestLocation.getX()).isEqualTo(3);
        Assertions.assertThat(theBestLocation.getY()).isEqualTo(4);
    }
}