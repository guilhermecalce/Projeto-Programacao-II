package DAO;
// testando git dnv
import Classes.ContaBancaria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAODBContaBancaria implements DAOContaBancaria {

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
    public boolean create(ContaBancaria contabancaria) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO contabancaria (id_cb, nome_titular, saldo, numero_agencia) VALUES (?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, contabancaria.getIdcb());
            pstm.setString(2, contabancaria.getNomeTitular());
            pstm.setInt(3, contabancaria.getSaldo());
            pstm.setInt(4, contabancaria.getNumeroAgencia());
            pstm.executeUpdate();

            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ContaBancaria read(int id_cb) {
        try {
            ContaBancaria resposta2 = new ContaBancaria();
            Connection conn = getConnection();
            String sql = "SELECT * FROM contabancaria WHERE id=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_cb);
            ResultSet rs = pstm.executeQuery();

            if (!rs.next()) {
                return null;
            }

            resposta2.setIdcb(rs.getInt(sql));
            resposta2.setNomeTitular(rs.getString(sql));
            resposta2.setSaldo(rs.getInt(sql));
            resposta2.setNumeroAgencia(rs.getInt(sql));

            pstm.close();
            conn.close();
            return resposta2;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(ContaBancaria contabancaria) {
        try {
            Connection conn = getConnection();
            String sql = "UPDATE contabancaria SET nome_titular=?, saldo=?, numero_agencia=? WHERE id=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, contabancaria.getNomeTitular());
            pstm.setInt(2, contabancaria.getSaldo());
            pstm.setInt(3, contabancaria.getNumeroAgencia());
            pstm.setInt(5, contabancaria.getIdcb());
            pstm.executeUpdate();

            pstm.close();
            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(ContaBancaria contabancaria) {
        try {
            Connection conn = getConnection();
            String sql = "DELETE FROM contabancaria WHERE id=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, contabancaria.getIdcb());
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
