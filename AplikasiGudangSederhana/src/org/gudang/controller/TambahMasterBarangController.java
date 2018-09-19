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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.gudang.Dao.BarangDao;
import org.gudang.Dao.impl.BarangDaoImplHibernate;
import org.gudang.model.Barang;

public class TambahMasterBarangController implements Initializable {

    @FXML
    private TextField namaBarangM;
    @FXML
    private TextField jumlahBarangM;
    @FXML
    private ComboBox satuanCB;

    @FXML
    private Label labelNamaBarang;

    @FXML
    private Label labelSatuanBarang;
    @FXML
    private Label labelJumlahBarang;
    @FXML
    private Label suksesL;
    ObservableList<String> item = FXCollections.observableArrayList("pcs", "Kardus");
    private BarangDao bDao;

    public TambahMasterBarangController() {
        bDao = new BarangDaoImplHibernate();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        satuanCB.setItems(item);
    }

    @FXML
    public void btnSimpanBarang(ActionEvent event) throws IOException {

        String namaBarang = namaBarangM.getText();
        String satuanBarang = satuanCB.getValue().toString();
        String jumlahBarang = jumlahBarangM.getText();

        if (namaBarangM.getText().equals("")) {
            labelNamaBarang.setVisible(true);
            labelNamaBarang.setText("Nama Barang Tidak Boleh Kosong");
        }
        if (satuanCB.getValue().toString().equals("")) {

            labelSatuanBarang.setVisible(true);
            labelSatuanBarang.setText("Satuan Barang Tidak Boleh Kosong");
        }

        if (jumlahBarangM.getText().equalsIgnoreCase("")) {
            labelJumlahBarang.setVisible(true);
            labelJumlahBarang.setText("Jumlah Barang Tidak Boleh Kosong");

        } else {
            Barang b = new Barang(0, namaBarang, jumlahBarang, satuanBarang);
            suksesL.setVisible(true);
            suksesL.setText("Berhasil Ditambahkan");
            bDao.saveDataBarang(b);

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
    public void btnmasterDataHL(ActionEvent event) throws IOException {

        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/MasterBarang.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

}
