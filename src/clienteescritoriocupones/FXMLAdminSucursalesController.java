/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteescritoriocupones;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author yahir
 */
public class FXMLAdminSucursalesController implements Initializable {

    @FXML
    private TextField tfBarraBusqueda;
    @FXML
    private JFXButton btnAgregarS;
    @FXML
    private JFXButton btnModificarS;
    @FXML
    private JFXButton btnEliminarS;
    @FXML
    private JFXButton btnUbicacion;
    @FXML
    private TableView<?> tvSucursales;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colNumTelefono;
    @FXML
    private TableColumn<?, ?> colEncargado;
    @FXML
    private TableColumn<?, ?> colDireccion;
    @FXML
    private TableColumn<?, ?> colEmpresa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}