package base.core.db.flyway.migrations;


import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.BaseJdbcMigration;

/**
 * Add default users to database.
 * It add one user which used by developers and should have all features.
 * Also it add another user which is admin and it will be given to the real admin. 
 * This is a Migrate class and should be executed by flyway.
 */
public class V1__InitialUsers extends BaseJdbcMigration {

	/**
	 * add default users to database.
	 */
	@Override
	public void migrate(Connection conn) throws Exception {
		conn.prepareStatement("INSERT INTO files VALUES(0)").executeQuery();
	}

}