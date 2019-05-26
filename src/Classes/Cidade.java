
package Classes;


import java.sql.*;

public class Cidade {

    private int id;
    private String nome;
    private String estado;
    private String pais;
    private int populacao;

    public Cidade() {

    }
    
    public Cidade(int id, String nome, String estado, String pais, int populacao){
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.pais = pais;
        this.populacao = populacao;       
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public void setPais(String pais){
        this.pais = pais;
    }
    
    public String getPais(){
        return pais;
    }
    
    public void setPopulacao(int populacao){
        this.populacao = populacao;
    }
    
    public int getPopulacao(){
        return populacao;
    }
}

