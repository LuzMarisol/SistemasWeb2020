package mx.uv.basededatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private static Conexion conexion = new Conexion();

    public static List<Usuarios> dameUsuarios(){
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        List<Usuarios> resultado = new ArrayList<>();

        con = Conexion.getConnection();
        try {
            String sql = "SELECT * FROM usuarios";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                Usuarios u = new Usuarios (rs.getString("id"), rs.getString("email"), rs.getString("password"));
                resultado.add(u);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if(stm != null){
                try {
                    stm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                stm = null;
            }
            try{
                con.close();
                System.out.println("Closed connection!");
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        return resultado;
    
}

//INSERTAR USUARIOS
public static String  crearUsuarios(Usuarios u){
    PreparedStatement stm = null;
    Connection con = null;
    ResultSet rs = null;
    List<Usuarios> resultado = new ArrayList<>();
    String msj = "";
    con = Conexion.getConnection();
    try {
        String sql = "INSERT INTO usuarios (id, email, password), VALUES (?,?,?)";
        stm = con.prepareStatement(sql);
        stm.setString(1, u.getId());
        stm.setString(2, u.getEmail());
        stm.setString(3, u.getPassword());
        
		if(stm.executeUpdate()>0)
            msj = "El usuario fue agregado";
        else
            msj = "No se pudo agregar el usuario";
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(stm != null){
            try {
                stm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            stm = null;
        }
        try{
            con.close();
            System.out.println("Closed connection!");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    return msj;
    }
}

/*Borrar USUARIOS
public static String  eliminarUsuarios(Usuarios u){
    PreparedStatement stm = null;
    Connection con = null;
    ResultSet rs = null;
    List<Usuarios> resultado = new ArrayList<>();
    String msj = "";
    con = Conexion.getConnection();
    try {
        String sql = "DELETE FROM usuarios WHERE id = ?");
        stm = con.prepareStatement(sql);
        stm.setString(1, u.getId());
        //stm.setString(2, u.getEmail());
        //stm.setString(3, u.getPassword());
        
		if(stm.executeUpdate()>0)
            msj = "El usuario fue agregado";
        else
            msj = "No se pudo agregar el usuario";
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(stm != null){
            try {
                stm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            stm = null;
        }
        try{
            con.close();
            System.out.println("Closed connection!");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    return msj;
    }
}*/