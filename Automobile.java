package projectFinal;

class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // Default constructor
    public Automobile() {
        this.make = "";
        this.model = "";
        this.color = "";
        this.year = 0;
        this.mileage = 0;
    }

    // Parameterized constructor
    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    // Method to list vehicle information
    public String[] listVehicleInfo() {
        return new String[] {this.make, this.model, this.color, String.valueOf(this.year), String.valueOf(this.mileage)};
    }

    // Override equals method for proper comparison in removeVehicle
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Automobile that = (Automobile) obj;
        return year == that.year &&
               mileage == that.mileage &&
               make.equals(that.make) &&
               model.equals(that.model) &&
               color.equals(that.color);
    }
}
