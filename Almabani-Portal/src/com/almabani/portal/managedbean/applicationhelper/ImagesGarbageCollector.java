package com.almabani.portal.managedbean.applicationhelper;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.almabani.common.util.Utils;

@ApplicationScoped
@ManagedBean(eager=true)
public class ImagesGarbageCollector extends Thread implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final long IMAGE_GARBAGE_COLLETOR_SLEEP_PERIOD = 120000;

	private Collection<String> imagePathesToBeRemoved = new ConcurrentLinkedDeque<>();
 
	@PostConstruct
	public void init() {
		start();
	} 

	public void run() {
		for (;;) {
			Iterator<String> imagePathesToBeRemovedIterator = imagePathesToBeRemoved
					.iterator();
			while (imagePathesToBeRemovedIterator.hasNext()) {
				try {
					String path = imagePathesToBeRemovedIterator.next();
					Utils.deleteFile(path);
					imagePathesToBeRemovedIterator.remove();   
					Thread.sleep(IMAGE_GARBAGE_COLLETOR_SLEEP_PERIOD);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
			}

		}
	}
	
	
	public void registerNewImage(String path)
	{
		imagePathesToBeRemoved.add(path); 
	}
}
