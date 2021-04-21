package language;

// Declaration implementation << Currently supports Int only >>
public class VariableDeclaration extends Expression{
    public String id;
    public String type;
    public Integer value;

    public VariableDeclaration(String id, String type, Integer value){
        this.id = id;
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "VariableDeclaration{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
