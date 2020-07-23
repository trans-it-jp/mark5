package jp.trans_it.mark5.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_images database table.
 * 
 */
@Entity
@Table(name="user_images")
@NamedQuery(name="UserImage.findAll", query="SELECT u FROM UserImage u")
public class UserImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="image_id")
	private Long imageId;

	@Column(name="user_id")
	private Long userId;

	public UserImage() {
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

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}