package com.gmail.ilerofv.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class InputReader {
    private static final Logger logger = LogManager.getLogger(InputReader.class);
    public static final String INPUT_FILE_PATH = "data/input.properties";

    public static Properties loadInputInfo() {
        Properties inputInfo = new Properties();
        File file = new File(INPUT_FILE_PATH);
        try (InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file))){
            inputInfo.load(streamReader);
        } catch (IOException e) {
            logger.error(e.toString(), e);
            throw new RuntimeException(e);
        }
        return inputInfo;
    }

}
