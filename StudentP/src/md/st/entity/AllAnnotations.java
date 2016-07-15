package md.st.entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Statement;

import md.st.entity.annotations.Column;
import md.st.entity.annotations.Entity;

public class AllAnnotations {

	public static <T> String EntAnt(T t) {
		Class<T> object = (Class) t;
		String entity = null;
		Annotation[] annotations = object.getAnnotations();
		for (int i = 0; i < annotations.length; i++) {
			for (Annotation annotation1 : annotations) {
				Entity e = (Entity) annotation1;
				// System.out.println(e.dbName());
				// System.out.println(e.tableName());
				entity = e.tableName();

			}
		}
		return entity;
	}

	public static <T> String ColAnt(T t) {
		
		
		Class<T> aClass = (Class) t;
		String column = null;
		Field[] field = aClass.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			Annotation[] annotations2 = field[i].getDeclaredAnnotations();
			
			for (Annotation annotation1 : annotations2) {
				Column a = (Column) annotation1;
				String b = a.name();
				String c = new String(b);
			    System.out.print("`"+c+"`"+",");
			    //a.substring(5).replace(a.substring(5, 6), "")
				column = a.name();
			}
		}
		return column;
        
	}
	

}
