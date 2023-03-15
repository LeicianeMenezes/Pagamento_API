package uea.pagamentos_api.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Instant timeStamp;
	private Integer status;
	private List<String> erros;
	private String message;
	private String path;

	public StandardError(Instant timeStamp, Integer status, List<String> erros, String message, String path) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.erros = erros;
		this.message = message;
		this.path = path;
	}

	public StandardError() {
	}

	public Instant getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
