package hse.projects.taskone.IO;

import hse.projects.taskone.entities.Person;

public class PersonIO implements TaskIO<Person> {

    @Override
    public void print(Person obj) {
        AnimalIO aio = new AnimalIO();
        System.out.println("      Имя: " + obj.getFirstName());
        System.out.println("      Фамилия: " + obj.getLastName());
        System.out.println("      Капитал: " + obj.getMoney());
        if (obj.getPets().size() > 0) {
            System.out.println("      Питомцы:");
            for (int i = 0; i < obj.getPets().size(); i++){
                aio.print(obj.getPets().get(i));
            }
        }
    }

    @Override
    public Person read() {
        return null;
    }
}
