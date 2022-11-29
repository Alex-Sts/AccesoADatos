/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package examenaccesomysql;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Alex Santos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField textId;
    @FXML
    private TextField textCiudad;
    @FXML
    private TextField textCodigo;
    @FXML
    private TextField textDistrito;
    @FXML
    private TextField textPoblacion;
    
    ArrayList<City> arrayCiudades = new ArrayList();
    CityModel cModel = new CityModel();
    int inicioVista = 0;
    int pasarCiudad = 0;
    int cont = 1;
    private Label labelContador;
    @FXML
    private Label ayuda;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arrayCiudades = cModel.mostrarInformacion();
        for(City c : arrayCiudades){
            if(cont == 1){
                textId.setText(String.valueOf(c.getId()));
                textCiudad.setText(c.getCiudad());
                textCodigo.setText(c.getCodigo());
                textDistrito.setText(c.getDistrito());
                textPoblacion.setText(String.valueOf(c.getPoblacion()));          
                cont++;
            }
        }
    }    

    @FXML
    private void back(ActionEvent event) {
        inicioVista--;
        City c = new City();
        ayuda.setText(inicioVista + "");
            /*textId.setText(Integer.toString(arrayCiudades.get(inicioVista).getId()));
            textCiudad.setText(arrayCiudades.get(inicioVista).getCiudad());
            textCodigo.setText(arrayCiudades.get(inicioVista).getCodigo());
            textDistrito.setText(arrayCiudades.get(inicioVista).getDistrito());
            textPoblacion.setText(Integer.toString(arrayCiudades.get(inicioVista).getPoblacion()));*/
        
        if(inicioVista >= 0){
            if(String.valueOf(textId.getText()).equals("")){
               c.setId(arrayCiudades.get(inicioVista-1).getId());
               cModel.borrarCiudad(c);
               arrayCiudades = cModel.mostrarInformacion();
               limpiarInformacion();
            } else if(!arrayCiudades.get(inicioVista-1).getCiudad().equalsIgnoreCase(textCiudad.getText()) || !arrayCiudades.get(inicioVista-1).getCodigo().equalsIgnoreCase(textCodigo.getText()) || !arrayCiudades.get(inicioVista-1).getDistrito().equalsIgnoreCase(textDistrito.getText()) || arrayCiudades.get(inicioVista-1).getPoblacion() != Integer.parseInt(String.valueOf(textPoblacion.getText()))){
                c.setId(Integer.parseInt(String.valueOf(textId.getText())));
                c.setCiudad(textCiudad.getText());
                c.setCodigo(textCodigo.getText());
                c.setDistrito(textDistrito.getText());
                c.setPoblacion(Integer.parseInt(String.valueOf(textPoblacion.getText())));
                cModel.actualizarCiudad(c);
                arrayCiudades = cModel.mostrarInformacion();
                inicioVista--;
                textId.setText(String.valueOf(arrayCiudades.get(inicioVista+1).getId()));
                textCiudad.setText(arrayCiudades.get(inicioVista+1).getCiudad());
                textCodigo.setText(arrayCiudades.get(inicioVista+1).getCodigo());
                textDistrito.setText(arrayCiudades.get(inicioVista+1).getDistrito());
                textPoblacion.setText(Integer.toString(arrayCiudades.get(inicioVista+1).getPoblacion()));
            } else {
                textId.setText(String.valueOf(arrayCiudades.get(inicioVista).getId()));
                textCiudad.setText(arrayCiudades.get(inicioVista).getCiudad());
                textCodigo.setText(arrayCiudades.get(inicioVista).getCodigo());
                textDistrito.setText(arrayCiudades.get(inicioVista).getDistrito());
                textPoblacion.setText(Integer.toString(arrayCiudades.get(inicioVista).getPoblacion()));
             }
        } else {
            inicioVista = arrayCiudades.size();
            textId.setText(Integer.toString(arrayCiudades.get(inicioVista).getId()));
            textCiudad.setText(arrayCiudades.get(inicioVista).getCiudad());
            textCodigo.setText(arrayCiudades.get(inicioVista).getCodigo());
            textDistrito.setText(arrayCiudades.get(inicioVista).getDistrito());
            textPoblacion.setText(Integer.toString(arrayCiudades.get(inicioVista).getPoblacion()));
        }
        
    }

    @FXML
    private void next(ActionEvent event) {
        inicioVista++;
        City c = new City();
        ayuda.setText(inicioVista + "");
        int limpiar = arrayCiudades.size();
        int agregar = arrayCiudades.size() + 1;
        
        if(inicioVista >= 0 && inicioVista < arrayCiudades.size()){
            if(String.valueOf(textId.getText()).equals("")){
               c.setId(arrayCiudades.get(inicioVista-1).getId());
               cModel.borrarCiudad(c);
               arrayCiudades = cModel.mostrarInformacion();
               limpiarInformacion();
            } else if(!arrayCiudades.get(inicioVista-1).getCiudad().equalsIgnoreCase(textCiudad.getText()) || !arrayCiudades.get(inicioVista-1).getCodigo().equalsIgnoreCase(textCodigo.getText()) || !arrayCiudades.get(inicioVista-1).getDistrito().equalsIgnoreCase(textDistrito.getText()) || arrayCiudades.get(inicioVista-1).getPoblacion() != Integer.parseInt(String.valueOf(textPoblacion.getText()))){
                c.setId(Integer.parseInt(String.valueOf(textId.getText())));
                c.setCiudad(textCiudad.getText());
                c.setCodigo(textCodigo.getText());
                c.setDistrito(textDistrito.getText());
                c.setPoblacion(Integer.parseInt(String.valueOf(textPoblacion.getText())));
                cModel.actualizarCiudad(c);
                arrayCiudades = cModel.mostrarInformacion();
                inicioVista--;
                textId.setText(String.valueOf(arrayCiudades.get(inicioVista+1).getId()));
                textCiudad.setText(arrayCiudades.get(inicioVista+1).getCiudad());
                textCodigo.setText(arrayCiudades.get(inicioVista+1).getCodigo());
                textDistrito.setText(arrayCiudades.get(inicioVista+1).getDistrito());
                textPoblacion.setText(Integer.toString(arrayCiudades.get(inicioVista+1).getPoblacion()));
            } else {
                textId.setText(String.valueOf(arrayCiudades.get(inicioVista).getId()));
                textCiudad.setText(arrayCiudades.get(inicioVista).getCiudad());
                textCodigo.setText(arrayCiudades.get(inicioVista).getCodigo());
                textDistrito.setText(arrayCiudades.get(inicioVista).getDistrito());
                textPoblacion.setText(Integer.toString(arrayCiudades.get(inicioVista).getPoblacion()));
             }
        } else if(inicioVista >= limpiar && inicioVista < agregar) {
            if(String.valueOf(textId.getText()).equals("")){
               c.setId(arrayCiudades.get(inicioVista-1).getId());
               cModel.borrarCiudad(c);
               arrayCiudades = cModel.mostrarInformacion();
               limpiarInformacion();
            } else if(!arrayCiudades.get(inicioVista-1).getCiudad().equalsIgnoreCase(textCiudad.getText()) || !arrayCiudades.get(inicioVista-1).getCodigo().equalsIgnoreCase(textCodigo.getText()) || !arrayCiudades.get(inicioVista-1).getDistrito().equalsIgnoreCase(textDistrito.getText()) || arrayCiudades.get(inicioVista-1).getPoblacion() != Integer.parseInt(String.valueOf(textPoblacion.getText()))){
                c.setId(Integer.parseInt(String.valueOf(textId.getText())));
                c.setCiudad(textCiudad.getText());
                c.setCodigo(textCodigo.getText());
                c.setDistrito(textDistrito.getText());
                c.setPoblacion(Integer.parseInt(String.valueOf(textPoblacion.getText())));
                cModel.actualizarCiudad(c);
                arrayCiudades = cModel.mostrarInformacion();
                limpiarInformacion();
                inicioVista--;
                textId.setText(String.valueOf(arrayCiudades.get(inicioVista+1).getId()));
                textCiudad.setText(arrayCiudades.get(inicioVista+1).getCiudad());
                textCodigo.setText(arrayCiudades.get(inicioVista+1).getCodigo());
                textDistrito.setText(arrayCiudades.get(inicioVista+1).getDistrito());
                textPoblacion.setText(Integer.toString(arrayCiudades.get(inicioVista+1).getPoblacion()));
            } else {
            limpiarInformacion();
            }
        } else if(inicioVista >= agregar) {
            c.setCiudad(textCiudad.getText());
            c.setCodigo(textCodigo.getText());
            c.setDistrito(textDistrito.getText());           
            c.setPoblacion(Integer.parseInt(String.valueOf(textPoblacion.getText())));
            cModel.agregarCiudad(c);
            arrayCiudades.add(c);
            arrayCiudades = cModel.mostrarInformacion();
            limpiarInformacion();
        }

    }

    @FXML
    private void configurar(ActionEvent event) {
    }

    @FXML
    private void consultabruta(ActionEvent event) {
    }
    
    private void limpiarInformacion() {
        textId.setText("");
        textCiudad.setText("");
        textCodigo.setText("");
        textDistrito.setText("");
        textPoblacion.setText("");
    }
    
}
