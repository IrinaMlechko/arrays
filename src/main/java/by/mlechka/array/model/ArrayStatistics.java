package by.mlechka.array.model;

import java.util.Objects;

public class ArrayStatistics {

    Integer min;
    Integer max;
    Integer sum;
    Double average;
    Integer amountOfPositiveElements;
    Integer amountOfNegativeElements;

    public ArrayStatistics(){}

    public ArrayStatistics(Integer min, Integer max, Integer sum, Double average, Integer amountOfPositiveElements, Integer amountOfNegativeElements){
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.average = average;
        this.amountOfPositiveElements = amountOfPositiveElements;
        this.amountOfNegativeElements = amountOfNegativeElements;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Integer getAmountOfPositiveElements() {
        return amountOfPositiveElements;
    }

    public void setAmountOfPositiveElements(Integer amountOfPositiveElements) {
        this.amountOfPositiveElements = amountOfPositiveElements;
    }

    public Integer getAmountOfNegativeElements() {
        return amountOfNegativeElements;
    }

    public void setAmountOfNegativeElements(Integer amountOfNegativeElements) {
        this.amountOfNegativeElements = amountOfNegativeElements;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArrayStatistics{");
        sb.append("min=").append(min);
        sb.append(", max=").append(max);
        sb.append(", sum=").append(sum);
        sb.append(", average=").append(average);
        sb.append(", amountOfPositiveElements=").append(amountOfPositiveElements);
        sb.append(", amountOfNegativeElements=").append(amountOfNegativeElements);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrayStatistics that = (ArrayStatistics) o;

        if (!Objects.equals(min, that.min)) return false;
        if (!Objects.equals(max, that.max)) return false;
        if (!Objects.equals(sum, that.sum)) return false;
        if (!Objects.equals(average, that.average)) return false;
        if (!Objects.equals(amountOfPositiveElements, that.amountOfPositiveElements))
            return false;
        return Objects.equals(amountOfNegativeElements, that.amountOfNegativeElements);
    }

    @Override
    public int hashCode() {
        int result = min != null ? min.hashCode() : 0;
        result = 31 * result + (max != null ? max.hashCode() : 0);
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        result = 31 * result + (average != null ? average.hashCode() : 0);
        result = 31 * result + (amountOfPositiveElements != null ? amountOfPositiveElements.hashCode() : 0);
        result = 31 * result + (amountOfNegativeElements != null ? amountOfNegativeElements.hashCode() : 0);
        return result;
    }
}
