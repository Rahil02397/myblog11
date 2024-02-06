import org.hibernate.internal.util.collections.ArrayHelper;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Person {

    private static ArrayHelper groupedByAge;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String [] args){

        List<Person> people = Arrays.asList(
                new Person("Rahil", 30),
                new Person("Rabiya", 20),
                new Person("Irfan", 30),
                new Person("Sabina",32)
                );
        Map<Integer, List<Person>> collect = people.stream().collect(Collectors.groupingBy(e -> e.getAge()));

        for (Map.Entry<Integer, List<Person>> entry : collect.entrySet()) {
            int age = entry.    getKey();
            List<Person> personWithAge = entry.getValue();
            System.out.println("age:-"+age);
            for(Person e: personWithAge){
                System.out.println(e.getName());
            }
        }


    }
}
