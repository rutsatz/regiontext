package javafxregion.component;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author rutsa
 */
public class Laco extends Region {

    private final Rectangle laco1;

    private final Rectangle laco2;

    public Laco() {

        setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        setLayoutX(300);
        setLayoutY(150);

        laco1 = new Rectangle();
        laco2 = new Rectangle();

        setMinSize(85, 180);

        initLaco(laco1);
        initLaco(laco2);

        laco1.setLayoutX(20);
        laco2.setLayoutX(50);

        getChildren().addAll(laco1, laco2);
    }

    public void processIntersection(Car car) {

//        System.out.println(this.getLaco1().parentToLocal(this.getLaco1().getBoundsInParent()).intersects( car.getLeftFrontWheel().parentToLocal(car.getBoundsInParent())));
//        System.out.println(this.getLaco1().getParent().getParent().getBoundsInParent());
//        System.out.println( car.getLeftFrontWheel().getParent().getParent().getBoundsInParent());
        System.out.println(car.getLeftFrontWheel().localToScene(car.getLeftFrontWheel().getBoundsInLocal())
                .intersects(this.getLaco1().localToScene(this.getLaco1().getBoundsInLocal()))
        );
    }

    private void initLaco(Rectangle rectangle) {
        rectangle.setHeight(170);
        rectangle.setWidth(20);
        rectangle.setLayoutY(5);
        rectangle.setFill(Color.DARKGRAY);
    }

    public Rectangle getLaco1() {
        return laco1;
    }

    public Rectangle getLaco2() {
        return laco2;
    }

}
