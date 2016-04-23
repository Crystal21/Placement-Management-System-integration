package org.crce.interns.dao.impl;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.crce.interns.dao.ResumeUploadDao;
import org.springframework.stereotype.Repository;

@Repository("resumeUploadDao")
public class ResumeUploadDaoImpl implements ResumeUploadDao {

	public void addNewResume(String username, String filePath) throws SQLException, IOException {

		Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/placementdb", "postgres", "school16");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");

		Statement st = c.createStatement();
		Statement st1 = c.createStatement();

		// System.out.println(username);
		// System.out.println(filePath);
		st1.executeUpdate(
				"insert into user_schema.professional_profile_resume values('" + username + "','" + filePath + "')");

		st.close();
		st1.close();

	}
}
