package fizzbuzzforalfresco.demo;

public class Range {
    /**
     * lower limit of the range
     */
    private int minValue;

    /**
     * higher limit of the range
     */
    private int maxValue;

    public Range(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
