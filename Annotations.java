
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface RequiredsPermission{
    String value() default "USER";
    int level() default 1;
}


class Annotations{
    @RequiredsPermission
    public void deleteUser(int userId){
        
        System.out.println("user deleted!");
    }
    public static void main(String[] args) {
        Annotations anno = new Annotations();
        anno.deleteUser(234);
    }
}