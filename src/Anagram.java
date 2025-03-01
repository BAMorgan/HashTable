import java.util.Arrays;

public class Anagram {
    private final int DEFAULT_CAPACITY = 5;
    private String key;
    private String[] values;
    private int valuesCount;

public Anagram(){
    this.values = new String[DEFAULT_CAPACITY];
}
//constructor
public Anagram(String value){
    this.values = new String[DEFAULT_CAPACITY];
    this.key = alphagram(value);
    values[0] = value;
    valuesCount = 1;
}
    //adds values to anagrams value array
     void addValue(String theWord){
        values[valuesCount] = theWord;
         valuesCount++;
     }

     //sorts strings into alphabetical order
    static String alphagram(String theString){
        char[] charArr = theString.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }

    String getKey(){
        return key;
    }

    int getValuesCount(){
        return valuesCount;
    }

    //method for helping write the found anagrams in driver
    String getValues(){

        String string = "";

        for (String value : values) {
            if (value == null) {
                //nothing
            } else {
                string += value + " ";
            }
        }

        return string;
    }




    public String getFirstValue(){
        return values[0];
    }

    @Override
    public String toString() {
        return "Anagram{" +
                "key='" + key + '\'' +
                ", values=" + Arrays.toString(values) +
                ", valuesCount=" + valuesCount +
                '}';
    }
}
