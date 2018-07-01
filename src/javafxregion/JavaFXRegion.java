package javafxregion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafxregion.animation.Sprite;
import javafxregion.component.CanvasComponent;
import javafxregion.component.Car;
import javafxregion.component.Laco;

/**
 *
 * @author rutsa
 */
public class JavaFXRegion extends Application {

    static HashSet<String> currentlyActiveKeys;

    static Scene mainScene;

    Long lastNanoTime = new Long(System.nanoTime());

    @Override
    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
        AnchorPane root = new AnchorPane();
        Semaphore regionTest = new Semaphore(10);

        DragResizer.makeResizable(regionTest);
//        DragResizeMod.makeResizable(regionTest);

        Plate plate = new Plate();

        DragResizer.makeResizable(plate);

        Laco laco = new Laco();
        DragResizer.makeResizable(laco);

        Car car = new Car();
        DragResizer.makeResizable(car);

//        root.getChildren().addAll(laco, car);
//        root.getChildren().addAll(regionTest, plate);
        mainScene = new Scene(root, 800, 600);

        Sprite lacoSprite = new Sprite();
        lacoSprite.setImage(laco);

//        prepareActionHandlers();
        Sprite carSprite = new Sprite();
        carSprite.setImage(car);

        ArrayList<Sprite> vehiclesList = new ArrayList<Sprite>();
        vehiclesList.add(carSprite);

        root.getChildren().addAll(lacoSprite.getObject(), carSprite.getObject());

        ArrayList<String> input = new ArrayList<String>();

        mainScene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                if (!input.contains(code)) {
                    input.add(code);
                }
            }
        });

        mainScene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                input.remove(code);
            }
        });

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
//                System.out.println("now" + currentNanoTime);

                // calculate time since last update.
                double elapsedTime = (currentNanoTime - lastNanoTime) / 1000000000.0;
                lastNanoTime = currentNanoTime;

                // game logic
                lacoSprite.setVelocity(0, 0);
                if (input.contains("LEFT")) {
                    lacoSprite.addVelocity(-50, 0);
                }
                if (input.contains("RIGHT")) {
                    lacoSprite.addVelocity(50, 0);
                }
                if (input.contains("UP")) {
                    lacoSprite.addVelocity(0, -50);
                }
                if (input.contains("DOWN")) {
                    lacoSprite.addVelocity(0, 50);
                }

                lacoSprite.update(elapsedTime);

                // collision detection
                Iterator<Sprite> vehiclesIter = vehiclesList.iterator();
                while (vehiclesIter.hasNext()) {
                    Sprite vehicle = vehiclesIter.next();
//                    System.out.println("intersects " +lacoSprite.intersects(moneybag));
                    if (lacoSprite.intersects(carSprite)) {
                        ((Laco) lacoSprite.getObject()).processIntersection((Car) vehicle.getObject());
//                        System.out.println(currentNanoTime + " intersect true");
                    }
                }

            }
        };

        gameLoop.start();

//        CanvasComponent canvasComponent = new CanvasComponent();
//        System.out.println("canvasComponent "+canvasComponent.getCanvas() == null);
//        root.getChildren().add(canvasComponent.getCanvas());
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private static void prepareActionHandlers() {
        // use a set so duplicates are not possible
        currentlyActiveKeys = new HashSet<String>();
        mainScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode().toString());
                currentlyActiveKeys.add(event.getCode().toString());
            }
        });
        mainScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode().toString());
                currentlyActiveKeys.remove(event.getCode().toString());
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
