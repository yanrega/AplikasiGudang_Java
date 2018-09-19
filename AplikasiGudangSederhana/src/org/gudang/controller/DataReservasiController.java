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
import org.gudang.Dao.ReservasiDao;
import org.gudang.Dao.impl.ReservasiDaoImplHibernate;
import org.gudang.model.Reservasi;

public class DataReservasiController implements Initializable {

    private ReservasiDao rdDao;
    @FXML
    private TableView<Reservasi> tabelReservasiTV;
    @FXML
    private TableColumn<Reservasi, String> idReservasiTV;
    @FXML
    private TableColumn<Reservasi, String> idBarangTV;
    @FXML
    private TableColumn<Reservasi, String> jlhBarangTV;
    @FXML
    private TableColumn<Reservasi, String> satuanTV;
    @FXML
    private TableColumn<Reservasi, String> statusTV;
    @FXML
    private TableColumn<Reservasi, String> tujuanTV;

    ObservableList<Reservasi> data;

    public DataReservasiController() {
        rdDao = new ReservasiDaoImplHibernate();
        tabelReservasiTV = new TableView<>();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }

    private void loadData() {
        List<Reservasi> reservasis = rdDao.getAllReservasi();
        data = FXCollections.observableArrayList(reservasis);
        idReservasiTV.setCellValueFactory(new PropertyValueFactory<Reservasi, String>("idReservasi"));
        idBarangTV.setCellValueFactory(new PropertyValueFactory<Reservasi, String>("idBarang"));
        jlhBarangTV.setCellValueFactory(new PropertyValueFactory<Reservasi, String>("jumlahBarang"));
        satuanTV.setCellValueFactory(new PropertyValueFactory<Reservasi, String>("satuan"));
        statusTV.setCellValueFactory(new PropertyValueFactory<Reservasi, String>("status"));
        tujuanTV.setCellValueFactory(new PropertyValueFactory<Reservasi,String>("tujuan"));
        tabelReservasiTV.setItems(data);
    }

    @FXML
    public void btnKembali(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/Reservasi.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

}
