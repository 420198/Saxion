package Model;

/**
 * Created by thama on 16-5-2017.
 */
public class Symbol {
    /**
     * Name of the symbol (ID)
     */
    private String name;

    /**
     * Type of the symbol
     */
    private Type type;

    /**
     * Loading position for the symbol
     */
    private int position;

    /**
     * Constructor for the symbol
     *
     * @param name Name of the symbol (ID)
     * @param type Type of the symbol
     */
    public Symbol(String name, Type type) {
        this.type = type;
        this.name = name;
    }

    /**
     * Getter for the symbol name
     *
     * @return symbol name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the symbol type
     *
     * @return symbol type
     */
    public Type getType() {
        return type;
    }

    /**
     * Getter for the symbol position
     *
     * @return symbol position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Setter for the symbol position
     *
     * @param position symbol position
     */
    public void setPosition(int position) {
        this.position = position;
    }
}