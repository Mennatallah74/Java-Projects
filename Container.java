
public class Container implements Comparable <Container>{
    private String ID;
    private String shortName;
    private String longName;

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getID() {
        return ID;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    @Override
    public String toString() {
        return "    <CONTAINER " + this.getID() + ">\n" +
               "    <SHORT-NAME>" + this.getShortName() + "</SHORT-NAME>\n" +
                "    <LONG-NAME>"+ this.getLongName() + "</LONG-NAME>\n" +
                "   </CONTAINER>\n";
        
                
    }
    

    @Override
    public int compareTo(Container o) {
        if(this.getShortName().charAt(9) > o.getShortName().charAt(9))
        {
        return 1;
        }
        else if(this.getShortName().charAt(9) < o.getShortName().charAt(9))
        {
        return -1;
        }
        else
        {
        return 0;
        }
    }
    
}
