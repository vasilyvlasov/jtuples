/*
 * =============================================================================
 *
 *   Copyright 2013, JTuples
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */

package com.othelle.jtuples;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * author: v.vlasov
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public abstract class Product implements Tuple, Iterable, Serializable {
    public static final int[] primes = {17, 31, 47, 67, 83, 103, 127, 149, 167, 191, 23, 41, 59, 73, 97, 109, 137, 157, 179, 197, 151};
    @JsonIgnore
    protected int arity;

    public abstract Object getElement(int index);

    public Iterator iterator() {
        return new ProductIterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tuple) {
            Product candidate = (Product) obj;
            if (candidate.arity != arity) return false; //for now it's inappropriate to compare two products with different arity.

            Iterator iterator1 = iterator();
            Iterator iterator2 = candidate.iterator();

            while (iterator1.hasNext()) {
                Object element1 = iterator1.next();
                Object element2 = iterator2.next();

                if (!Product.equals(element1, element2)) return false;
            }

            return true;
        } else return false;
    }

    @Override
    public int hashCode() {
        int hash = 0;

        int numbersCount = 0;

        for (Object o : this) {
            if (o instanceof Number) {
                //BigDecimal has a good hash function however we assume it's a rare when it's used
                hash ^= o.hashCode() * primes[numbersCount];
                numbersCount++;
            } else if (o != null) hash ^= o.hashCode();
        }

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder().append('(');

        boolean firstIndex = true;

        for (Object o : this) {
            if (firstIndex)
                firstIndex = !firstIndex;
            else
                builder.append(',');

            builder.append(o);
        }

        return builder.append(')').toString();
    }

    private class ProductIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < arity;
        }

        @Override
        public Object next() {
            Object element = getElement(index);
            index++;
            return element;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported");
        }
    }

    public static boolean equals(Object object1, Object object2) {
        return object1 == object2 || !((object1 == null) || (object2 == null)) && object1.equals(object2);
    }

    public int getArity() {
        return arity;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[getArity()];

        for (int i = 0; i < result.length; i++)
            result[i] = getElement(i);
        return result;

    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(Class<T> clazz) {
        T[] result = (T[]) java.lang.reflect.Array.newInstance(clazz, getArity());

        for (int i = 0; i < result.length; i++)
            result[i] = (T) getElement(i);
        return result;
    }

    @Override
    public List toList() {
        return toList(Object.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> toList(Class<T> clazz) {
        ArrayList<T> list = new ArrayList<T>(getArity());
        for (Object o : this)
            list.add((T) o);
        return list;
    }
}
