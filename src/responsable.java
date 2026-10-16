import java.sql.*;
public class responsable {
     String curpr,nombrer,sexo,telefono,parentesco,estador;
  
      static String todos = "SELECT * FROM responsables ORDER BY nombrer";
      static String curprr = "SELECT * FROM responsables ORDER BY curpr";
     
     
     public responsable(){
         
     }

  
  
  
    public responsable(String curpr, String nombrer, String sexo, String telefono, String parentesco, String estador) {
        this.curpr = curpr;
        this.nombrer = nombrer;
        this.sexo = sexo;
        this.telefono = telefono;
        this.parentesco = parentesco;
        this.estador = estador;
    }
     
   
    
   
   
    
    public int insertar(Connection con){
        int resultado = 0;
        
        try {
            String sql = "INSERT INTO resposable VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curpr);
            ps.setString(2, nombrer);
            ps.setString(3, sexo);
            ps.setString(4, telefono);
            ps.setString(5, parentesco);
            ps.setString(6, estador);
            return  ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
            return  resultado;
            
        }
    }
    public int borrar(Connection con){
        int resultado = 0;
        try {
            String sql = "DELETE FROM responsable WHERE curpr = ?";
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
            String sql = "UPDATE responsable SET nombrer=?,sexor=?,telefono=?,paresntesco=?,estador=? WHERE curpr=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombrer);
            ps.setString(2, sexo);
            ps.setString(3, telefono);
             ps.setString(4, parentesco);
            ps.setString(5, estador);
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error"+ e.getMessage());
            return resultado;
        }
    }
}
