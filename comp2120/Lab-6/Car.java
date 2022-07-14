package Lab3;

public class Car {
    private double efficiency; //miles per gallon
    private double totalMiles;
    private double milesLeft;
    private double gas;

    public Car(double efficiency){
        this.efficiency = efficiency;   //miles per gallon
        gas = 0;
    }

    public void addGas(int gas) {
        this.gas += gas;
    }
//You may assume that the drive method is never called with a
// distance that consumes more than the available gas.
    public void drive(int driven){
        totalMiles = gas * efficiency;  //gallons* mpg = miles
        milesLeft = totalMiles - driven;
    }

    public double getGasInTank() {
        gas = milesLeft/efficiency;
        //gas = gas - (milesLeft/efficiency);   //Gas used
        return gas;
    }
}
