package com.mycompany.ra3_inscripcionextraescolaresampliacion_danieldr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
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
import javafx.scene.control.ToggleGroup;

public class PrimaryController {

    //NO SE SI HAY QUE METER UN TEXT-INPUT-DIALOG.
    
    @FXML
    private TextField NombreAlumno;
    
    @FXML
    private ComboBox<String> ComboboxCurso = new ComboBox<>();
    
    @FXML
    private ListView<String> ListaInscritos;
    
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
    private Label HorasBind = new Label();
    
    @FXML
    private Label Curso = new Label();
    
    @FXML
    private Alert alertaInfo = new Alert(Alert.AlertType.INFORMATION);
    
    @FXML
    private Alert alertaWarning = new Alert(Alert.AlertType.WARNING);
    
    @FXML
    private Alert alertaConfirm = new Alert(Alert.AlertType.CONFIRMATION);
    
    @FXML 
    private ToggleGroup Actividades;
    
    @FXML 
    private ToggleGroup Turnos;
    
    @FXML 
    private ToggleGroup Niveles;
    
    @FXML 
    private ToggleGroup Pagos;
    
    int contador = 0;
    //Esto lo hago para que en el initialize a la hora de reactivar varias veces el programa, no añada los ITEMS de la ESO siempre.
    
    @FXML
    private void initialize() {
        ComboboxCurso.setDisable(true);
        PanelScroll.setDisable(true);
        Añadir.setDisable(true);
        Buscar.setDisable(true);
        Eliminar.setDisable(true);
        Renombrar.setDisable(true);
        Curso.setDisable(true);
        
        //Config inicial de combobox
        if (contador==0) {
            ComboboxCurso.getItems().addAll("1ºESO","2ºESO","3ºESO","4ºESO");
            contador++;
        }
        
        //El listener para lo del max 15 caracteres. //NO LO HEMOS DADO PERO APRENDETELO.
        NombreAlumno.textProperty().addListener((obs, antiguo, nuevo) -> {
            if (nuevo.length() > 15) NombreAlumno.setText(antiguo);
        });
        
        //Binding de slider con label
        HorasBind.textProperty().bind(
            Deslizador.valueProperty().asString("%.0fh")
        );
        
        // configuración del slider (Lo hago aqui porque en el ScenBuilder no funciona el SnapTicks)
        Deslizador.setMin(1);
        Deslizador.setMax(10);
        Deslizador.setMajorTickUnit(1);
        Deslizador.setMinorTickCount(0);
        Deslizador.setSnapToTicks(true);
        Deslizador.setShowTickMarks(true);
        Deslizador.setShowTickLabels(true);
        
        ListaInscritos.setItems(Inscritos);
    }
    
    @FXML 
    private void alPulsar() {
        if(!NombreAlumno.getText().isBlank()||!NombreAlumno.getText().isEmpty()) {  
            ComboboxCurso.setDisable(false);
            PanelScroll.setDisable(false);
            Añadir.setDisable(false);
            Buscar.setDisable(false);
            Cancelar.setDisable(false);
            Salir.setDisable(false);
            Curso.setDisable(false);
                
            ComboboxCurso.getSelectionModel().selectFirst();
            ComboboxCurso.requestFocus();
                
            configuracionEstandar();
        } else {
            initialize(); //No se si esto sirve como una solucion a lo de que cuando el nombre es " ", si pulsamos añadir se pone el nombre en blanco la verdad
            configuracionEstandarFALSE();
            alertaWarning.setHeaderText("NOMBRE VACIO");
            alertaWarning.setContentText("No debe de dejar el texto vacio");
            alertaWarning.showAndWait();
        }
    }
    
    @FXML
    private void configuracionEstandar() {
        
        Robotica.setSelected(true);
        LunesMiercoles.setSelected(true);
        Iniciacion.setSelected(true);
        Mensual.setSelected(true);
        
        SeguroEscolar.setSelected(true);
        Comedor.setSelected(false);
        Transporte.setSelected(false);
        MaterialIncluido.setSelected(true);
        
        Deslizador.setValue(2);
    }
    
    @FXML
    private void configuracionEstandarFALSE() {
        Robotica.setSelected(false);
        LunesMiercoles.setSelected(false);
        Iniciacion.setSelected(false);
        Mensual.setSelected(false);
        
        SeguroEscolar.setSelected(false);
        Comedor.setSelected(false);
        Transporte.setSelected(false);
        MaterialIncluido.setSelected(false);
        
        Deslizador.setValue(1);
    }
    
    //VUELVE A REVISAR ABSOLUTAMENTE TODO EL CODIGO DE ARRIBA Y LUEGO HAZ TODO 
    
    @FXML 
    private void AlAñadir() {
        String nombre = NombreAlumno.getText();
        String curso = ComboboxCurso.getValue();
        
        RadioButton actividadRadio = (RadioButton) Actividades.getSelectedToggle();
        String actividad = actividadRadio.getText();
        
        RadioButton turnoRadio = (RadioButton) Turnos.getSelectedToggle();
        String turno = turnoRadio.getText();
        
        RadioButton nivelRadio = (RadioButton) Niveles.getSelectedToggle();
        String nivel = nivelRadio.getText();
        
        RadioButton pagoRadio = (RadioButton) Pagos.getSelectedToggle();
        String pago = pagoRadio.getText();
        
        int horas = (int) Deslizador.getValue();
        
        List<String> opcionesMarcadas = new ArrayList();
        if (SeguroEscolar.isSelected()) {
            opcionesMarcadas.add(SeguroEscolar.getText());
        }
        if (Comedor.isSelected()) {
            opcionesMarcadas.add(Comedor.getText());
        }
        if (Transporte.isSelected()) {
            opcionesMarcadas.add(Transporte.getText());
        }
        if (MaterialIncluido.isSelected()) {
            opcionesMarcadas.add(MaterialIncluido.getText());
        }
        
        Inscripcion inscripcion = new Inscripcion(nombre,curso,actividad,turno,nivel,pago,horas,opcionesMarcadas);
        
        Inscritos.addAll(inscripcion.toString());
        AlCancelar();
        
        //Llamamos otra vez al initialize para que luego no podamos añadir un alumno null.
        initialize();
        
        alertaInfo.setHeaderText("INSCRIPCION REALIZADA");
        alertaInfo.setContentText("La inscripción ha sido realizada con éxito.");
        alertaInfo.showAndWait();
    }
    
    @FXML 
    private void AlBuscar() {
        
    }
    
    @FXML 
    private void AlEliminar() {
        
    }
    @FXML 
    private void AlRenombrar() {
        
    }
    
    
    //AQUI DENTRO TAMBIEN TENDREMOS QUE HACER ALGO QUE HAGA SI EL TEXTFIELD ESTA VACIO SI O SI NO PODAMOS AÑADIR ALGO.
    @FXML 
    private void AlCancelar() {
        NombreAlumno.setText(null);
        
        SeguroEscolar.setSelected(false);
        Comedor.setSelected(false);
        Transporte.setSelected(false);
        MaterialIncluido.setSelected(false);
        
        Actividades.selectToggle(null);
        Turnos.selectToggle(null);
        Niveles.selectToggle(null);
        Pagos.selectToggle(null);
        
        ComboboxCurso.getSelectionModel().selectFirst(); 
        
        Deslizador.setValue(1);
    }
    
    @FXML 
    private void AlSalir() {
        Platform.exit();
    }
    
    
    
}
