package Model;

import Model.Exceptions.InvalidTypeException;

/**
 * Created by thama on 6-6-2017.
 */
public enum Type {
    BOOL,
    INT,
    STRING,
    VOID,
    FLOAT,
    INVALID;

    /**
     * Static method to determine datatype based on text
     *
     * @param datatype datatype in string
     * @return datatype
     */
    public static Type getType(String datatype) {
        switch (datatype) {
            case "draad":
                return Type.STRING;
            case "nummer":
                return Type.INT;
            case "booleaans":
                return Type.BOOL;
            case "vliegend":
                return Type.FLOAT;
            case "leegte":
                return Type.VOID;
            default:
                throw new InvalidTypeException("Invalid type for " + datatype);
        }
    }

    public String getMnenonic() {
        switch (this) {
            case FLOAT:
                return "F";
            case INT:
                return "I";
            case BOOL:
                return "Z";
            case VOID:
                return "V";
            case STRING:
                return "Ljava/lang/String;";
            default:
                return "";
        }
    }
}
