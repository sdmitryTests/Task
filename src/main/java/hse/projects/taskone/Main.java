package hse.projects.taskone;

import hse.projects.taskone.entities.*;
import hse.projects.taskone.serializers.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Street s = new Street("1a1"); // улица
        Building b = new Building(12);
        Aparts a = new Aparts(11);
        Person p = new Person("eee", "sss", 10000);
        Person p2 = new Person("p2", "p222", 1010101);
        Animal an1 = new Animal("fff");
        an1.setType("dog");
        Animal an2 = new Animal("aaa");
        an2.setType("cat");
        Animal anp = new Animal("sss");
        anp.setType("hamster");
        //AnimalSerializer ans = new AnimalSerializer();
        PersonSerializer ps = new PersonSerializer();
        ApartSerializer as = new ApartSerializer();
        BuildingSerializer bs = new BuildingSerializer();
        StreetSerializer ss = new StreetSerializer();
        p.addPet(an1);
        p.addPet(an2);
        p2.addPet(anp);
        a.addResident(p2);
        a.addResident(p);
        b.addApart(a);
        s.AddBuilding(b);
        /*                                 */
        List<Person> pl = new ArrayList<>();
        pl.add(p);
        pl.add(p2);
        System.out.println(ps.toJsonList(pl));
    }
}
