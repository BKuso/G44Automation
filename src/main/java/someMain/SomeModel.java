package someMain;


public class SomeModel {

    private int id;
    private String name;
    private String someString;

    public int getId() {
        return id;
    }

    public SomeModel setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SomeModel setName(String name) {
        this.name = name;
        return this;
    }

    public SomeModel setSomeString(String someString) {
        this.someString = someString;
        return this;
    }

    @Override
    public String toString(){
        return String.format("{Это наш экземпляр модели. Параметры:\n" +
                "Идентификатор: %s, \n" +
                "Имя: %s, \n" +
                "Некоторая строка: %s" +
                "}",
                this.id,
                this.name,
                this.someString );
    }
}
