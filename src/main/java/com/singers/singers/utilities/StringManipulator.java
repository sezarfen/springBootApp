package com.singers.singers.utilities;

import org.springframework.stereotype.Component;

@Component
public class StringManipulator {
    public String hadithForMainPage(String string)
    {
        if (string.length() > 100)
        {
            String toReturn;
            if (string.substring(0,100).endsWith(" "))
            {
                toReturn = string.substring(0,99).concat("...");
            }
            else if (string.substring(0,100).endsWith("."))
            {
                toReturn = string.substring(0,100).concat("..");
            }
            else
                toReturn = string.substring(0,100).concat("...");
            return toReturn;
        }
        return string;
    }

    public String singerDescriptionSetter(String description, String wiki)
    {
     if (description.length() > 500)
     {
         String toReturn = description.substring(0,500).concat(".. \nFor more -> " + wiki);
         return toReturn;
     }
     return description;
    }
}
