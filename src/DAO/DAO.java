
package DAO;

import Classes.Cidade;

public interface DAO {
    
    public boolean create(Cidade cidade);
    public Cidade read (int id);
    public boolean update (Cidade cidade);
    public boolean delete (Cidade cidade);
}
