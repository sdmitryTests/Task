package hse.projects.taskone.IO;

import hse.projects.taskone.entities.Building;

public class BuildingIO implements TaskIO<Building>{

    @Override
    public void print(Building obj) {
        ApartIO aio = new ApartIO();
        System.out.println("  Номер: " + obj.getNumber());
        if (obj.getAparts().size() > 0) {
            System.out.println("  Квартиры:");
            for (int i = 0; i < obj.getAparts().size(); i++){
                aio.print(obj.getAparts().get(i));
            }
        }
    }

    @Override
    public Building read() {
        return null;
    }
}
