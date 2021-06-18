package hu.alkfej.dao;

import hu.alkfej.config.Configuration;
import hu.alkfej.model.OrokbefogadhatoAllat;
import hu.alkfej.model.Orokbefogado;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OrokbefogadhatoAllatDAOImpl implements OrokbefogadhatoAllatDAO{

    private static final String SELECT_ALL = "SELECT * FROM OROKBEFOGADHATOALLAT";
    private static final String INSERT = "INSERT INTO OROKBEFOGADHATOALLAT (nev, faj, fenykep, szoveg, szuldatum) VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE OROKBEFOGADHATOALLAT SET nev = ?, faj = ?, fenykep = ?, szoveg = ?, szuldatum = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM OROKBEFOGADHATOALLAT WHERE id = ?";
    private static final String SELECT_BY_ID ="SELECT * FROM OROKBEFOGADHATOALLAT WHERE id=?" ;
    private Properties prop = new Properties();
    private String connenctionurl;

    public OrokbefogadhatoAllatDAOImpl(){

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connenctionurl = Configuration.getValue("db.url");
    }

    @Override
    public List<OrokbefogadhatoAllat> findAll() {
        List<OrokbefogadhatoAllat> result = new ArrayList<>();

        try(Connection c = DriverManager.getConnection(connenctionurl);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);

        ){
            while(rs.next()){
                OrokbefogadhatoAllat orokbefogadhatoAllat = new OrokbefogadhatoAllat();
                orokbefogadhatoAllat.setId(rs.getInt("id"));
                orokbefogadhatoAllat.setNev(rs.getString("nev"));
                orokbefogadhatoAllat.setFaj(rs.getString("faj"));
                orokbefogadhatoAllat.setFenykep(rs.getString("fenykep"));
                orokbefogadhatoAllat.setSzoveg(rs.getString("szoveg"));
                Date date = Date.valueOf(rs.getString("szuldatum"));
                orokbefogadhatoAllat.setSzuldatum(date == null ? LocalDate.now() : date.toLocalDate());

                result.add(orokbefogadhatoAllat);
            }

        }catch (SQLException e){
            System.out.println("Nem sikerült!");
            e.printStackTrace();
        }

        return result;


    }

    @Override
    public OrokbefogadhatoAllat save(OrokbefogadhatoAllat orokbefogadhatoAllat) {
        try(Connection c = DriverManager.getConnection(connenctionurl);
            PreparedStatement stmt = orokbefogadhatoAllat.getId() <= 0 ? c.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS) : c.prepareStatement(UPDATE);
        ){


            if(orokbefogadhatoAllat.getId() > 0 ){ //UPDATE
                stmt.setInt(6,orokbefogadhatoAllat.getId());
            }

            stmt.setString(1,orokbefogadhatoAllat.getNev());
            stmt.setString(2,orokbefogadhatoAllat.getFaj());
            stmt.setString(3,orokbefogadhatoAllat.getFenykep());
            stmt.setString(4, orokbefogadhatoAllat.getSzoveg());
            stmt.setString(5, orokbefogadhatoAllat.getSzuldatum().toString());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0){
                return null;
            }

            if(orokbefogadhatoAllat.getId() <= 0){ //INSERT
                ResultSet genKeys = stmt.getGeneratedKeys();
                if(genKeys.next()){
                    orokbefogadhatoAllat.setId(genKeys.getInt(1));
                }
            }



        }catch (SQLException e){
            System.out.println("Nem sikerült!");
            e.printStackTrace();
            return null;

        }
        return orokbefogadhatoAllat;

    }

    @Override
    public OrokbefogadhatoAllat findAllById(int id) {
        OrokbefogadhatoAllat result = new OrokbefogadhatoAllat();

        try(Connection c = DriverManager.getConnection(connenctionurl);
            PreparedStatement statement = c.prepareStatement(SELECT_BY_ID)){

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.isBeforeFirst()){
                result.setId(rs.getInt("id"));
                result.setNev(rs.getString("nev"));
                result.setFaj(rs.getString("faj"));
                result.setFenykep(rs.getString("fenykep"));
                result.setSzoveg(rs.getString("szoveg"));
                Date date = Date.valueOf(rs.getString("szuldatum"));
                result.setSzuldatum(date == null ? LocalDate.now() : date.toLocalDate());
            }



        }catch (SQLException e){
            System.out.println("Nem sikerült!");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(OrokbefogadhatoAllat orokbefogadhatoAllat) {
        try(Connection c = DriverManager.getConnection(connenctionurl);
            PreparedStatement stmt = c.prepareStatement(DELETE);

        ){
            stmt.setInt(1, orokbefogadhatoAllat.getId());
            stmt.executeUpdate();



        } catch (SQLException e){
            System.out.println("Nem sikerült!");
            e.printStackTrace();
        }

    }
}
