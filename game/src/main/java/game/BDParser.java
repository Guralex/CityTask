package game;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BDParser implements Parsing {



	@Override
	public TreeSet<String> parse(Object obj) {
		TreeSet<String>  cities= new TreeSet<String>();
		  Connection cn=null;
		  Statement st=null;
		  try {
		cn=ConnectorDB.getConnection();
		st=cn.createStatement();
		ResultSet rs= st.executeQuery("SELECT * FROM city");
		while(rs.next()){
			 String city=rs.getString(3);
		cities.add(city.toLowerCase());
		}

		} catch (SQLException e) {
		System.err.println("SQL Exeption (request or table failed):"+e);
		}
		  
		return cities;
	}

	
}
