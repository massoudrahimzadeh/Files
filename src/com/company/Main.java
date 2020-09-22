package com.company;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try{
            List <String> readList = Files.readAllLines(Paths.get("D:\\java programming with tom\\sherlock.txt"));
            System.out.println(readList.size());

            String line = "";
            for (int i =0; i<readList.size();i++){
                line = readList.get(i);
                line=line.replaceAll("Sherlock Holmes" , "Massoud Rahimzadeh");
                readList.set(i, line);
            }

            File massHolmes = new File("D:\\java programming with tom\\Massoudsherlock.txt");
            if (massHolmes.createNewFile()){
                System.out.println("File created: "+ massHolmes.getName());
            }else{
                System.out.println("Was an error in creating the file");
            }
            FileWriter fw = new FileWriter("D:\\java programming with tom\\Massoudsherlock.txt");
            for(String line1:readList){
                fw.write(line1 + System.getProperty("line.separator"));
            }
            fw.close();
            List <String> readList1 = Files.readAllLines(Paths.get("D:\\java programming with tom\\sherlock.txt"));
            System.out.println(readList1.size());
            System.out.println(readList1.size());
            int count=0;

            for(int i=0; i<readList1.size();i++){
                if(readList1.get(i).startsWith("ADVENTURE")){
                    count+=1;
                    File adventure = new File("D:\\java programming with tom\\adventure_"+count+".txt");
                    FileWriter fw1 = new FileWriter("D:\\java programming with tom\\adventure_"+count+".txt");
                    fw1.write(readList1.get(i) + System.getProperty("line.separator"));
                    i++;
                    while (!readList1.get(i).startsWith("ADVENTURE") && i<readList1.size()-1){
                        fw1.write(readList1.get(i) + System.getProperty("line.separator"));
                        i++;
                    }
                    fw1.close();
                    i-=1;
                }
            }
            System.out.println(count);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
