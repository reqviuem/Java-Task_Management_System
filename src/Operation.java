public enum Operation {
    QUITE("quit") ,SHOW("show"),EDIT("edit"),CREATE("create") ,CHECK("check") ;
    private final String operation;
    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation StringToEnum(String oper) {

        for (Operation s : Operation.values()) {
            if (s.operation.equals(oper)) {
                return s;
            }
        }
        return null;
    }
}
