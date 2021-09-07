package hse.projects.taskone.IO;

import hse.projects.taskone.entities.Aparts;

public class ApartIO implements TaskIO<Aparts>{
    @Override
    public void print(Aparts obj) {
        PersonIO pio = new PersonIO();
        System.out.println("    Номер: " + obj.getNumber());
        if (obj.getResidents().size() > 0) {
            System.out.println("    Жители:");
            for (int i = 0; i < obj.getResidents().size(); i++){
                pio.print(obj.getResidents().get(i));
            }
        }
    }

    @Override
    public Aparts read() {
        return null;
    }
}
