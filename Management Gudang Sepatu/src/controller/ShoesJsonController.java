package controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.ShoesModel;

public class ShoesJsonController {
    private static final String JSON_PATH = "src/database/shoes.json";
    private Gson gson;

    public ShoesJsonController() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void loadDatabase(ArrayList<ShoesModel> shoesList) {
        try (FileReader fileReader = new FileReader(JSON_PATH)) {
            Type listType = new TypeToken<ArrayList<ShoesModel>>() {
            }.getType();
            ArrayList<ShoesModel> loadedList = gson.fromJson(fileReader, listType);
            if (loadedList != null) {
                shoesList.clear();
                shoesList.addAll(loadedList);
            }
        } catch (IOException e) {
            System.out.println("Error Saat Load Database!");
        }
    }

    public void saveDatabase(ArrayList<ShoesModel> shoesList) {
        try (FileWriter fileWriter = new FileWriter(JSON_PATH)) {
            gson.toJson(shoesList, fileWriter);
        } catch (IOException e) {
            System.out.println("Gagal Melakukan Save Database!.");
        }
    }
}
