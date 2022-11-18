package com.Test.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Preberi  
{
    @SuppressWarnings("unchecked")
    public static void Preberi() 
    {
        //JSON parser object v reading file :) 
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("helloWorld.json"))
        {
            //pa preberi json file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
             
            //iteracija :D - bomo nasl carovnijo :D 
            employeeList.forEach( emp -> Carovnija( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static String getStringBetweenTwoChars(String input, String startChar, String endChar) {
        try {
            int start = input.indexOf(startChar);
            if (start != -1) {
                int end = input.indexOf(endChar, start + startChar.length());
                if (end != -1) {
                    return input.substring(start + startChar.length(), end);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input; 
    } 

    private static void Carovnija(JSONObject employee) 
    {
        //zacetek
        JSONObject employeeObject = (JSONObject) employee;
        String doctype = (String) employeeObject.get("doctype");    
        String language = (String) employeeObject.get("language");    


        JSONObject headOBJ = (JSONObject) employee.get("head");
        JSONObject metaOBJ = (JSONObject) headOBJ.get("meta");
        String charset = (String) metaOBJ.get("charset"); 
        String author = (String) metaOBJ.get("author"); 
        String keyWords = (String) metaOBJ.get("keywords");
        
        // STYLE 
        String style = getStringBetweenTwoChars(headOBJ.toString(), "\"href\":", ",");
        String rel = getStringBetweenTwoChars(headOBJ.toString(), "\"rel\":", ",");
        //TITLE
        String title = getStringBetweenTwoChars(employee.toString(),"\"title\":" , "},");
        //BODY
        String attributesID = getStringBetweenTwoChars(employee.toString(),"\"id\":" , "},");
   
        String stylew = getStringBetweenTwoChars(employee.toString(),"\"width\":\"" , "\",");
        String styleh = getStringBetweenTwoChars(employee.toString(),"\"height\":\"" , "\",");
        String alignText = getStringBetweenTwoChars(employee.toString(),"\"text-align\":\"" , "}");
        // text h1 p h2
        String h1 = getStringBetweenTwoChars(employee.toString(),"\"h1\":\"" , "\",");
        String p = getStringBetweenTwoChars(employee.toString(),"\"p\":\"" , "\",");
        String h2 = getStringBetweenTwoChars(employee.toString(),"\"h2\":\"", "\"}");
        String nested = getStringBetweenTwoChars(employee.toString(),"\"class\":", "},");
        String h3 = getStringBetweenTwoChars(employee.toString(),"\"h3\":\"", "\"}");
    
        try {
            FileWriter myWriter = new FileWriter("helloWorld.html");
            myWriter.write("<!DOCTYPE html>\n");
            myWriter.write("<" + doctype + " lang=\"" + language + "\">\n");
            myWriter.write("    <head>\n");

            myWriter.write("        <meta charset=\""  + charset + "\">\n");
            myWriter.write("        <meta name=\"author\" content=\"" + author + "\">\n");
            myWriter.write("        <meta name=\"keywords\" keywords=\"" + keyWords + "\">\n");
            myWriter.write("        <link href= " + style + " rel=" + rel + " type=\"text/css\">\n");
            myWriter.write("        <title>"+ title +"</title>\n");

            myWriter.write("    </head>\n");
            myWriter.write("    <body id="  + attributesID + " style=\"width:"+ stylew +";height:" + styleh +";text-align:"+ alignText + ">\n");

            myWriter.write("        <h1>"  + h1 + "</h1>\n");
            myWriter.write("        <p>"  + p + "</p>\n");
            myWriter.write("        <h2>"  + h2 + "</h2>\n");
            myWriter.write("        <div class=" + nested  + ">\n");
            myWriter.write("            <h3>"  + h3 + "</h3>\n");
            myWriter.write("        </div>\n");
            myWriter.write("    </body>\n");
            myWriter.write("</html>\n");
        
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    
    }
}
