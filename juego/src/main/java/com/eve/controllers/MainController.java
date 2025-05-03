package com.eve.controllers;

import java.util.HashMap;

import com.eve.SceneID;
import com.eve.SceneManager;
import com.eve.model.GestorJuego;
import com.eve.model.Protagonista;
import com.eve.model.ProtasEstadisticas;
import com.eve.model.Proveedor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class MainController {
    /** Se establecen las etiquetas FXML con los componentes de las vistas */
    @FXML
    VBox vBox;
    @FXML
    SplitPane splitPane;
    @FXML
    RadioButton radioButton1;
    @FXML
    RadioButton radioButton2;
    @FXML
    VBox vBoxBotones;
    @FXML
    TextField Tnombre;
    @FXML
    SplitMenuButton splitMenuButton;
    @FXML
    AnchorPane anchorPane1;
    @FXML
    AnchorPane anchorPane2;
    @FXML
    ImageView imageChica;
    @FXML
    ImageView imageChico;
    @FXML
    Button button;
    @FXML
    GridPane gridPane;
    @FXML
    Label LpuntosVida;
    @FXML
    Label Ldefensa;
    @FXML
    Label Lfuerza;
    @FXML
    Label Lvelocidad;
    @FXML
    Label LMensajePersonaje;
    @FXML
    Label LMensajeNombre;
    @FXML
    Label LpuntosVida2;
    @FXML
    Label Ldefensa2;
    @FXML
    Label Lfuerza2;
    @FXML
    Label Lvelocidad2;
    @FXML
    StackPane stackPane1;
    @FXML
    StackPane stackPane2;

    @FXML
    public void initialize() {
        Proveedor.getInstance().setGestorJuego(new GestorJuego());
        GestorJuego gestorJuego = Proveedor.getInstance().getGestorJuego();
        ProtasEstadisticas estadisticas = new ProtasEstadisticas();
        /**
         * Para que los radioButtons estñen en el mismo grupo y solo se pueda
         * seleccionar 1 de ellos
         */
        ToggleGroup group = new ToggleGroup();
        radioButton1.setToggleGroup(group);
        radioButton2.setToggleGroup(group);
        /**
         * Se selecciona el radioButton1 por defecto, por si el usuario no selecciona
         * ninguno
         */
        radioButton1.setSelected(true);

        /** Imágenes de los protagonistas, para seleccionar uno u otro */
        this.imageChica.setImage(new Image(getClass().getResourceAsStream("/com/eve/images/protaChica.png")));
        this.imageChico.setImage(new Image(getClass().getResourceAsStream("/com/eve/images/protaChico.png")));

        /** Menu para seleccionar el rol y que de este dependan sus estadísticas */

        splitMenuButton.setText("Seleccionar Rol");
        MenuItem asesino = new MenuItem("ASESINO");
        asesino.setOnAction(event -> rellenarDatos("asesino", estadisticas));
        MenuItem aventurero = new MenuItem("AVENTURERO");
        aventurero.setOnAction(event -> rellenarDatos("aventurero", estadisticas));
        MenuItem protector = new MenuItem("PROTECTOR");
        protector.setOnAction(event -> rellenarDatos("protector", estadisticas));
        splitMenuButton.getItems().addAll(asesino, aventurero, protector);

        button.setOnAction(event -> {
            if (!comprobarNombre()) {
                LMensajeNombre.setText("El nombre no puede estar vacío");
            } else {
                LMensajeNombre.setText("");
            }
            if (!comprobarRol()) {
                LMensajePersonaje.setText("El rol debe esta seleccionado");
            } else {
                LMensajePersonaje.setText("");
            }
            if (comprobarNombre() && comprobarRol()) {
                crearProta(estadisticas, gestorJuego);
                SceneManager sm = SceneManager.getInstance();
                // La que contiene las otras vistas
                sm.setScene(SceneID.PRIMARY, "primary");
                sm.loadScene(SceneID.PRIMARY);
            }
        });
    }

    private boolean comprobarNombre() {
        String nombre = Tnombre.getText();
        if (nombre.isEmpty())
            return false;
        else
            return true;
    }

    private boolean comprobarRol() {
        String rol = splitMenuButton.getText();
        if (rol.equals("Seleccionar Rol"))
            return false;
        else
            return true;
    }

    /**
     * Método para comprobar que los valores con las estadísticas de los personas
     * están rellenos
     * 
     * @return true o false
     */

    private void rellenarDatos(String tipo, ProtasEstadisticas estadisticas) {
        splitMenuButton.setText(tipo);
        HashMap<String, Integer> estadisticasP = estadisticas.getEstadisticas().get(tipo);
        this.LpuntosVida2.setText(estadisticasP.get("puntosVida").toString());
        this.Lfuerza2.setText(estadisticasP.get("fuerza").toString());
        this.Ldefensa2.setText(estadisticasP.get("defensa").toString());
        this.Lvelocidad2.setText(estadisticasP.get("velocidad").toString());
    }

    public void crearProta(ProtasEstadisticas estadisticas, GestorJuego gestorJuego) {
        String rol = splitMenuButton.getText().toLowerCase();
        HashMap<String, Integer> estadProtas = estadisticas.getEstadisticas().get(rol);
        int puntosVida = estadProtas.get("puntosVida");
        int fuerza = estadProtas.get("fuerza");
        int defensa = estadProtas.get("defensa");
        int velocidad = estadProtas.get("velocidad");
        int porcentajeCritico = estadProtas.get("porcentajeCritico");
        String nombre = Tnombre.getText();
        String imagen = "";
        if (radioButton1.isSelected())
            imagen = new Protagonista().getProtaChica();
        else
            imagen = new Protagonista().getProtaChico();

        gestorJuego.getPersonajes().add(new Protagonista(imagen, nombre, puntosVida, porcentajeCritico, fuerza,
                defensa, velocidad, rol, 999));
        gestorJuego.getPersonajes().sort(null);
    }
}
