import java.util.Arrays;
import java.util.Objects;

public class HashTable {

    Anagram[] array = new Anagram[198733];
    int collisions;
    int filledBuckets;
    int sameKey;


    HashTable(){

    }

    public int hashCode(String theKey){
        //start with prime
        int hash = 7;
        //multiply hash by 31 and add the ascii code of the character at position i
        for(int i = 0; i < theKey.length(); i++){
            hash = hash*31 + theKey.charAt(i);
        }

        return Math.abs(hash % array.length);
    }

    //add method for my custom hash function
    public void add(String theWord){

        int bucket = hashCode(Anagram.alphagram(theWord));

        //if the bucket is null -> add
        if(array[bucket] == null){
            array[bucket] = new Anagram(theWord);
        }
        //if the bucket and the new anagram have the same key
        else if(array[bucket].getKey().equals(Anagram.alphagram(theWord))){
            sameKey++;
            array[bucket].addValue(theWord);
        }
        //if adding to a bucket that is taken and not the same key as current anagram object
        else{
            collisions++;
            collisionHandler(theWord, Math.abs((bucket * 31 + Anagram.alphagram(theWord).length()) % array.length));
        }

    }
    //add method for testing Java .hashcode method (same as above add method other than hashing function)
    public void addJava(String theWord){

        int bucket = Math.abs(Anagram.alphagram(theWord).hashCode() % array.length);

        if(array[bucket] == null){
            array[bucket] = new Anagram(theWord);
        }
        else if(array[bucket].getKey().equals(Anagram.alphagram(theWord))){
            sameKey++;
            array[bucket].addValue(theWord);
        }else{
            collisions++;
            collisionHandler(theWord, Math.abs((bucket * 31 + Anagram.alphagram(theWord).length()) % array.length));
        }

    }

    public Anagram search(String theWord){
        int bucket = hashCode(Anagram.alphagram(theWord));
        //find bucket based on hashcode
        if(array[bucket] == null){
            return null;
        }

        return array[bucket];
    }



    public void collisionHandler(String theWord, int hashValue){
        //take new hashvalue from param and assign to new bucket
        if(array[hashValue] == null){
            array[hashValue] = new Anagram(theWord);
        //if still colliding then probe for new bucket based on function
        }else{
            collisionHandler(theWord, Math.abs((hashValue * 31 + Anagram.alphagram(theWord).length()) % array.length));
        }

    }


    float getLoadFactor(){
        return filledBuckets / (float) 198733;
    }


}
