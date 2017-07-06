package uk.route;

import java.util.ArrayList;

public class Route {

    private ArrayList<PointData> points;
    private boolean smallest;
    private String from;
    private String to;
    private String via;
    
    public Route(){
        points = new ArrayList<PointData>();
        smallest = false;
    }
    
    public void setSmallest(boolean smallest){
        this.smallest = smallest;
    }
    
    public boolean isSmallest(){
        return smallest;
    }
    
    public ArrayList<PointData> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<PointData> points) {
        this.points = points;
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the via
     */
    public String getVia() {
        return via;
    }

    /**
     * @param via the via to set
     */
    public void setVia(String via) {
        this.via = via;
    }
}
