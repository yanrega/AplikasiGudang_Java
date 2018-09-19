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
import org.gudang.Dao.StaffDao;
import org.gudang.Dao.impl.StaffDaoImplHibernate;
import org.gudang.model.Staff;

public class DataStaffController implements Initializable {

    private StaffDao sDao;
    @FXML
    private TableView<Staff> tabelStaff;
    @FXML
    private TableColumn< Staff, String> idTC;
    @FXML
    private TableColumn< Staff, String> namaTC;
    @FXML
    private TableColumn< Staff, String> nohpTC;
    @FXML
    private TableColumn< Staff, String> alamatTC;
    @FXML
    private TableColumn< Staff, String> usernameTC;
    ObservableList<Staff> data;

    public DataStaffController() {
        sDao=new StaffDaoImplHibernate();
        tabelStaff=new TableView<>();
    }

    /**
     * Initializes the controller class.
     */
    
    
    private void loadData(){
        List<Staff> staffs = sDao.getAllStaff();
        data=FXCollections.observableArrayList(staffs);
        idTC.setCellValueFactory(new PropertyValueFactory<Staff, String>("id"));
        namaTC.setCellValueFactory(new PropertyValueFactory<Staff,String>("nama"));
        nohpTC.setCellValueFactory(new PropertyValueFactory<Staff, String>("nomorHP"));
        alamatTC.setCellValueFactory(new PropertyValueFactory<Staff,String>("alamat"));
        usernameTC.setCellValueFactory(new PropertyValueFactory<Staff,String>("username"));
        tabelStaff.setItems(data);
    }
    
    @FXML
    public void btnKembali(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/Home.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadData();
    }

}
