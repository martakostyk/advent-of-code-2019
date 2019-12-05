package com.martak.adventofcode.wirepathanalyzer;


import com.martak.adventofcode.wirepathanalyzer.model.Command;
import com.martak.adventofcode.wirepathanalyzer.model.CommandParser;
import com.martak.adventofcode.wirepathanalyzer.model.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class WireAnalyzerTest {

    @Test
    public void test() {
        WireAnalyzer wireAnalyzer = new WireAnalyzer();
        List<Command> pathA = CommandParser.getPath(new String[]{"R8","U5", "L5", "D3"});
        List<Command> pathB = CommandParser.getPath(new String[]{"U7","R6", "D4", "L4"});
        Map<Point, Integer> intersections = wireAnalyzer.findIntersections(pathA, pathB);
        Integer result = wireAnalyzer.getFewestSteps(intersections);
        Assert.assertNotNull(result);
        Assert.assertEquals((int) result, 30);
    }

}