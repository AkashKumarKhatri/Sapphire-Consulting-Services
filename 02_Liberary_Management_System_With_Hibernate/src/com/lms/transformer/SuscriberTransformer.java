package com.lms.transformer;

import com.lms.beans.SuscriberBean;
import com.lms.dto.SuscriberDTO;

public class SuscriberTransformer {
	
	public static SuscriberDTO transform(SuscriberBean suscriberBean) {
		
		SuscriberDTO suscriberDTO = new SuscriberDTO();
		
		if (suscriberBean.getSuscriberId() != null) {
			suscriberDTO.setSuscriberId(suscriberBean.getSuscriberId().toString());
		}
		
		if (suscriberBean.getName() != null) {
			suscriberDTO.setName(suscriberBean.getName());
		}
		
		if (suscriberBean.getAddress() != null) {
			suscriberDTO.setAddress(suscriberBean.getAddress());
		}
		
		if (suscriberBean.getApprovalStatus() != null) {
			suscriberDTO.setApprovalStatus(suscriberBean.getApprovalStatus());
		}
		
		if (suscriberBean.getContact() != null) {
			suscriberDTO.setContact(suscriberBean.getContact());
		}
		
		if (suscriberBean.getQuota() != null) {
			suscriberDTO.setQuota(suscriberBean.getQuota().toString());
		}
		
		if (suscriberBean.getStatus() != null) {
			suscriberDTO.setStatus(suscriberBean.getStatus());
		}
		
		if (suscriberBean.getEmail() != null) {
			suscriberDTO.setEmail(suscriberBean.getEmail());
		}
		
		if (suscriberBean.getPassword() != null) {
			suscriberDTO.setPassword(suscriberBean.getPassword());
		}
		
		return suscriberDTO;
	}
}
