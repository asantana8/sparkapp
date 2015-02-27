package persist;

import java.sql.SQLException;

import sparkapp.domain.Step;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

public class StepDao extends BaseDaoImpl<Step, Long> implements Dao<Step, Long> {

	public StepDao(ConnectionSource connectionSource, Class<Step> dataClass) throws SQLException {
		super(connectionSource, dataClass);
		initialize();
	}

}
