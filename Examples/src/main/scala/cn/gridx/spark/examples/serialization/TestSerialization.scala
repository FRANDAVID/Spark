package cn.gridx.spark.examples.serialization

import org.apache.hadoop.hbase.util.Bytes
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.SparkContext._

/**
 * Created by tao on 7/16/15.
 */
object TestSerialization {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("Test Serialization")
        val sc = new SparkContext(conf)

        val rdd = sc.parallelize(1 to 10000, 4)

        rdd.map(i => new UnserializableJavaClass("I'm `UnserializableJavaClass`", Bytes.toBytes("Hello `UnserializableJavaClass`"), i))
            .map(x => (x.n, x))
            .coalesce(100, true)
            .reduceByKey((a, b) => new UnserializableJavaClass("After", Bytes.toBytes("`reduceByKey`"), a.n + b.n))
            .collect
            .foreach(x => {Thread.sleep(2000); println(x)})

        sc.stop
    }
}
