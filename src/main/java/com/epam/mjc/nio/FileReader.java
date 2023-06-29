package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;


public class FileReader {


    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try {
            BufferedReader bf = new BufferedReader(new java.io.FileReader(file));
            String line = bf.readLine();
            while (line != null){
                String value = line.split(":")[1];
                switch(line.split(":")[0]){
                    case "Name": profile.setName(value.trim()); break;
                    case "Age": profile.setAge(Integer.valueOf(value.trim())); break;
                    case "Email": profile.setEmail(value.trim()); break;
                    case "Phone": profile.setPhone(Long.valueOf(value.trim())); break;
                }
                line = bf.readLine();
            }
            bf.close();
        } catch (IOException e) {
            Logger.getLogger(String.valueOf(e));
        }
        return profile;
    }
}
