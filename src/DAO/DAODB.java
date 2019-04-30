
package DAO;

import Classes.Cidade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAODB implements DAO {

    private Connection getConnection() {
        String url = "jdbc:derby://localhost:1527/banco";
        String user = "Arthur";
        String password = "volpe123";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(Cidade cidade) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO cidade (id, nome, estado, pais, populacao) VALUES (?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, cidade.getId());
            pstm.setString(2, cidade.getNome());
            pstm.setString(3, cidade.getEstado());
            pstm.setString(4, cidade.getPais());
            pstm.setInt(5, cidade.getPopulacao());
            pstm.executeUpdate();

            conn.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Cidade read(int id) {
        try {
            Cidade resposta = new Cidade();
            Connection conn = getConnection();
            String sql = "SELECT * FROM cidade WHERE id=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            if (!rs.next()){ 
                return null; }

            resposta.setId(rs.getInt(sql));
            resposta.setNome(rs.getString(sql));
            resposta.setEstado(rs.getString(sql));
            resposta.setPais(rs.getString(sql));
            resposta.setPopulacao(rs.getInt(sql));
            
            pstm.close();
            conn.close();
            return resposta;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Cidade cidade) {
        try{
            Connection conn= getConnection ();
            String sql = "UPDATE cidade SET nome=?, estado=?, pais=?, populacao=? WHERE id=?";
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setString(1, cidade.getNome());
            pstm.setString(2, cidade.getEstado());
            pstm.setString(3, cidade.getPais());
            pstm.setInt(4, cidade.getPopulacao());
            pstm.setInt(5, cidade.getId());
            pstm.executeUpdate();
            
            pstm.close();
            conn.close();
            return true;
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Cidade cidade) {
        try {
            Connection conn = getConnection();
            String sql = "DELETE FROM cidade WHERE id=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, cidade.getId());
            pstm.executeUpdate();
            
            pstm.close();
            conn.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

