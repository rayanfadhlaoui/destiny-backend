package ca.destiny.v2.fighter;

public enum ClassEnum {
    NO_CLASS,
    APPRENTICE,
    THIRD_CLASS,
    SECOND_CLASS,
    FIRST_CLASS,
    SERGEANT,
    SERGEANT_MAYOR,
    WARRANT_OFFICER,
    OFFICER,
    JUNIOR_LIEUTENANT,
    LIEUTENANT,
    FIRST_LIEUTENANT,
    MAYOR,
    COLONEL,
    REAR_ADMIRAL,
    SUB_ADMIRAL,
    VICE_ADMIRAL,
    ADMIRAL,
    GRAND_ADMIRAL;

    public ClassEnum getPrevious() {
        switch (this) {
            case NO_CLASS:
                throw new IllegalArgumentException("getPrevious NO_CLASS is impossible");
            case APPRENTICE:
                return NO_CLASS;
            case THIRD_CLASS:
                return APPRENTICE;
            case SECOND_CLASS:
                return THIRD_CLASS;
            case FIRST_CLASS:
                return SECOND_CLASS;
            case SERGEANT:
                return FIRST_CLASS;
            case SERGEANT_MAYOR:
                return SERGEANT;
            case WARRANT_OFFICER:
                return SERGEANT_MAYOR;
            case OFFICER:
                return WARRANT_OFFICER;
            case JUNIOR_LIEUTENANT:
                return OFFICER;
            case LIEUTENANT:
                return JUNIOR_LIEUTENANT;
            case FIRST_LIEUTENANT:
                return LIEUTENANT;
            case MAYOR:
                return FIRST_LIEUTENANT;
            case COLONEL:
                return MAYOR;
            case REAR_ADMIRAL:
                return COLONEL;
            case SUB_ADMIRAL:
                return REAR_ADMIRAL;
            case VICE_ADMIRAL:
                return SUB_ADMIRAL;
            case ADMIRAL:
                return VICE_ADMIRAL;
            case GRAND_ADMIRAL:
                return ADMIRAL;
        }
        throw new IllegalArgumentException("Unreachable");
    }
}
