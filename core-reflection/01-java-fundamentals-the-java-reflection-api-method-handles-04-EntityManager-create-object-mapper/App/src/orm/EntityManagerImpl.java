package orm;

import util.MetaModel;

public class EntityManagerImpl<T> implements EntityManager<T> {


	@Override
	public void persit(T t) {
		MetaModel metaModel = MetaModel.of(t.getClass());
		String sql = metaModel.buildInsertRequest();
		//PreparedStatement statement = prepparedStatementwithSql(sql).addParameter(t);
		//statement.executeUpdate();
	}

}
