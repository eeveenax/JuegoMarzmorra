package com.eve;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * El SceneManager se encarga de gestionar las escenas de
 * la aplicación JavaFX: carga, almacena, cambia y elimina las escenas del
 * programa.
 * También se encarga de la gestión de estilos con el uso de CSS.
 * Inicia la escena actual, para que se cargue en la ventana
 * principal (Stage).
 */
public class SceneManager {
    // Instancia única (singleton) de la clase SceneManager
    private static SceneManager instance;

    private Stage stage;
    private URL styles;
    private HashMap<SceneID, Scene> scenes;

    /**
     * Constructor privado de la clase SceneManager.
     * Este constructor contiene un mapa de tipo HashMap vacío.
     */
    private SceneManager() {
        scenes = new HashMap<>();
    }

    /**
     * Método estático para obtener la instancia de la clase que es SceneManager,
     * instancia única.
     * 
     * @return una instancia única de la clase SceneManager.
     */
    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    /**
     * Inicializa la clase SceneManager con la ventana (Stage) principal y
     * la ruta de la hoja de estilo.
     * 
     * @param stage  la ventana principal de la aplicación donde se mostrarán las
     *               escenas.
     * @param styles el nombre de la hoja de estilo CSS.
     */
    @SuppressWarnings("exports")
    public void init(Stage stage, String styles) {
        this.stage = stage;
        this.styles = App.class.getResource("styles/" + styles + ".css");
    }

    /**
     * Método para inicializaz el SceneManager con la ventana principal y
     * la ruta de la hoja de estilo.
     * 
     * @param stage la ventana principal de la aplicación. En esta se mostrarán las
     *              escenas.
     */
    @SuppressWarnings("exports")
    public void init(Stage stage) {
        this.stage = stage;
    }

    /**
     * Méotod para establecer una de las escenas creada, a partir de la carga de un
     * archivo FXML.
     * La escena también se asocia con la hoja de estilo.
     * 
     * @param sceneID identificador único de la escena.
     * @param fxml    nombre del archivo FXML, este define la vista de la escena que
     *                se muestra.
     * @param width   ancho de la escena.
     * @param height  alto de la escena.
     */
    public void setScene(SceneID sceneID, String fxml) {
        Screen screen = Screen.getPrimary();

        // Tamaño de la pantalla
        double screenWidth = screen.getBounds().getWidth();
        double screenHeight = screen.getBounds().getHeight();
        try {
            // Archivo FXML
            URL url = App.class.getResource("views/" + fxml + ".fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, screenWidth * 0.7, screenHeight * 0.7);
            if (styles != null)
                scene.getStylesheets().add(styles.toExternalForm());
            scenes.put(sceneID, scene); // Almacena la escena en el mapa, creado anteriormente (el cual estaba vacío),
                                        // con su identificador correspondiente.
        } catch (IOException e) {
            e.printStackTrace(); // Si se produce algún tipo de error al cargar el FXML.
        }
    }

    /**
     * Método para eliminar alguna escena previamente almacenada, a partir de su
     * identificador.
     * 
     * @param sceneID identificador de la escena que se va a eliminar.
     */
    public void removeScene(SceneID sceneID) {
        scenes.remove(sceneID);
    }

    /**
     * Método que se usa para la carga y muestra de
     * una de las escena ya almacenadas en el mapa de la clase
     * SceneManager.
     * 
     * @param sceneID identificador de la escena a cargar.
     */
    public void loadScene(SceneID sceneID) {
        if (scenes.containsKey(sceneID)) {
            stage.setScene(scenes.get(sceneID)); // El setScene establece (set) la escena en la ventana principal
            stage.show(); // Carga la ventana en la que se muestra la nueva escena
        } else {
            System.err.println("La escena seleccionada no existe");
        }
    }

    /**
     * Método para seleccionar una de las escenas ya guardadas en el mapa de
     * escenas.
     * 
     * @param sceneID identificador único de la escena, guardados en el mapa de
     *                escenas con su escena asociada.
     * @return
     */
    @SuppressWarnings("exports")
    public Scene getScene(SceneID sceneID) {
        if (scenes.containsKey(sceneID)) {
            return scenes.get(sceneID);
        } else {
            System.err.println("La escena seleccionada no existe");
            return null;
        }
    }
}