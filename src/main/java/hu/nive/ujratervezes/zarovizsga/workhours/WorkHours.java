package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {


    public String minWork(String s) {
        Path file = Path.of(s);
        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {

            String foundName = "";
            Integer foundMinHour = Integer.MAX_VALUE;
            String foundDate = "";

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                Integer hour = Integer.parseInt(parts[1]);
                if (foundMinHour > hour) {
                    foundMinHour = hour;
                    foundName = parts[0];
                    foundDate = parts[2];
                }
            }
            return foundName + ": " + foundDate;
        } catch (
                IOException ioException) {
            throw new IllegalStateException("File is non-readable or not exists!", ioException);
        }
    }
}
