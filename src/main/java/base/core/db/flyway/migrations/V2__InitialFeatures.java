package base.core.db.flyway.migrations;


import java.sql.Connection;
import java.sql.PreparedStatement;

import org.flywaydb.core.api.migration.jdbc.BaseJdbcMigration;

import base.core.feature.FeatureNames;
import base.model.user.Feature;
import base.util.generator.UIDGenerator;

public class V2__InitialFeatures extends BaseJdbcMigration {

	@Override
	public void migrate(Connection conn) throws Exception {
		
	      String query = " insert into feature ("+Feature.UID+","+Feature.NAME+","+ Feature.DESCRIPTION+")"
	        + " values (?, ?, ?)";

	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, UIDGenerator.generatUID());
	      preparedStmt.setString (2, FeatureNames.ACCESS_API);
	      preparedStmt.setString (3, "access the api");

	      preparedStmt.execute();
		
	}

}