package com.gmail.ilerofv.utils;

import com.gmail.ilerofv.entity.Report;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

public class ReportWriter {
    private static final Logger logger = LogManager.getLogger(ReportWriter.class);

    public static void writeReport (String reportFileName, Report report){
        List<String> result = new ArrayList<>();

        String pattern = "#.##";
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        DecimalFormatSymbols sb = myFormatter.getDecimalFormatSymbols();
        sb.setDecimalSeparator('.');
        myFormatter.setDecimalFormatSymbols(sb);

        String number = "Number of transactions = " + report.getCount();
        String average = "Average Transaction Value = " + myFormatter.format(report.getAverage());
        result.add(number);
        result.add(average);
        Path path = Paths.get(reportFileName);
        try {
            Files.write(path, result);
        } catch (IOException e) {
            logger.error(e.toString(), e);
            throw new RuntimeException(e);
        }
    }

}
