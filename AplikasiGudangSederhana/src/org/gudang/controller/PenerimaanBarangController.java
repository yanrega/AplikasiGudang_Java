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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.gudang.Dao.PenerimaanBarangDao;
import org.gudang.Dao.impl.PenerimaanBarangDaoImplHibernate;
import org.gudang.model.Barang;
import org.gudang.model.PenerimaanBarang;

public class PenerimaanBarangController implements Initializable {

    @FXML
    private TextField idBarangTF;
    @FXML
    private TextField idStaffTF;
    @FXML
    private TextField jBarangTF;
    @FXML
    private DatePicker tanggalTF;
    @FXML
    private ComboBox satuanCB;
    @FXML
    private Label idBarangL;
    @FXML
    private Label idStaffL;
    @FXML
    private Label jlhBarangL;
    @FXML
    private Label tanggalL;
    @FXML
    private Label satuanL;
    @FXML
    private Label suksesL;

    ObservableList<String> item = FXCollections.observableArrayList("pcs", "kardus");

    private PenerimaanBarangDao pbDao;

    public PenerimaanBarangController() {
        pbDao = new PenerimaanBarangDaoImplHibernate();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        satuanCB.setItems(item);

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

    @FXML
    public void btnStaff(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/DataStaff.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void btnBarang(ActionEvent event) throws IOException {
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
        String idStaff = idStaffTF.getText();
        String jBarang = jBarangTF.getText();
        String tanggal = tanggalTF.getValue().toString();
        String satuan = satuanCB.getValue().toString();

        if (idBarangTF.getText().equals("") && idStaffTF.getText().equals("")) {
            idBarangL.setVisible(true);
            idBarangL.setText("Id Barang Tidak Boleh Kosong");
            idStaffL.setVisible(true);
            idStaffL.setText("Id Staff Tidak Boleh Kosong");
        }

        if (jBarangTF.getText().equals("") && tanggalTF.getValue().toString().equals("")) {
            jlhBarangL.setVisible(true);
            jlhBarangL.setText("Jumlah Barang Tidak Boleh Kosong");
            tanggalL.setVisible(true);
            tanggalL.setText("Tanggal Tidak Boleh Kosong");
        }

        if (satuanCB.getValue().toString().equalsIgnoreCase("")) {
            satuanL.setVisible(true);
            satuanL.setText("Satuan Barang Tidak Boleh Kosong");
        } else {

            try {

                PenerimaanBarang pb = new PenerimaanBarang(0, idBarang, idStaff, jBarang, tanggal, satuan);
                suksesL.setVisible(true);
                suksesL.setText("Berhasil Ditambahkan");
                pbDao.saveDataPenerimaanBarang(pb);
            } catch (Exception e) {
                suksesL.setVisible(true);
                suksesL.setText("Data Tersebut Tidak Valid \nCoba Anda Periksa Kembali");
            }
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
}
