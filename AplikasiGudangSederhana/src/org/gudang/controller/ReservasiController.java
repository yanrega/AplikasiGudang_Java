/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gudang.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.gudang.Dao.ReservasiDao;
import org.gudang.Dao.impl.ReservasiDaoImplHibernate;
import org.gudang.model.Reservasi;

public class ReservasiController implements Initializable {
    
    @FXML
    private TextField idBarangTF;
    @FXML
    private TextField jlhBarangTF;
    @FXML
    private ComboBox satuanCB;
    @FXML
    private TextField statusTF;
    @FXML
    private ComboBox tujuanCB;
    @FXML
    private Label suksesL;
    
    private ReservasiDao rdDao;
    
    ObservableList<String> item = FXCollections.observableArrayList("pcs", "Kardus");
    ObservableList<String> items = FXCollections.observableArrayList("Motor", "Mobil");
    
    public ReservasiController() {
        rdDao = new ReservasiDaoImplHibernate();
    }
    
    @FXML
    public void btnBarang(ActionEvent event)throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/MasterBarang.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void btnSimpan(ActionEvent event) throws IOException {
        String idBarang = idBarangTF.getText();
        String jumlahBarang = jlhBarangTF.getText();
        String satuan = satuanCB.getValue().toString();
        String tujuan = tujuanCB.getValue().toString();
        String status = statusTF.getText();
        
        try {
            
            Reservasi r = new Reservasi(0,idBarang, jumlahBarang, satuan, status, tujuan);
            suksesL.setVisible(true);
            suksesL.setText("Tersimpan");
            rdDao.saveDataReservasi(r);
        } catch (Exception e) {
            suksesL.setVisible(true);
            suksesL.setText("Data Tidak Valid \nCoba Anda Periksa Kembali");
        }
    }
    
    @FXML
    public void btnBatal(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/Home.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void btnDataReservasi(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/DataReservasi.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        satuanCB.setItems(item);
        tujuanCB.setItems(items);
    }
    
}
