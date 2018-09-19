/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gudang.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.gudang.Dao.BarangDao;
import org.gudang.Dao.impl.BarangDaoImplHibernate;
import org.gudang.model.Barang;

public class MasterBarangController implements Initializable {

    private BarangDao bDao;
    @FXML
    private TableView< Barang> tabelBarangTV;
    @FXML
    private TableColumn< Barang, String> idTC;
    @FXML
    private TableColumn< Barang, String> namaBarangTC;
    @FXML
    private TableColumn< Barang, String> jBarangTC;
    @FXML
    private TableColumn< Barang, String> satuanTC;
    ObservableList<Barang> data;

    public MasterBarangController() {
        bDao = new BarangDaoImplHibernate();
        tabelBarangTV = new TableView<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }

    private void loadData() {
        List<Barang> barangs = bDao.getAllBarang();
        data = FXCollections.observableArrayList(barangs);
        idTC.setCellValueFactory(new PropertyValueFactory<Barang, String>("id"));
        namaBarangTC.setCellValueFactory(new PropertyValueFactory<Barang, String>("namaBarang"));
        jBarangTC.setCellValueFactory(new PropertyValueFactory<Barang, String>("jumlahBarang"));
        satuanTC.setCellValueFactory(new PropertyValueFactory<Barang, String>("satuan"));
        tabelBarangTV.setItems(data);
    }

    @FXML
    public void btnKembali(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/TambahMasterBarang.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

}
