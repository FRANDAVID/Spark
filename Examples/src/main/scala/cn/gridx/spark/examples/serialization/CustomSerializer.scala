package cn.gridx.spark.examples.serialization

import com.esotericsoftware.kryo.Kryo
import org.apache.spark.serializer.KryoRegistrator

/**
 * Created by tao on 7/7/15.
 */
class CustomSerializer extends KryoRegistrator{
    def registerClasses(kryo: Kryo): Unit = {
      //  kryo.register(classOf[ImmutableBytesWritable])
      //  kryo.register(classOf[com.sematext.hbase.wd.RowKeyDistributorByHashPrefix])
        kryo.register(classOf[UnserializableJavaClass])
    }
}
