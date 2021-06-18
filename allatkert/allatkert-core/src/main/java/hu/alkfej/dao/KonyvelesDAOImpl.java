package hu.alkfej.dao;

import hu.alkfej.config.Configuration;
import hu.alkfej.model.Konyveles;
import hu.alkfej.model.OrokbefogadhatoAllat;
import hu.alkfej.model.Orokbefogado;
import hu.alkfej.model.enums.TamogatasGyak;
import hu.alkfej.model.enums.TamogatasTipusa;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class KonyvelesDAOImpl implements KonyvelesDAO{

    private static final String SELECT_ALL = "SELECT * FROM KONYVELES";
    private static final String INSERT = "INSERT INTO KONYVELES (mikor, nev, tamogat, ertek, gyakorisag, orokbefogado_id, orokbefogadhato_allat_id) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE KONYVELES SET mikor=?, nev=?, tamogat=?, ertek=?, gyakorisag=?, orokbefogado_id=?, orokbefogadhato_allat_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM KONYVELES WHERE id=?";
    private static final String SELECT_TAVALYI = "SELECT * FROM KONYVELES WHERE mikor BETWEEN '2020-01-01' AND '2020-12-31' ";
    private static final String SELECT_PENZ = "SELECT * FROM KONYVELES WHERE tamogat = 'PENZOSSZEG'";
    private static final String SELECT_ELEDEL = "SELECT * FROM KONYVELES WHERE tamogat = 'ALLATELEDEL' ";
    private Properties prop = new Properties();
    private String connenctionurl;

    public KonyvelesDAOImpl(){

        try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        connenctionurl = Configuration.getValue("db.url");
    }

    @Override
    public List<Konyveles> findAll() {
        List<Konyveles> result = new ArrayList<>();

        try(Connection c = DriverManager.getConnection(connenctionurl);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);

        ){
            while(rs.next()){
                Konyveles konyveles = new Konyveles();
                OrokbefogadoDAO orokbefogadoDAO = new OrokbefogadoDAOImpl();
                OrokbefogadhatoAllatDAO orokbefogadhatoAllatDAO = new OrokbefogadhatoAllatDAOImpl();
                konyveles.setId(rs.getInt("id"));
                Date date = Date.valueOf(rs.getString("mikor"));
                konyveles.setMikor(date == null ? LocalDate.now() : date.toLocalDate());
                konyveles.setNev(rs.getString("nev"));
                konyveles.setErtek(rs.getDouble("ertek"));
                String tamogatasTip = rs.getString("tamogat");
                String tamogatasGy = rs.getString("gyakorisag");
                konyveles.setTamogat(tamogatasTip == null ? null : TamogatasTipusa.valueOf(tamogatasTip));
                konyveles.setGyakorisag(tamogatasGy == null ? null : TamogatasGyak.valueOf(tamogatasGy));
                if(rs.getInt("orokbefogado_id") > 0){
                    konyveles.setOrokbefogado(orokbefogadoDAO.findAllById(rs.getInt("orokbefogado_id")));
                }
                if(rs.getInt("orokbefogadhato_allat_id") > 0){
                    konyveles.setOrokbefogadoallatok(orokbefogadhatoAllatDAO.findAllById(rs.getInt("orokbefogadhato_allat_id")));
                }


                result.add(konyveles);
            }

        }catch (SQLException e){
            System.out.println("Nem sikerült!");
            e.printStackTrace();
        }

        return result;

    }

    @Override
    public Konyveles save(Konyveles konyveles) {
        try(Connection c = DriverManager.getConnection(connenctionurl);
            PreparedStatement stmt = konyveles.getId() <= 0 ? c.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS) : c.prepareStatement(UPDATE);
        ){


            if(konyveles.getId() > 0 ){
                stmt.setInt(8,konyveles.getId());
            }

            stmt.setString(1,konyveles.getMikor().toString());
            stmt.setString(2,konyveles.getNev());
            stmt.setString(3,konyveles.getTamogat().getValue());
            stmt.setDouble(4, konyveles.getErtek());
            stmt.setString(5,konyveles.getGyakorisag().getValue());
            stmt.setInt(6, konyveles.getOrokbefogado().getId());
            stmt.setInt(7, konyveles.getOrokbefogadoallatok().getId());


            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0){
                return null;
            }

            if(konyveles.getId() <= 0){
                ResultSet genKeys = stmt.getGeneratedKeys();
                if(genKeys.next()){
                    konyveles.setId(genKeys.getInt(1));
                }
            }



        }catch (SQLException e){
            System.out.println("Nem sikerült!");
            e.printStackTrace();
            return null;

        }
        return konyveles;


    }

    @Override
    public void delete(Konyveles konyveles) {
        try(Connection c = DriverManager.getConnection(connenctionurl);
            PreparedStatement stmt = c.prepareStatement(DELETE);

        ){
            stmt.setInt(1, konyveles.getId());
            stmt.executeUpdate();



        } catch (SQLException e){
            System.out.println("Nem sikerült!");
            e.printStackTrace();
        }

    }

    @Override
    public List<Konyveles> lastYear() {
        List<Konyveles> result = new ArrayList<>();

        try(Connection c = DriverManager.getConnection(connenctionurl);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_TAVALYI);

        ){
            while(rs.next()){
                Konyveles konyveles = new Konyveles();
                OrokbefogadoDAO orokbefogadoDAO = new OrokbefogadoDAOImpl();
                OrokbefogadhatoAllatDAO orokbefogadhatoAllatDAO = new OrokbefogadhatoAllatDAOImpl();
                konyveles.setId(rs.getInt("id"));
                Date date = Date.valueOf(rs.getString("mikor"));
                konyveles.setMikor(date == null ? LocalDate.now() : date.toLocalDate());
                konyveles.setNev(rs.getString("nev"));
                String tamogatasTip = rs.getString("tamogat");
                konyveles.setErtek(rs.getDouble("ertek"));
                String tamogatasGy = rs.getString("gyakorisag");
                konyveles.setTamogat(tamogatasTip == null ? null : TamogatasTipusa.valueOf(tamogatasTip));
                konyveles.setGyakorisag(tamogatasGy == null ? null : TamogatasGyak.valueOf(tamogatasGy));
                if(rs.getInt("orokbefogado_id") > 0){
                    konyveles.setOrokbefogado(orokbefogadoDAO.findAllById(rs.getInt("orokbefogado_id")));
                }
                if(rs.getInt("orokbefogadhato_allat_id") > 0){
                    konyveles.setOrokbefogadoallatok(orokbefogadhatoAllatDAO.findAllById(rs.getInt("orokbefogadhato_allat_id")));
                }


                result.add(konyveles);
            }

        }catch (SQLException e){
            System.out.println("Nem sikerült!");
            e.printStackTrace();
        }

        return result;



    }

    @Override
    public List<Konyveles> penzTamogatok() {
        List<Konyveles> result = new ArrayList<>();

        try(Connection c = DriverManager.getConnection(connenctionurl);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_PENZ);

        ){
            while(rs.next()){
                Konyveles konyveles = new Konyveles();
                OrokbefogadoDAO orokbefogadoDAO = new OrokbefogadoDAOImpl();
                OrokbefogadhatoAllatDAO orokbefogadhatoAllatDAO = new OrokbefogadhatoAllatDAOImpl();
                konyveles.setId(rs.getInt("id"));
                Date date = Date.valueOf(rs.getString("mikor"));
                konyveles.setMikor(date == null ? LocalDate.now() : date.toLocalDate());
                konyveles.setNev(rs.getString("nev"));
                String tamogatasTip = rs.getString("tamogat");
                konyveles.setErtek(rs.getDouble("ertek"));
                String tamogatasGy = rs.getString("gyakorisag");
                konyveles.setTamogat(tamogatasTip == null ? null : TamogatasTipusa.valueOf(tamogatasTip));
                konyveles.setGyakorisag(tamogatasGy == null ? null : TamogatasGyak.valueOf(tamogatasGy));
                if(rs.getInt("orokbefogado_id") > 0){
                    konyveles.setOrokbefogado(orokbefogadoDAO.findAllById(rs.getInt("orokbefogado_id")));
                }
                if(rs.getInt("orokbefogadhato_allat_id") > 0){
                    konyveles.setOrokbefogadoallatok(orokbefogadhatoAllatDAO.findAllById(rs.getInt("orokbefogadhato_allat_id")));
                }


                result.add(konyveles);
            }

        }catch (SQLException e){
            System.out.println("Nem sikerült!");
            e.printStackTrace();
        }

        return result;



    }

    @Override
    public List<Konyveles> eledelTamogatok() {
        List<Konyveles> result = new ArrayList<>();

        try(Connection c = DriverManager.getConnection(connenctionurl);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ELEDEL);

        ){
            while(rs.next()){
                Konyveles konyveles = new Konyveles();
                OrokbefogadoDAO orokbefogadoDAO = new OrokbefogadoDAOImpl();
                OrokbefogadhatoAllatDAO orokbefogadhatoAllatDAO = new OrokbefogadhatoAllatDAOImpl();
                konyveles.setId(rs.getInt("id"));
                Date date = Date.valueOf(rs.getString("mikor"));
                konyveles.setMikor(date == null ? LocalDate.now() : date.toLocalDate());
                konyveles.setNev(rs.getString("nev"));
                String tamogatasTip = rs.getString("tamogat");
                konyveles.setErtek(rs.getDouble("ertek"));
                String tamogatasGy = rs.getString("gyakorisag");
                konyveles.setTamogat(tamogatasTip == null ? null : TamogatasTipusa.valueOf(tamogatasTip));
                konyveles.setGyakorisag(tamogatasGy == null ? null : TamogatasGyak.valueOf(tamogatasGy));
                if(rs.getInt("orokbefogado_id") > 0){
                    konyveles.setOrokbefogado(orokbefogadoDAO.findAllById(rs.getInt("orokbefogado_id")));
                }
                if(rs.getInt("orokbefogadhato_allat_id") > 0){
                    konyveles.setOrokbefogadoallatok(orokbefogadhatoAllatDAO.findAllById(rs.getInt("orokbefogadhato_allat_id")));
                }


                result.add(konyveles);
            }

        }catch (SQLException e){
            System.out.println("Nem sikerült!");
            e.printStackTrace();
        }

        return result;


    }


}
