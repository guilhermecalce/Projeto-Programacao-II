package DAO;

import Classes.ContaBancaria;
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

public class ContaBancariaDAO {

    private PreparedStatement stmC;
    private PreparedStatement stmR;
    private PreparedStatement stmU;
    private PreparedStatement stmD;
    private Connection conn;

    public ContaBancariaDAO() {
        try {
            
            this.conn = DriverManager.getConnection("jdbc:derby://localhost:1527/banco", "Arthur", "volpe123");
            this.stmC = this.conn.prepareStatement("INSERT INTO CONTABANCARIA(NOME_TITULAR, SALDO, NUMERO_AGENCIA) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            this.stmR = this.conn.prepareStatement("SELECT * FROM CONTABANCARIA");
            this.stmU = this.conn.prepareStatement("UPDATE CONTABANCARIA SET NOME_TITULAR=?, SALDO=?, NUMERO_AGENCIA=? WHERE ID=?");
            this.stmD = this.conn.prepareStatement("DELETE FROM CONTABANCARIA WHERE ID=?");
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

    public List<ContaBancaria> read() {
        try {
            ResultSet rs = this.stmR.executeQuery();

            List<ContaBancaria> contasbancaria = new ArrayList<>();

            while (rs.next()) {
                ContaBancaria cb = new ContaBancaria();
                cb.setIdcb(rs.getInt("ID"));
                cb.setNomeTitular(rs.getString("NOME_TITULAR"));
                cb.setSaldo(rs.getInt("SALDO"));
                cb.setNumeroAgencia(rs.getInt("NUMERO_AGENCIA"));
                contasbancaria.add(cb);
            }

            return contasbancaria;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ContaBancaria create(ContaBancaria contabancaria) {
        try {
            this.stmC.setString(1, contabancaria.getNomeTitular());
            this.stmC.setInt(2, contabancaria.getSaldo());
            this.stmC.setInt(3, contabancaria.getNumeroAgencia());

            this.stmC.executeUpdate();

            ResultSet rs = this.stmC.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            contabancaria.setIdcb(id);

            return contabancaria;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(ContaBancaria contabancaria, int id) {
        try {
            this.stmU.setString(1, contabancaria.getNomeTitular());
            this.stmU.setInt(2, contabancaria.getSaldo());
            this.stmU.setInt(3, contabancaria.getNumeroAgencia());
            this.stmU.setInt(4, id);
            
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
