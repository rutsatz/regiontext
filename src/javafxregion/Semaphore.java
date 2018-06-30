package javafxregion;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

/**
 *
 * @author rutsa
 */
public final class Semaphore extends Region {

    private final Label text;
    private final Circle redCircle;
    private final Circle yellowCircle;
    private final Circle greeCircle;

    /**
     * Id do semaforo enviado pela supervisora. Exemplo: 10, 11
     */
    private int idSemaphore;

    /**
     * Id do semaforo convertido para exibicao visual.
     */
    private int idVisible;

    public Semaphore(int idSemaphore) {

        setIdSemaphore(idSemaphore);

        text = new Label("Semáforo " + getIdVisible());
        text.setTextFill(Color.WHITE);
        text.layoutXProperty().bind(Bindings.createDoubleBinding(() -> {
            return (this.getWidth() / 2) - (text.getWidth() / 2);
        }, this.widthProperty()));

        redCircle = new Circle();
        yellowCircle = new Circle();
        greeCircle = new Circle();
        
        setBackground(new Background(new BackgroundFill(Color.web("#25282c"),
                new CornerRadii(5), Insets.EMPTY)));
        setMinSize(150, 390);
        getChildren().addAll(text, redCircle, yellowCircle, greeCircle);

        initCircle(redCircle);
        initCircle(yellowCircle);
        initCircle(greeCircle);

        makeCircleResizable(redCircle, 0.2);
        makeCircleResizable(yellowCircle, 0.5);
        makeCircleResizable(greeCircle, 0.8);

        desligarTodas();
    }

    /**
     * Desliga todas as luzes.
     */
    public void desligarTodas() {
        redCircle.setFill(Color.web("#281b1b"));
        yellowCircle.setFill(Color.web("#292c0c"));
        greeCircle.setFill(Color.web("#112510"));
    }

    /**
     * Seta atributos comuns aos circulos.
     *
     * @param circle
     */
    private void initCircle(Circle circle) {
        circle.setStroke(Color.BLACK);
        circle.setStrokeType(StrokeType.INSIDE);
    }

    /**
     * Bind para auto dimensionar os circulos.
     *
     * @param circle
     * @param yPercentPos Percentual da posição do circulo em relação ao Parent.
     */
    private void makeCircleResizable(Circle circle, double yPercentPos) {
        circle.radiusProperty().bind(Bindings.createDoubleBinding(() -> {
            return (this.getMinWidth() - 40) / 2;
        }, this.widthProperty()));

        circle.centerXProperty().bind(Bindings.createDoubleBinding(() -> {
            return this.getMinWidth() / 2;
        }, this.widthProperty()));

        circle.centerYProperty().bind(Bindings.createDoubleBinding(() -> {
            return (this.getMinHeight() * yPercentPos);
        }, this.heightProperty()));
    }

    public int getIdSemaphore() {
        return idSemaphore;
    }

    public int getIdVisible() {
        return idVisible;
    }

    private void setIdSemaphore(int idSemaphore) {
        this.idSemaphore = idSemaphore;
        if (idSemaphore == 10) {
            this.idVisible = 1;
        } else {
            this.idVisible = 2;
        }
    }
}
