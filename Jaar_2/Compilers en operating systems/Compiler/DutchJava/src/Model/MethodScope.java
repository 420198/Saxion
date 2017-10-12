package Model;

/**
 * Created by thama on 20-6-2017.
 */
public class MethodScope extends Scope {
    /**
     * Method in the scope
     */
    private Method method;

    /**
     * Constructor for new method scope
     *
     * @param parent parent of method scope
     * @param name   name of scope
     * @param method Method in the scope
     */
    public MethodScope(Scope parent, String name, Method method) {
        super(parent, name);
        this.method = method;
        for (Symbol s :
                method.getParameters()) {
            addVariable(s);
            assignPosition(s);
        }
    }

    /**
     * Getter for the method
     *
     * @return the method
     */
    public Method getMethod() {
        return method;
    }
}