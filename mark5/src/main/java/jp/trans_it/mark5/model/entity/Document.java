package jp.trans_it.mark5.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the documents database table.
 * 
 */
@Entity
@Table(name="documents")
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String content;

	@Column(name="create_at")
	private Timestamp createAt;

	@Temporal(TemporalType.DATE)
	@Column(name="document_date")
	private Date documentDate;

	@Column(name="document_number")
	private Integer documentNumber;

	@Column(name="document_type")
	private Integer documentType;

	@Column(name="project_id")
	private Long projectId;

	@Column(name="sales_id")
	private Long salesId;

	private Integer status;

	@Column(name="template_id")
	private Long templateId;

	@Column(name="update_at")
	private Timestamp updateAt;

	public Document() {
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

	public Date getDocumentDate() {
		return this.documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

	public Integer getDocumentNumber() {
		return this.documentNumber;
	}

	public void setDocumentNumber(Integer documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Integer getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(Integer documentType) {
		this.documentType = documentType;
	}

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getSalesId() {
		return this.salesId;
	}

	public void setSalesId(Long salesId) {
		this.salesId = salesId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public Timestamp getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

}