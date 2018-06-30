package javafxregion;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author rutsa
 */
public class RegionTest extends Region {

    Circle redCircle;
    Circle yellowCircle;
    Circle greeCircle;

    public RegionTest() {

        redCircle = new Circle(100, 100, 50, Color.RED);
        yellowCircle = new Circle(100, 200, 50, Color.YELLOW);
        greeCircle = new Circle(100, 300, 50, Color.GREEN);

        setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        setPrefSize(150, 360);

        makeCircleResizable(redCircle, 0.2);
        makeCircleResizable(yellowCircle, 0.5);
        makeCircleResizable(greeCircle, 0.8);

        this.getChildren().addAll(redCircle, yellowCircle, greeCircle);

    }

    private void makeCircleResizable(Circle circle, double scale) {
        circle.radiusProperty().bind(Bindings.createDoubleBinding(() -> {
            return (this.getMinWidth() - 40) / 2;
        }, this.widthProperty()));

        circle.centerXProperty().bind(Bindings.createDoubleBinding(() -> {
            return this.getMinWidth() / 2;
        }, this.widthProperty()));

        circle.centerYProperty().bind(Bindings.createDoubleBinding(() -> {
            return (this.getMinHeight() * scale);
        }, this.heightProperty()));
    }
}
