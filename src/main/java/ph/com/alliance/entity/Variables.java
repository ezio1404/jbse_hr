package ph.com.alliance.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_VARIABLES")
public class Variables implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name ="FD_VARIABLE_NAME")
	private String variableName;
	
	@Column(name = "FD_VALUE")
	private String value;
	
	@Column(name = "FD_REMARKS")
	private String remarks;

	@Column(name = "FD_UPDATED_BY")
	private String updatedBy;
	
	@Column(name = "FD_TIMESTAMP")
	private Timestamp timestamp;

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Variables [variableName=" + variableName + ", value=" + value + ", remarks=" + remarks
				+ ", updatedBy=" + updatedBy + ", timestamp=" + timestamp + "]";
	}
}