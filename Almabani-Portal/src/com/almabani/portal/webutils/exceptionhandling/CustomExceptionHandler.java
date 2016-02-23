package com.almabani.portal.webutils.exceptionhandling;

import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.webutils.WebUtils;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;

	CustomExceptionHandler(ExceptionHandler exception) {
		this.wrapped = exception;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return wrapped;
	}

	@Override
	public void handle() throws FacesException {

		final Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents()
				.iterator();
		while (i.hasNext()) {
			ExceptionQueuedEvent event = i.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event
					.getSource();

			// get the exception from context
			Throwable t = context.getException();

			// here you do what ever you want with exception
			try {

				// remove the comment below if you want to report the error in a
				// jsf error message
				Throwable ex = getRootCause(t);
				if (t instanceof AlmabaniException) {
					WebUtils.fireErrorMessage(((AlmabaniException) t).getKey());

				} else if (t.getCause() instanceof AlmabaniException) {
					if (Utils.isEmptySet(((AlmabaniException) t.getCause())
							.getParameters())) {
						WebUtils.fireErrorMessage(((AlmabaniException) t
								.getCause()).getKey());
					} else {
						WebUtils.displayAlmabanyExceptionErrorMessage((AlmabaniException) t
								.getCause());
					}  

				} else if (ex instanceof AlmabaniException) {
					if (Utils.isEmptySet(((AlmabaniException) ex)
							.getParameters())) {
						WebUtils.fireErrorMessage(((AlmabaniException) ex)
								.getKey());
					} else { 
						WebUtils.displayAlmabanyExceptionErrorMessage(((AlmabaniException) ex));
					}

				}

			} finally {
				// remove it from queue
				//i.remove();
			}    
		}
		// parent hanle
		//getWrapped().handle();
	}

}