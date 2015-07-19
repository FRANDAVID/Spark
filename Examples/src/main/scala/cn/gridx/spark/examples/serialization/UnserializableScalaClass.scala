package cn.gridx.spark.examples.serialization

import org.apache.hadoop.hbase.util.Bytes

/**
 * Created by tao on 7/16/15.
 */
class UnserializableScalaClass(ms:String, bytes: Array[Byte], n:Int) {
        override
        def toString(): String =
            s"ms=${ms}\nbytes=${Bytes.toStringBinary(bytes)}\nn=${}n}\n"

}
