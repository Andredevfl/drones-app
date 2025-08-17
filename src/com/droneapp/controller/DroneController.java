package com.droneapp.controller;

import com.droneapp.model.Drone;
import com.droneapp.view.DroneView;
import com.droneapp.utils.DroneDataLoader;

import java.util.List;

public class DroneController {
    private DroneView view;
    private List<Drone> drones;

    public DroneController() {
        // Carregar os dados dos drones
        this.drones = DroneDataLoader.loadDroneData();
        // Criar a view
        this.view = new DroneView(drones);
    }

    // Método para iniciar o aplicativo
    public void start() {
        view.display();
    }

    public static void main(String[] args) {
        DroneController controller = new DroneController();
        controller.start();
    }
}