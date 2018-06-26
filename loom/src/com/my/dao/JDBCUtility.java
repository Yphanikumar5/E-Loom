package com.my.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtility {
	private static Connection con;
	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			
			
			
			
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			// cnfe: handle exception
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public static Connection getConnection()
	{
		if(con==null)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
				
				
				
				
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
				// cnfe: handle exception
			}
			catch (SQLException sqle) {
				sqle.printStackTrace();
				// TODO: handle exception
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
		}
		
		
		
		return con;
	}
	public static void closeResultSet(ResultSet rs)
	  {
		  if(rs!=null)
		  {
			  try {
					rs.close();
					
					
					
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					// TODO: handle exception
				}
				
				catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				
		  }
	  }
		
	  public static void closeStatement(Statement st)
	  {
		 
		  if(st!=null)
		  {
			  try {
					st.close();
					
					
					
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					// TODO: handle exception
				}
				
				catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				
		  }
		  
	  }
	  
	  private JDBCUtility()
	  {
		  
	  }
	  

}
