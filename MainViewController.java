package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.PasswordField;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class MainViewController implements Initializable {
	@FXML
	private TableView<TableModel> tAble;
	@FXML
	private TableColumn<TableModel,String> rID;
	@FXML
	private TableColumn<TableModel,String> rPW;
	@FXML
	private TableColumn<TableModel,String> rPH;
	@FXML
	private TextField ipID;
	@FXML
	private TextField ipPH;
	@FXML
	private PasswordField ipPW;
	
	ObservableList<TableModel> oblist = FXCollections.observableArrayList();
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	// Event Listener on Button.onAction
	@FXML
	public void getRegister(ActionEvent event) {
		// TODO Autogenerated
		Connection conn = DBConnection.getConnection();
		String sql = "insert into TEST1 (id,pw,phone) values(?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, ipID.getText());
			pst.setString(2, ipPW.getText());
			pst.setString(3, ipPH.getText());
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Users Add Success");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Connection conn = DBConnection.getConnection();
		try {
			ResultSet rs = conn.createStatement().executeQuery("select * from TEST1");
			while(rs.next()) {
				oblist.add(new TableModel(rs.getString("id"),rs.getString("pw"),rs.getString("phone")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rID.setCellValueFactory(new PropertyValueFactory<>("id"));
		rPW.setCellValueFactory(new PropertyValueFactory<>("pw"));
		rPH.setCellValueFactory(new PropertyValueFactory<>("phone"));
		
		
		tAble.setItems(oblist);
	}
}
