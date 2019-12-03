import com.github.javafaker.Faker

class RandomUtil {
    private static def faker = new Faker(new Locale("en-US"))

    static def firstName(){
        faker.name().firstName()
    }
}