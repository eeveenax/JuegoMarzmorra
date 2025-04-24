package com.eve;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase <code>App</code> es la aplicación principal que extiende la clase
 * <code>Application</code> de JavaFX.
 * Esta clase es responsable de iniciar la aplicación, configurar la ventana
 * principal (Stage),
 * establecer el icono de la ventana, y gestionar las escenas mediante el
 * <code>SceneManager</code>.
 */
public class App extends Application {

    /**
     * Método que se ejecuta cuando se inicia JavaFX.
     * 
     * Se establecen: título de la ventana, icono, escenas disponibles.
     * Se inicializa el <code>SceneManager</code>.
     * Se carga la escena principal.
     * 
     * @param stage el Stage que representa la ventana principal de la app.
     * @throws IOException si ocurre algún error cuando se cargan los recursos o las
     *                     vistas.
     */
    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws IOException {
        // Establece el título de la ventana
        stage.setTitle("Bichitos y Mazmorras");

        // Icono de la ventana
        stage.getIcons().add(new Image(App.class.getResource("images/icono.png").toExternalForm()));

        // Instancia del SceneManager
        SceneManager sm = SceneManager.getInstance();

        // Ruta de estilos, para que quede fancy
        sm.init(stage, "style");

        // Configura las escenas con identificadores
        sm.setScene(SceneID.TERTIARY, "tertiary");
        sm.setScene(SceneID.QUATERNARY, "quaternary");
        sm.setScene(SceneID.QUINTENNIAL, "quintennial");
        sm.setScene(SceneID.SECONDARY, "secondary");
        sm.setScene(SceneID.PRIMARY, "primary");
        sm.setScene(SceneID.MAIN, "main");

        // Sirve para cargar la escena principal
        sm.loadScene(SceneID.MAIN);
    }

    public static void main(String[] args) {
        launch();
    }
}
