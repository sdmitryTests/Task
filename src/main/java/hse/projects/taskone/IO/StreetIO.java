package hse.projects.taskone.IO;

import hse.projects.taskone.entities.Street;

public class StreetIO implements TaskIO<Street>{

    @Override
    public void print(Street obj) {
        BuildingIO bio = new BuildingIO();
        System.out.println("Улица: " + obj.getStreetName());
        if (obj.getBuildings().size() > 0) {
            System.out.println("Дома:");
            for (int i = 0; i < obj.getBuildings().size(); i++){
                bio.print(obj.getBuildings().get(i));
            }
        }
    }

    @Override
    public Street read() {
        return null;
    }
}
