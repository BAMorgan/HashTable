import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static void main(String[] args) throws IOException {
        run();
    }


    static void run() throws IOException {
        var fileName = "words.txt";

        //initializing reader and writer
        BufferedReader reader = new BufferedReader(new FileReader(fileName));;
        FileWriter writer = new FileWriter("output.txt");;
        //initizialing custom hashtable object
        HashTable hashTable = new HashTable();
        var fileName2 = "input.txt";



            String line = reader.readLine();

            //first while loop which adds and times my hashtable function
            long timerStart = System.nanoTime();
            while(line != null){

                hashTable.add(line);
                line = reader.readLine();
            }

            long timerEnd = System.nanoTime();
            long runtime = TimeUnit.NANOSECONDS.toMillis(timerEnd - timerStart);

            //writing first part of Output.txt
            writer.write("Collision Count: " + hashTable.collisions + "\n");
            writer.write("Java Collision Count: " + javaCollisionCounter());

            //reinitializing reader for timing java implementation of hashmap
            reader = new BufferedReader(new FileReader(fileName));

            line = reader.readLine();

            //hashmap for running time comparison
            HashMap<String, List<String>> hm = new HashMap<String, List<String>>();

            //second while loop which adds and times java HashMap
            long javatimerStart = System.nanoTime();

            while(line != null){

                //if-else for adding multiple values per key in java HashMap
                if(hm.containsKey(Anagram.alphagram(line))){
                    hm.get(Anagram.alphagram(line)).add(line);
                }else{
                    hm.put(Anagram.alphagram(line), new ArrayList<String>());
                    hm.get(Anagram.alphagram(line)).add(line);
                }


                line = reader.readLine();
            }
            long javatimerEnd = System.nanoTime();
            long javaruntime = TimeUnit.NANOSECONDS.toMillis(javatimerEnd - javatimerStart);

            //writing table of runing times in terms of milliseconds
            writer.write("\n------------------------------------------------------");
            writer.write("\nMy Running Time: " + runtime + "ms || Java Running Time: " + javaruntime + "ms");
            writer.write("\n------------------------------------------------------");

            //reinitializing reader to read the input file for anagram searching
            reader = new BufferedReader(new FileReader(fileName2));
            line = reader.readLine();

            //third while loop for anagram searching
            while (line != null){

                //make anagram object for easy sorting of the string to get key
                Anagram theAnagram = hashTable.search(line);

                if(theAnagram == null){
                    writer.write("\n" + line + " 0");
                }else{
                    writer.write("\n" + line + " " + theAnagram.getValuesCount() + " " + theAnagram.getValues());
                }

                line = reader.readLine();
            }

            //finally closing reader and writer in order to finalize output.txt
            writer.close();
            reader.close();

    }


    //method which calls addJava() in HashTable in order to measure .hashcode() insert times
    static int javaCollisionCounter() throws IOException {
        HashTable ht = new HashTable();
        BufferedReader reader;
        FileWriter writer;

        var fileName = "words.txt";
        //var fileName2 = "input.txt";


            reader = new BufferedReader(new FileReader(fileName));
            writer = new FileWriter("output.txt");

            String line = reader.readLine();

            HashTable hashTable = new HashTable();



            while(line != null){


                hashTable.addJava(line);

                line = reader.readLine();
            }


            return hashTable.collisions;
    }


}
