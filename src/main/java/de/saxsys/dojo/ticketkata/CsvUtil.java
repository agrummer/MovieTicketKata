package de.saxsys.dojo.ticketkata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvUtil {

    public static void writeToCsvFile(String filename, List<String[]> rows) throws IOException {
        File file = new File(filename);
        if (!file.exists() && !file.createNewFile()) {
            throw new IOException("Unable to create new file on disk");
        }
        try (PrintWriter writer = new PrintWriter(file)) {
            for (String[] values : rows) {
                writer.println(toCsvRow(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String toCsvRow(String[] values) {
        return String.join(",", values);
    }

}
