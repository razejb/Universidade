public class ElectricCar extends Car{

    private int rechargeHour ;

    public ElectricCar(int rechargeHour) {
        this.rechargeHour = rechargeHour;
    }

    public ElectricCar() {

    }

    public ElectricCar(ElectricCar car){

        this.make = car.make ;
        this.weight = car.weight ;
        this.color = new String(car.color) ;
        this.rechargeHour = car.rechargeHour ;

    }


}
