package projet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Terrasse {
    int codeTerrasse;
    String typeTerrasse;
    double surface; 
    Date firstDate = new Date();
    public Terrasse(int codeTerrasse, String typeTerrasse, double surface, String firstDate) throws ParseException{
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE );
        this.codeTerrasse = codeTerrasse;
        this.typeTerrasse = typeTerrasse;
        this.surface = surface;
        this.firstDate = dtf.parse(firstDate);
    }

    public double calculDateUtilisation( String lastdate) throws ParseException{
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE );
        Date lastDate = dtf.parse(lastdate);
        return TimeUnit.DAYS.convert(Math.abs(lastDate.getTime() - firstDate.getTime()), TimeUnit.MILLISECONDS)+1;

    }
    public int getCodeTerrasse() {
        return codeTerrasse;
    }
    public Date getFirstDate() {
        return firstDate;
    }
    public double getSurface() {
        return surface;
    }
    public String getTypeTerrasse() {
        return typeTerrasse;
    }
    public void setCodeTerrasse(int codeTerrasse) {
        this.codeTerrasse = codeTerrasse;
    }
    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }
    public void setSurface(double surface) {
        this.surface = surface;
    }
    public void setTypeTerrasse(String typeTerrasse) {
        this.typeTerrasse = typeTerrasse;
    }

}
