package finalProject;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * @author Yu-Pin Liang COMS 363, final project
 *
 */
public class FianlProject {

	/**
	 * create an user interaction dialog
	 *
	 */
	public static String[] loginDialog() {
		String result[] = new String[2];
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		JLabel lbUsername = new JLabel("Username: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbUsername, cs);

		JTextField tfUsername = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfUsername, cs);

		JLabel lbPassword = new JLabel("Password: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbPassword, cs);

		JPasswordField pfPassword = new JPasswordField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(pfPassword, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		String[] options = new String[] { "OK", "Cancel" };
		int ioption = JOptionPane.showOptionDialog(null, panel, "Login", JOptionPane.OK_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (ioption == 0) // pressing OK button
		{
			result[0] = tfUsername.getText();
			result[1] = new String(pfPassword.getPassword());
		}
		return result;
	}

	private static void q3(Connection conn, int k, int y) {

		ResultSet rs;
		ResultSetMetaData rsMetaData;
		String toShow;

		if (conn == null || k == 0 || y == 0)
			throw new NullPointerException();
		try {

			CallableStatement cstmt = conn.prepareCall("{call Q3(?,?)}");

			// first column has the given k
			cstmt.setInt(1, k);
			// second column has the given year
			cstmt.setInt(2, y);
			// execute the query
			cstmt.execute();
			// get result set
			rs = cstmt.getResultSet();
			// get result data
			rsMetaData = rs.getMetaData();
			// print result
			toShow = "";
			while (rs.next()) {
				for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
					toShow += rs.getString(i + 1) + ", ";
				}
				toShow += "\n";
			}
			JOptionPane.showMessageDialog(null, toShow);

			cstmt.close();
			conn.setAutoCommit(false);
			// confirm that these are the changes
			conn.commit();

		} catch (SQLException e) {
		}
		;
	}

	private static void q7(Connection conn, String hashtags, String state, int k, int m, int y) {

		ResultSet rs;
		ResultSetMetaData rsMetaData;
		String toShow;

		if (conn == null || k == 0 || y == 0 || m == 0 || hashtags == null || state == null)
			throw new NullPointerException();
		try {

			CallableStatement cstmt = conn.prepareCall("{call Q7(?,?,?,?,?)}");

			// first column has the given hashtags
			cstmt.setString(1, hashtags);
			// second column has the given state
			cstmt.setString(2, state);
			// third column has the given k
			cstmt.setInt(3, k);
			// forth column has the given month
			cstmt.setInt(4, m);
			// fifth column has the given year
			cstmt.setInt(5, y);

			// execute the query
			cstmt.execute();
			// get result set
			rs = cstmt.getResultSet();
			// get result data
			rsMetaData = rs.getMetaData();
			// print result
			toShow = "";
			while (rs.next()) {
				for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
					toShow += rs.getString(i + 1) + ", ";
				}
				toShow += "\n";
			}
			JOptionPane.showMessageDialog(null, toShow);

			cstmt.close();
			conn.setAutoCommit(false);
			// confirm that these are the changes
			conn.commit();

		} catch (SQLException e) {
		}
		;
	}

	private static void q9(Connection conn, int k, String subcategory) {
		ResultSet rs;
		ResultSetMetaData rsMetaData;
		String toShow;

		if (conn == null || k == 0 || subcategory == null)
			throw new NullPointerException();
		try {

			CallableStatement cstmt = conn.prepareCall("{call Q9(?,?)}");

			// first column has the given k
			cstmt.setInt(1, k);
			// second column has the given subcategory
			cstmt.setString(2, subcategory);
			// execute the query
			cstmt.execute();
			// get result set
			rs = cstmt.getResultSet();
			// get result data
			rsMetaData = rs.getMetaData();
			// print result
			toShow = "";
			while (rs.next()) {
				for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
					toShow += rs.getString(i + 1) + ", ";
				}
				toShow += "\n";
			}
			JOptionPane.showMessageDialog(null, toShow);

			cstmt.close();
			conn.setAutoCommit(false);
			// confirm that these are the changes
			conn.commit();

		} catch (SQLException e) {
		}
		;
	}

	private static void q16(Connection conn, int k, int m, int y) {
		ResultSet rs;
		ResultSetMetaData rsMetaData;
		String toShow;

		if (conn == null || k == 0 || m == 0 || y == 0)
			throw new NullPointerException();
		try {

			CallableStatement cstmt = conn.prepareCall("{call Q16(?,?,?)}");

			// first column has the given k
			cstmt.setInt(1, k);
			// second column has the given month
			cstmt.setInt(2, m);
			// third column has the given year
			cstmt.setInt(3, y);
			// execute the query
			cstmt.execute();
			// get result set
			rs = cstmt.getResultSet();
			// get result data
			rsMetaData = rs.getMetaData();
			// print result
			toShow = "";
			while (rs.next()) {
				for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
					toShow += rs.getString(i + 1) + ", ";
				}
				toShow += "\n";
			}
			JOptionPane.showMessageDialog(null, toShow);

			cstmt.close();
			conn.setAutoCommit(false);
			// confirm that these are the changes
			conn.commit();

		} catch (SQLException e) {
		}
		;
	}

	private static void q18(Connection conn, int k, String subcategory, int m, int y) {
		ResultSet rs;
		ResultSetMetaData rsMetaData;
		String toShow;

		if (conn == null || k == 0 || subcategory == null || m == 0 || y == 0)
			throw new NullPointerException();
		try {

			CallableStatement cstmt = conn.prepareCall("{call Q18(?,?,?,?)}");

			// first column has the given k
			cstmt.setInt(1, k);
			// second column has the given subcategory
			cstmt.setString(2, subcategory);
			// third column has the given month
			cstmt.setInt(3, m);
			// forth column has the given year
			cstmt.setInt(4, y);
			// execute the query
			cstmt.execute();
			// get result set
			rs = cstmt.getResultSet();
			// get result data
			rsMetaData = rs.getMetaData();
			// print result
			toShow = "";
			while (rs.next()) {
				for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
					toShow += rs.getString(i + 1) + ", ";
				}
				toShow += "\n";
			}
			JOptionPane.showMessageDialog(null, toShow);

			cstmt.close();
			conn.setAutoCommit(false);
			// confirm that these are the changes
			conn.commit();

		} catch (SQLException e) {
		}
		;

	}

	private static void q23(Connection conn, int k, String subcategory, String month, int y) {
		ResultSet rs;
		ResultSetMetaData rsMetaData;
		String toShow;

		if (conn == null || k == 0 || subcategory == null || month == null || y == 0)
			throw new NullPointerException();
		try {

			CallableStatement cstmt = conn.prepareCall("{call Q23(?,?,?,?)}");

			// first column has the given k
			cstmt.setInt(1, k);
			// second column has the given k
			cstmt.setString(2, subcategory);
			// third column has the given month
			cstmt.setString(3, month);
			// third column has the given year
			cstmt.setInt(4, y);
			// execute the query

			cstmt.execute();
			// get result set
			rs = cstmt.getResultSet();
			// get result data
			rsMetaData = rs.getMetaData();
			// print result
			toShow = "";
			while (rs.next()) {
				for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
					toShow += rs.getString(i + 1) + ", ";
				}
				toShow += "\n";
			}
			JOptionPane.showMessageDialog(null, toShow);

			cstmt.close();
			conn.setAutoCommit(false);
			// confirm that these are the changes
			conn.commit();

		} catch (SQLException e) {
		}
		;
	}

	private static void insertUser(Connection conn, String screenname, String name, int numFollowers, int numFollowing,
			String category, String subcategory, String state)

	{

		if (conn == null || screenname == null)
			throw new NullPointerException();
		try {

			conn.setAutoCommit(false);
			PreparedStatement inststmt = conn.prepareStatement(
					" insert into users (screenname,name,numFollowers,numFollowing,category,subcategory,state) values(?,?,?,?,?,?,?) ");

			inststmt.setString(1, screenname);
			inststmt.setString(2, name);
			inststmt.setInt(3, numFollowers);
			inststmt.setInt(4, numFollowing);
			inststmt.setString(5, category);
			inststmt.setString(6, subcategory);
			inststmt.setString(7, state);

			// execute the query
			int rowcount = inststmt.executeUpdate();

			System.out.println("Number of rows updated:" + rowcount);

			inststmt.close();

			conn.setAutoCommit(false);
			// confirm that these are the changes
			conn.commit();

		} catch (SQLException e) {
		}

	}

	private static void deleteUser(Connection conn, String screenName) {

		if (conn == null || screenName == null)
			throw new NullPointerException();
		try {

			PreparedStatement check = conn.prepareStatement("SELECT screenname FROM users WHERE screenname = ?");
			check.setString(1, screenName);

			ResultSet rs = check.executeQuery();

			if (rs.next()) {

				CallableStatement cstmt = conn.prepareCall("{call deleteUsers(?)}");
				int rowcount = cstmt.executeUpdate();
				cstmt.setString(1, screenName);

				System.out.println("Number of rows updated:" + rowcount);

				cstmt.close();

				conn.setAutoCommit(false);
				// confirm that these are the changes
				conn.commit();

				// Quest already completed
			} 
			
			

		} catch (SQLException e) {
		}

	}

	public static void main(String[] args) {
		String dbServer = "jdbc:mysql://127.0.0.1:3306/group48?useSSL=false&allowPublicKeyRetrieval=true";

		String userName = "cs363";
		String password = "363F2020";
		String result[] = loginDialog();
		System.out.println(result[1]);

		result[0] = userName;
		result[1] = password;

		Connection conn;
		Statement stmt;
		if (result[0] == null || result[1] == null) {
			System.out.println("Terminating: No username nor password is given");
			return;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbServer, userName, password);
			stmt = conn.createStatement();
			String option = "";
			String instruction =

					"Enter 3: Find k hashtags that appeared in the most number of states in a given year" + "\n"
							+ "Enter 7: Find k users who used a given hashtag in a given state in a given month of a given year."
							+ "\n" + "Enter 9: Find top k most followed users in a given party" + "\n"
							+ "Enter 16: Show names and categories of k users by retweet count" + "\n"
							+ "Enter 18: Find k users who were mentioned the most in tweets of users of a given party in a given month of a given year"
							+ "\n" + "Enter 23: Find k most used hashtags with the count of tweets" + "\n"
							+ "Enter I: Insert information of a new user into the database." + "\n"
							+ "Enter D: Delete a given user and all the tweets the user has tweeted, relevant hashtags, and users mentioned"
							+ "\n"

							+ "Enter e: Quit Program";

			while (true) {
				option = JOptionPane.showInputDialog(instruction);

				if (option.equals("I")) {

					String screenname = JOptionPane.showInputDialog("Enter screen name:");
					String name = JOptionPane.showInputDialog("Enter name:");
					int numFollowers = Integer.parseInt(JOptionPane.showInputDialog("Enter numFollowers:"));
					int numFollowing = Integer.parseInt(JOptionPane.showInputDialog("Enter numFollowing:"));
					String category = JOptionPane.showInputDialog("Enter category:");
					String subcategory = JOptionPane.showInputDialog("Enter subcategory:");
					String state = JOptionPane.showInputDialog("Enter State:");
					insertUser(conn, screenname, name, numFollowers, numFollowing, category, subcategory, state);

				}

				else if (option.equals("D")) {
					int input = JOptionPane.showConfirmDialog(null,
							"All the information related to this user will be deleted, continute?");
					if (input == 0) {
						String inputScreenName = JOptionPane.showInputDialog("Enter ScreenName to delete:");

						deleteUser(conn, inputScreenName);

					} else {
						break;
					}

				}

				else if (option.equals("3")) {
					int k = Integer.parseInt(JOptionPane.showInputDialog("k=?"));
					int y = Integer.parseInt(JOptionPane.showInputDialog("Which year?"));
					if (y <= 2016) {
						q3(conn, k, y);
					} else {
						break;
					}
				}

				else if (option.equals("7")) {
					String hashtag = JOptionPane.showInputDialog("Enter hashtags:");
					String state = JOptionPane.showInputDialog("Enter state:");
					int k = Integer.parseInt(JOptionPane.showInputDialog("k ?:"));
					int month = Integer.parseInt(JOptionPane.showInputDialog("Which month:"));
					int year = Integer.parseInt(JOptionPane.showInputDialog("Which year:"));
					if (month <= 12) {
						q7(conn, hashtag, state, k, month, year);
					} else {
						break;
					}
				}

				else if (option.equals("9")) {
					String subcategory = JOptionPane.showInputDialog("Enter subcategory:");
					int k = Integer.parseInt(JOptionPane.showInputDialog("k?:"));

					q9(conn, k, subcategory);

				}

				else if (option.equals("16")) {
					int k = Integer.parseInt(JOptionPane.showInputDialog("k?"));
					int month = Integer.parseInt(JOptionPane.showInputDialog("Which month:"));
					int year = Integer.parseInt(JOptionPane.showInputDialog("Which year:"));
					if (month <= 12) {
						q16(conn, k, month, year);
					} else {
						break;
					}
				}

				else if (option.equals("18")) {
					int k = Integer.parseInt(JOptionPane.showInputDialog("k?"));
					String subcategory = JOptionPane.showInputDialog("Enter subcategory:");
					int month = Integer.parseInt(JOptionPane.showInputDialog("Which month:"));
					int year = Integer.parseInt(JOptionPane.showInputDialog("Which year:"));
					if (month <= 12) {
						q18(conn, k, subcategory, month, year);
					} else {
						break;
					}
				}

				else if (option.equals("23")) {
					int k = Integer.parseInt(JOptionPane.showInputDialog("k:?"));
					String subcategory = JOptionPane.showInputDialog("Enter subcategory:");
					String month = JOptionPane.showInputDialog("Enter months, seperate by comma (ex:1,2,3):");
					int year = Integer.parseInt(JOptionPane.showInputDialog("Which year:"));
					q23(conn, k, subcategory, month, year);
					break;
				} //

				else {
					break;
				}
			}

			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Program terminates due to errors");
			e.printStackTrace();
		}
	}

}
