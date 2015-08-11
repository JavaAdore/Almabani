package com.almabani.common.interfaces;

import java.io.Serializable;
import java.sql.Blob;

public interface ByteArrayHolder extends Serializable {

	public void setHoldedImage(byte[] blob);
	
	public byte[] getHoldedImage();
	
}
