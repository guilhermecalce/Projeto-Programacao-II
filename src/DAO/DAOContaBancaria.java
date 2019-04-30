
package DAO;

import Classes.ContaBancaria;

public interface DAOContaBancaria {
    
    public boolean create(ContaBancaria contabancaria);
    public ContaBancaria read (int id);
    public boolean update (ContaBancaria contabancaria);
    public boolean delete (ContaBancaria contabancaria);
}

