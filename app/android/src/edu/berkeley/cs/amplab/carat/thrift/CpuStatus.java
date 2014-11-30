/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package edu.berkeley.cs.amplab.carat.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;

//import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.annotation.SuppressLint;

@SuppressLint("NewApi")
@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
//@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2014-11-30")
public class CpuStatus implements org.apache.thrift.TBase<CpuStatus, CpuStatus._Fields>, java.io.Serializable, Cloneable, Comparable<CpuStatus> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CpuStatus");

  private static final org.apache.thrift.protocol.TField CPU_USAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("cpuUsage", org.apache.thrift.protocol.TType.DOUBLE, (short)1);
  private static final org.apache.thrift.protocol.TField UPTIME_FIELD_DESC = new org.apache.thrift.protocol.TField("uptime", org.apache.thrift.protocol.TType.DOUBLE, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CpuStatusStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CpuStatusTupleSchemeFactory());
  }

  public double cpuUsage; // optional
  public double uptime; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CPU_USAGE((short)1, "cpuUsage"),
    UPTIME((short)2, "uptime");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // CPU_USAGE
          return CPU_USAGE;
        case 2: // UPTIME
          return UPTIME;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __CPUUSAGE_ISSET_ID = 0;
  private static final int __UPTIME_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.CPU_USAGE,_Fields.UPTIME};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CPU_USAGE, new org.apache.thrift.meta_data.FieldMetaData("cpuUsage", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.UPTIME, new org.apache.thrift.meta_data.FieldMetaData("uptime", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CpuStatus.class, metaDataMap);
  }

  public CpuStatus() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CpuStatus(CpuStatus other) {
    __isset_bitfield = other.__isset_bitfield;
    this.cpuUsage = other.cpuUsage;
    this.uptime = other.uptime;
  }

  public CpuStatus deepCopy() {
    return new CpuStatus(this);
  }

  @Override
  public void clear() {
    setCpuUsageIsSet(false);
    this.cpuUsage = 0.0;
    setUptimeIsSet(false);
    this.uptime = 0.0;
  }

  public double getCpuUsage() {
    return this.cpuUsage;
  }

  public CpuStatus setCpuUsage(double cpuUsage) {
    this.cpuUsage = cpuUsage;
    setCpuUsageIsSet(true);
    return this;
  }

  public void unsetCpuUsage() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CPUUSAGE_ISSET_ID);
  }

  /** Returns true if field cpuUsage is set (has been assigned a value) and false otherwise */
  public boolean isSetCpuUsage() {
    return EncodingUtils.testBit(__isset_bitfield, __CPUUSAGE_ISSET_ID);
  }

  public void setCpuUsageIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CPUUSAGE_ISSET_ID, value);
  }

  public double getUptime() {
    return this.uptime;
  }

  public CpuStatus setUptime(double uptime) {
    this.uptime = uptime;
    setUptimeIsSet(true);
    return this;
  }

  public void unsetUptime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __UPTIME_ISSET_ID);
  }

  /** Returns true if field uptime is set (has been assigned a value) and false otherwise */
  public boolean isSetUptime() {
    return EncodingUtils.testBit(__isset_bitfield, __UPTIME_ISSET_ID);
  }

  public void setUptimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __UPTIME_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CPU_USAGE:
      if (value == null) {
        unsetCpuUsage();
      } else {
        setCpuUsage((Double)value);
      }
      break;

    case UPTIME:
      if (value == null) {
        unsetUptime();
      } else {
        setUptime((Double)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CPU_USAGE:
      return Double.valueOf(getCpuUsage());

    case UPTIME:
      return Double.valueOf(getUptime());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CPU_USAGE:
      return isSetCpuUsage();
    case UPTIME:
      return isSetUptime();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CpuStatus)
      return this.equals((CpuStatus)that);
    return false;
  }

  public boolean equals(CpuStatus that) {
    if (that == null)
      return false;

    boolean this_present_cpuUsage = true && this.isSetCpuUsage();
    boolean that_present_cpuUsage = true && that.isSetCpuUsage();
    if (this_present_cpuUsage || that_present_cpuUsage) {
      if (!(this_present_cpuUsage && that_present_cpuUsage))
        return false;
      if (this.cpuUsage != that.cpuUsage)
        return false;
    }

    boolean this_present_uptime = true && this.isSetUptime();
    boolean that_present_uptime = true && that.isSetUptime();
    if (this_present_uptime || that_present_uptime) {
      if (!(this_present_uptime && that_present_uptime))
        return false;
      if (this.uptime != that.uptime)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_cpuUsage = true && (isSetCpuUsage());
    list.add(present_cpuUsage);
    if (present_cpuUsage)
      list.add(cpuUsage);

    boolean present_uptime = true && (isSetUptime());
    list.add(present_uptime);
    if (present_uptime)
      list.add(uptime);

    return list.hashCode();
  }

  @Override
  public int compareTo(CpuStatus other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCpuUsage()).compareTo(other.isSetCpuUsage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCpuUsage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cpuUsage, other.cpuUsage);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUptime()).compareTo(other.isSetUptime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUptime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.uptime, other.uptime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CpuStatus(");
    boolean first = true;

    if (isSetCpuUsage()) {
      sb.append("cpuUsage:");
      sb.append(this.cpuUsage);
      first = false;
    }
    if (isSetUptime()) {
      if (!first) sb.append(", ");
      sb.append("uptime:");
      sb.append(this.uptime);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CpuStatusStandardSchemeFactory implements SchemeFactory {
    public CpuStatusStandardScheme getScheme() {
      return new CpuStatusStandardScheme();
    }
  }

  private static class CpuStatusStandardScheme extends StandardScheme<CpuStatus> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CpuStatus struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CPU_USAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.cpuUsage = iprot.readDouble();
              struct.setCpuUsageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // UPTIME
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.uptime = iprot.readDouble();
              struct.setUptimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, CpuStatus struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetCpuUsage()) {
        oprot.writeFieldBegin(CPU_USAGE_FIELD_DESC);
        oprot.writeDouble(struct.cpuUsage);
        oprot.writeFieldEnd();
      }
      if (struct.isSetUptime()) {
        oprot.writeFieldBegin(UPTIME_FIELD_DESC);
        oprot.writeDouble(struct.uptime);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CpuStatusTupleSchemeFactory implements SchemeFactory {
    public CpuStatusTupleScheme getScheme() {
      return new CpuStatusTupleScheme();
    }
  }

  private static class CpuStatusTupleScheme extends TupleScheme<CpuStatus> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CpuStatus struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetCpuUsage()) {
        optionals.set(0);
      }
      if (struct.isSetUptime()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetCpuUsage()) {
        oprot.writeDouble(struct.cpuUsage);
      }
      if (struct.isSetUptime()) {
        oprot.writeDouble(struct.uptime);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CpuStatus struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.cpuUsage = iprot.readDouble();
        struct.setCpuUsageIsSet(true);
      }
      if (incoming.get(1)) {
        struct.uptime = iprot.readDouble();
        struct.setUptimeIsSet(true);
      }
    }
  }

}

