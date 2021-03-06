package com.othelle.jtuples;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;

import static com.othelle.jtuples.Tuples.convert;
import static com.othelle.jtuples.Tuples.tuple;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * author: v.vlasov
 */
public class TuplesTest {

    @Test
    public void testTuple() {
        Tuple1<Integer> tuple1 = tuple(1);
        Tuple2<Integer, Integer> tuple2 = tuple(1, 2);
        Tuple3<Integer, Integer, Integer> tuple3 = tuple(1, 2, 3);

        assertThat(tuple1._1(), equalTo(1));

        assertThat(tuple2._1(), equalTo(1));
        assertThat(tuple2._2(), equalTo(2));

        assertThat(tuple3._1(), equalTo(1));
        assertThat(tuple3._2(), equalTo(2));
        assertThat(tuple3._3(), equalTo(3));
    }

    @Test
    public void testTupleForNulls() {
        Tuple1<Object> tuple1 = tuple(null);
        Tuple2<Integer, Object> tuple2 = tuple(1, null);

        assertThat(tuple1._1(), Matchers.nullValue());

        assertThat(tuple2._1(), equalTo(1));
        assertThat(tuple2._2(), Matchers.nullValue());
    }

    @Test
    public void testConvert() {
        Tuple tuple = convert(Arrays.asList("1", "2", "3"));
        assertThat(tuple, equalTo((Object) tuple("1", "2", "3")));

        tuple = convert(new String[]{"1", "2", "3"});
        assertThat(tuple, equalTo((Object) tuple("1", "2", "3")));

        //the number of items to use from a collection or array can be specified
        tuple = convert(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "1", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"});
        assertThat(tuple, equalTo((Object) tuple("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16")));
    }

}
