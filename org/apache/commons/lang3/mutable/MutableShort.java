package org.apache.commons.lang3.mutable;

/* loaded from: classes6.dex */
public class MutableShort extends Number implements Comparable<MutableShort>, Mutable<Number> {
    private static final long serialVersionUID = -2135791679;
    private short value;

    public MutableShort() {
    }

    public MutableShort(short s) {
        this.value = s;
    }

    public MutableShort(Number number) {
        this.value = number.shortValue();
    }

    public MutableShort(String str) throws NumberFormatException {
        this.value = Short.parseShort(str);
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue, reason: avoid collision after fix types in other method */
    public Number getValue2() {
        return new Short(this.value);
    }

    public void setValue(short s) {
        this.value = s;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.shortValue();
    }

    public void increment() {
        this.value = (short) (this.value + 1);
    }

    public void decrement() {
        this.value = (short) (this.value - 1);
    }

    public void add(short s) {
        this.value = (short) (this.value + s);
    }

    public void add(Number number) {
        this.value = (short) (this.value + number.shortValue());
    }

    public void subtract(short s) {
        this.value = (short) (this.value - s);
    }

    public void subtract(Number number) {
        this.value = (short) (this.value - number.shortValue());
    }

    @Override // java.lang.Number
    public short shortValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public Short toShort() {
        return Short.valueOf(shortValue());
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableShort) && this.value == ((MutableShort) obj).shortValue();
    }

    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableShort mutableShort) {
        short s = mutableShort.value;
        short s2 = this.value;
        if (s2 < s) {
            return -1;
        }
        return s2 == s ? 0 : 1;
    }

    public String toString() {
        return String.valueOf((int) this.value);
    }
}
