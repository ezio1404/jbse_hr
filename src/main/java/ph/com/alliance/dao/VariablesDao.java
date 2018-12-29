package ph.com.alliance.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ph.com.alliance.entity.Variables;

public interface VariablesDao {
	public List<Variables> selectAll(EntityManager entityManager);
	public Variables selectVariableByName(EntityManager entityManager, String pstrVariableName);
	public boolean updateVariable(EntityManager entityManager, Variables variables);
}