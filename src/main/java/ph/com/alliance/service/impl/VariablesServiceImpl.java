package ph.com.alliance.service.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;

import ph.com.alliance.dao.VariablesDao;
import ph.com.alliance.entity.Variables;
import ph.com.alliance.service.VariablesService;

@Service
public class VariablesServiceImpl implements VariablesService {

	@Autowired
	private JpaTransactionManager transactionManager;
	
	@Autowired
	private VariablesDao variablesDao;
	
	@Override
	public boolean setVariable(Variables variables) throws Exception {
		EntityManager entityManager = null;
		Variables variable = null;
		boolean isSet = false;
		
		try {
			entityManager = transactionManager.getEntityManagerFactory().createEntityManager();
			variable = variablesDao.selectVariableByName(entityManager, variables.getVariableName());
			if (null != variable && variable.getVariableName().equals(variables.getVariableName())) {
				isSet = variablesDao.updateVariable(entityManager, variables);
				System.setProperty(variables.getVariableName(), variables.getValue());
			} else {
				throw new Exception("[ERROR] variableName " + variables.getVariableName() + " does not exists.");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if(null != entityManager && entityManager.isOpen()){
				entityManager.close();
				entityManager = null;
			}
		}
		
		return isSet;
	}
}