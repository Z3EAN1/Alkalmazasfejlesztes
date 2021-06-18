package hu.alkfej.dao;

import at.favre.lib.crypto.bcrypt.BCrypt;
import hu.alkfej.config.Configuration;
import hu.alkfej.model.Orokbefogado;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OrokbefogadoDAOImpl implements OrokbefogadoDAO{

    private static final String SELECT_ALL = "SELECT * FROM OROKBEFOGADO";
    private static final String INSERT = "INSERT INTO OROKBEFOGADO (nev, email) VALUES (?,?)";
    private static final String UPDATE = "UPDATE OROKBEFOGADO SET nev=?, email=? WHERE id=?";
    private static final String DELETE = "DELETE FROM OROKBEFOGADO WHERE id=?";
    private static final String SELECT_BY_ID = "SELECT * FROM OROKBEFOGADO WHERE id=?";
    private static final String SELECT_BY_EMAIL = "SELECT * FROM OROKBEFOGADO WHERE email=?";
    private Properties prop = new Properties();
    private String connenctionurl;

    public OrokbefogadoDAOImpl() {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connenctionurl = Configuration.getValue("db.url");
    }




    @Override
    public List<Orokbefogado> findAll() {
        List<Orokbefogado> result = new ArrayList<>();

        try(Connection c = DriverManager.getConnection(connenctionurl);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);

        ){
            while(rs.next()){
                Orokbefogado orokbefogado = new Orokbefogado();
                orokbefogado.setId(rs.getInt("id"));
                orokbefogado.setNev(rs.getString("nev"));
                orokbefogado.setEmail(rs.getString("email"));

                result.add(orokbefogado);
            }

        }catch (SQLException e){
            System.out.println("Nem sikerült!");
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Orokbefogado findAllById(int id) {
        Orokbefogado result = new Orokbefogado();

        try(Connection c = DriverManager.getConnection(connenctionurl);
            PreparedStatement statement = c.prepareStatement(SELECT_BY_ID)){

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if(rs.isBeforeFirst()) {
                result.setId(rs.getInt("id"));
                result.setNev(rs.getString("nev"));
                result.setEmail(rs.getString("email"));
            } else {
                return null;
            }

        }catch (SQLException e){
            System.out.println("Nem sikerült!");
            e.printStackTrace();
        }
        return result;
    }

//    @Override
//    public Orokbefogado findByEmail(String email) {
//        Orokbefogado result = new Orokbefogado();
//
//        try(Connection c = DriverManager.getConnection(connenctionurl);
//            PreparedStatement statement = c.prepareStatement(SELECT_BY_EMAIL)){
//
//            statement.setString(1, email);
//            ResultSet rs = statement.executeQuery();
//
//            if(rs.isBeforeFirst()) {
//                result.setId(rs.getInt("id"));
//                result.setNev(rs.getString("nev"));
//                result.setEmail(rs.getString("email"));
//            } else {
//                return null;
//            }
//
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return result;
//    }

    @Override
    public Orokbefogado save(Orokbefogado orokbefogado) {
        try(Connection c = DriverManager.getConnection(connenctionurl);
            PreparedStatement stmt = orokbefogado.getId() <= 0 ? c.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS) : c.prepareStatement(UPDATE);
        ){


            if(orokbefogado.getId() > 0 ){
                stmt.setInt(3,orokbefogado.getId());
            }

            stmt.setString(1,orokbefogado.getNev());
            stmt.setString(2,orokbefogado.getEmail());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0){
                return null;
            }

            if(orokbefogado.getId() < 0){
                ResultSet genKeys = stmt.getGeneratedKeys();
                if(genKeys.next()){
                    orokbefogado.setId(genKeys.getInt(1));
                }
            }



        }catch (SQLException e){
            System.out.println("Nem sikerült!");
            e.printStackTrace();
            return null;

        }
        return orokbefogado;
    }

    @Override
    public void delete(Orokbefogado orokbefogado) {

        try(Connection c = DriverManager.getConnection(connenctionurl);
            PreparedStatement stmt = c.prepareStatement(DELETE);

        ){
            stmt.setInt(1, orokbefogado.getId());
            stmt.executeUpdate();



        } catch (SQLException e){
            System.out.println("Nem sikerült!");
            e.printStackTrace();
        }

    }

//    @Override
//    public Orokbefogado login(String nev, String email) {
//        try (Connection conn = DriverManager.getConnection(connenctionurl);
//             PreparedStatement pst = conn.prepareStatement("SELECT * FROM OROKBEFOGADO WHERE nev = ?")
//        ) {
//            pst.setString(1, nev);
//
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//
//                String dbPass = rs.getString("email");
//
//                BCrypt.Result result = BCrypt.verifyer().verify(email.toCharArray(), dbPass);
//                if(result.verified){
//                    Orokbefogado orokbefogado = new Orokbefogado();
//                    orokbefogado.setNev(rs.getString("nev"));
//                    orokbefogado.setEmail(rs.getString("email"));
//                    orokbefogado.setId(rs.getInt("id"));
//                    return orokbefogado;
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

    }

