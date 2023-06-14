package net.codejava.javaee.brand;

public class DIASList {

	
	protected String  file_name="";
	protected String  file_type="";
	protected String  uploaded_by="";
	protected String  upload_time="";
	protected String  locking_time="";
	protected String  status="";
	protected String  Id="";
	public DIASList(String file_name, String file_type, String uploaded_by, String upload_time, String locking_time,
			String status, String id) {
		super();
		this.file_name = file_name;
		this.file_type = file_type;
		this.uploaded_by = uploaded_by;
		this.upload_time = upload_time;
		this.locking_time = locking_time;
		this.status = status;
		Id = id;
	}
	public DIASList(String id) {
		super();
		Id = id;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	public String getUploaded_by() {
		return uploaded_by;
	}
	public void setUploaded_by(String uploaded_by) {
		this.uploaded_by = uploaded_by;
	}
	public String getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(String upload_time) {
		this.upload_time = upload_time;
	}
	public String getLocking_time() {
		return locking_time;
	}
	public void setLocking_time(String locking_time) {
		this.locking_time = locking_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public DIASList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}


