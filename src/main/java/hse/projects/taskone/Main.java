package hse.projects.taskone;

import hse.projects.taskone.deserializers.*;
import hse.projects.taskone.entities.*;
import hse.projects.taskone.serializers.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //
        Animal an1 = new Animal.Builder().withName("sabaka1").withType("dog").build();
        Animal an2 = new Animal.Builder().withName("kot1").withType("cat").build();
        Animal an3 = new Animal.Builder().withName("kot2").withType("cat").build();
        Animal an4 = new Animal.Builder().withName("tortik").withType("turtle").build();
        List<Animal> animals1 = new ArrayList<>();
        List<Animal> animals2 = new ArrayList<>();
        List<Animal> animals3 = new ArrayList<>();
        animals1.add(an1);
        animals1.add(an2);
        animals2.add(an3);
        animals3.add(an4);
        //
        Person p1 = new Person.Builder().withFirstName("Ivan").withLastName("Ivanov").withMoney(10000).withPets(animals1).build();
        Person p2 = new Person.Builder().withFirstName("Petr").withLastName("Petrov").withMoney(50000).withPets(animals2).build();
        Person p3 = new Person.Builder().withFirstName("Steven").withLastName("King").withMoney(80000).withPets(animals3).build();
        List<Person> residents1 = new ArrayList<>();
        List<Person> residents2 = new ArrayList<>();
        List<Person> residents3 = new ArrayList<>();
        residents1.add(p1);
        residents1.add(p2);
        residents2.add(p2);
        residents3.add(p3);
        //
        Aparts a1 = new Aparts.Builder().withNumber(1).withResidents(residents1).build();
        Aparts a2 = new Aparts.Builder().withNumber(2).withResidents(residents2).build();
        Aparts a3 = new Aparts.Builder().withNumber(3).withResidents(residents3).build();
        List<Aparts> aparts1 = new ArrayList<>();
        List<Aparts> aparts2 = new ArrayList<>();
        aparts1.add(a1);
        aparts1.add(a2);
        aparts2.add(a3);
        //
        Building b1 = new Building.Builder().withNumber(11).withAparts(aparts1).build();
        Building b2 = new Building.Builder().withNumber(12).withAparts(aparts2).build();
        List<Building> buildings1 = new ArrayList<>();
        buildings1.add(b1);
        buildings1.add(b2);
        //
        Street street1 = new Street.Builder().withName("Komarova").withBuildings(buildings1).build();
        List<Street> streets1 = new ArrayList<>();
        streets1.add(street1);
        //
        AnimalSerializer ans = new AnimalSerializer();
        AnimalDeserializer and = new AnimalDeserializer();
        PersonSerializer ps = new PersonSerializer();
        PersonDeserializer pd = new PersonDeserializer();
        ApartSerializer as = new ApartSerializer();
        ApartDeserializer ad = new ApartDeserializer();
        BuildingSerializer bs = new BuildingSerializer();
        BuildingDeserializer bd = new BuildingDeserializer();
        StreetSerializer ss = new StreetSerializer();
        StreetDeserializer sd = new StreetDeserializer();
        /*                                 */
        System.out.println(sd.fromJsonList(ss.toJsonList(streets1)));
    }
}
