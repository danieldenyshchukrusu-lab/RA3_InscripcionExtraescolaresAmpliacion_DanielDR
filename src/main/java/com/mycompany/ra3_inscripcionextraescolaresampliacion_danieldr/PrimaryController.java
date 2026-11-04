package com.mycompany.ra3_inscripcionextraescolaresampliacion_danieldr;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class PrimaryController {

    //NO SE SI HAY QUE METER UN TEXT-INPUT-DIALOG.
    
    @FXML
    private TextField NombreAlumno;
    
    @FXML
    private ComboBox<String> ComboboxCurso = new ComboBox<>();
    
    @FXML
    private ListView<Inscripcion> listaInscritos;
    
    @FXML
    private ObservableList<String> Inscritos = FXCollections.observableArrayList();
    
    @FXML
    private ScrollPane PanelScroll = new ScrollPane();
    
    @FXML
    private RadioButton Robotica = new RadioButton("Robótica");
    
    @FXML
    private RadioButton Ajedrez = new RadioButton("Ajedrez");
    
    @FXML
    private RadioButton Pintura = new RadioButton("Pintura");
    
    @FXML
    private RadioButton Idiomas = new RadioButton("Idiomas");
    
    @FXML
    private RadioButton LunesMiercoles = new RadioButton("Lun-Mié 16:00");
    
    @FXML
    private RadioButton MartesJueves = new RadioButton("Mar-Jue 16:00");
    
    @FXML
    private RadioButton Viernes = new RadioButton("Viernes 16:00");
    
    @FXML
    private RadioButton Sabado = new RadioButton("Sabado 16:00");
    
    @FXML
    private RadioButton Iniciacion = new RadioButton("Iniciación");
    
    @FXML
    private RadioButton Intermedio = new RadioButton("Intermedio");
    
    @FXML
    private RadioButton Avanzado = new RadioButton("Avanzado");
    
    @FXML
    private RadioButton Mensual = new RadioButton("Mensual");
    
    @FXML
    private RadioButton Trimestral = new RadioButton("Trimestral");
    
    @FXML
    private RadioButton Anual = new RadioButton("Anual");
    
    @FXML
    private CheckBox Comedor = new CheckBox("Comedor");
    
    @FXML
    private CheckBox Transporte = new CheckBox("Transporte");
    
    @FXML
    private CheckBox SeguroEscolar = new CheckBox("Seguro Escolar");
    
    @FXML
    private CheckBox MaterialIncluido = new CheckBox("Material Incluido");
    
    @FXML
    private Slider Deslizador = new Slider(1,10,0);
    
    @FXML 
    private Button Añadir;
    
    @FXML 
    private Button Buscar;
    
    @FXML 
    private Button Eliminar;
    
    @FXML 
    private Button Renombrar;
    
    @FXML 
    private Button Cancelar;
    
    @FXML 
    private Button Salir;
    
    @FXML
    private TextInputDialog dialogo = new TextInputDialog();
    
    @FXML
    private Label horasBind = new Label();
    
    @FXML
    private Label Curso = new Label();
    
    @FXML
    private Alert alertaInfo = new Alert(Alert.AlertType.INFORMATION);
    
    @FXML
    private Alert alertaWarning = new Alert(Alert.AlertType.WARNING);
    
    @FXML
    private Alert alertaConfirm = new Alert(Alert.AlertType.CONFIRMATION);
    
    
    
    @FXML
    private void initialize() {
        ComboboxCurso.setDisable(true);
        PanelScroll.setDisable(true);
        Añadir.setDisable(true);
        Buscar.setDisable(true);
        Eliminar.setDisable(true);
        Renombrar.setDisable(true);
        Cancelar.setDisable(true);
        Salir.setDisable(true);
        Curso.setDisable(true);
        
        ComboboxCurso.getItems().addAll("1ºESO","2ºESO","3ºESO","4ºESO");
    }
    
    @FXML 
    private void alPulsar() {
        if(!NombreAlumno.getText().isBlank()||!NombreAlumno.getText().isEmpty()) {
            if (NombreAlumno.getText().length()<=15 ) {
                ComboboxCurso.setDisable(false);
                PanelScroll.setDisable(false);
                Añadir.setDisable(false);
                Buscar.setDisable(false);
                Cancelar.setDisable(false);
                Salir.setDisable(false);
                Curso.setDisable(false);
                ComboboxCurso.getSelectionModel().selectFirst();
            } else {
                alertaWarning.setHeaderText("NOMBRE MAYOR DE 15 CARACTERES");
                alertaWarning.setContentText("El nombre no puede ser mayor a 15 caracteres");
                alertaWarning.showAndWait();
            }
        } else {
            initialize();
            alertaWarning.setHeaderText("NOMBRE VACIO");
            alertaWarning.setContentText("No debe de dejar el texto vacio");
            alertaWarning.showAndWait();
        }
    }
    
    @FXML 
    private void Añadir() {
        
    }
    
    @FXML 
    private void Buscar() {
        
    }
    
    @FXML 
    private void Eliminar() {
        
    }
    @FXML 
    private void Renombrar() {
        
    }
    
    @FXML 
    private void Cancelar() {
        
    }
    
    @FXML 
    private void Salir() {
        
    }
    
    
    
}
