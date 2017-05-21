package base.core.db;

import java.io.IOException;
import java.sql.SQLException;

import org.flywaydb.core.Flyway;
import org.springframework.context.ApplicationContext;

import base.core.spring.ApplicationContextProvider;

/**
 * The Class Migrate_ResetAndInit.
 */
public final class Migrate_ResetAndInit {
	
	private Migrate_ResetAndInit() {
		// private constructor added to hide implicit public one
	}

	/**
	 * Clears the database and reruns flyway migrations.
	 *
	 * @param args the arguments
	 * @throws SQLException 
	 * @throws InvalidEntitySchemaException 
	 * @throws DuplicateEnumTypeException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SQLException {
		ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
		Flyway flyway = applicationContext.getBean(Flyway.class);
        flyway.clean();
        flyway.migrate();
	}
}
