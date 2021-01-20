package hazelNet;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Nuts {
    public static void main(String[] args) throws Exception {
        System.out.println("%%%");
    }
    
    public String CreateDatabase(String txtname){  //create new database
        try {
            File myObj = new File(txtname + ".txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          return txtname;
    }

//-----------------------------------------------------------------------------------------------------------------------------

    public String addToDatabaseString(String array, String Database) {   //puts strings into the database
        try {
            FileWriter myWriter = new FileWriter(Database + ".txt", true);
            myWriter.append(array);
            myWriter.close();
            System.out.println("Database Saved!");  
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return array;
    }

//-----------------------------------------------------------------------------------------------------------------------------------

    public String addToDatabaseStringArray(String[] array, String otroun, String Database) {  //puts string arrays into the database
        try {
            FileWriter myWriter = new FileWriter(Database + ".txt", true);
            for(String i: array){
                myWriter.append(i);
            }
            myWriter.close();
            System.out.println("Database Saved!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return otroun;
    }

//------------------------------------------------------------------------------------------------------------------------------------

    public String addToDatabaseInt(int array, String un, String Database) {   //puts int variables into the database
        try {
            FileWriter myWriter = new FileWriter(Database + ".txt", true);
            String newarraw = Integer.toString(array);
            myWriter.append(newarraw);
            myWriter.close();
            System.out.println("Database Saved!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return un;
    }

//---------------------------------------------------------------------------------------------------------------------------------

    public String addToDatabaseIntArray(int[] array, String un, String Database) {   //puts int arrays into the database
        try {
            FileWriter myWriter = new FileWriter(Database + ".txt", true);
            for(int i: array){
                String newarraw = Integer.toString(i);
                myWriter.append(newarraw);
            }
            myWriter.close();
            System.out.println("Database Saved!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return un;
    }


    public String setDataMark(String Database, String MarkName){
        try {
            String Mark = MarkName;
            FileWriter myWriter = new FileWriter(Database + ".txt", true);
            myWriter.append(Mark);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("ERROR. Unable to create data mark.");
            e.printStackTrace();
        }
        return Database;
    }

    public String endDataMark(String Database, String EndMarkName){
        try {
            String endMark = EndMarkName;
            FileWriter myWriter = new FileWriter(Database + ".txt", true);
            myWriter.append(endMark);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("ERROR. Unable to end data mark.");
            e.printStackTrace();
        }
        return Database;
    }

    public String getDatabaseMark(String Database, String MarkName, String EndMarkName){
        FileReader dataE;
        try {
            dataE = new FileReader(Database + ".txt");
            Scanner myReader = new Scanner(dataE);
            String data = myReader.nextLine();
            if(data.contains(MarkName)){
                int jend = data.indexOf(MarkName);
                int iend = data.indexOf(EndMarkName);
                String subString;
                subString = data.substring(jend, iend);
                System.out.println(subString);
            } else {
                System.out.println("No Mark Found!");
            }
            myReader.close();

        } catch (IOException e) {
            System.out.println("ERROR. Unable to create data mark.");
            e.printStackTrace();
        }
        return Database;
    }

    public String deleteData(String Database, String MarkName, String EndMarkName){
        FileReader dataE;
        try {
            dataE = new FileReader(Database + ".txt");
            Scanner myReader = new Scanner(dataE);
            String data = myReader.nextLine();
            if(data.contains(MarkName)){
                int jend = data.indexOf(MarkName);
                int iend = data.indexOf(EndMarkName);
                String subString;
                subString = data.substring(jend, iend);
                System.out.println(data.replace(subString, ""));
            } else {
                System.out.println("No Mark Found!");
            }
            myReader.close();

        } catch (IOException e) {
            System.out.println("ERROR. Unable to create data mark.");
            e.printStackTrace();
        }
        return Database;
    }

    public String deleteDatabase(String Database){
        File myObj = new File(Database + ".txt"); 
        if (myObj.delete()) { 
          System.out.println("Deleted the file: " + myObj.getName());
        } else {
          System.out.println("Failed to delete the file.");
        } 
        return Database;
    }

//--------------------------------------------------------------------------------------------------------------------------------

    public String getDatabase(String forcedVar, String Database) {   //prints database info
        FileReader dataE;
        try {
            dataE = new FileReader(Database + ".txt");
            Scanner myReader = new Scanner(dataE);
            String data = myReader.nextLine();
            System.out.println(data);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Me obligaron a anadir exception");
            e.printStackTrace();
        }
        return forcedVar;
    }
}
