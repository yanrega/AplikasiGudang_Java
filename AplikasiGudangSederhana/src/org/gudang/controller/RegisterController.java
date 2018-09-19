/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gudang.controller;

import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.gudang.Dao.StaffDao;
import org.gudang.Dao.impl.StaffDaoImplHibernate;
import org.gudang.model.Staff;

public class RegisterController implements Initializable {

    @FXML
    private TextField namaTF;
    @FXML
    private TextField nomorHpTF;
    @FXML
    private TextField alamatTF;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField confirmPasswordTF;
    @FXML
    private Label suksesL;
    @FXML
    private Label namaL;
    @FXML
    private Label usernameRL;
    @FXML
    private Label noHPL;
    @FXML
    private Label alamatL;
    @FXML
    private Label passL;
    @FXML
    private Label confPassL;

    ObservableList<Staff> data;

    private StaffDao sDao;

    public RegisterController() {
        sDao = new StaffDaoImplHibernate();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }

    @FXML
    public void btnDaftar(ActionEvent event) throws IOException {

        String nama = namaTF.getText();
        String nomorHp = nomorHpTF.getText();
        String alamat = alamatTF.getText();
        String username = usernameTF.getText();
        String password = passwordTF.getText();

        if (namaTF.getText().equalsIgnoreCase("") && usernameTF.getText().equals("")) {
            namaL.setVisible(true);
            namaL.setText("nama tidak boleh kosong");
            usernameRL.setVisible(true);
            usernameRL.setText("username tidak boleh kosong");
        }

        if (nomorHpTF.getText().equalsIgnoreCase("") && alamatTF.getText().equals("")) {
            noHPL.setVisible(true);
            noHPL.setText("no.Hp tidak boleh kosong");
            alamatL.setVisible(true);
            alamatL.setText("alamat tidak boleh kosong");
        }

        if (passwordTF.getText().equalsIgnoreCase("") && confirmPasswordTF.getText().equals("")) {
            passL.setVisible(true);
            passL.setText("password tidak boleh kosong");
            confPassL.setVisible(true);
            confPassL.setText("confirmasi password tidak boleh kosong");
        } else if (!confirmPasswordTF.getText().equals(password)) {
            LabelAwalRegistrasiPass();
            confPassL.setVisible(true);
            confPassL.setText("password tidak sesuai");
        } else {
            Staff s = new Staff(0, nama, nomorHp, alamat, username, password);
            suksesL.setVisible(true);
            sDao.saveDataStaff(s);
            inisialisasiAwalInputanStaff();
            LabelAwalRegistrasi();

            ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            Pane myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/Login.fxml"));
            Scene scene = new Scene(myPane);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void btnBack(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        Pane myPane = null;
        myPane = FXMLLoader.load(getClass().getResource("/org/gudang/view/Login.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

    public void loadData() {
        List<Staff> staffs = sDao.getAllStaff();
        data = FXCollections.observableArrayList(staffs);
        String nama = namaTF.getText();
        String nomorHp = nomorHpTF.getText();
        String alamat = alamatTF.getText();
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        String confirmasi = confirmPasswordTF.getText();
    }

    private void inisialisasiAwalInputanStaff() {
        namaTF.setText("");
        usernameTF.setText("");
        nomorHpTF.setText("");
        alamatTF.setText("");
        passwordTF.setText("");
        confirmPasswordTF.setText("");
    }

    private void LabelAwalRegistrasi() {
        namaL.setText("");
        usernameRL.setText("");
        noHPL.setText("");
        alamatL.setText("");
        passL.setText("");
        confPassL.setText("");
        suksesL.setText("");
    }

    private void LabelAwalRegistrasiPass() {
        namaL.setText("");
        usernameRL.setText("");
        noHPL.setText("");
        alamatL.setText("");
        passL.setText("");
        suksesL.setText("");
    }

}
