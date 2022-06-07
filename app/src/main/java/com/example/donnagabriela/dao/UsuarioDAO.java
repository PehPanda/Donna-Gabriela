package com.example.donnagabriela.dao;

import com.example.donnagabriela.conexao.Conexao;
import com.example.donnagabriela.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {

    public Usuario selecionaUsuario(String usuario, String senha){

        try {
            Connection conn = Conexao.conectar();
            if(conn != null){
                String sql = "select * from usuario where usuario = '"+usuario+"' and senha = '"+senha+"'";
                Statement st = null;
                st = conn.createStatement();

                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    Usuario usu = new Usuario();
                    usu.setCodigo(rs.getInt(1));
                    usu.setUsuario(rs.getString(2));
                    usu.setSenha(rs.getString(3));

                    conn.close();
                    return usu;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }
}
