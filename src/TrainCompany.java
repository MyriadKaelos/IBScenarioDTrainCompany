import java.util.ArrayList;

public class TrainCompany {
    ArrayList<Journey> arrayList = new ArrayList<Journey>();
    private String companyName;
    private String companyCode;
    private int numberOfJourneys;
    private Journey[] journeyHistory = new Journey[100000];
    public TrainCompany(String x, String y)  {
        this.companyName = x;
        this.companyCode = y;
        this.numberOfJourneys = 0;
    }
    public TrainCompany(){}
    // accessor and mutator methods
    Journey getJourney(int x) {
        return journeyHistory[x];
    }
    public void addJourney(Journey j) {
        journeyHistory[numberOfJourneys] = j;
        numberOfJourneys++;
    }
    public String getCompanyCode() {
        return this.companyCode;
    }
    public int getNumberOfJourneys() {
        return this.numberOfJourneys;
    }
    public double averageDelay() {
        int x = 0;
        int y = 0;
        for(int i = 0; i < this.journeyHistory.length; i ++) {
            if(this.journeyHistory[i].weatherRelated) {
                y += this.journeyHistory[i].delay;
                x++;
            }
        }
        return y/x;
    }
    // returns the average delay for all of a company’s journeys
    public String longestDelay(Codes[] c) {
        int y = 0;
        Journey j = journeyHistory[0];
        String r = "";
        for(int i = 0; i < numberOfJourneys; i ++) {
            if(journeyHistory[i].delay > y) {
                y = journeyHistory[i].delay;
                j = journeyHistory[i];
            }
        }
        for(int i = 0; i < c.length; i ++) {
            if(c[i].getRouteCode() == j.routeCode) {
                r = c[i].getRouteName();
            }
        }
        return r;
    }
    // returns the route name for the journey with the longest delay
    public String toString(Codes[] c) {
        return this.companyName + " : Average Delay = " + averageDelay() + " minutes : Longest Delay = " + longestDelay(c);
    }
    public void Convert() {

        for(int i = 0; i < journeyHistory.length; i ++) {
            for(int o = 0; o < arrayList.size(); o ++) {
                if(arrayList.get(o).routeCode.equals(journeyHistory[i].routeCode)) {
                    arrayList.add(journeyHistory[i]);
                }
            }
        }
    }
}