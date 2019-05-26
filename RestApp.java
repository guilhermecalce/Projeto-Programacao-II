
import DAO.CidadeDAO;
import DAO.ContaBancariaDAO;
import Resource.CidadeResource;
import Resource.ContaBancariaResource;
import ch.qos.logback.core.CoreConstants;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RestApp extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new RestApp().run(new String[]{"server"});
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        CidadeDAO daocidade = new CidadeDAO();
        environment.jersey().register(new CidadeResource(daocidade));

        ContaBancariaDAO daocontasbancaria = new ContaBancariaDAO();
        environment.jersey().register(new ContaBancariaResource(daocontasbancaria));

    }
}
