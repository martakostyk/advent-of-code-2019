package com.martak.adventofcode.wirepathanalyzer;


import com.martak.adventofcode.wirepathanalyzer.model.Command;
import com.martak.adventofcode.wirepathanalyzer.model.CommandParser;
import com.martak.adventofcode.wirepathanalyzer.model.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WireAnalyzerTest {

    @Test
    public void test() {
        WireAnalyzer wireAnalyzer = new WireAnalyzer();
        List<Command> pathA = CommandParser.getPath(new String[]{"R8","U5","L5","D3"});
        List<Command> pathB = CommandParser.getPath(new String[]{"U7","R6","D4","L4"});
        List<Point> intersections = wireAnalyzer.findIntersections(pathA, pathB);
        Integer result = wireAnalyzer.getManhattanDistanceOfClosest(intersections);
        Assert.assertNotNull(result);
        Assert.assertEquals((int) result, 6);
    }

}