package com.othelle.jtuples;

/*
 * =============================================================================
 *
 *   Copyright 2013, JTuples team
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

/*
 * =============================================================================
 *   GENERATED CODE DO NOT EDIT
 * =============================================================================
 */


import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Product1<T1> extends Product implements Tuple1<T1> {
    private static final long serialVersionUID = -1187955276020306879L;

    private T1 v1;

    @JsonCreator
    public Product1(@JsonProperty("_1") T1 v1) {
        this.v1 = v1;
        this.arity = 1;
    }

    public Object getElement(int index) {
        switch (index) {
            case 0:
                return v1;
            default:
                throw new IndexOutOfBoundsException("Index is out of range: " + index);
        }
    }

    @JsonProperty("_1")
    public T1 _1() {
        return v1;
    }
}