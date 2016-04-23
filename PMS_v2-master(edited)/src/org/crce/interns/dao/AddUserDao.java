package org.crce.interns.dao;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestParam;

public interface AddUserDao {

	public void loadCopyFile(String tableName, String year) throws SQLException, IOException;
}
