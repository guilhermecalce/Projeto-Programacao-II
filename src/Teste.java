
import Classes.Cidade;
import DAO.DAODB;


public class Teste {
    public static void main(String[] args) {
        
        DAODB ddb = new DAODB();
        Cidade in = new Cidade(50,"Arthur","SP","Brasil",10000);
        if (ddb.create(in)){
            System.out.println("Funcionou!");
        }
    }
}

