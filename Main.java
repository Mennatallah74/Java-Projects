
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Main {
    
    public static void main(String[] args)  {
      try{
      
      String fileName = args[0];
      if(!fileName.endsWith(".arxml"))
      {
      throw new NotValidAutosarFileException("Invalid file extension");
      }
      File file = new File(fileName);
      FileInputStream inputStream = new FileInputStream(file);
      int d;
      StringBuilder stringBuilder = new StringBuilder();
      if(inputStream.read() == -1){
            throw new EmptyAutosarFileException("your file is an empty file");            
            }
      while((d = inputStream.read()) != -1)
      {
      stringBuilder.append((char) d);
      }
      String data = stringBuilder.toString();
      Scanner scanner = new Scanner(data);
      ArrayList <Container> containers = new ArrayList<> ();
      while(scanner.hasNextLine())
      {
      String line = scanner.nextLine();
      if(line.contains("<CONTAINER"))
      {
      String ID = line.substring(line.indexOf("UUID="),line.indexOf(">"));
      String shortNameTag = scanner.nextLine();
      String shortName = shortNameTag.substring(shortNameTag.indexOf(">")+1, shortNameTag.indexOf("</"));
      String longNameTag = scanner.nextLine();
      String longName = longNameTag.substring(longNameTag.indexOf(">")+1  , longNameTag.indexOf("</"));
      
      Container container = new Container();
      container.setID(ID);
      container.setShortName(shortName);
      container.setLongName(longName);
      containers.add(container);
  
    
      
      
      
      }
      
      }
      Collections.sort(containers);
      
      String outName = fileName.substring(0,fileName.indexOf("."))+"_mod.arxml";
      FileOutputStream outputStream = new FileOutputStream(outName);
      outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
      outputStream.write("<AUTOSAR>\n".getBytes());
      for(int i =0; i <containers.size(); i++)
      {
      outputStream.write(containers.get(i).toString().getBytes());
      }
      outputStream.write("</AUTOSAR>\n".getBytes());
      
      }
      
      catch ( NotValidAutosarFileException e) {
                e = new NotValidAutosarFileException("Not Valid Autosar File Exception");
            }
            catch (IOException e) {
                e = new IOException("IO Exception");
            }
    }
}