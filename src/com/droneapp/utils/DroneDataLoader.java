package com.droneapp.utils;

import com.droneapp.model.Drone;

import java.util.List;
import java.util.Arrays;

public class DroneDataLoader {
    public static List<Drone> loadDroneData() {
        // Exemplificando dados estáticos dos drones, mas em um caso real, você pode carregar de um banco de dados ou arquivo.
        return Arrays.asList(
            new Drone("Drone A", "resourses/drone1.png", "Drone A: Excelente para fotos", "Drone A: Câmera 4K, 30min de voo"),
            new Drone("Drone B", "resourses/drone2.png", "Drone B: Ideal para vídeos", "Drone B: Câmera 1080p, 45min de voo"),
            new Drone("Drone C", "resourses/drone3.png", "Drone C: Compacto e leve", "Drone C: Câmera 720p, 25min de voo")
        );
    }
}