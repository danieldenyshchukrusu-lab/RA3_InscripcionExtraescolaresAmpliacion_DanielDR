module com.mycompany.ra3_inscripcionextraescolaresampliacion_danieldr {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.ra3_inscripcionextraescolaresampliacion_danieldr to javafx.fxml;
    exports com.mycompany.ra3_inscripcionextraescolaresampliacion_danieldr;
}
