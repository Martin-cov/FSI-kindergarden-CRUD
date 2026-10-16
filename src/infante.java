import java.sql.*;
public class infante {
    
    String curp,nombre, sexo, fecha_nac, estado;
    
    
    static String todos = "SELECT * FROM infantes ORDER BY nombreI";
    static String curpi = "SELECT curpi FROM infantes ORDER BY curpi";
    
    public infante(){
        
    }

    public infante(String curp, String nombre, String sexo, String fecha_nac, String estado) {
        this.curp = curp;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fecha_nac = fecha_nac;
        this.estado = estado;
    }
   
    
    public int insertar(Connection con){
        int resultado = 0;
        
        try {
            String sql = "INSERT INTO infantes VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curp);
            ps.setString(2, nombre);
            ps.setString(3, sexo);
            ps.setString(4, fecha_nac);
            ps.setString(5, estado);
            return  ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
            return  resultado;
            
        }
    }
    public int borrar(Connection con){
        int resultado = 0;
        try {
            String sql = "DELETE FROM infantes WHERE curp = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error"+ e.getMessage());
            return resultado;
        }
    }
    
    public int actualizar(Connection con){
        int resultado = 0;
        try {
            String sql = "UPDATE infante SET nombreI=?,sexo=?,fecha_nac=?,estado=? WHEREcurp=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, sexo);
            ps.setString(3, fecha_nac);
            ps.setString(4, estado);
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error"+ e.getMessage());
            return resultado;
        }
    }
}
