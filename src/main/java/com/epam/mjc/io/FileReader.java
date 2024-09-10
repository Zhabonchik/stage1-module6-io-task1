package com.epam.mjc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.logging.Logger;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Logger logger = Logger.getLogger(getClass().getName());
        Profile profile = new Profile();
        StringBuilder data = new StringBuilder();
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            int c;
            while ((c = fileInputStream.read()) !=- 1){
                data.append((char)c);
            }
            String[] values = data.toString().split("\\s+");
            profile.setName(values[1]);
            profile.setAge(Integer.parseInt(values[3]));
            profile.setEmail(values[5]);
            profile.setPhone(Long.parseLong(values[7]));
        } catch (FileNotFoundException e) {
            logger.info("File not found: " + file.getAbsolutePath());
        } catch (IOException e){
            logger.info("Error reading file" + file.getAbsolutePath());
        }
        return profile;
    }
}
