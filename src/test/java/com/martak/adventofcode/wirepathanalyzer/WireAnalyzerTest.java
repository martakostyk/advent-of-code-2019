package com.martak.adventofcode.wirepathanalyzer;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WireAnalyzerTest {

    @Test
    public void test() {
        WireAnalyzer wireAnalyzer = new WireAnalyzer();
        List<Point> pathA = wireAnalyzer.getWirePath(new String[]{"R8","U5","L5","D3"});
        List<Point> pathB = wireAnalyzer.getWirePath(new String[]{"U7","R6","D4","L4"});
        List<Point> intersections = wireAnalyzer.findIntersections(pathA, pathB);
        Integer result = wireAnalyzer.getManhattanDistanceOfClosest(intersections);
        Assert.assertNotNull(result);
        Assert.assertEquals((int) result, 6);
    }

}