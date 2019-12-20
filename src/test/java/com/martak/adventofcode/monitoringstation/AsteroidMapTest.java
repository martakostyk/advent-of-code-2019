package com.martak.adventofcode.monitoringstation;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class AsteroidMapTest {

    @Test
    public void shouldParseMapCorrectly() {
        // given
        String[] map = {".#..#", ".....", "#####", "....#", "...##"};
        // when
        AsteroidMap asteroidMap = AsteroidMap.parse(map);
        List<Asteroid> asteroids = asteroidMap.getAsteroids();
        Asteroid asteroid = asteroids.get(0);
        // then
        Assertions.assertThat(asteroids.size()).isEqualTo(10);
        Assertions.assertThat(asteroid).isNotNull();
        Assertions.assertThat(asteroid.getX()).isEqualTo(1);
        Assertions.assertThat(asteroid.getY()).isEqualTo(0);
    }
}