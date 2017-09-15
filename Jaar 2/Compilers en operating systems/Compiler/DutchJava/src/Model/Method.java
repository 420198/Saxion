package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thama on 16-5-2017.
 */
public class Method {
    /**
     * List of parameters in the method
     */
    private List<Symbol> parameters;

    /**
     * Name of the method
     */
    private String name;

    /**
     * Return type of the method
     */
    private Type returnType;

    /**
     * Constructor for the method
     *
     * @param name       Name of the method
     * @param returnType Return type of the method
     */
    public Method(String name, Type returnType) {
        this.name = name;
        this.returnType = returnType;
        this.parameters = new ArrayList<>();
    }

    /**
     * Add a parameter to the method
     *
     * @param parameter Parameter to be added
     * @return true/false
     */
    public boolean addParameter(Symbol parameter) {
        return parameters.add(parameter);
    }

    /**
     * Get the parameters of the method
     *
     * @return the parameters
     */
    public List<Symbol> getParameters() {
        return parameters;
    }

    /**
     * Get the name of the method
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the return type of the method
     *
     * @return
     */
    public Type getReturnType() {
        return returnType;
    }
}