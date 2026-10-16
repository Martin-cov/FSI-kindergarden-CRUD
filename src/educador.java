
import java.sql.*;

public class educador {

    String curpe, nombree, sexoe, telefonoe, direccion, estadoe;

    static String todos = "SELECT * FROM educadores ORDER BY nombree";
    static String curpee = "SELECT curpe FROM educadores ORDER BY curpe";

    public educador() {

    }

    public educador(String curpe, String nombree, String sexo, String telefonoe, String direccion, String estadoe) {
        this.curpe = curpe;
        this.nombree = nombree;
        this.sexoe = sexo;
        this.telefonoe = telefonoe;
        this.direccion = direccion;
        this.estadoe = estadoe;
    }

    public int insertar(Connection con) {
        int resultado = 0;

        try {
            String sql = "INSERT INTO educadores VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curpe);
            ps.setString(2, nombree);
            ps.setString(3, sexoe);
            ps.setString(4, telefonoe);
            ps.setString(5, direccion);
            ps.setString(6, estadoe);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
            return resultado;

        }
    }

    public int borrar(Connection con) {
        int resultado = 0;
        try {
            String sql = "DELETE FROM educadores WHERE curpe = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curpe);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE educadores SET nombree=?,sexo=?,telefonoe=?,direccion=?,estadoe=? WHERE curpe=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombree);
            ps.setString(2, sexoe);
            ps.setString(3, telefonoe);
            ps.setString(4, direccion);
            ps.setString(5, estadoe);
            ps.setString(6, curpe);

            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
            return resultado;
        }
    }
}
