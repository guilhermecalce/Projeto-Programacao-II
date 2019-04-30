

package Classes;


import java.sql.*;

public class ContaBancaria {

    private int id_cb;
    private String nome_titular;
    private int saldo;
    private int numero_agencia;

    public ContaBancaria() {

    }
    
    public ContaBancaria(int id_cb, String nome_titular, int saldo, int numero_agencia){
        this.id_cb = id_cb;
        this.nome_titular = nome_titular;
        this.saldo = saldo;
        this.numero_agencia = numero_agencia;
    }

    public void setIdcb(int id_cb) {
        this.id_cb = id_cb;
    }
    
    public int getIdcb(){
        return id_cb;
    }
    
    public void setNomeTitular(String nome_titular){
        this.nome_titular = nome_titular;
    }
    
    public String getNomeTitular(){
        return nome_titular;
    }
    
    public void setSaldo(int saldo){
        this.saldo = saldo;
    }
    
    public int getSaldo(){
        return saldo;
    }
    
    public void setNumeroAgencia(int numero_agencia){
        this.numero_agencia = numero_agencia;
    }
    
    public int getNumeroAgencia(){
        return numero_agencia;
    }
}


