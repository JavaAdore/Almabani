package com.almabani.common.dto;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Random;

import com.almabani.common.entity.schema.adminoam.OamDocumentType;

public class FileHolder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String fileName;

	private InputStream inputStream;

	private OamDocumentType documentType;

	private FileHolder() {
	}

	public static FileHolder prepareFileHolder(String fileName,
			InputStream inputStream) {
		FileHolder fileHolder = new FileHolder();
		fileHolder.setId(new Random().nextLong() * -1);
		fileHolder.setFileName(fileName);
		fileHolder.setInputStream(inputStream);
		return fileHolder;

	}

	public static FileHolder prepareFileHolder(Long id, String fileName,
			InputStream inputStream) {
		FileHolder fileHolder = new FileHolder();
		fileHolder.setId(id != null ? id : new Random().nextLong() * -1);
		fileHolder.setFileName(fileName);
		fileHolder.setInputStream(inputStream);
		return fileHolder;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileHolder other = (FileHolder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public OamDocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(OamDocumentType documentType) {
		this.documentType = documentType;
	}

}
