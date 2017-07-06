package uk.route.bean;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import uk.route.CityMapper;
import uk.route.PointMapper;
import uk.route.Utility;

public class MapperPanel extends JPanel implements MouseMotionListener,MouseListener{
    
    private Point startPoint, endPoint;
    
    private Image image;
    private boolean validImage;
    
    PointMapper pointMapper;
    
    public void clearMap(){
        repaint();
    }
    
    public MapperPanel(){
        try{
            image = ImageIO.read(getClass().getResource("/uk/route/pics/uttarakhand.png"));
            validImage = true;
        }
        catch(Exception ex){
            validImage = false;
            System.out.println("Cannot load image : " + ex.getMessage());
        }
        
        addMouseListener(this);
        addMouseMotionListener(this);
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
        
        if(startPoint!=null && endPoint!=null){
            int x = startPoint.x;
            int y = startPoint.y;
            
            int w = endPoint.x - x;
            int h = endPoint.y - y;
            
            g.drawRect(x, y, w, h);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        endPoint = e.getPoint();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = e.getPoint();
        repaint();
        
        pointMapper = new PointMapper(CityMapper.myself, true);
        pointMapper.setPanel(this);
        pointMapper.setVisible(true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void saveMapping(String city) {
        int x = startPoint.x;
        int y = startPoint.y;

        int w = endPoint.x - x;
        int h = endPoint.y - y;

        Utility.saveCityMapping(x, y, w, y, city);
        
        startPoint = null;
        endPoint = null;
        
        repaint();
    }
}
