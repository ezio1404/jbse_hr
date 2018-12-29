package ph.com.alliance.util;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;

import ph.com.alliance.dao.VariablesDao;
import ph.com.alliance.entity.Variables;

@Component
public class SetVariables {
	
	@Autowired
	private JpaTransactionManager transactionManager;
	
	@Autowired
	private VariablesDao variablesDao;
	
	public void run() {
		EntityManager entityManager = null;
		List<Variables> variablesList = null;
		entityManager = transactionManager.getEntityManagerFactory().createEntityManager();
		variablesList = variablesDao.selectAll(entityManager);
		for (Variables v : variablesList) {
			System.setProperty(v.getVariableName(), v.getValue());
		}
	}
}