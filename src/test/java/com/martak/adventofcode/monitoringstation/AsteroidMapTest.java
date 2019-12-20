package com.martak.adventofcode.monitoringstation;

import com.martak.adventofcode.monitoringstation.model.Asteroid;
import com.martak.adventofcode.monitoringstation.model.AsteroidMapParser;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class AsteroidMapTest {

    @Test
    public void shouldParseMapCorrectly() {
        // given
        List<String> map = List.of(".#..#", ".....", "#####", "....#", "...##");
        // when
        List<Asteroid> asteroids = AsteroidMapParser.parse(map);
        Asteroid asteroid = asteroids.get(0);
        // then
        Assertions.assertThat(asteroids.size()).isEqualTo(10);
        Assertions.assertThat(asteroid).isNotNull();
        Assertions.assertThat(asteroid.getX()).isEqualTo(1);
        Assertions.assertThat(asteroid.getY()).isEqualTo(0);
    }
}