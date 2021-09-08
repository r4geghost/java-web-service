// package com.practice.practicedyusov;

// import java.util.List;
// import java.util.ArrayList;
// import java.io.FileReader;
// import java.io.FileWriter;
// import au.com.bytecode.opencsv.CSVWriter;
// import au.com.bytecode.opencsv.CSVReader;

// public class mainClass 
// {
//     public static void main(String[] args) throws Exception
//     {
//         // конструктор
//         Light light = new Light(0,"yellow", 240, 20, 6000);
//         System.out.println("Конструктор:");
//         System.out.println(light.getId());
//         System.out.println(light.getHue());
//         System.out.println(light.getPower());
//         System.out.println(light.getLux());
//         System.out.println(light.getLifeTime());

//         // // конструктор по умолчанию
//         // Light simpleLight = new Light();
//         // System.out.println("Конструктор по умолчанию:");
//         // System.out.println(simpleLight.getId());
//         // System.out.println(simpleLight.getHue());
//         // System.out.println(simpleLight.getPower());
//         // System.out.println(simpleLight.getLux());
//         // System.out.println(simpleLight.getLifeTime());


//         Light lamp = new Light(1,"blue", 50, 30, 5500);
//         // Список из объектов класса 
//         ArrayList<Light> listOfLight = new ArrayList<Light>();
//         listOfLight.add(light);
//         listOfLight.add(lamp);
//         // БИБЛИОТЕКА OpenCSV //     
//         // тест записи данных в новый csv файл (если файла нет, он сам создается в папке с проектом)
//         String csv = "data.csv";
//         CSVWriter writer = new CSVWriter(new FileWriter(csv));
//         // проходимся по списку объектов класса и заносим информацию в файл (построчно для каждого элемента списка)
//         for (int i = 0; i < listOfLight.size(); i++) {
//             String [] record = 
//             String.valueOf(listOfLight.get(i).getId() + "," + 
//             listOfLight.get(i).getHue() + "," +
//             String.valueOf(listOfLight.get(i).getPower()) + "," + 
//             String.valueOf(listOfLight.get(i).getLux() + "," + 
//             String.valueOf(listOfLight.get(i).getLifeTime()))).split(",");
//             writer.writeNext(record);
//         }
//         writer.close();
        
//         // тест чтения csv файла (читает все содержимое файла)
//         CSVReader reader = new CSVReader(new FileReader("data.csv"));
//         // создаем список для хранения записей
//         List<String[]> allData = reader.readAll();
//         for (String[] counter : allData) {
//             for (int i = 0; i < 4; i++) {
//                 // System.out.println(counter[i]);
//             }
//         }

//     }
// }



