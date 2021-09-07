package pojo;

public class ResponsePojo {
	private String action;
	private boolean success;
	private String message;
	private int data;
	
	public ResponsePojo() {
		super();
	}
	
	public ResponsePojo(String action, boolean success, String message,int data) {
		this.data = data;
		this.action = action;
		this.success = success;
		this.message = message;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponsePojo [data=" + data + ", action=" + action + ", success=" + success + ", message=" + message
				+ "]";
	}
}
