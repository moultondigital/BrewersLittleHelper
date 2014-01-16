package org.blh.core.units;

import java.util.Objects;

/**
 *
 * @author thinner
 */
public abstract class Unit<T> {

    private final T value;

    public Unit(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.value);
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

        @SuppressWarnings("unchecked")
        final Unit<T> other = (Unit<T>) obj;
        return Objects.equals(this.value, other.value);
    }

    @Override
    public String toString() {
        if(this.value == null) {
            return "NULL";
        }

        return this.value.toString();
    }


}