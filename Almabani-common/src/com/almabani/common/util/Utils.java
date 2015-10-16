package com.almabani.common.util;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.almabani.common.entity.AbstractEntity;
import com.almabani.common.entity.schema.admincor.DepartmentSection;

public class Utils {

	public static boolean isNull(Object obj) {
		return obj == null;

	}

	public static boolean isNotNull(Object obj) {
		return obj != null;

	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmptyList(List list) {
		return isNull(list) || list.size() == 0;
	}

	@SuppressWarnings("rawtypes")
	public static boolean isNotEmptyList(List list) {
		return isNotNull(list) && list.size() > 0;
	}

	public static boolean hasID(AbstractEntity abstractEntity) {
		return abstractEntity.getId() != null;
	}

	public static boolean isNotEmptyString(String str) {
		return isNotNull(str) && str.trim().length() > 0;
	}

	public static boolean isStringEqualsEachOthers(String str1, String str2) {

		if (isNotEmptyString(str1) && isNotEmptyString(str2)) {
			return str1.trim().equalsIgnoreCase(str2.trim());
		}
		return false;
	}

	public static boolean isNotEmptySet(Set<String> params) {

		return isNotNull(params) && params.size() > 0;
	}

	public static boolean isAString(Object object) {
		return isNotNull(object) && object instanceof String;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public static Class getFilterClass(String currentFilter, Class class1) {

		if (currentFilter.indexOf(".") == -1) {
			return getFieldType(class1, currentFilter);

		}

		int indexofDot = currentFilter.indexOf(".");

		return getFilterClass(currentFilter, 0, class1);

	}

	@SuppressWarnings("rawtypes")
	private static Class getFilterClass(String currentFilter,
			int currentFieldIndex, Class class1) {
		String[] fields = currentFilter.split("\\.");

		try {
			Field field = class1.getDeclaredField(fields[currentFieldIndex].trim());
			if (fields.length - 1 > currentFieldIndex) {
				return getFilterClass(currentFilter, ++currentFieldIndex,
						field.getType());
			}
			return field.getType();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
			return null;
		} catch (SecurityException e) {

			e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("rawtypes")
	private static Class getFieldType(Class class1, String currentFilter) {
		try {
			Field field = class1.getDeclaredField(currentFilter);
			return field.getType();
		} catch (NoSuchFieldException e) {

			return null;
		} catch (SecurityException e) {

			return null;
		}

	}

	@SuppressWarnings("rawtypes")
	public static Object initiatePrimitiveObject(Class targetedClass,
			String filterValue) {

		try {
			Constructor constructor = getAppropriateConstructor(targetedClass,
					new Object[] { filterValue });
			Object obj = constructor.newInstance(filterValue.trim());
			return obj;

		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {

			e.printStackTrace();
			return null;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Constructor getAppropriateConstructor(Class c,
			Object[] initArgs) {
		if (initArgs == null)
			initArgs = new Object[0];
		for (Constructor con : c.getDeclaredConstructors()) {
			Class[] types = con.getParameterTypes();
			if (types.length != initArgs.length)
				continue;
			boolean match = true;
			for (int i = 0; i < types.length; i++) {
				Class need = types[i], got = initArgs[i].getClass();
				if (!need.isAssignableFrom(got)) {
					if (need.isPrimitive()) {
						match = (int.class.equals(need) && Integer.class
								.equals(got))
								|| (long.class.equals(need) && Long.class
										.equals(got))
								|| (char.class.equals(need) && Character.class
										.equals(got))
								|| (Integer.class.equals(need) && Integer.class
										.equals(got))
								|| (boolean.class.equals(need) && Boolean.class
										.equals(got))
								|| (byte.class.equals(need) && Byte.class
										.equals(got));
					} else {
						match = false;
					}
				}
				if (!match)
					break;
			}
			if (match)
				return con;
		}
		throw new IllegalArgumentException(
				"Cannot find an appropriate constructor for class " + c
						+ " and arguments " + Arrays.toString(initArgs));
	}

	public static Set<Class<?>> getWrapperTypes() {
		Set<Class<?>> ret = new HashSet<Class<?>>();
		ret.add(Boolean.class);
		ret.add(Character.class);
		ret.add(Byte.class);
		ret.add(Integer.class);
		ret.add(Integer.class);
		ret.add(Long.class);
		ret.add(Float.class);
		ret.add(Double.class);
		return ret;
	}

	@SuppressWarnings("rawtypes")
	public static boolean isPrimitiveDataType(Class clz) {
		return clz.isPrimitive() || getWrapperTypes().contains(clz);
	}

	public static Date getStartOfDay(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		setHHMMSS(c, 0, 0, 0);
		return c.getTime();

	}

	public static Date getEndOfDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		setHHMMSS(c, 23, 59, 59);
		return c.getTime();
	}

	public static void setHHMMSS(Calendar c, int hh, int mi, int ss) {
		c.set(Calendar.HOUR_OF_DAY, hh);
		c.set(Calendar.MINUTE, mi);
		c.set(Calendar.SECOND, ss);
		c.set(Calendar.MILLISECOND, 0);
	}

	public static boolean isDirectValue(String filterValue) {
		return filterValue.indexOf(".") == -1;
	}

	@SuppressWarnings("rawtypes")
	public static Object getFirstResult(List list) {
		return isNotEmptyList(list) ? list.get(0) : null;
	}

	public static String dublicate(String str, int numberOfDuplication) {

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < numberOfDuplication; i++) {
			stringBuilder.append(str);
		}
		return stringBuilder.toString();
	}

	@SuppressWarnings("rawtypes")
	public static Object initiateNewEntityWithPrimaryKey(Class class1, Long key) {
		try {
			Object obj = class1.newInstance();
			if (obj instanceof AbstractEntity) {
				((AbstractEntity) (obj)).setId(key);
				return obj;
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();

		}
		return null;
	}

	public static boolean isEmptyStringOrNotNumericValue(String value) {
		return isNull(value) || value.trim().length() == 0
				|| !isNumericValue(value);
	}

	private static boolean isNumericValue(String value) {

		try {
			Double.parseDouble(value);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static void deleteFile(final String path) {
		new Thread() {
			public void run() {

				new File(path).delete();

			}
		}.start();

	}

	public static String getFullDate(Date date) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(date);

	}

	public static boolean isEmptyString(String value) {
		return Utils.isNull(value) || value.trim().length() == 0;
	}

	public static boolean isObjectInstanceOf(Object obj, Class class1) {

		try {
			class1.cast(obj);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static String dateToFullString(Date date)
	{
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
		return dateFormat.format(date);
	}
	
	
	public static Map<TimeUnit,Long> computeDiff(Date date1, Date date2) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
	    Collections.reverse(units);
	    Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
	    long milliesRest = diffInMillies;
	    for ( TimeUnit unit : units ) {
	        long diff = unit.convert(milliesRest,TimeUnit.MILLISECONDS);
	        long diffInMilliesForUnit = unit.toMillis(diff);
	        milliesRest = milliesRest - diffInMilliesForUnit;
	        result.put(unit,diff);
	    }
	    return result;
	}

	public static String getAbsoluteStringValue(String applicationDescription) {
		if(isNotEmptyString(applicationDescription))
		{
			return applicationDescription.trim();
		} 
		return "";
		
	}

	public static boolean isEmptySet(Set allApplications) {
		return Utils.isNull(allApplications) || allApplications.size()==0;
	}

	public static boolean isEmptyMap(
			Map<String, String> applicationsDescriptions) {
		return isNull(applicationsDescriptions) || applicationsDescriptions.size()==0;
	}

	
	public static void main(String [] arsgs) throws NoSuchFieldException, SecurityException
	{
		
		System.out.println(DepartmentSection.class.getDeclaredField("sectionCode"));
		
		
	}
}
