package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.isteMySQL.Util.VeriTabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

import java.sql.*;

public class LoginController {
	
	public LoginController() {
		baglanti=VeriTabaniUtil.Baglan();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_giris;

    @FXML
    private TextField txt_kuladi;

    @FXML
    private TextField txt_sifre;
    Connection baglanti=null;
    PreparedStatement SorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btn_giris_click(ActionEvent event) {
    sql="select * from login where kul_adi=? and sifre=?";
   
    try {
		SorguIfadesi=baglanti.prepareStatement(sql);
		SorguIfadesi.setString(1, txt_kuladi.getText().trim());
		SorguIfadesi.setString(2, VeriTabaniUtil.MD5Sifrele(txt_sifre.getText().trim()));
		
		ResultSet getirilen=SorguIfadesi.executeQuery();
		if(!getirilen.next()) {
			
				Alert alert=new Alert(AlertType.ERROR);
				alert.setTitle("Akaryakit otomasyonu");
				alert.setHeaderText("Hata Mesaji");
				alert.setContentText("Kullanýcý adý veya þifre hatalý...");
				
				alert.showAndWait();
		}else {
			if(getirilen.getInt(4)==1) {
				try{
			        Stage stage=new Stage();
			        Parent root = FXMLLoader.load(getClass().getResource("YoneticiKontrolSayfasi.fxml"));
			        stage.setScene(new Scene(root));
			        stage.show();
			        }
			        catch(Exception e){
			            System.out.println(e.toString());
			        }
			}
			else {
				try{
			        Stage stage=new Stage();
			        Parent root = FXMLLoader.load(getClass().getResource("KullaniciSayfasi.fxml"));
			        stage.setScene(new Scene(root));
			        stage.show();
			        }
			        catch(Exception e){
			            System.out.println(e.toString());
			        }
			}
		}
		
		
		
    }catch (Exception e) {
		// TODO: handle exception
	}
    }
    @FXML
    void initialize() {
      

    }

}
