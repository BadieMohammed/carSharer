package de.unidue.inf.is.stores;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.unidue.inf.is.domain.User;
import de.unidue.inf.is.utils.DBUtil;



public final class UserStore implements Closeable {

    private Connection connection;
    private boolean complete;
    
    public UserStore() throws StoreException {
        try {
            connection = DBUtil.getConnection();
            connection.setAutoCommit(false);
        }
        catch (SQLException e ) {
            throw new StoreException(e);
        }
    }
  private static String INSERT_USER = "insert into dbp141.benutzer (firstname, lastname) values (?, ?)" ;
  private static String SELECT_ALL_USER = "select * from dbp141.benutzer";
  private static String SELECT_USER_BY_ID = "select firstname , lastname from dbp141.benutzer where bid=?";

  
  /////////////////////////////////////////////////////////////////////////
    
    public void addUser(User userToAdd) throws StoreException {
        try  {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, userToAdd.getName());
            preparedStatement.setString(2, userToAdd.getEmail());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
    }
//////////////////////////////////////////////////////////////////////////
  
    
    public User showUser(int bid) throws StoreException, IOException  {
    	   try{

            User user = null ;
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);            
            preparedStatement.setInt(1, bid);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs. getString("email") ;
                user = new User(name, email);
    	
            }
            rs.close();
            preparedStatement.close();
            return user;
    	   }
           catch (SQLException e) {
               throw new StoreException(e);
           }
       
    }
   
///////////////////////////////////////////////////////////////////////////
    
    
    public List<User> selectAllUsers () {
    	List<User> users = new ArrayList<>() ;
    	try {
    		PreparedStatement preparedstatement = connection.prepareStatement(SELECT_ALL_USER);
    		ResultSet rs = preparedstatement.executeQuery();
    		while (rs.next()) {
				String email = rs.getString("name");
				String name = rs.getString("email");
				users.add(new User(name , email)) ;
			} 
    		rs.close();
    		preparedstatement.close();
    		return users;
    		
    		
    	} catch (SQLException e) {
			throw new StoreException(e) ;
		}
    	
    	
    	
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