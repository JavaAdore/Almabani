package com.almabani.common.interfaces;

import java.io.Serializable;

public interface ByteArrayHolder extends Serializable {

	public void setHoldedImage(byte[] blob);
	
	public byte[] getHoldedImage();
	
}
