package de.unidue.inf.is.stores;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import de.unidue.inf.is.domain.fahrt;
import de.unidue.inf.is.utils.DBUtil;



public final class FahrtStore implements Closeable {

    private Connection connection;
    private boolean complete;


    public FahrtStore() throws StoreException {
        try {
            connection = DBUtil.getConnection();
            connection.setAutoCommit(false);
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
    }
    private static String INSERT_FAHRT = "INSERT INTO dbp141.fahrt (startort, zielort, fahrtdatumzeit, maxPlaetze, fahrtkosten, anbieter, transportmittel, beschreibung)  VALUES\\r\\n\" + \r\n" + 
    		"        			\"(?,?,?,?,?,?,?,?)\"" ;
    private static String SELECT_FAHRT = "select * from dbp141.fahrt where kid=?";

/////////////////////////////////////////////////////////////////////
    public void addFahrt(fahrt newFahrt) throws StoreException ,SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FAHRT);
            
            preparedStatement.setString(1, newFahrt.getStart());
            preparedStatement.setString(2, newFahrt.getZiel());
            preparedStatement.setLong(3, newFahrt.getZeit());
            preparedStatement.setInt(4, newFahrt.getMaxPlaetze());
            preparedStatement.setInt(5, newFahrt.getFahrKosten());
            preparedStatement.setString(6, newFahrt.getAnbieter());
            preparedStatement.setString(7, newFahrt.getMittle());
            preparedStatement.setString(8,newFahrt.getBeschreibung());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
    }
    
////////////////////////////////////////////////////////////////////////
    public List<fahrt> showFahrt(List<Integer> FahrtID) throws StoreException, SQLException
    {
    	List<fahrt> result = new ArrayList<>();
        try {
            for (int i = 0; i < FahrtID.size(); i++) {
                    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FAHRT);
                    preparedStatement.setInt(1, FahrtID.get(i));
                    ResultSet resultSet = preparedStatement.executeQuery();
                    
                    while (resultSet.next()) {
                          result.add(new fahrt(resultSet.getInt("fid"), resultSet.getString("startort "),
                          resultSet.getString("zielort"), resultSet.getLong("fahrtdatumzeit"),
                          resultSet.getInt("maxPlaetze"),
                          resultSet.getInt("fahrtkosten"),resultSet.getString("status"),resultSet.getString("anbieter")
                         ,resultSet.getString("transportmittel"),resultSet.getString("beschreibung")));
                    }                  
                    resultSet.close();
                    preparedStatement.close();
                }
            
            complete = true;
            close();
            return result;
        } catch (IOException e)
        {
            throw new StoreException(e);}
        }
    

    public void complete() {
        complete = true;
    }


    @Override
    public void close() throws IOException {
        if (connection != null) {
            try {
                if (complete) {
                    connection.commit();
                }
                else {
                    connection.rollback();
                }
            }
            catch (SQLException e) {
                throw new StoreException(e);
            }
            finally {
                try {
                    connection.close();
                }
                catch (SQLException e) {
                    throw new StoreException(e);
                }
            }
        }
    }

}