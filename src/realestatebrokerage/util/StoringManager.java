package realestatebrokerage.util;

import realestatebrokerage.models.storageandsystemmodels.Storage;

import java.io.*;

public class StoringManager {
    public static void serialize(Storage storage){
        try
        {
            String filename = "D://f1.txt";
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(storage);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }catch (Exception e){System.out.println(e);}
    }

    public static Storage deserialize(){
        // Deserialization
        Storage storage = null;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("D://f1.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            storage = (Storage) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
        } catch(IOException e)
        {
            System.out.println("IOException is caught\n Creating a new database");
            return new Storage();
        }catch (Exception e){
            System.out.println(e);
        }
        return storage;
    }
}
