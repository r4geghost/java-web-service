package com.practice.practicedyusov;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

@Service
public class AppService {
    // чтобы использовать массив объектов из главного класса
    // (где запускается программа)
    private final PracticeDyusovApplication app;
    public AppService(PracticeDyusovApplication app) {
        this.app = app;
    }
    private static int lightCount;

    public ArrayList<Light> showAll() {
        return app.listOfLight;
    }
    public Light showById(int id) {
        for (int i = 0; i < app.listOfLight.size(); i++) {
            if (app.listOfLight.get(i).getId() == id)  {
                return app.listOfLight.get(i);
            }
        }
        return null;
    }
    public void addLight(Light light) {
        if (app.listOfLight.isEmpty() == false) { // если список не пустой
            int lastLight = app.listOfLight.size() - 1;
            if (app.listOfLight.get(lastLight).getId() >= lightCount) { // чтобы при загрузке данных не сбился счет по ID
                lightCount = (app.listOfLight.get(lastLight).getId()) + 1; // присваеваем счетчику ID последнего элемента в списке
            }
        }
        light.setId(lightCount++);
        app.listOfLight.add(light);
    }
    public void deleteLight(int id) {
        for (int i = 0; i < app.listOfLight.size(); i++) {
            if (app.listOfLight.get(i).getId() == id)  {
                app.listOfLight.remove(i);
            }
        }
    }
    public void saveToFile() throws IOException {
        String csv = "data.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        for (int i = 0; i < app.listOfLight.size(); i++) {
            String [] record = 
            String.valueOf(app.listOfLight.get(i).getId() + "," + 
            app.listOfLight.get(i).getHue() + "," +
            String.valueOf(app.listOfLight.get(i).getPower()) + "," + 
            String.valueOf(app.listOfLight.get(i).getLux() + "," + 
            String.valueOf(app.listOfLight.get(i).getLifeTime()))).split(",");
            writer.writeNext(record);
        }
        writer.close();
    }
    public void loadFromFile() throws IOException {
        String csv = "data.csv";
        CSVReader reader = new CSVReader(new FileReader(csv));
        List<String[]> allData = reader.readAll();
        app.listOfLight.clear(); // делаем список пустым
        lightCount = 0; // обнуляем счетчик
        for (String[] counter : allData) {
            Light light = new Light();
            app.listOfLight.add(light);
            for (int i = 0; i < 4; i++) {
                app.listOfLight.get(lightCount).setId(Integer.parseInt(counter[0]));
                app.listOfLight.get(lightCount).setHue(counter[1]);
                app.listOfLight.get(lightCount).setPower(Integer.parseInt(counter[2]));
                app.listOfLight.get(lightCount).setLux(Integer.parseInt(counter[3]));
                app.listOfLight.get(lightCount).setLifeTime(Integer.parseInt(counter[4]));
            }
            lightCount++;
        }
    }
    public String info() {
        return "RESTful service by Dyusov, var 18, MIIT. Amount of objects: " + app.listOfLight.size();
    }
}