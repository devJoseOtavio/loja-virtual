package loja_process;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource datasource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooleDataSource = new ComboPooledDataSource();
		comboPooleDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?userTimezone=true&serverTimezone=UTC");
		comboPooleDataSource.setUser("root");
		comboPooleDataSource.setPassword("root");
		
		comboPooleDataSource.setMaxPoolSize(15);
		
		this.datasource = comboPooleDataSource;
	}
	
	public Connection recuperarConexao() throws SQLException {
		return this.datasource.getConnection();
	}
}
