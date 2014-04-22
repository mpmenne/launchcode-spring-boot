package hello;

/**
 * Created with IntelliJ IDEA.
 * User: mpmenne
 * Date: 4/21/14
 * Time: 1:45 AM
 * To change this template use File | Settings | File Templates.
 */
// generate this in class!
public class Beer {
    private String name;
    private String type;

    public Beer() {

    }

    public Beer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
