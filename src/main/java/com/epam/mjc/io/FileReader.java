package com.epam.mjc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        StringBuilder data = new StringBuilder();
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            int c;
            while ((c = fileInputStream.read()) !=- 1){
                data.append((char) c);
            }
            System.out.println(data);
            String[] values = data.toString().split("\\s|\\n");
            profile.setName(values[1]);
            profile.setAge(Integer.parseInt(values[3]));
            profile.setEmail(values[5]);
            profile.setPhone(Long.parseLong(values[7]));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        return profile;
    }
}
