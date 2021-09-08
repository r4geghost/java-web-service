package com.practice.practicedyusov;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private final AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    // на главной (при запуске)
    @GetMapping
    public String hello() {
        return "Welcome! Commands: /info, /all, /{id}, /add, /delete, /save, /load";
    }
    // на странице /info
    // @GetMapping("/info")
    // public String info() {
    //     return "RESTful Web-service by Dyusov, var 18, MIIT";
    // }
    @GetMapping("/info")
    public String info() {
        return appService.info();
    }
    @GetMapping("/all") 
    public ArrayList<Light> showAll() {
        return appService.showAll();
    }
    @GetMapping("/{id}")
    public Light showById(@PathVariable("id") int id) {
        return appService.showById(id);
    }
    //добавление нового объекта
    @PostMapping("/add")
    public void addLight(@RequestBody Light light) {
        appService.addLight(light);
    }
    //удаление существующего объекта по его ID
    @DeleteMapping("/delete")
    public void deleteLight(@RequestParam(value = "id") Integer id) {
        appService.deleteLight(id);
    }    
    // сохранение данных в файл
    @GetMapping("/save")
    public String saveToFile() throws IOException {
        appService.saveToFile();
        return "Save complete!";
    }
    // загрузка данных из файла
    @GetMapping("/load")
    public String loadFromFile() throws IOException {
        appService.loadFromFile();
        return "Load complete!";
    }
}
