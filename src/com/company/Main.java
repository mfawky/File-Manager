package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class Main {

    public static boolean CreateNewFile(String path, String Filename) {
        try {
            Process p = Runtime.getRuntime().exec( "gedit  " + path + "/" + Filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String Output;
            while((Output = reader.readLine()) != null) {
                System.out.println(Output);
            }
            return true;
        }
        catch(Exception e) {
            System.out.println("Error Happened Type : " + e);
            return false;
        }
    }
    public static boolean DeleteFile(String path, String FileName) {
        try {
            Process p = Runtime.getRuntime().exec( "rm  -r " + path + "/" + FileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String Output;
            while((Output = reader.readLine()) != null) {
                System.out.println(Output);
            }
            return true;
        }
        catch(Exception e) {
            System.out.println("Error Happened Type : " + e);
            return false;
        }
    }
    public static boolean CreateNewDirectory(String path, String DirectoryName) {
        try {
            Process p = Runtime.getRuntime().exec( "mkdir  -p " + path + "/" + DirectoryName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String Output;
            while((Output = reader.readLine()) != null) {
                System.out.println(Output);
            }
            return true;
        }
        catch(Exception e) {
            System.out.println("Error Happened Type : " + e);
            return false;
        }

    }
    public static boolean DeleteDirectory(String path, String DirectoryName) {
        try {
            Process p = Runtime.getRuntime().exec( "rm  -r " + path + "/" + DirectoryName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String Output;
            while((Output = reader.readLine()) != null) {
                System.out.println(Output);
            }
            return true;
        }
        catch(Exception e) {
            System.out.println("Error Happened Type : " + e);
            return false;
        }
    }
    public static boolean listDirectories(String path) {
        try {

            Process p = Runtime.getRuntime().exec("ls -p /home/mustafa");
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String Output;
            while((Output = reader.readLine()) != null) {
                int x = Output.lastIndexOf("/");
                if (x > 0) {
                    Output = Output.replace("/", "");
                    System.out.println(Output);
                }
            }
            return true;
        }
        catch(Exception e) {
            System.out.println("Error Happened Type : " + e);
            return false;
        }

    }
    public static boolean listFiles(String path) {
        try {
            path.replace("~","/home/mustafa");
  /*          if (path.charAt(0) == '~' ) {
                path = path.replace("~","");
                path = "/home/mustafa" + path;
                System.out.println(path);
            }*/
            Process p = Runtime.getRuntime().exec( "ls -v " + path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String Output;
            while((Output = reader.readLine()) != null) {
                System.out.println(Output);
            }
            return true;
        }
        catch(Exception e) {
            System.out.println("Error Happened Type : " + e);
            return false;
        }

    }
    public static boolean CreateSymbolLink(String path, String linkName) {
        try {
            Process p = Runtime.getRuntime().exec( "ln  -s " + path + " " + linkName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String Output;
            while((Output = reader.readLine()) != null) {
                System.out.println(Output);
            }
            return true;
        }
        catch(Exception e) {
            System.out.println("Error Happened Type : " + e);
            return false;
        }


    }


    public static void main(String[] args) {
        String deviceName = new String();
        try {
            Process p = Runtime.getRuntime().exec( "hostname");
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String Output;
            while((Output = reader.readLine()) != null) {
                int index = Output.indexOf("-");

                if (index == -1)
                    deviceName = Output;
                else{
                    for (int i = 0; i < index; i++)
                        deviceName = deviceName + Output.charAt(i);
                }
            }
        }
        catch(Exception e) {
            System.out.println("Error Happened Type : " + e);
        }

              new FileManager(deviceName);
    }
}
