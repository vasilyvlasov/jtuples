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

public class Product2<T1, T2> extends Product implements Tuple2<T1, T2> {
    private static final long serialVersionUID = -1187955276020306879L;

    private T1 v1;
    private T2 v2;

    @JsonCreator
    public Product2(@JsonProperty("_1") T1 v1, @JsonProperty("_2") T2 v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.arity = 2;
    }

    public Object getElement(int index) {
        switch (index) {
            case 0:
                return v1;
            case 1:
                return v2;
            default:
                throw new IndexOutOfBoundsException("Index is out of range: " + index);
        }
    }

    @JsonProperty("_1")
    public T1 _1() {
        return v1;
    }

    @JsonProperty("_2")
    public T2 _2() {
        return v2;
    }
}