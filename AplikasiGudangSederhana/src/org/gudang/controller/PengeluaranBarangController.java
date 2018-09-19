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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.gudang.Dao.PengeluaranBarangDao;
import org.gudang.Dao.ReservasiDao;
import org.gudang.Dao.impl.ReservasiDaoImplHibernate;
import org.gudang.model.PengeluaranBarang;
import org.gudang.model.Reservasi;

public class PengeluaranBarangController implements Initializable {

    @FXML
    private TableView<Reservasi> tabelReservasiTC;
    @FXML
    private TableColumn<Reservasi, String> idReservasiTC;
    @FXML
    private TableColumn<Reservasi, String> idBarangTC;
    @FXML
    private TableColumn<Reservasi, String> jumlahTC;
    @FXML
    private TableColumn<Reservasi, String> satuanTC;
    @FXML
    private TableColumn<Reservasi, String> statusTC;
    @FXML
    private TableColumn<Reservasi, String> tujuanTC;
    @FXML
    private TextField idReservasiTF;
    @FXML
    private TextField idStaffTF;
    @FXML
    private DatePicker tanggalTF;

    private ReservasiDao reservasiDao;
    private PengeluaranBarangDao pengeluaranBarangDao;
    ObservableList<Reservasi> data;

    public PengeluaranBarangController() {
        reservasiDao = new ReservasiDaoImplHibernate();
        tabelReservasiTC = new TableView<>();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }

    private void loadData() {
        List<Reservasi> reservasis = reservasiDao.getAllReservasi();
        data = FXCollections.observableArrayList(reservasis);
        idReservasiTC.setCellValueFactory(new PropertyValueFactory<Reservasi, String>("idReservasi"));
        idBarangTC.setCellValueFactory(new PropertyValueFactory<Reservasi, String>("idBarang"));
        jumlahTC.setCellValueFactory(new PropertyValueFactory<Reservasi, String>("jumlahBarang"));
        satuanTC.setCellValueFactory(new PropertyValueFactory<Reservasi, String>("satuan"));
        tujuanTC.setCellValueFactory(new PropertyValueFactory<Reservasi, String>("tujuan"));
        tabelReservasiTC.setItems(data);
    }

    @FXML
    public void btnSimpan(ActionEvent event) throws IOException {
        int idReservasi = Integer.parseInt(idReservasiTF.getText());
        //String idReservasi = idReservasiTF.getText();
        String idBarang = idBarangTC.getCellData(idReservasi);
        String idStaff = idStaffTF.getText();
        String jumlah = jumlahTC.getCellData(idReservasi);
        String tanggal = tanggalTF.getValue().toString();
        String satuan = satuanTC.getCellData(idReservasi);
        String tujuan = tujuanTC.getCellData(idReservasi);
        try {
            reservasiDao.deleteReservasi(idReservasi);
            //pengeluaranBarangDao.konfirmasi(reservasiDao.getTujuan(idReservasi), idReservasi);

        } catch (Exception e) {
            System.out.println("Ada Yang salah " + e);
        }

        PengeluaranBarang pengeluaranBarang = new PengeluaranBarang(0, idReservasi, idBarang, idStaff, jumlah, tanggal, satuan, tujuan);
        pengeluaranBarangDao.saveDataPengeluaranBarang(pengeluaranBarang);
        loadData();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/PengeluaranBarang.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
        //loadData();
//        PengeluaranBarang pengeluaranBarang=new PengeluaranBarang(0, 0, 0, jumlah, tanggal, satuan);
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
