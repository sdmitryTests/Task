package hse.projects.taskone;

import hse.projects.taskone.IO.*;
import hse.projects.taskone.entities.*;
import hse.projects.taskone.serializers.StreetSerializer;

public class Main {
    public static void main(String[] args) {
        Street s = new Street("1a1"); // улица
        Building b = new Building(12);
        Aparts a = new Aparts(11);
        Person p = new Person("eee", "sss", 10000);
        Animal an = new Animal("fff", "dog");
        StreetSerializer ss = new StreetSerializer();
        p.addPet(an);
        a.addResident(p);
        b.addApart(a);
        s.AddBuilding(b);
        /*                                 */
        StreetIO sio = new StreetIO();
        sio.print(s);
    }
}
