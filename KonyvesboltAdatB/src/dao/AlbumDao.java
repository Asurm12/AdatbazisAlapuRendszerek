package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;
import model.Konyv;

/**
 * @author Tam�ssy Urm�s
 *
 */
public class AlbumDao {
	/**
	 * Albumok hozz�ad�sa
	 * @param album
	 * @return
	 */
	public static int addAlbum(Album album){
		int id=0;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("INSERT INTO ALBUM(ELOADO, CIM, MUFAJ, AR)"+
		" VALUES (?, ?, ?, ?)"
					, new String[]{"ID"});
			try{
				s.setString(1, album.getEloado());
				s.setString(2, album.getCim());
				s.setString(3, album.getMufaj());
				s.setInt(4, album.getAr());
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
	public static List<Album> getAlbumok(){
		List<Album> list=new ArrayList<Album>();
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
			+ "ID,ELOADO,CIM,MUFAJ,AR"
			+ " FROM ALBUM");
			try{
				ResultSet rs=s.executeQuery();
				try{
					while(rs.next()){
						list.add(new Album(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
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
	public static Album getAlbumIdSzerint(int AlbumId){
		Album album=null;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
			+ "ID,ELOADO,CIM,MUFAJ,AR"
			+ " FROM ALBUM where ID=?");
			try{
				s.setInt(1, AlbumId);
				ResultSet rs=s.executeQuery();
				try{
					if(rs.next()){
						album=new Album(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
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
		return album;
	}
}
