package com.almabani.portal.component.imageuploader;

import java.io.File;
import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.sql.rowset.serial.SerialException;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;

import com.almabani.common.interfaces.ByteArrayHolder;
import com.almabani.common.util.Utils;
import com.almabani.portal.constant.PortalConstants;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class ImageUploaderHandlerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StreamedContent image;

	private String path;
	private ByteArrayHolder byteArrayHolder;
	public static String parent_uploaded_images_path = WebUtils.getWarPath();

	static {

		if (parent_uploaded_images_path.lastIndexOf("/") != parent_uploaded_images_path
				.length()) {
			parent_uploaded_images_path += "/";
		}

		parent_uploaded_images_path += PortalConstants.TEMP_IMAGES_PATH
				+ File.separator;
	}

	public boolean ableToDeleteImage() {
		return path != null
				&& path.equalsIgnoreCase(PortalConstants.DEFAULT_IMAGE_PLACEHOLDER) == false;
	}

	public void handleFileUpload(FileUploadEvent event) {

		byteArrayHolder = (ByteArrayHolder) event.getComponent()
				.getAttributes().get(getByteArrayHolderAttributeName());
		if (Utils.isNotNull(byteArrayHolder)) {
			try {
				byteArrayHolder
						.setHoldedImage(new javax.sql.rowset.serial.SerialBlob(
								event.getFile().getContents()));
			} catch (SerialException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void deleteOldImage(ByteArrayHolder byteArrayHolder) {

		if (Utils.isNotNull(byteArrayHolder)) {
			byteArrayHolder.setHoldedImage(null);
		}
	}

	public StreamedContent getImage() {
		return image;
	}

	public void setImage(StreamedContent image) {
		this.image = image;
	}

	public String getPath() {
		return path != null ? path : PortalConstants.DEFAULT_IMAGE_PLACEHOLDER;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getByteArrayHolderAttributeName() {
		return PortalConstants.BYTE_ARRAY_HOLDER_ATTRIBUTE_NAME;
	}

	public ByteArrayHolder getByteArrayHolder() {
		return byteArrayHolder;
	}

	public void setByteArrayHolder(ByteArrayHolder byteArrayHolder) {
		this.byteArrayHolder = byteArrayHolder;
	}

}