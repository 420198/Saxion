package Model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by thama on 16-5-2017.
 */
public class Scope {
    /**
     * Parent for the current scope
     */
    private Scope parent;

    /**
     * Variable table for the current scope
     */
    private LinkedHashMap<String, Symbol> variableTable = new LinkedHashMap<>();

    /**
     * Functie table for the current scope
     */
    private LinkedHashMap<String, MethodScope> functieTable = new LinkedHashMap<>();

    /**
     * Child scope list for the current scope
     */
    private List<Scope> childScopes = new ArrayList<>();

    /**
     * Scope name
     */
    private String name;

    /**
     * Position needed for the symbols in the scope
     */
    private int position;

    /**
     * Stack size
     */
    private int stack;

    /**
     * Constructor for a scope
     *
     * @param parent Parent for the current scope
     * @param name   Scope name
     *               Set the position
     *               Set the stack size
     */
    public Scope(Scope parent, String name) {
        this.parent = parent;
        this.name = name;
        this.position = parent == null ? 0 : parent.position;
        this.stack = parent == null ? 0 : parent.stack;
    }

    /**
     * Constructor for a scope
     *
     * @param parent Parent for the current scope
     * @param name   Scope name
     *               Set the position
     *               Set the stack size
     */
    public Scope(Scope parent, String name,int stack) {
        this.parent = parent;
        this.name = name;
        this.position = parent == null ? 0 : parent.position;
        this.stack = stack;
    }

    /**
     * Create a new child scope
     *
     * @param naam the name of the scope
     * @return the newly created scope
     */
    public Scope createChild(String naam) {
        return new Scope(this, naam);
    }

    /**
     * Create a new child scope with custom stack
     *
     * @param naam the name of the scope
     * @return the newly created scope
     */
    public Scope createChild(String naam, int stack) {
        return new Scope(this, naam,stack);
    }

    /**
     * Close a current scope
     *
     * @return its parent
     */
    public Scope closeChild() {
        return parent;
    }

    /**
     * Add a child scope to the current scope
     *
     * @param scope Child scope
     * @return false or true based on succes
     */
    public boolean addChildScope(Scope scope) {
        return childScopes.add(scope);
    }

    /**
     * Add a new function to the scope
     *
     * @param method method to be added
     * @return true/false based on succes
     */
    public boolean addFunctie(Method method) {
        MethodScope mt = lookFunctie(method.getName());
        if (mt == null) {
            MethodScope methodScope = new MethodScope(this, method.getName(), method);
            functieTable.put(method.getName(), methodScope);
            childScopes.add(methodScope);
            return true;
        }
        return false;
    }

    /**
     * Add a new variable to the scope
     *
     * @param variable variable to be added
     * @return true/false based on succes
     */
    public boolean addVariable(Symbol variable) {
        Symbol s = lookVariable(variable.getName());
        if (s == null) {

            variableTable.put(variable.getName(), variable);
            return true;
        }
        return false;
    }

    /**
     * Find a variable based on name
     *
     * @param name variable name
     * @return null or variable
     */
    public Symbol lookVariable(String name) {

        if (parent != null) {
            if (variableTable.get(name) != null) {
                return variableTable.get(name);
            } else {
                return parent.lookVariable(name);
            }
        } else {
            return variableTable.get(name);
        }
    }

    /**
     * Find a function (method) based on name
     *
     * @param name function name
     * @return null or function
     */
    public MethodScope lookFunctie(String name) {
        MethodScope mt = functieTable.get(name);
        if (parent != null) {
            if (mt != null) {
                return mt;
            } else {
                return parent.lookFunctie(name);
            }
        } else {
            return mt;
        }
    }

    /**
     * Telt zichzelf+ grootste child
     *
     * @return
     */
    public int getLocalAmount() {

        int max = 0;
        int temp = 0;
        for (Scope scope : childScopes) {
            if (scope instanceof MethodScope) {
                continue;
            }

            temp = scope.getLocalAmount();
            if (temp > max) {
                max = temp;
            }
        }
        return max + variableTable.size();
    }

    /**
     * Get stack based on scope
     *
     * @return stack
     */
    public int getLocalStack() {
        int max = 0;
        int temp = 0;
        for (Scope scope : childScopes) {
            if (scope instanceof MethodScope) {
                continue;
            }

            temp = scope.getLocalStack();
            if (temp > max) {
                max = temp;
            }
        }
        return max + stack;
    }

    /**
     * Get the global scope
     *
     * @return global scope
     */
    public Scope getTopParent() {
        if (parent != null) {
            return parent.getTopParent();
        }
        return this;
    }

    /**
     * Assign position to symbol
     *
     * @param symbol symbol
     */
    public void assignPosition(Symbol symbol) {
        symbol.setPosition(position++);
    }

    /**
     * Higher the stack
     */
    public void addToStack() {
        stack++;
    }

    /**
     * Get the name of the current scope
     *
     * @return name of curent scope
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the scope
     *
     * @param name name of the scope
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get all child scopes of a scope
     *
     * @return all child scopes
     */
    public List<Scope> getChildScopes() {
        return childScopes;
    }

    /**
     * Get scope parent
     *
     * @return scope parent
     */
    public Scope getParent() {
        return parent;
    }
}