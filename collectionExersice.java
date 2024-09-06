package ir.freeland.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ir.freeland.collection.model.Address;
import ir.freeland.collection.model.person2;
public class collectionExersice {

	public static void main(String[] args) {
		
		person2 sample1 = new person2 ("hanie","bayati",24,new Address("tehran","iran"));
		person2 sample2 = new person2 ("eli","babaei",14,new Address("yazd","iran"));
		person2 sample3 = new person2 ("mohammad","yaghmaei",28,new Address("abadan","iran"));
		person2 sample4 = new person2 ("baran","montazerii",18,new Address("shiraz","iran"));
		person2 sample5 = new person2 ("anahita","mohammadi",30,new Address("paris","france"));
		person2 sample6 = new person2 ("parmida","aria",29,new Address("berlin","germani"));
		person2 sample7 = new person2 ("saman","elahi",37,new Address("tehran","iran"));
		person2 sample8 = new person2 ("amir","bahrami",25,new Address("berlin","germani"));
		person2 sample9 = new person2 ("avina","moghaddam",17,new Address("london","england"));
		person2 sample10 = new person2 ("sadaf","sabeti",10,new Address("mazandaran","iran"));
		
		List<person2> persons = new ArrayList<person2>();
		persons.add(sample1);
		persons.add(sample2);
		persons.add(sample3);
		persons.add(sample4);
		persons.add(sample5);
		persons.add(sample6);
		persons.add(sample7);
		persons.add(sample8);
		persons.add(sample9);
		persons.add(sample10);
		
        for (person2 person : persons) {
            System.out.println(person);
        }
        
        
        System.out.println();
        System.out.println("sorted by city:");
        Collections.sort(persons, new Comparator<person2>() {
            @Override
            public int compare(person2 p1, person2 p2) {
                return p1.getAddress().getCity().compareTo(p2.getAddress().getCity());
            }
        });
        for (person2 person : persons) {
            System.out.println(person);
        }
        
        System.out.println();
        System.out.println("older 18:");
        for (person2 person : persons) {
            if (person.getAge() > 18) {
                System.out.println(person);
            }
        }

        System.out.println();
        System.out.println("younger 18:");
        for (person2 person : persons) {
            if (person.getAge() <= 18) {
                System.out.println(person);
            }
        }
        
        System.out.println();
        System.out.println("grouping by city:");
        Map<String, List<person2>> cityGroups = new HashMap<>();

        for (person2 person : persons) {
            String city = person.getAddress().getCity(); 

            if (!cityGroups.containsKey(city)) {
                cityGroups.put(city, new ArrayList<>());
            }

            cityGroups.get(city).add(person);
        }


        for (String city : cityGroups.keySet()) {
            System.out.println("city " + city + ":");
            for (person2 person : cityGroups.get(city)) {
                System.out.println(person);
            }
            System.out.println(); 
        }
        
        System.out.println();
        System.out.println("average of ages:");
        double averageAge = persons.stream()
                .collect(Collectors.averagingDouble(person2::getAge));
        System.out.println(averageAge);
	
	}
}
