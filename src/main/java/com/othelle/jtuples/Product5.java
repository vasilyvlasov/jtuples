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
public class Product5<T1, T2, T3, T4, T5> extends Product implements Tuple5<T1, T2, T3, T4, T5>{
    private static final long serialVersionUID = -1187955276020306879L;

    private T1 v1;
    private T2 v2;
    private T3 v3;
    private T4 v4;
    private T5 v5;

    public Product5(T1 v1, T2 v2, T3 v3, T4 v4, T5 v5){
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
        this.v5 = v5;
        this.arity = 5;
    }

    public Object getElement(int index){
        switch(index){
            case 0:
                return v1;
            case 1:
                return v2;
            case 2:
                return v3;
            case 3:
                return v4;
            case 4:
                return v5;
            default:
                throw new IndexOutOfBoundsException("Index is out of range: " + index);
        }
    }
    public T1 _1() {
        return v1;
    }

    public T2 _2() {
        return v2;
    }

    public T3 _3() {
        return v3;
    }

    public T4 _4() {
        return v4;
    }

    public T5 _5() {
        return v5;
    }}