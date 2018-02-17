package ostoslista.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ostoslista.model.Ostos;

public class OstosDAO extends DataAccessObject{

	


	public ArrayList<Ostos> haeOstokset() {
		Connection yhteys = null;
		PreparedStatement prepStatement = null;
		ResultSet resultSetti = null;
		ArrayList<Ostos> ostoslista = new ArrayList<Ostos>();
		Ostos ostos = null;
		
		try {
		
		yhteys = getConnection();
		String valitse = "SELECT id, nimi, maara, kuvaus, hinta FROM ostoslista;";
		prepStatement = yhteys.prepareStatement(valitse);
		resultSetti = prepStatement.executeQuery();
		while (resultSetti.next()) {
			ostos = lueOstos(resultSetti);
			ostoslista.add(ostos);
		}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(resultSetti, prepStatement, yhteys); 
		}
	
		return ostoslista;
	}
		
	
	private Ostos lueOstos(ResultSet resultSetti) {	
		try {
			
			int id = resultSetti.getInt("id");
			String nimi = resultSetti.getString("nimi");
			int maara = resultSetti.getInt("maara");
			String kuvaus = resultSetti.getString("kuvaus");
			double hinta = resultSetti.getDouble("hinta");
		
		
			return new Ostos(id, nimi, maara, kuvaus, hinta);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public void lisaaOstos(Ostos ostos)throws SQLException {
		Connection yhteys = null;
		PreparedStatement statementInsert = null;
		
		try {
			yhteys = getConnection();
			String sqlInsert = "INSERT INTO ostoslista(id, nimi, maara, kuvaus, hinta) VALUES(?,?,?,?,?)";
			statementInsert = yhteys.prepareStatement(sqlInsert);
			statementInsert.setInt(1, ostos.getId());
			statementInsert.setString(2, ostos.getNimi());
			statementInsert.setInt(3, ostos.getMaara());
			statementInsert.setString(4, ostos.getKuvaus());
			statementInsert.setDouble(5, ostos.getHinta());
			statementInsert.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(statementInsert, yhteys);
		}
		
		
		
	}
	
	public void poistaOstos(int id) throws SQLException {
		Connection yhteys = null;
		PreparedStatement statementDelete = null;
		
		try {
			yhteys = getConnection();
			String sqlDelete = "DELETE FROM ostoslista WHERE id = ?;";
			statementDelete = yhteys.prepareStatement(sqlDelete);
			statementDelete.setInt(1, id);
			statementDelete.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(statementDelete, yhteys);
		}
}
	
	public void muutaOstos(Ostos ostos)throws SQLException {
		Connection yhteys = null;
		PreparedStatement statementUpdate = null;

		yhteys = getConnection();
		String sqlUpdate = "UPDATE ostoslista SET id=?, nimi=?, maara=?, kuvaus=?, hinta=? WHERE id=?;";
		statementUpdate = yhteys.prepareStatement(sqlUpdate);
		statementUpdate.setInt(1,  ostos.getId());;
		statementUpdate.setString(2, ostos.getNimi());
		statementUpdate.setInt(3, ostos.getMaara());
		statementUpdate.setString(4, ostos.getKuvaus());
		statementUpdate.setDouble(5, ostos.getHinta());
		statementUpdate.setInt(6, ostos.getId());
		statementUpdate.executeUpdate();
}


	public Ostos haeOstosId(int id) throws SQLException {
		Connection yhteys = null;
		PreparedStatement statementHaku = null;
		Ostos ostos = null;
		
		try {
			yhteys = getConnection();
			
			String sqlHaku = "SELECT * FROM ostoslista WHERE id=?;";
			statementHaku = yhteys.prepareStatement(sqlHaku);
			statementHaku.setInt(1, id);
			ResultSet resultSetti = statementHaku.executeQuery();
			ostos = new Ostos();
			
			if (resultSetti.next()) {
				ostos.setNimi(resultSetti.getString("nimi"));
				ostos.setMaara(resultSetti.getInt("maara"));
				ostos.setKuvaus(resultSetti.getString("kuvaus"));
				ostos.setHinta(resultSetti.getDouble("hinta"));
				
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(statementHaku, yhteys);
		}
		return ostos;
	}

}