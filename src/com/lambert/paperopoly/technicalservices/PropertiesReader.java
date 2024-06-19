package com.lambert.paperopoly.technicalservices;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
   public static @Nullable String getPropertyValue(String propertyKey) {
      try (InputStream propertiesInputStream = PropertiesReader.class.getClassLoader().getResourceAsStream("/src/resources/application.properties")){
         if(propertiesInputStream != null) {
            Properties properties = new Properties();
            properties.load(propertiesInputStream);
            String propertyValue = properties.getProperty(propertyKey);
            propertiesInputStream.close();
            return propertyValue;
         }
         return null;
      } catch (IOException iOException) {
         iOException.printStackTrace();
         return null;
      }
   }
}
