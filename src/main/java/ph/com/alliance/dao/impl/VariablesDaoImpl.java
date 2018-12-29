package ph.com.alliance.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ph.com.alliance.dao.VariablesDao;
import ph.com.alliance.entity.Variables;
import ph.com.alliance.util.Common;

@Repository
public class VariablesDaoImpl implements VariablesDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Variables> selectAll(EntityManager entityManager) {
		Session session = entityManager.unwrap(Session.class);
		StringBuilder sb = new StringBuilder();
		sb.append(" FROM Variables");
		Query query = session.createQuery(sb.toString());
		return query.list();
	}
	
	@Override
	public Variables selectVariableByName(EntityManager entityManager, String pstrVariableName) {
		Session session = entityManager.unwrap(Session.class);
		StringBuilder sb = new StringBuilder();
		sb.append("FROM ");
			sb.append("Variables ");
		sb.append("WHERE variableName = :variableName");
		Query query = session.createQuery(sb.toString());
		query.setParameter("variableName", pstrVariableName);
		return (Variables) query.uniqueResult();
	}

	@Override
	public boolean updateVariable(EntityManager entityManager, Variables variables) {
		Session session = entityManager.unwrap(Session.class);
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ");
			sb.append("Variables ");
		sb.append("SET ");
			sb.append("value = :value ");
			sb.append(", timestamp = :timestamp ");
			sb.append(", updatedBy = :updatedBy ");
		if (!Common.isNullOrEmpty(variables.getRemarks())) {
			sb.append(", remarks = :remarks ");
		}
		sb.append("WHERE ");
			sb.append("variableName = :variableName");
		Query query = session.createQuery(sb.toString());
		query.setParameter("variableName", variables.getVariableName());
		query.setParameter("value", variables.getValue());
		query.setParameter("updatedBy", variables.getUpdatedBy());
		if (!Common.isNullOrEmpty(variables.getRemarks())) {
			query.setParameter("remarks", variables.getRemarks());
		}
		query.setParameter("timestamp", new Timestamp(System.currentTimeMillis()));
		return query.executeUpdate() == 1;
	}
}