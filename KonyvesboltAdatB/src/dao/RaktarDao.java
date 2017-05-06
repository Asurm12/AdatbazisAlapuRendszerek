package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;
import model.Aruhaz;
import model.Raktar;
import model.Termek;

/**
 * @author Tam�ssy Urm�s
 *
 */
public class RaktarDao {
	/**
	 * Id alapj�n m�dos�t egy sort.
	 * @param raktarId
	 * @param raktar
	 */
	public static void update(int raktarId, Raktar raktar){
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("update RAKTAR set TERMEKID=?, TERMEKTIPUS=?, DARAB=?, ARUHAZID=? WHERE ID=?");
			try{
				s.setInt(1, raktar.getTermek().getId());
				s.setString(2, raktar.getTermek().getTipus());
				s.setInt(3, raktar.getDarab());
				s.setInt(4, raktar.getAruhaz().getId());
				s.setInt(5, raktarId);
				s.execute();
			}finally{
				s.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 *  Cs�kkenti egy sor(term�k �s �ruh�z alapj�n)) darab attrib�tum�t 1-el.
	 * @param aruhazId
	 * @param termekId
	 * @param termekTipus
	 */
	public static void keszletCsokkentes(int aruhazId,int termekId,String termekTipus){
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("update RAKTAR set DARAB=DARAB-1 WHERE TERMEKID=? AND ARUHAZID=? AND TERMEKTIPUS LIKE ?");
			try{
				s.setInt(1, termekId);
				s.setInt(2, aruhazId);
				s.setString(3, termekTipus);
				s.execute();
			}finally{
				s.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Lek�ri a term�k k�szlet�t, -1 ha nincs tal�lat.
	 * @param aruhazId
	 * @param termekId
	 * @param termekTipus
	 * @return
	 */
	public static int keszlet(int aruhazId,int termekId,String termekTipus){
		int darab=-1;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT DARAB FROM RAKTAR WHERE TERMEKID=? AND ARUHAZID=? AND TERMEKTIPUS LIKE ?");
			try{
				s.setInt(1, termekId);
				s.setInt(2, aruhazId);
				s.setString(3, termekTipus);
				ResultSet rs=s.executeQuery();
				try{
					if(rs.next()){
						darab=rs.getInt(1);
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
		return darab;
	}
	/**
	 * Hozz�ad egy rakt�rat (adott term�k darabsz�mmal)
	 * @param raktar
	 * @return
	 */
	public static int addRaktar(Raktar raktar){
		int id=-1;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("INSERT INTO RAKTAR (TERMEKID,TERMEKTIPUS,DARAB,ARUHAZID) VALUES (?,?,?,?)",new String[]{"ID"});
			try{
				s.setInt(1, raktar.getTermek().getId());
				s.setString(2, raktar.getTermek().getTipus());
				s.setInt(3, raktar.getDarab());
				s.setInt(4, raktar.getAruhaz().getId());
				
				ResultSet rs=s.executeQuery();
				try{
					if(rs.next()){
						id=rs.getInt(1);
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
		return id;
	}
	/**
	 * Visszaadja az �sszes t�rolt term�ket
	 * @return
	 */
	public static List<Raktar> getRaktarak(){
		List<Raktar> list=new ArrayList<Raktar>();
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
			+ "RAKTAR.ID,RAKTAR.TERMEKID,RAKTAR.TERMEKTIPUS,RAKTAR.DARAB,RAKTAR.ARUHAZID,ARUHAZ.CIM,ARUHAZ.DOLGOZOSZAM,ARUHAZ.NYITVATART"
			+ " FROM RAKTAR,ARUHAZ WHERE RAKTAR.ARUHAZID=ARUHAZ.ID");
			try{
				ResultSet rs=s.executeQuery();
				try{
					while(rs.next()){
						String termekTipus=rs.getString(3);
						int termekId=rs.getInt(2);
						Termek termek=TermekDao.getTermek(termekId, termekTipus);
						list.add(new Raktar(rs.getInt(1), termek,
								rs.getInt(4), new Aruhaz(rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8))));
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
