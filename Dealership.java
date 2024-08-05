package projectFinal;

import java.util.ArrayList;
import java.util.List;

class Dealership {
    private List<Automobile> inventory;

    // Constructor
    public Dealership() {
        this.inventory = new ArrayList<>();
    }

    // Method to add a new vehicle
    public String addVehicle(Automobile vehicle) {
        try {
            this.inventory.add(vehicle);
            return "Vehicle added successfully";
        } catch (Exception e) {
            return "Failed to add vehicle: " + e.getMessage();
        }
    }

    // Method to remove a vehicle
    public String removeVehicle(Automobile vehicle) {
        if (this.inventory.contains(vehicle)) {
            this.inventory.remove(vehicle);
            return "Vehicle removed successfully";
        } else {
            return "Vehicle not found in inventory";
        }
    }

    // Method to list all vehicles
    public List<Automobile> listVehicles() {
        return this.inventory;
    }
}
