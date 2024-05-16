public class Fish extends Animal {

    private int fins ;
    private int gills ;

    public Fish(String type, double weight, int fins, int gills) {
        super(type, "small", weight);
        this.fins = fins;
        this.gills = gills;
    }

    private void moveMuscles(){

        System.out.print("muscles moving ");
    }

    private void moveBackFin(){

        System.out.print("backfin moving ");
    }

    @Override
    public void move(String speed) {
        super.move(speed);
        if(speed == "fast"){
            moveBackFin();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Fish{" +
                "fins=" + fins +
                ", gills=" + gills +
                "} " + super.toString();
    }
}
