package Utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opencsv.CSVWriter;

public class DataBaseUtility {
	
	
			private static Connection connection; // connect our script to DB
			private static Statement statement; // Execute the query we passing
			private static ResultSet resultSet; // Store the retrieved data from query execution
			private static String url = "jdbc:postgresql://localhost:5432/dvdrental";
			private static String userName = "postgres";
			private static String password = "root";
			public static void setupDBConnection() {
				try {
					connection = DriverManager.getConnection(url, userName, password);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			public static ResultSet runQuery(String query) {
				try {
					statement = connection.createStatement();
					resultSet = statement.executeQuery(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return resultSet;
			}
			public static void returnResult() {
				try {
					while (resultSet.next()) {
						
						CSVWriter csvWriter;
						String output = System.getProperty("usre.dir")+"\\output\\book.csv";
						
						File file = new File(
								"C:\\Users\\SDET1\\eclipse-workspace\\SeleniumProject.Feb2020\\testdataOutput\\book.csv");
						try {
							FileWriter filewriter = new FileWriter(file);
							csvWriter = new CSVWriter(filewriter);
							csvWriter.writeAll(resultSet, true);
							csvWriter.close();
						} catch (SQLException e) {
						} catch (IOException e) {
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// close the DB connection
			public static void closeDBConnection() {
				if (connection != null) {
					try {
						connection.close();
					} catch (Exception e) {
					} finally {
						try {
							connection.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

}
