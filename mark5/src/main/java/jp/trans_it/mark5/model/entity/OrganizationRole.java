package jp.trans_it.mark5.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the organization_roles database table.
 * 
 */
@Entity
@Table(name="organization_roles")
@NamedQuery(name="OrganizationRole.findAll", query="SELECT o FROM OrganizationRole o")
public class OrganizationRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Integer authority;

	@Column(name="organization_id")
	private Long organizationId;

	@Column(name="user_id")
	private Long userId;

	public OrganizationRole() {
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

	public Long getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}