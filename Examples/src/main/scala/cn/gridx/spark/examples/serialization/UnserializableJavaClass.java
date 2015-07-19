package cn.gridx.spark.examples.serialization;

import org.apache.hadoop.hbase.util.Bytes;

/**
 * Created by tao on 7/8/15.
 */
public class UnserializableJavaClass  {
    public String ms;
    public byte[] bytes;
    public int n;

    public UnserializableJavaClass() {
        ms = "Uninitialized String";
        bytes = null;
        n = 0;
    }

    public UnserializableJavaClass(String s, byte[] bytes, int n) {
        ms = s;
        this.bytes = bytes.clone();
        this.n = n;
    }

    public String getMs() {
        return this.ms ;
    }

    public byte[] getBytes() { return this.bytes; }

    public int getInt() { return this.n ; }

    public String toString() { return "ms=" + ms + "\nbytes=" + Bytes.toStringBinary(bytes) + "\nn=" + n + "\n"; }

    public void setInt(int n) { this.n = n; }
}
