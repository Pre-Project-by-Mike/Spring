import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**Задание:

 Прочитайте про виды бинов.
V Создайте POJO-класс Cat.
V В классе AppConfig, по аналогии, создайте бин с именем “cat”.
V Настройте этот бин так, чтобы он создавался новым при каждом запросе.
V В классе App, по аналогии, вызовите еще раз бин HelloWorld,
 затем 2 раза вызовите бин cat. Сравните 2 пары бинов по ссылке и
 выведите результат в консоль. Для пары HelloWorld должно вернуться
 true, для cat - false. Так вы можете увидеть результат того,
 как работает
 наш контейнер.**/
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        HelloWorld otherBean =
                (HelloWorld) applicationContext.getBean("helloworld");

        System.out.println(bean.getMessage());
        Cat cat = applicationContext.getBean(Cat.class);
        Cat otherCat = applicationContext.getBean(Cat.class);

        System.out.println(bean == otherBean);
        System.out.println(cat == otherCat);


    }
}