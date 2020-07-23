package jp.trans_it.mark5.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the project_roles database table.
 * 
 */
@Entity
@Table(name="project_roles")
@NamedQuery(name="ProjectRole.findAll", query="SELECT p FROM ProjectRole p")
public class ProjectRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Integer authority;

	@Column(name="project_id")
	private Long projectId;

	@Column(name="user_id")
	private Long userId;

	public ProjectRole() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAuthority() {
		return this.authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}