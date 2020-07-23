package jp.trans_it.mark5.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the document_templates database table.
 * 
 */
@Entity
@Table(name="document_templates")
@NamedQuery(name="DocumentTemplate.findAll", query="SELECT d FROM DocumentTemplate d")
public class DocumentTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String content;

	@Column(name="create_at")
	private Timestamp createAt;

	@Column(name="organization_id")
	private Long organizationId;

	@Column(name="update_at")
	private Timestamp updateAt;

	public DocumentTemplate() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Long getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Timestamp getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

}