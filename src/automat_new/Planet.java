package automat_new;
public enum Planet {
    EARTH, MARS;

    public String toString()
    {
        switch(this)
        {
            case EARTH: return "Earth";
            case MARS: return "Mars";
            default: return "Unknown";
        }
    }
}