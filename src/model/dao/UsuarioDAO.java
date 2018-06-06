/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.MyBatisUtils;
import model.pojos.Curso;
import model.pojos.Usuario;
import model.pojos.Grupo;
import model.pojos.Login;
import org.apache.ibatis.session.SqlSession;

public class UsuarioDAO {
    public static List<Usuario> obtenerAllUsuarios()
    {
        List<Usuario> lista = new ArrayList<Usuario>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            lista = conn.selectList("Usuario.obtenerAllUsuarios");
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return lista;
    }
    
    public static Usuario obtenerUsuario(Login log)
    {
        Usuario user = null;
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            user = conn.selectOne("Usuario.obtenerUsuario",log);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return user;
    }
        
    public static boolean registrarUsuario(Usuario u){
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            conn.insert("Usuario.registrarUsuario",u);
            conn.commit();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return false;
    }
    
    public static boolean eliminarUsuario(Integer id){
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            conn.delete("Usuario.eliminarUsuario",id);
            conn.commit();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return false;
    }
    
   public static List<Grupo> obtenerGrupoDeUsuario(Integer id)
    {
        List<Grupo> lista = new ArrayList<Grupo>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            lista = conn.selectList("Usuario.obtenerGrupoDeUsuario",id);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return lista;
    }
   
   public static List<Curso> obtenerCursosDeUsuario(Integer id)
    {
        List<Curso> lista = null;
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            lista = conn.selectList("Usuario.obtenerCursosDeUsuario",id);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return lista;
    }

    public static Usuario obtenerUsuarioId(Integer idUsuario)
    {
        Usuario user = null;
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            user = conn.selectOne("Usuario.obtenerUsuarioId", idUsuario);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return user;
    }
}
