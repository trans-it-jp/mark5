package jp.trans_it.mark5.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the organization_images database table.
 * 
 */
@Entity
@Table(name="organization_images")
@NamedQuery(name="OrganizationImage.findAll", query="SELECT o FROM OrganizationImage o")
public class OrganizationImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="image_id")
	private Long imageId;

	@Column(name="organization_id")
	private Long organizationId;

	public OrganizationImage() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getImageId() {
		return this.imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public Long getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

}