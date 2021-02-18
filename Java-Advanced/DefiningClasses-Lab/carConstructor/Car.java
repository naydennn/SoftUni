package CarConstructor;

public class Car {
    String brand;
    String model;
    int horsePower;

    public Car(String brand){
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car(String brand, String model, int horsePower){
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }



    public String getBrand(){
        return this.brand;
    }
    public String getModel(){
        return this.model;
    }
    public int getHorsePower(){
        return this.horsePower;
    }


    @Override
    public String toString(){
        return String.format("The car is: %s %s - %d HP.", getBrand(), getModel(),getHorsePower());
    }


}
