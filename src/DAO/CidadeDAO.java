package DAO;

import Classes.Cidade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {

    private PreparedStatement stmC;
    private PreparedStatement stmR;
    private PreparedStatement stmU;
    private PreparedStatement stmD;
    private Connection conn;

    public CidadeDAO() {
        try {
            this.conn = DriverManager.getConnection("jdbc:derby://localhost:1527/banco", "Arthur", "volpe123");
            this.stmC = this.conn.prepareStatement("INSERT INTO CIDADE(NOME, ESTADO, PAIS, POPULACAO) VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            this.stmR = this.conn.prepareStatement("SELECT * FROM CIDADE");
            this.stmU = this.conn.prepareStatement("UPDATE CIDADE SET NOME=?, ESTADO=?, PAIS=?, POPULACAO=? WHERE ID=?");
            this.stmD = this.conn.prepareStatement("DELETE FROM CIDADE WHERE ID=?");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cidade> read() {
        try {
            ResultSet rs = this.stmR.executeQuery();

            List<Cidade> cidades = new ArrayList<>();

            while (rs.next()) {
                Cidade c = new Cidade();
                c.setId(rs.getInt("ID"));
                c.setNome(rs.getString("NOME"));
                c.setEstado(rs.getString("ESTADO"));
                c.setPais(rs.getString("PAIS"));
                c.setPopulacao(rs.getInt("POPULACAO"));
                cidades.add(c);
            }

            return cidades;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cidade create(Cidade cidade) {
        try {
            this.stmC.setString(1, cidade.getNome());
            this.stmC.setString(2, cidade.getEstado());
            this.stmC.setString(3, cidade.getPais());
            this.stmC.setInt(4, cidade.getPopulacao());

            this.stmC.executeUpdate();

            ResultSet rs = this.stmC.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            cidade.setId(id);

            return cidade;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(Cidade cidade, int id) {
        try {
            this.stmU.setString(1, cidade.getNome());
            this.stmU.setString(2, cidade.getEstado());
            this.stmU.setString(3, cidade.getPais());
            this.stmU.setInt(4, cidade.getPopulacao());
            this.stmU.setInt(5, id);

            this.stmU.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean delete(int id) {
        try {
            this.stmD.setInt(1, id);
            this.stmD.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
