package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Vasarlo;

/**
 * @author Tam�ssy Urm�s
 *
 */
public class VasarloDao {
	/**
	 * Hozz�ad egy v�s�rl�t
	 * @param vasarlo
	 * @return
	 */
	public static int addVasarlo(Vasarlo vasarlo){
		int id=-1;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("INSERT INTO VASARLO(NEV,SZAMLACIM,SZALLITCIM,SZALLITCIM2,TORZSE,"
					+ "OSSZESKOLTSEG,TETELSZAM)"+
					" VALUES (?, ?, ?, ?, ?, ?, ?)"
					, new String[]{"ID"});
			try{
				s.setString(1, vasarlo.getNev());
				s.setString(2, vasarlo.getSzamlaCim());
				s.setString(3, vasarlo.getSzallitCim());
				s.setString(4, vasarlo.getSzallitCim2());
				s.setBoolean(5, vasarlo.isTorzsE());
				s.setInt(6, vasarlo.getOsszesKoltseg());
				s.setInt(7, vasarlo.getTetelSzam());
				s.execute();
				ResultSet rs=s.getGeneratedKeys();
				try{
					if(rs.next()) id=rs.getInt(1);
				}finally{
					rs.close();
				}
			}finally{
				s.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	/**
	 * Lek�ri az �sszes v�s�rl�t
	 * @return
	 */
	public static List<Vasarlo> getVasarlok(){
		List<Vasarlo> list=new ArrayList<Vasarlo>();
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
			+ "ID,NEV,SZAMLACIM,SZALLITCIM,SZALLITCIM2,TORZSE,OSSZESKOLTSEG,TETELSZAM"
			+ " FROM VASARLO");
			try{
				ResultSet rs=s.executeQuery();
				try{
					while(rs.next()){
						list.add(new Vasarlo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getBoolean(6), rs.getInt(7), rs.getInt(8)));
					}
				}finally{
					rs.close();
				}
			}finally{
				s.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
