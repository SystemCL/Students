package md.st.entity.annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {
	public String dbName() default "studentsdb";
	public String tableName() default "";

}
