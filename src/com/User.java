package model;


import java.sql.*;

public class User {
	
	// DB Connection
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/payment", "root", "");

			// For testing
			System.out.print("DB Successfully connected");
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.print("DB not connected");
		}

		return con;
	}
	
	// Insert
		public String insertUser(String name, String email, String phoneNo, String password) {

			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database";
				}

				// create a prepared statement
				String query = " insert into user(`id`,`name`,`email`,`phoneNo`,`password`)"
						+ " values (?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, name);
				preparedStmt.setString(3, email);
				preparedStmt.setInt(4, Integer.parseInt(phoneNo));
				preparedStmt.setString(5, password);
				
			

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Insertion successful";

			} catch (Exception e) {
				output = "Insertion Unsuccess";
				System.err.println(e.getMessage());
			}
			return output;
		}

		
		// Read
		public String readUser() {

			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for reading.";
				}

				// Prepare the html table to be displayed
				output = "<table border=\"1\"><tr><th>Name</th>" + "<th>Email</th><th>PhoneNo</th>"
						 + "<th>Password</th></tr>";

				String query = "select * from user";

				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery(query);

				// iterate through the rows in the result set
				while (rs.next()) {

					String id  = Integer.toString(rs.getInt("id"));
					String name = rs.getString("name");
					String email = rs.getString("email");
					String phoneNo = Integer.toString(rs.getInt("phoneNo"));
					String password = rs.getString("password");
				
					

					// Add into the html table
					output += "<tr><td>" + name + "</td>";
					output += "<td>" + email + "</td>";
					output += "<td>" + phoneNo + "</td>";
					output += "<td>" + password + "</td>";

				}

				con.close();

				// Complete the html table
				output += "</table>";

			} catch (Exception e) {
				output = "Error while reading.";
				System.err.println(e.getMessage());
			}
			return output;
		}

		
		// Update
		public String updateUser(String id ,String name, String email, String phoneNo, String password) {

			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}

				// create a prepared statement
				String query = "UPDATE user SET name=?,email=?,phoneNo=?,password=? WHERE id=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setString(1, name);
				preparedStmt.setString(2, email);
				preparedStmt.setInt(3, Integer.parseInt(phoneNo));
				preparedStmt.setString(4, password);
				preparedStmt.setInt(5, Integer.parseInt(id));

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Successfully Updated";

			} catch (Exception e) {
				output = "Updating unsuccesful .";
				System.err.println(e.getMessage());
			}
			return output;
		}

		
		// Delete
		public String deleteUser(String id) {
			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}

				// create a prepared statement
				String query = "delete from user where id=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, Integer.parseInt(id));

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Deleted successfully";

			} catch (Exception e) {
				output = "Error while deleting the Product Details.";
				System.err.println(e.getMessage());
			}
			return output;
		}
	
	


}
