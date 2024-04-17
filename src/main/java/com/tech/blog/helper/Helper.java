/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.tech.blog.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *
 * @author Anshika Jaiswal
 */
public class Helper {

    /**
     * @param args the command line arguments
     */
    public static boolean deleteFile(String path){
        
         try {
        File file = new File(path);
        
        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist: " + path);
            return false;
        }

        // Attempt to delete the file
        boolean deleted = file.delete();
        
        if (!deleted) {
            System.out.println("Failed to delete file: " + path);
        }
        
        return deleted;
    } catch (Exception e) {
        System.out.println("Error deleting file: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
    }
    
     public static boolean saveFile(InputStream is ,String path){
        boolean f =false;
        try{
            byte [] b = new byte[is.available()];
            is.read(b);
            
            FileOutputStream fos = new FileOutputStream(path);
            
            fos.write(b);
            fos.flush();
            fos.close();
            f= true;
            
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
