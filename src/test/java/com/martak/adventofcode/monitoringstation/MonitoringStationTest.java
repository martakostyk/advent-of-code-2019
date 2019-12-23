package com.martak.adventofcode.monitoringstation;

import com.martak.adventofcode.monitoringstation.model.Asteroid;
import com.martak.adventofcode.monitoringstation.model.AsteroidMapParser;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class MonitoringStationTest {

    @Test
    public void testFindTheBestLocationMethod() {
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

    @Test
    public void testVaporizeAsteroidsMethod() {
        // given
        List<Asteroid> asteroids = AsteroidMapParser.parse(
                List.of(".#..##.###...#######",
                        "##.############..##.",
                        ".#.######.########.#",
                        ".###.#######.####.#.",
                        "#####.##.#.##.###.##",
                        "..#####..#.#########",
                        "####################",
                        "#.####....###.#.#.##",
                        "##.#################",
                        "#####.##.###..####..",
                        "..######..##.#######",
                        "####.##.####...##..#",
                        ".#####..#.######.###",
                        "##...#.##########...",
                        "#.##########.#######",
                        ".####.#.###.###.#.##",
                        "....##.##.###..#####",
                        ".#.#.###########.###",
                        "#.#.#.#####.####.###",
                        "###.##.####.##.#..##"));
        Asteroid theBestLocation = new Asteroid(11, 13);
        MonitoringStation monitoringStation = new MonitoringStation(asteroids);
        // when
        monitoringStation.vaporizeAsteroids(theBestLocation);
        // then
        // expected 200 asteroid to vaporized at 8,2
    }

    @DataProvider(name = "angles")
    public static Object[] diagnosticTests() {
        Asteroid base = new Asteroid(2, 3);
        return new Object[][]{
                {base, new Asteroid(5, 1), 33.690067f, 56.309933f},
                {base, new Asteroid(5, 3), 0f, 90f},
                {base, new Asteroid(4, 5), 45f, 135f},
                {base, new Asteroid(2, 6), 0f, 180f},
                {base, new Asteroid(0, 5), 45f, 225f},
                {base, new Asteroid(1, 3), 0f, 270f},
                {base, new Asteroid(0, 0), 56.309933f, 326.309933f},
                {base, new Asteroid(2, 1), 0f, 0f}
        };
    }

    @Test(dataProvider = "angles")
    public void shouldCalculateAngle(Asteroid a1, Asteroid a2, float expectedAngle, float expectedFullAngle) {
        // given
        MonitoringStation monitoringStation = new MonitoringStation(Collections.emptyList());
        // when
        float angle = monitoringStation.calculateAngle(a1, a2);
        // then
        Assertions.assertThat(angle).isEqualTo(expectedAngle);
    }

    @Test(dataProvider = "angles")
    public void shouldCalculateFullAngle(Asteroid a1, Asteroid a2, float expectedAngle, float expectedFullAngle) {
        // given
        MonitoringStation monitoringStation = new MonitoringStation(Collections.emptyList());
        // when
        float fullAngle = monitoringStation.calculateFullAngle(a1, a2, expectedAngle);
        // them
        Assertions.assertThat(fullAngle).isEqualTo(expectedFullAngle);
    }
}