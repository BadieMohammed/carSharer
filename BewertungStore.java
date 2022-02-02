package de.unidue.inf.is.stores;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import de.unidue.inf.is.domain.bewertung;
import de.unidue.inf.is.utils.DBUtil;



public final class BewertungStore implements Closeable {

    private Connection connection;
    private boolean complete;
    
   
    public BewertungStore() throws StoreException {
        try {
            connection = DBUtil.getConnection();
            connection.setAutoCommit(false);
        }
        catch (SQLException e ) {
            throw new StoreException(e);
        }
    }
  private static String INSERT_BEWERTUNG = "insert into dbp141.bewertung (textnachricht, erstellungsdatum, rating) values (?,?,?)" ;
  private static String SELECT_BEWERTUNG = "select * from dbp141.bewertung  where beid=?";
  
  /////////////////////////////////////////////////////////////////////////
    
    public void addBewertung(bewertung bewertungToAdd) throws StoreException {
        try  {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BEWERTUNG);
            preparedStatement.setString(1, bewertungToAdd.getText());
            preparedStatement.setLong(2, bewertungToAdd.getDatum());
            preparedStatement.setInt(2, bewertungToAdd.getRate());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
    }
//////////////////////////////////////////////////////////////////////////
  
    
    public bewertung showBewertung(int beid) throws StoreException, IOException  {
    	   try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BEWERTUNG)) {

            bewertung bewertung = null ;
          
            preparedStatement.setInt(1, beid);            
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                String nachricht = rs.getString("textnachricht ");
                Long datum = rs. getLong("erstellungsdatum") ;
                int rate = rs.getInt("rating") ;
                bewertung = new bewertung(nachricht,datum, rate);
    	
            }
            rs.close();
            preparedStatement.close();
            return bewertung;
    	   }
           catch (SQLException e) {
               throw new StoreException(e);
           }
       
    }
   
///////////////////////////////////////////////////////////////////////////

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