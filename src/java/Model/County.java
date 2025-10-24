/**
 * IST 411 Project
 * Author: Phillip Nguyen
 * Description: Class for retrieving OpenPA JSON info
 *              Locations are for Pennsylvania County
 */
package Model;

public class County {
    
    private String date;
    private String county;
    private int partially_covered;
    private int fully_covered;
    private int additional_dose1;
    private int additional_dose2;
    private int bivalent_booster_1;

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the county
     */
    public String getCounty() {
        return county;
    }

    /**
     * @param county the county to set
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @return the partially_covered
     */
    public int getPartially_covered() {
        return partially_covered;
    }

    /**
     * @param partially_covered the partially_covered to set
     */
    public void setPartially_covered(int partially_covered) {
        this.partially_covered = partially_covered;
    }

    /**
     * @return the fully_covered
     */
    public int getFully_covered() {
        return fully_covered;
    }

    /**
     * @param fully_covered the fully_covered to set
     */
    public void setFully_covered(int fully_covered) {
        this.fully_covered = fully_covered;
    }

    /**
     * @return the additional_dose1
     */
    public int getAdditional_dose1() {
        return additional_dose1;
    }

    /**
     * @param additional_dose1 the additional_dose1 to set
     */
    public void setAdditional_dose1(int additional_dose1) {
        this.additional_dose1 = additional_dose1;
    }

    /**
     * @return the additional_dose2
     */
    public int getAdditional_dose2() {
        return additional_dose2;
    }

    /**
     * @param additional_dose2 the additional_dose2 to set
     */
    public void setAdditional_dose2(int additional_dose2) {
        this.additional_dose2 = additional_dose2;
    }

    /**
     * @return the bivalent_booster_1
     */
    public int getBivalent_booster_1() {
        return bivalent_booster_1;
    }

    /**
     * @param bivalent_booster_1 the bivalent_booster_1 to set
     */
    public void setBivalent_booster_1(int bivalent_booster_1) {
        this.bivalent_booster_1 = bivalent_booster_1;
    }
    
}
