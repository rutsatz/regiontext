package javafxregion.component;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;

/**
 *
 * @author rutsa
 */
public class Car extends Region {

    private final Line leftFrontWheel;
    private final Line rightFrontWheel;
    private final Line leftRearWheel;
    private final Line rightRearWheel;

    public Car() {

        setMinSize(130, 50);
        setLayoutX(100);
        setLayoutY(200);
        setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        leftFrontWheel = new Line();
        rightFrontWheel = new Line();
        leftRearWheel = new Line();
        rightRearWheel = new Line();

        leftFrontWheel.setLayoutX(101);
        leftFrontWheel.setLayoutY(27);
        leftFrontWheel.setStartX(-7);
        leftFrontWheel.setStartY(-27);
        leftFrontWheel.setEndX(-7);
        leftFrontWheel.setEndY(-5);

        rightFrontWheel.setLayoutX(101);
        rightFrontWheel.setLayoutY(53);
        rightFrontWheel.setStartX(-7);
        rightFrontWheel.setStartY(-27);
        rightFrontWheel.setEndX(-7);
        rightFrontWheel.setEndY(-5);

        leftRearWheel.setLayoutX(43);
        leftRearWheel.setLayoutY(27);
        leftRearWheel.setStartX(-8);
        leftRearWheel.setStartY(-27);
        leftRearWheel.setEndX(-8);
        leftRearWheel.setEndY(-6);

        rightRearWheel.setLayoutX(43);
        rightRearWheel.setLayoutY(54);
        rightRearWheel.setStartX(-8);
        rightRearWheel.setStartY(-27);
        rightRearWheel.setEndX(-8);
        rightRearWheel.setEndY(-6);
        
        getChildren().addAll(leftFrontWheel,rightFrontWheel,leftRearWheel,rightRearWheel);

    }

    public Line getLeftFrontWheel() {
        return leftFrontWheel;
    }

    public Line getRightFrontWheel() {
        return rightFrontWheel;
    }

    public Line getLeftRearWheel() {
        return leftRearWheel;
    }

    public Line getRightRearWheel() {
        return rightRearWheel;
    }
    
    
}
