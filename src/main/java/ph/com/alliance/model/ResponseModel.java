package ph.com.alliance.model;

public class ResponseModel<T> {

	// use either HttpServletResponse.SC_INTERNAL_SERVER_ERROR or HttpServletResponse.SC_OK
	private int responsecode;
	private T responsedata;
	private String responsemessage;

	public int getResponsecode() {
		return responsecode;
	}

	public void setResponsecode(int responsecode) {
		this.responsecode = responsecode;
	}

	public T getResponsedata() {
		return responsedata;
	}

	public void setResponsedata(T responsedata) {
		this.responsedata = responsedata;
	}

	public String getResponsemessage() {
		return responsemessage;
	}

	public void setResponsemessage(String responsemessage) {
		this.responsemessage = responsemessage;
	}
	
	@Override
	public String toString() {
		return "ResponseModel [responsecode=" + responsecode + ", responsedata=" + responsedata + ", responsemessage="
				+ responsemessage + "]";
	}
}