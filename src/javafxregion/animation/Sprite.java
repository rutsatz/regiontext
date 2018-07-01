package javafxregion.animation;

import javafx.geometry.Bounds;
import javafx.scene.layout.Region;

public class Sprite {

    private Region object;
    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;

    public Sprite() {
        positionX = 0;
        positionY = 0;
        velocityX = 0;
        velocityY = 0;
    }

    public void setImage(Region o) {
        object = o;
        width = o.getWidth();
        height = o.getHeight();
    }


    public void setPosition(double x, double y) {
        positionX = x;
        positionY = y;
    }

    public void setVelocity(double x, double y) {
        velocityX = x;
        velocityY = y;
    }

    public void addVelocity(double x, double y) {
        velocityX += x;
        velocityY += y;
    }

    public void update(double time) {
        positionX += velocityX * time;
        positionY += velocityY * time;
        
        object.setLayoutX(positionX);
        object.setLayoutY(positionY);
    }

    public Bounds getBoundary() {
        return object.getBoundsInParent();
    }

    public boolean intersects(Sprite s) {
        return s.getObject().getBoundsInParent().intersects(this.getObject().getBoundsInParent());
    }

    public String toString() {
        return " Position: [" + positionX + "," + positionY + "]"
                + " Velocity: [" + velocityX + "," + velocityY + "]";
    }
    
    public Region getObject(){
        return this.object;
    }
}
