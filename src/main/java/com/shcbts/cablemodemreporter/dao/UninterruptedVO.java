package com.shcbts.cablemodemreporter.dao;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author bunchr
 */
public class UninterruptedVO {
    private Date dtg;
    private int elapsedSecsCount;
    private int elapsedMinsCount;
    private int elapsedHoursCount;
    private int elapsedDaysCount;

    @Override
    public String toString() {
        return "UninterruptedVO{" + "dtg=" + dtg + ", elapsedSecsCount=" + elapsedSecsCount + ", elapsedMinsCount=" + elapsedMinsCount + ", elapsedHoursCount=" + elapsedHoursCount + ", elapsedDaysCount=" + elapsedDaysCount + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.dtg);
        hash = 71 * hash + this.elapsedSecsCount;
        hash = 71 * hash + this.elapsedMinsCount;
        hash = 71 * hash + this.elapsedHoursCount;
        hash = 71 * hash + this.elapsedDaysCount;
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
        final UninterruptedVO other = (UninterruptedVO) obj;
        if (!Objects.equals(this.dtg, other.dtg)) {
            return false;
        }
        if (this.elapsedSecsCount != other.elapsedSecsCount) {
            return false;
        }
        if (this.elapsedMinsCount != other.elapsedMinsCount) {
            return false;
        }
        if (this.elapsedHoursCount != other.elapsedHoursCount) {
            return false;
        }
        if (this.elapsedDaysCount != other.elapsedDaysCount) {
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
     * @return the elapsedSecsCount
     */
    public int getElapsedSecsCount() {
        return elapsedSecsCount;
    }

    /**
     * @param elapsedSecsCount the elapsedSecsCount to set
     */
    public void setElapsedSecsCount(int elapsedSecsCount) {
        this.elapsedSecsCount = elapsedSecsCount;
    }

    /**
     * @return the elapsedMinsCount
     */
    public int getElapsedMinsCount() {
        return elapsedMinsCount;
    }

    /**
     * @param elapsedMinsCount the elapsedMinsCount to set
     */
    public void setElapsedMinsCount(int elapsedMinsCount) {
        this.elapsedMinsCount = elapsedMinsCount;
    }

    /**
     * @return the elapsedHoursCount
     */
    public int getElapsedHoursCount() {
        return elapsedHoursCount;
    }

    /**
     * @param elapsedHoursCount the elapsedHoursCount to set
     */
    public void setElapsedHoursCount(int elapsedHoursCount) {
        this.elapsedHoursCount = elapsedHoursCount;
    }

    /**
     * @return the elapsedDaysCount
     */
    public int getElapsedDaysCount() {
        return elapsedDaysCount;
    }

    /**
     * @param elapsedDaysCount the elapsedDaysCount to set
     */
    public void setElapsedDaysCount(int elapsedDaysCount) {
        this.elapsedDaysCount = elapsedDaysCount;
    }
}
