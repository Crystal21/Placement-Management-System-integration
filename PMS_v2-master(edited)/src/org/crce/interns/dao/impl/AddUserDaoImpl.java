package org.crce.interns.dao.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.crce.interns.dao.AddUserDao;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository("addUserDao")
public class AddUserDaoImpl implements AddUserDao {

	public void loadCopyFile(String tableName, String year) throws SQLException, IOException {
		CopyManager copyManager;
		InputStream inStream = null;
		File copyFile;
		// String tableName;

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

		copyFile = new File("C:/Users/Crystal/workspace1/PMS_v2_Working-master/PMS_v2-master(edited)/src/resources/csv/ce.csv");
		// tableName = "loader_schema.loader";
	
		InputStream bufferedInStream;

		inStream = new FileInputStream(copyFile);
		bufferedInStream = new BufferedInputStream(inStream, 65536);

		copyManager = new CopyManager((BaseConnection) c);

		copyManager.copyIn("COPY " + tableName + " FROM STDIN DELIMITER ',' CSV", bufferedInStream);

		Statement st = c.createStatement();
		Statement st1 = c.createStatement();
		//ResultSet rs = st.executeQuery("SELECT * FROM users");
		System.out.println(year);
		st1.executeUpdate("insert into user_schema.userdetails(username) select roll_no from loader_schema.loader");
		st1.executeUpdate("insert into user_schema.personal_profile(username,name,gender,dob,mobile_no,email_id) select roll_no,name,gender,dob,mobile,email from loader_schema.loader");
		st1.executeUpdate("insert into user_schema.professional_profile(username,branch) select roll_no,branch from loader_schema.loader");
		st1.executeUpdate("update user_schema.professional_profile set year='" + year +"' where year is NULL");
		st1.executeUpdate("insert into user_schema.qualification(username,ssc_per,hsc_or_dip,hsc_or_dip_per,s1_mark,s1_max,s1_per,s1_res,s1_kt,s2_mark,s2_max,s2_per,s2_res,s2_kt,s3_mark,s3_max,s3_per,s3_res,s3_kt,s4_mark,s4_max,s4_per,s4_res,s4_kt,s5_mark,s5_max,s5_per,s5_res,s5_kt,s6_mark,s6_max,s6_per,s6_res,s6_kt,s7_mark,s7_max,s7_per,s7_res,s7_kt,s8_mark,s8_max,s8_per,s8_res,s8_kt,deg_per,deg_kt,drops) select roll_no,ssc_per,hsc_or_dip,hsc_or_dip_per,s1_mark,s1_max,s1_per,s1_res,s1_kt,s2_mark,s2_max,s2_per,s2_res,s2_kt,s3_mark,s3_max,s3_per,s3_res,s3_kt,s4_mark,s4_max,s4_per,s4_res,s4_kt,s5_mark,s5_max,s5_per,s5_res,s5_kt,s6_mark,s6_max,s6_per,s6_res,s6_kt,s7_mark,s7_max,s7_per,s7_res,s7_kt,s8_mark,s8_max,s8_per,s8_res,s8_kt,deg_per,deg_kt,drops from loader_schema.loader");
		st1.executeUpdate("update user_schema.userdetails set role_id='1' where role_id is NULL");
		

		//rs.close();
		st.close();
		st1.close();
		inStream.close();
		inStream = null;

		
	}
}
