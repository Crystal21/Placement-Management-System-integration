package org.crce.interns.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface ResumeUploadDao {

	public void addNewResume(String username,String filePath) throws SQLException, IOException;
}
