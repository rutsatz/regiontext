package javafxregion;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

/**
 *
 * @author rutsa
 */
public class Plate extends Region {

    public Plate(){
        
        setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        setPrefSize(100, 100);
        setLayoutX(300);
        
        AnchorPane.setRightAnchor(this, 22d);
    }
    
}
