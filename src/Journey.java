public class Journey {

    public String routeCode;
    public int delay;
    public boolean weatherRelated;

    public Journey(String x, int y, boolean z) {
        this.routeCode = x;
        this.delay = y;
        this.weatherRelated = z;
    }
    //accessor and mutator methods
    public int getDelay() {
        return this.delay;
    }
}