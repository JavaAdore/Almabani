package com.almabani.common.entity;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 6031140183212988620L;

	public abstract Long getId();

	public abstract void setId(Long i);

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractEntity))
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		if (getId() != null) {
			return getId().intValue();
		}
		return 0;
	}

}
