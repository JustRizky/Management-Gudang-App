package controller;

import java.util.ArrayList;

import model.ShoesModel;

public class ShoesController {
    private ArrayList<ShoesModel> shoesList;
    private ShoesJsonController jsonController;

    public ShoesController() {
        shoesList = new ArrayList<>();
        jsonController = new ShoesJsonController();
    }

    public void addShoes(ShoesModel shoes) {
        shoesList.add(shoes);
        jsonController.saveDatabase(shoesList);
    }

    public boolean updateShoes(int shoesId, String newName, String newBrand, String newType, int newStock) {
        for (ShoesModel shoes : shoesList) {
            if (shoes.getId() == shoesId) {
                shoes.setName(newName);
                shoes.setBrand(newBrand);
                shoes.setType(newType);
                shoes.setStock(newStock);
                jsonController.saveDatabase(shoesList);
                return true;
            }
        }
        return false;
    }

    public boolean editShoesStock(int shoesId, int newStock) {
        for (ShoesModel shoes : shoesList) {
            if (shoes.getId() == shoesId) {
                shoes.setStock(newStock);
                jsonController.saveDatabase(shoesList);
                return true;
            }
        }
        return false;
    }

    public ShoesModel searchByName(String name) {
        for (ShoesModel shoes : shoesList) {
            if (shoes.getName().equalsIgnoreCase(name)) {
                return shoes;
            }
        }
        return null;
    }

    public ArrayList<ShoesModel> searchByBrand(String brand) {
        ArrayList<ShoesModel> matchingShoesBrand = new ArrayList<>();
        for (ShoesModel shoes : shoesList) {
            if (shoes.getBrand().equalsIgnoreCase(brand)) {
                matchingShoesBrand.add(shoes);
            }
        }
        return matchingShoesBrand;
    }

    public boolean deleteShoes(int shoesIdToDelete) {
        for (ShoesModel shoes : shoesList) {
            if (shoes.getId() == shoesIdToDelete) {
                shoesList.remove(shoes);
                jsonController.saveDatabase(shoesList);
                return true;
            }
        }
        return false;
    }

    public int getTotalStock() {
        int totalStock = 0;
        for (ShoesModel shoes : shoesList) {
            totalStock += shoes.getStock();
        }
        return totalStock;
    }

    public ArrayList<ShoesModel> getAllShoes() {
        return new ArrayList<>(shoesList);
    }

    public int generateUUID() {
        return (int) System.currentTimeMillis();
    }
}
