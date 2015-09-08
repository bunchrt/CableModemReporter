package com.shcbts.cablemodemreporter.dao;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author bunchr
 */
public class AverageVO {

    private Date dtg;
    private int count;
    private int avgUninterruptedMins;

    @Override
    public String toString() {
        return "AverageVO{" + "dtg=" + dtg + ", count=" + count + ", avgUninterruptedMins=" + avgUninterruptedMins + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.dtg);
        hash = 11 * hash + this.count;
        hash = 11 * hash + this.avgUninterruptedMins;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AverageVO other = (AverageVO) obj;
        if (!Objects.equals(this.dtg, other.dtg)) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }
        if (this.avgUninterruptedMins != other.avgUninterruptedMins) {
            return false;
        }
        return true;
    }

    /**
     * @return the dtg
     */
    public Date getDtg() {
        return dtg;
    }

    /**
     * @param dtg the dtg to set
     */
    public void setDtg(Date dtg) {
        this.dtg = dtg;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the avgUninterruptedMins
     */
    public int getAvgUninterruptedMins() {
        return avgUninterruptedMins;
    }

    /**
     * @param avgUninterruptedMins the avgUninterruptedMins to set
     */
    public void setAvgUninterruptedMins(int avgUninterruptedMins) {
        this.avgUninterruptedMins = avgUninterruptedMins;
    }
}
