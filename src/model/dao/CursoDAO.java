/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.MyBatisUtils;
import model.pojos.Categoria;
import model.pojos.Curso;
import model.pojos.Grupo;
import model.pojos.Maestro;
import model.pojos.Pago;
import org.apache.ibatis.session.SqlSession;

public class CursoDAO {
    public static List<Curso> obtenerAllCursos()
    {
        List<Curso> lista = new ArrayList<Curso>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            lista = conn.selectList("Curso.obtenerAllCursos");
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return lista;
    }
    
    public static List<Curso> obtenerAllCursosOrdenados()
    {
        List<Curso> lista = new ArrayList<Curso>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            lista = conn.selectList("Curso.obtenerAllCursosOrdenados");
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return lista;
    }
    
    public static List<Curso> obtenerAllCursosDeCategoria(Categoria cat)
    {
        List<Curso> lista = new ArrayList<Curso>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            lista = conn.selectList("Curso.obtenerAllCursosDeCategoria",cat);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return lista;
    }
    
    public static List<Categoria> obtenerCategorias()
    {
        List<Categoria> lista = new ArrayList<Categoria>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            lista = conn.selectList("Curso.obtenerCategorias");
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return lista;
    }

    public static Categoria obtenerCategoriaCurso(Integer idCategoria)
    {
        Categoria lista = new Categoria();
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            lista = conn.selectOne("Curso.obtenerCategoriaCurso", idCategoria);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return lista;
    }

    public static Maestro obtenerMaestroCurso(Integer idMaestro)
    {
        Maestro lista = new Maestro();
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            lista = conn.selectOne("Curso.obtenerMaestroCurso", idMaestro);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return lista;
    }
    
    public static Curso obtenerCurso(String nombre)
    {
        Curso curso = new Curso();
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            curso = conn.selectOne("Curso.obtenerCurso",nombre);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return curso;
    }
        
    public static boolean registrarCurso(Curso c){
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            conn.insert("Curso.registrarCurso",c);
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
    
    public static boolean eliminarCurso(Integer id){
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            conn.delete("Curso.eliminarCurso",id);
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
    
   public static List<Grupo> obtenerGrupoDeCurso(Integer id)
    {
        List<Grupo> lista = new ArrayList<Grupo>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            lista = conn.selectList("Curso.obtenerGrupoDeCurso",id);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return lista;
    }
   
    public static boolean registrarGrupo(Grupo g){
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            conn.insert("Curso.registrarGrupo",g);
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

    public static void nuevoEstudianteGrupo(Grupo g){
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            conn.insert("Curso.nuevoEstudianteGrupo",g);
            conn.commit();
            //return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        //return false;
    }

    public static boolean registrarPago(Pago p){
        SqlSession conn = null;
        try{
            conn = MyBatisUtils.getSession();
            conn.insert("Curso.registrarPago", p);
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
}
