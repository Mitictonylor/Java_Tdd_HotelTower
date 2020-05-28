public class Booking {
    private Bedroom bedroom;
    private int numOfNights;

    public Booking(Bedroom bedroom, int numOfNights){
        this.bedroom = bedroom;
        this.numOfNights = numOfNights;
    }

    public Bedroom getBedroom() {
        return this.bedroom;
    }

    public int getNumOfNights() {
        return this.numOfNights;
    }

    public double totalCost(){
        double cost = this.bedroom.getRate();
        return cost * this.getNumOfNights();
    }
}
