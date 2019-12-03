package com.martak.adventofcode.fuelrequirements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CsvReader {

    private Logger log = Logger.getLogger(CsvReader.class.getName());

    public List<Long> read(String file) {
        String line;
        List<Long> masses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                masses.add(Long.parseLong(line));
            }
        } catch (IOException e) {
            log.warning("Cannot read from the given file: " + file);
        }
        return masses;
    }
}
