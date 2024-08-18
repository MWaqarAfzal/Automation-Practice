package streamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class JavaStream {
	
	//@Test
    public void Regular()
    {
        ArrayList<String> languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("Python");
        languages.add("Node");
        languages.add("Server");
        languages.add("Jeson");

        int count = 0;
        for(int i=0; i<languages.size(); i++)
        {
            if(languages.get(i).startsWith("N"))
            {
                count++;
            }
            /*
            String language = languages.get(i);
            System.out.println(language);
            if(language.startsWith("N"))
            {
                count++;
            }
             */
        }
        System.out.println(count);
    }
	
	//@Test
    public void FiltererStreams()
    {
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("Node");
        languages.add("Server");
        languages.add("Jeson");
        languages.add("Ruby");

        //Long count = languages.stream().filter(s->s.startsWith("N")).count();
        //System.out.println(count);
        //languages.stream().filter(s->s.contains("n")).forEach(System.out::println);

        Long countofLanguages = Stream.of("Java","Python","Node","Server","Jeson", "Ruby", "Rails").filter(s->s.contains("a")).count();
        System.out.println(countofLanguages);
        languages.stream().filter(s->s.contains("R")).forEach(s->System.out.println(s));
        Stream.of("Java","Python","Node","Server","Jeson", "Ruby", "Rails").filter(s->s.contains("a")).limit(1).forEach(System.out::println);
        Stream.of("Java","Python","Node","Server","Jeson", "Ruby", "Rails").filter(s->s.contains("a")).limit(2).forEach(s->System.out.println(s));
    }
	
    //@Test
    public void StreamMap()
    {
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("Node");
        languages.add("Server");
        languages.add("Join");
        languages.add("Jeson");
        languages.add("Ruby");

        List<String> names = Arrays.asList("Junaid","Salman","Sameer","Qasim","Shahbaz","Sunail");

        //      Filter the records that ends with R and then convert it into upper case and then print
        languages.stream().filter(s->s.endsWith("r")).map(s->s.toUpperCase()).forEach(System.out::println);
        //      Filter the records that starts with J and then convert it into the upper case and then sorted it and print it. Sorted() is a Terminal operator
        languages.stream().filter(s->s.startsWith("J")).map(s->s.toUpperCase()).sorted().forEach(System.out::println);

        //      Merge two Streams
        Stream<String> mergedStream = Stream.concat(languages.stream(), names.stream());
        //      Verify that is there any record with Qasim is present or not by using the anyMatch() methods and its return boolean value
        boolean result = mergedStream.anyMatch(s->s.equalsIgnoreCase("Qasim"));
        System.out.println("After merged two streams the value with Qasim is present or not? The answer is " + result);
        Assert.assertTrue(result);

        List<String> manipulatedList = names.stream().filter(s->s.startsWith("S")).map(s->s.toUpperCase()).sorted().collect(Collectors.toList());
        System.out.println(manipulatedList.get(0));
    }
    @Test
    public void StreamCollect()
    {
        //      Take the list --> convert into stream --> do required manipulation --> convert back into list
        List<String> names = Arrays.asList("Junaid","Salman","Sameer","Qasim","Shahbaz","Sunail");
        List<String> manipulatedList = names.stream().filter(s->s.startsWith("S")).map(s->s.toUpperCase()).sorted().collect(Collectors.toList());
        System.out.println(manipulatedList.get(0));
        System.out.println("All the names starts with letter S " + manipulatedList);

        //      Take the list --> convert into stream --> Find the unique values --> sorted them --> convert back into list --> print the 3rd index value
        List<Integer> values = Arrays.asList(2,5,10,4,2,20,2,45,65,0,1);
        List<Integer> sortedValues = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("The 3rd index of sorted list value is " + sortedValues.get(3));

    }

}
