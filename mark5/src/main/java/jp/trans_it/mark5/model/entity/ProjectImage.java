package jp.trans_it.mark5.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the project_images database table.
 * 
 */
@Entity
@Table(name="project_images")
@NamedQuery(name="ProjectImage.findAll", query="SELECT p FROM ProjectImage p")
public class ProjectImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="image_id")
	private Long imageId;

	@Column(name="project_id")
	private Long projectId;

	public ProjectImage() {
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

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

}