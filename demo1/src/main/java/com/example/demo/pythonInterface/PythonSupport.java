package com.example.demo.pythonInterface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;

public class PythonSupport {
    /**
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public  void register(String url,String userID) {
        try {



            String[] arguments = new String[] {"C://Users/HP-PC/AppData/Local/Programs/Python/Python37/python.exe",
                    "H://untitled1/addFace.py",userID,url
                    };
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            int re = process.waitFor();
            System.out.println("waitFor的返回值"+re);
            in.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String judgeFace(String url) {

        String line = null;
        try {


            String[] arguments = new String[]{"C://Users/HP-PC/AppData/Local/Programs/Python/Python37/python.exe",
                    "H://untitled1/searchFace.py", url
            };
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));


            line = in.readLine();



            in.close();


        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return line;
    }
}