package net.muni.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.muni.entidad.Usuario;
import net.muni.utils.MySqlBDConexion;

public class ModelUsuario {
	public Usuario iniciarSesion(String cod ,String dni){
		Usuario obj=null;
		Connection cn=null;
		ResultSet rs=null;
		PreparedStatement pstm=null;
		
		try {
		String sql="select * from usuario where IdUser=? and DniUser=?";
		cn=MySqlBDConexion.getConexion();
		pstm=cn.prepareStatement(sql);
		pstm.setString(1, cod);
		pstm.setString(2, dni);
		rs=pstm.executeQuery();
		
		if(rs.next()){
			obj=new Usuario();
				obj.setCod(rs.getInt(1));
				obj.setNom(rs.getString(2));
				obj.setApe(rs.getString(3));
				obj.setDni(rs.getInt(4));
				obj.setCel(rs.getInt(5));
				obj.setEmail(rs.getString(6));
				obj.setTipo(rs.getString(7));
				obj.setArea(rs.getString(8));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return obj;
		}
}
