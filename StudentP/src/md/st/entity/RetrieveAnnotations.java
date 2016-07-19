package md.st.entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Statement;

import md.st.entity.annotations.Column;
import md.st.entity.annotations.Entity;

public class RetrieveAnnotations {

	public static <T> String EntityAnnotation(T t) {
		Class<T> object = (Class) t;
		String entity = "";
		Annotation[] annotations = object.getAnnotations();
		for (int i = 0; i < annotations.length; i++) {
			for (Annotation annotation1 : annotations) {
				Entity e = (Entity) annotation1;
				// System.out.println(e.dbName());
				// System.out.println(e.tableName());
				entity += "`"+e.tableName()+"`";

			}
		}
		return entity;
	}

	public static <T> String ColumnAnnotation(T t) {

		Class<T> aClass = (Class) t;
		String column = "";
		Field[] field = aClass.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			Annotation[] annotations2 = field[i].getDeclaredAnnotations();
			if (i == field.length - 1) {
				for (Annotation annotation1 : annotations2) {
					Column a = (Column) annotation1;
					String b = a.name();
					String c = new String(b);
					// System.out.print("`"+c+"`"+" ");
				//	System.out.print("`"+c+"`"+" ");
					column += "`"+a.name()+"`";
				}
			}

			else {
				for (Annotation annotation1 : annotations2) {
					Column a = (Column) annotation1;
					String b = a.name();
					// annotations2[0]
					String c = new String(b);
					//System.out.print("`"+c+"`"+",");
					// b.substring(5).replace(b.substring(5, 6), "");
					column += " "+"`"+a.name().replace("id,", "")+"`" + ",";
				}
			}
		}
		return column;

	}

	public static <T> String ColumnAnnotationUpdate(T t) {

		Class<T> aClass = (Class) t;
		String column = null;
		Field[] field = aClass.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			Annotation[] annotations2 = field[i].getDeclaredAnnotations();
			if (i == field.length - 1) {
				for (Annotation annotation1 : annotations2) {
					Column a = (Column) annotation1;
					String b = a.name();
					String c = new String(b);
					System.out.print(c);

				}
			}

			else {
				for (Annotation annotation1 : annotations2) {
					Column a = (Column) annotation1;
					String b = a.name();
					String c = new String(b);
					System.out.print(c + " ");
					// b.substring(5).replace(b.substring(5, 6), "");
					column = a.name();
				}
			}
		}
		return column;

	}
	
	
	

}
