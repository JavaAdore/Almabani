package com.almabani.portal.component.imageuploader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

import com.almabani.common.interfaces.ByteArrayHolder;
import com.almabani.common.util.Utils;
import com.almabani.portal.constant.PortalConstants;
import com.almabani.portal.managedbean.applicationhelper.ImagesGarbageCollector;

@ManagedBean
@ViewScoped   
public class ByteImageViewerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@ManagedProperty(value="#{imagesGarbageCollector}")
	private ImagesGarbageCollector imagesGarbageCollector;
	
	String path;

	public String createTempImagePath(ByteArrayHolder byteArrayHolder) {
		if (Utils.isNotNull(byteArrayHolder)
				&& Utils.isNotNull(byteArrayHolder.getHoldedImage())) {
			path = new Date().getTime() + "-" + new Random().nextInt(999999999)
					+ ".png";
			try {
				String fullPath =ImageUploaderHandlerBean.parent_uploaded_images_path
						+ path;
				FileOutputStream fis = new FileOutputStream(new File(
						ImageUploaderHandlerBean.parent_uploaded_images_path
								+ path));
				fis.write( Utils.getBytes(byteArrayHolder.getHoldedImage()));
				fis.close();
				imagesGarbageCollector.registerNewImage(fullPath); 
			} catch (IOException e) {
				e.printStackTrace();
				path = PortalConstants.DEFAULT_IMAGE_PLACEHOLDER;
			}
		} else {
			path = PortalConstants.DEFAULT_IMAGE_PLACEHOLDER;
		}
		return path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ImagesGarbageCollector getImagesGarbageCollector() {
		return imagesGarbageCollector;
	}

	public void setImagesGarbageCollector(
			ImagesGarbageCollector imagesGarbageCollector) {
		this.imagesGarbageCollector = imagesGarbageCollector;
	}
  
	  

}
