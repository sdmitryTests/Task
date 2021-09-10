package hse.projects.taskone;

import hse.projects.taskone.deserializers.*;
import hse.projects.taskone.entities.*;
import hse.projects.taskone.serializers.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Street s = new Street("1a1"); // улица
        Building b = new Building(12);
        Building b2 = new Building(3);
        Aparts a = new Aparts(11);
        Aparts a2 = new Aparts(1);
        Aparts a3 = new Aparts(8);
        Person p = new Person("eee", "sss", 10000);
        Person p2 = new Person("p2", "p222", 1010101);
        Person p3 = new Person("p3", "p333", 5555);
        Animal an1 = new Animal("fff");
        an1.setType("dog");
        Animal an2 = new Animal("aaa");
        an2.setType("turtle");
        Animal anp = new Animal("sss");
        anp.setType("cat");
        Animal an3 = new Animal("kitty");
        an3.setType("cat");
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
        p.addPet(an1);
        p.addPet(an2);
        p2.addPet(anp);
        p3.addPet(an3);
        a.addResident(p2);
        a.addResident(p);
        a2.addResident(p3);
        a3.addResident(p3);
        b.addApart(a);
        b2.addApart(a2);
        b.addApart(a3);
        s.AddBuilding(b);
        s.AddBuilding(b2);
        /*                                 */
        String str = ss.toJson(s);
        System.out.println(sd.fromJson(str));
    }
}
