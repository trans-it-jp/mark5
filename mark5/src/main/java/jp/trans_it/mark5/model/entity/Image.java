package jp.trans_it.mark5.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the images database table.
 * 
 */
@Entity
@Table(name="images")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="create_at")
	private Timestamp createAt;

	@Column(name="file_name")
	private double fileName;

	@Column(name="file_stream")
	private byte[] fileStream;

	@Column(name="update_at")
	private Timestamp updateAt;

	@Column(name="user_id")
	private Long userId;

	public Image() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public double getFileName() {
		return this.fileName;
	}

	public void setFileName(double fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileStream() {
		return this.fileStream;
	}

	public void setFileStream(byte[] fileStream) {
		this.fileStream = fileStream;
	}

	public Timestamp getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}