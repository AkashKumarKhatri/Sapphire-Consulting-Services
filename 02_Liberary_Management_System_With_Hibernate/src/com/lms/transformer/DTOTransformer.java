package com.lms.transformer;

import com.lms.beans.Beans;
import com.lms.dto.DTO;

public class DTOTransformer {
	
	public static DTO transform(Beans beans) {
		
		DTO dto = new DTO();
		
		if (beans.getCreatedBy() != null) {
			dto.setCreatedBy(beans.getCreatedBy().toString());
		}
		
		if (beans.getCreatedDate() != null) {
			dto.setCreatedDate(beans.getCreatedDate().toString());
		}
		
		if (beans.getModifiedBy() != null) {
			dto.setModifiedBy(beans.getModifiedBy().toString());
		}
		
		if (beans.getModifiedDate() != null) {
			dto.setModifiedDate(beans.getModifiedDate().toString());
		}
		
		return dto;
	}
}
