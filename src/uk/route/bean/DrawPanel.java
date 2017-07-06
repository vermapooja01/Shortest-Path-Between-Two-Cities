package uk.route.bean;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import uk.route.CityRoute;
import uk.route.PointData;
import uk.route.Route;
import uk.route.Utility;

public class DrawPanel extends JPanel{
    
    private Image image;
    private boolean validImage;
    private ArrayList<Route> routes = new ArrayList<Route>();
    
    public void clearMap(){
        setRoutes();
        repaint();
    }
    
    public DrawPanel(){
        try{
            image = ImageIO.read(getClass().getResource("/uk/route/pics/uttarakhand.png"));
            validImage = true;
        }
        catch(Exception ex){
            validImage = false;
            System.out.println("Cannot load image : " + ex.getMessage());
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(validImage){
            g.drawImage(image, 0, 0, 1000, 714, this);
        }
        else{
            g.drawString("Cannot load map...",300,300);
        }
        
        if(routes!=null && !routes.isEmpty()){
            
            for(Route route : routes){

                if(!route.isSmallest())
                    continue;

                ArrayList<PointData> points = route.getPoints();

                System.out.println(">>" + points.size());
                
                if(route.isSmallest()){
                    g.setColor(Color.RED);
                }
                else{
                    g.setColor(Color.BLACK);
                }
                
                int x1 = points.get(0).startPoint.x;
                int y1 = points.get(0).startPoint.y;

                for(int i=0;i<points.size();i++){

                    System.out.println(points.get(i));
                    
                    int x2 = points.get(i).startPoint.x;
                    int y2 = points.get(i).startPoint.y;

                    float[] dash = { 2f, 0f, 2f };
                    BasicStroke bs = new BasicStroke(1, BasicStroke.CAP_BUTT,  BasicStroke.JOIN_ROUND, 1.0f, dash, 2f );

                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(bs);
                    g.drawLine(x1, y1, x2, y2);

                    x1 = x2;
                    y1 = y2;
                }
                
                break;
            }
        }
    }

    public ArrayList<Route> getRoutes() {
        return routes;
    }

    private void setRoutes() {
        routes = null;
    }

    public void drawRoute(ArrayList<CityRoute> cityRoutes) {
        
        if(routes!=null)
        routes.clear();
        
        Route route = null;
        
        if(cityRoutes.size()>0){
            
            String prevVia = null;
            boolean added = false;
            
            boolean firstTime = true;
            
            for(int ix=0;ix<cityRoutes.size();ix++){
                
                CityRoute cityRoute = cityRoutes.get(ix);
                        
                PointData tdata = null;
                
                if(firstTime){
                    tdata = Utility.getPointData(cityRoute.getSource());
                    firstTime = !firstTime;
                    --ix;       // reset to 0 position
                }
                else
                    tdata = Utility.getPointData(cityRoute.getDestination());
                
                if(prevVia==null){
                    route = new Route();             
                
                    route.setFrom(cityRoute.getFrom());
                    route.setTo(cityRoute.getTo());
                    route.setVia(cityRoute.getVia());

                    route.getPoints().add(tdata);
                    added = false;
                    prevVia = cityRoute.getVia();
                }
                else if(!prevVia.equals(cityRoute.getVia())){
                    prevVia = cityRoute.getVia();
                    added = true;
                    routes.add(route);
                    
                    route = new Route();

                    route.setFrom(cityRoute.getFrom());
                    route.setTo(cityRoute.getTo());
                    route.setVia(cityRoute.getVia());     
                    
                    route.getPoints().add(tdata);                    
                }
                else{
                    route.getPoints().add(tdata);
                    added = false;
                }

            }
            
            if(!added){
                routes.add(route);
            }        
            
            if(routes.size()>0) {
                Utility.findSmallestRoute(routes);

                repaint();
            }
        }
    }
}
