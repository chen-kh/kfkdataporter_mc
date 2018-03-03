/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package act.nsfc.kfkDataPorterMC.thrift;

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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-08-30")
public class ThriftObdDs implements org.apache.thrift.TBase<ThriftObdDs, ThriftObdDs._Fields>, java.io.Serializable, Cloneable, Comparable<ThriftObdDs> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ThriftObdDs");

  private static final org.apache.thrift.protocol.TField SN_FIELD_DESC = new org.apache.thrift.protocol.TField("sn", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField GPSTIME_FIELD_DESC = new org.apache.thrift.protocol.TField("gpstime", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField TOTAL_FUEL_FIELD_DESC = new org.apache.thrift.protocol.TField("totalFuel", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField TOTAL_MILEAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("totalMileage", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField MILEAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("mileage", org.apache.thrift.protocol.TType.DOUBLE, (short)5);
  private static final org.apache.thrift.protocol.TField SPEED_FIELD_DESC = new org.apache.thrift.protocol.TField("speed", org.apache.thrift.protocol.TType.DOUBLE, (short)6);
  private static final org.apache.thrift.protocol.TField ENGINE_SPEED_FIELD_DESC = new org.apache.thrift.protocol.TField("engineSpeed", org.apache.thrift.protocol.TType.DOUBLE, (short)7);
  private static final org.apache.thrift.protocol.TField VIN_FIELD_DESC = new org.apache.thrift.protocol.TField("vin", org.apache.thrift.protocol.TType.STRING, (short)8);
  private static final org.apache.thrift.protocol.TField RES_FIELD_DESC = new org.apache.thrift.protocol.TField("res", org.apache.thrift.protocol.TType.STRING, (short)9);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ThriftObdDsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ThriftObdDsTupleSchemeFactory());
  }

  public String sn; // required
  public long gpstime; // required
  public double totalFuel; // optional
  public double totalMileage; // optional
  public double mileage; // optional
  public double speed; // optional
  public double engineSpeed; // optional
  public String vin; // optional
  public String res; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SN((short)1, "sn"),
    GPSTIME((short)2, "gpstime"),
    TOTAL_FUEL((short)3, "totalFuel"),
    TOTAL_MILEAGE((short)4, "totalMileage"),
    MILEAGE((short)5, "mileage"),
    SPEED((short)6, "speed"),
    ENGINE_SPEED((short)7, "engineSpeed"),
    VIN((short)8, "vin"),
    RES((short)9, "res");

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
        case 1: // SN
          return SN;
        case 2: // GPSTIME
          return GPSTIME;
        case 3: // TOTAL_FUEL
          return TOTAL_FUEL;
        case 4: // TOTAL_MILEAGE
          return TOTAL_MILEAGE;
        case 5: // MILEAGE
          return MILEAGE;
        case 6: // SPEED
          return SPEED;
        case 7: // ENGINE_SPEED
          return ENGINE_SPEED;
        case 8: // VIN
          return VIN;
        case 9: // RES
          return RES;
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
  private static final int __GPSTIME_ISSET_ID = 0;
  private static final int __TOTALFUEL_ISSET_ID = 1;
  private static final int __TOTALMILEAGE_ISSET_ID = 2;
  private static final int __MILEAGE_ISSET_ID = 3;
  private static final int __SPEED_ISSET_ID = 4;
  private static final int __ENGINESPEED_ISSET_ID = 5;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TOTAL_FUEL,_Fields.TOTAL_MILEAGE,_Fields.MILEAGE,_Fields.SPEED,_Fields.ENGINE_SPEED,_Fields.VIN,_Fields.RES};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SN, new org.apache.thrift.meta_data.FieldMetaData("sn", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.GPSTIME, new org.apache.thrift.meta_data.FieldMetaData("gpstime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TOTAL_FUEL, new org.apache.thrift.meta_data.FieldMetaData("totalFuel", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.TOTAL_MILEAGE, new org.apache.thrift.meta_data.FieldMetaData("totalMileage", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.MILEAGE, new org.apache.thrift.meta_data.FieldMetaData("mileage", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.SPEED, new org.apache.thrift.meta_data.FieldMetaData("speed", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.ENGINE_SPEED, new org.apache.thrift.meta_data.FieldMetaData("engineSpeed", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.VIN, new org.apache.thrift.meta_data.FieldMetaData("vin", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.RES, new org.apache.thrift.meta_data.FieldMetaData("res", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ThriftObdDs.class, metaDataMap);
  }

  public ThriftObdDs() {
  }

  public ThriftObdDs(
    String sn,
    long gpstime)
  {
    this();
    this.sn = sn;
    this.gpstime = gpstime;
    setGpstimeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftObdDs(ThriftObdDs other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetSn()) {
      this.sn = other.sn;
    }
    this.gpstime = other.gpstime;
    this.totalFuel = other.totalFuel;
    this.totalMileage = other.totalMileage;
    this.mileage = other.mileage;
    this.speed = other.speed;
    this.engineSpeed = other.engineSpeed;
    if (other.isSetVin()) {
      this.vin = other.vin;
    }
    if (other.isSetRes()) {
      this.res = other.res;
    }
  }

  public ThriftObdDs deepCopy() {
    return new ThriftObdDs(this);
  }

  @Override
  public void clear() {
    this.sn = null;
    setGpstimeIsSet(false);
    this.gpstime = 0;
    setTotalFuelIsSet(false);
    this.totalFuel = 0.0;
    setTotalMileageIsSet(false);
    this.totalMileage = 0.0;
    setMileageIsSet(false);
    this.mileage = 0.0;
    setSpeedIsSet(false);
    this.speed = 0.0;
    setEngineSpeedIsSet(false);
    this.engineSpeed = 0.0;
    this.vin = null;
    this.res = null;
  }

  public String getSn() {
    return this.sn;
  }

  public ThriftObdDs setSn(String sn) {
    this.sn = sn;
    return this;
  }

  public void unsetSn() {
    this.sn = null;
  }

  /** Returns true if field sn is set (has been assigned a value) and false otherwise */
  public boolean isSetSn() {
    return this.sn != null;
  }

  public void setSnIsSet(boolean value) {
    if (!value) {
      this.sn = null;
    }
  }

  public long getGpstime() {
    return this.gpstime;
  }

  public ThriftObdDs setGpstime(long gpstime) {
    this.gpstime = gpstime;
    setGpstimeIsSet(true);
    return this;
  }

  public void unsetGpstime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __GPSTIME_ISSET_ID);
  }

  /** Returns true if field gpstime is set (has been assigned a value) and false otherwise */
  public boolean isSetGpstime() {
    return EncodingUtils.testBit(__isset_bitfield, __GPSTIME_ISSET_ID);
  }

  public void setGpstimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __GPSTIME_ISSET_ID, value);
  }

  public double getTotalFuel() {
    return this.totalFuel;
  }

  public ThriftObdDs setTotalFuel(double totalFuel) {
    this.totalFuel = totalFuel;
    setTotalFuelIsSet(true);
    return this;
  }

  public void unsetTotalFuel() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TOTALFUEL_ISSET_ID);
  }

  /** Returns true if field totalFuel is set (has been assigned a value) and false otherwise */
  public boolean isSetTotalFuel() {
    return EncodingUtils.testBit(__isset_bitfield, __TOTALFUEL_ISSET_ID);
  }

  public void setTotalFuelIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TOTALFUEL_ISSET_ID, value);
  }

  public double getTotalMileage() {
    return this.totalMileage;
  }

  public ThriftObdDs setTotalMileage(double totalMileage) {
    this.totalMileage = totalMileage;
    setTotalMileageIsSet(true);
    return this;
  }

  public void unsetTotalMileage() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TOTALMILEAGE_ISSET_ID);
  }

  /** Returns true if field totalMileage is set (has been assigned a value) and false otherwise */
  public boolean isSetTotalMileage() {
    return EncodingUtils.testBit(__isset_bitfield, __TOTALMILEAGE_ISSET_ID);
  }

  public void setTotalMileageIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TOTALMILEAGE_ISSET_ID, value);
  }

  public double getMileage() {
    return this.mileage;
  }

  public ThriftObdDs setMileage(double mileage) {
    this.mileage = mileage;
    setMileageIsSet(true);
    return this;
  }

  public void unsetMileage() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MILEAGE_ISSET_ID);
  }

  /** Returns true if field mileage is set (has been assigned a value) and false otherwise */
  public boolean isSetMileage() {
    return EncodingUtils.testBit(__isset_bitfield, __MILEAGE_ISSET_ID);
  }

  public void setMileageIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MILEAGE_ISSET_ID, value);
  }

  public double getSpeed() {
    return this.speed;
  }

  public ThriftObdDs setSpeed(double speed) {
    this.speed = speed;
    setSpeedIsSet(true);
    return this;
  }

  public void unsetSpeed() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SPEED_ISSET_ID);
  }

  /** Returns true if field speed is set (has been assigned a value) and false otherwise */
  public boolean isSetSpeed() {
    return EncodingUtils.testBit(__isset_bitfield, __SPEED_ISSET_ID);
  }

  public void setSpeedIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SPEED_ISSET_ID, value);
  }

  public double getEngineSpeed() {
    return this.engineSpeed;
  }

  public ThriftObdDs setEngineSpeed(double engineSpeed) {
    this.engineSpeed = engineSpeed;
    setEngineSpeedIsSet(true);
    return this;
  }

  public void unsetEngineSpeed() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ENGINESPEED_ISSET_ID);
  }

  /** Returns true if field engineSpeed is set (has been assigned a value) and false otherwise */
  public boolean isSetEngineSpeed() {
    return EncodingUtils.testBit(__isset_bitfield, __ENGINESPEED_ISSET_ID);
  }

  public void setEngineSpeedIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ENGINESPEED_ISSET_ID, value);
  }

  public String getVin() {
    return this.vin;
  }

  public ThriftObdDs setVin(String vin) {
    this.vin = vin;
    return this;
  }

  public void unsetVin() {
    this.vin = null;
  }

  /** Returns true if field vin is set (has been assigned a value) and false otherwise */
  public boolean isSetVin() {
    return this.vin != null;
  }

  public void setVinIsSet(boolean value) {
    if (!value) {
      this.vin = null;
    }
  }

  public String getRes() {
    return this.res;
  }

  public ThriftObdDs setRes(String res) {
    this.res = res;
    return this;
  }

  public void unsetRes() {
    this.res = null;
  }

  /** Returns true if field res is set (has been assigned a value) and false otherwise */
  public boolean isSetRes() {
    return this.res != null;
  }

  public void setResIsSet(boolean value) {
    if (!value) {
      this.res = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SN:
      if (value == null) {
        unsetSn();
      } else {
        setSn((String)value);
      }
      break;

    case GPSTIME:
      if (value == null) {
        unsetGpstime();
      } else {
        setGpstime((Long)value);
      }
      break;

    case TOTAL_FUEL:
      if (value == null) {
        unsetTotalFuel();
      } else {
        setTotalFuel((Double)value);
      }
      break;

    case TOTAL_MILEAGE:
      if (value == null) {
        unsetTotalMileage();
      } else {
        setTotalMileage((Double)value);
      }
      break;

    case MILEAGE:
      if (value == null) {
        unsetMileage();
      } else {
        setMileage((Double)value);
      }
      break;

    case SPEED:
      if (value == null) {
        unsetSpeed();
      } else {
        setSpeed((Double)value);
      }
      break;

    case ENGINE_SPEED:
      if (value == null) {
        unsetEngineSpeed();
      } else {
        setEngineSpeed((Double)value);
      }
      break;

    case VIN:
      if (value == null) {
        unsetVin();
      } else {
        setVin((String)value);
      }
      break;

    case RES:
      if (value == null) {
        unsetRes();
      } else {
        setRes((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SN:
      return getSn();

    case GPSTIME:
      return getGpstime();

    case TOTAL_FUEL:
      return getTotalFuel();

    case TOTAL_MILEAGE:
      return getTotalMileage();

    case MILEAGE:
      return getMileage();

    case SPEED:
      return getSpeed();

    case ENGINE_SPEED:
      return getEngineSpeed();

    case VIN:
      return getVin();

    case RES:
      return getRes();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SN:
      return isSetSn();
    case GPSTIME:
      return isSetGpstime();
    case TOTAL_FUEL:
      return isSetTotalFuel();
    case TOTAL_MILEAGE:
      return isSetTotalMileage();
    case MILEAGE:
      return isSetMileage();
    case SPEED:
      return isSetSpeed();
    case ENGINE_SPEED:
      return isSetEngineSpeed();
    case VIN:
      return isSetVin();
    case RES:
      return isSetRes();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftObdDs)
      return this.equals((ThriftObdDs)that);
    return false;
  }

  public boolean equals(ThriftObdDs that) {
    if (that == null)
      return false;

    boolean this_present_sn = true && this.isSetSn();
    boolean that_present_sn = true && that.isSetSn();
    if (this_present_sn || that_present_sn) {
      if (!(this_present_sn && that_present_sn))
        return false;
      if (!this.sn.equals(that.sn))
        return false;
    }

    boolean this_present_gpstime = true;
    boolean that_present_gpstime = true;
    if (this_present_gpstime || that_present_gpstime) {
      if (!(this_present_gpstime && that_present_gpstime))
        return false;
      if (this.gpstime != that.gpstime)
        return false;
    }

    boolean this_present_totalFuel = true && this.isSetTotalFuel();
    boolean that_present_totalFuel = true && that.isSetTotalFuel();
    if (this_present_totalFuel || that_present_totalFuel) {
      if (!(this_present_totalFuel && that_present_totalFuel))
        return false;
      if (this.totalFuel != that.totalFuel)
        return false;
    }

    boolean this_present_totalMileage = true && this.isSetTotalMileage();
    boolean that_present_totalMileage = true && that.isSetTotalMileage();
    if (this_present_totalMileage || that_present_totalMileage) {
      if (!(this_present_totalMileage && that_present_totalMileage))
        return false;
      if (this.totalMileage != that.totalMileage)
        return false;
    }

    boolean this_present_mileage = true && this.isSetMileage();
    boolean that_present_mileage = true && that.isSetMileage();
    if (this_present_mileage || that_present_mileage) {
      if (!(this_present_mileage && that_present_mileage))
        return false;
      if (this.mileage != that.mileage)
        return false;
    }

    boolean this_present_speed = true && this.isSetSpeed();
    boolean that_present_speed = true && that.isSetSpeed();
    if (this_present_speed || that_present_speed) {
      if (!(this_present_speed && that_present_speed))
        return false;
      if (this.speed != that.speed)
        return false;
    }

    boolean this_present_engineSpeed = true && this.isSetEngineSpeed();
    boolean that_present_engineSpeed = true && that.isSetEngineSpeed();
    if (this_present_engineSpeed || that_present_engineSpeed) {
      if (!(this_present_engineSpeed && that_present_engineSpeed))
        return false;
      if (this.engineSpeed != that.engineSpeed)
        return false;
    }

    boolean this_present_vin = true && this.isSetVin();
    boolean that_present_vin = true && that.isSetVin();
    if (this_present_vin || that_present_vin) {
      if (!(this_present_vin && that_present_vin))
        return false;
      if (!this.vin.equals(that.vin))
        return false;
    }

    boolean this_present_res = true && this.isSetRes();
    boolean that_present_res = true && that.isSetRes();
    if (this_present_res || that_present_res) {
      if (!(this_present_res && that_present_res))
        return false;
      if (!this.res.equals(that.res))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_sn = true && (isSetSn());
    list.add(present_sn);
    if (present_sn)
      list.add(sn);

    boolean present_gpstime = true;
    list.add(present_gpstime);
    if (present_gpstime)
      list.add(gpstime);

    boolean present_totalFuel = true && (isSetTotalFuel());
    list.add(present_totalFuel);
    if (present_totalFuel)
      list.add(totalFuel);

    boolean present_totalMileage = true && (isSetTotalMileage());
    list.add(present_totalMileage);
    if (present_totalMileage)
      list.add(totalMileage);

    boolean present_mileage = true && (isSetMileage());
    list.add(present_mileage);
    if (present_mileage)
      list.add(mileage);

    boolean present_speed = true && (isSetSpeed());
    list.add(present_speed);
    if (present_speed)
      list.add(speed);

    boolean present_engineSpeed = true && (isSetEngineSpeed());
    list.add(present_engineSpeed);
    if (present_engineSpeed)
      list.add(engineSpeed);

    boolean present_vin = true && (isSetVin());
    list.add(present_vin);
    if (present_vin)
      list.add(vin);

    boolean present_res = true && (isSetRes());
    list.add(present_res);
    if (present_res)
      list.add(res);

    return list.hashCode();
  }

  @Override
  public int compareTo(ThriftObdDs other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSn()).compareTo(other.isSetSn());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSn()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sn, other.sn);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGpstime()).compareTo(other.isSetGpstime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGpstime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.gpstime, other.gpstime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTotalFuel()).compareTo(other.isSetTotalFuel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotalFuel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalFuel, other.totalFuel);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTotalMileage()).compareTo(other.isSetTotalMileage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotalMileage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalMileage, other.totalMileage);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMileage()).compareTo(other.isSetMileage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMileage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mileage, other.mileage);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSpeed()).compareTo(other.isSetSpeed());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSpeed()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.speed, other.speed);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEngineSpeed()).compareTo(other.isSetEngineSpeed());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEngineSpeed()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.engineSpeed, other.engineSpeed);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetVin()).compareTo(other.isSetVin());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVin()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.vin, other.vin);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRes()).compareTo(other.isSetRes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.res, other.res);
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
    StringBuilder sb = new StringBuilder("ThriftObdDs(");
    boolean first = true;

    sb.append("sn:");
    if (this.sn == null) {
      sb.append("null");
    } else {
      sb.append(this.sn);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("gpstime:");
    sb.append(this.gpstime);
    first = false;
    if (isSetTotalFuel()) {
      if (!first) sb.append(", ");
      sb.append("totalFuel:");
      sb.append(this.totalFuel);
      first = false;
    }
    if (isSetTotalMileage()) {
      if (!first) sb.append(", ");
      sb.append("totalMileage:");
      sb.append(this.totalMileage);
      first = false;
    }
    if (isSetMileage()) {
      if (!first) sb.append(", ");
      sb.append("mileage:");
      sb.append(this.mileage);
      first = false;
    }
    if (isSetSpeed()) {
      if (!first) sb.append(", ");
      sb.append("speed:");
      sb.append(this.speed);
      first = false;
    }
    if (isSetEngineSpeed()) {
      if (!first) sb.append(", ");
      sb.append("engineSpeed:");
      sb.append(this.engineSpeed);
      first = false;
    }
    if (isSetVin()) {
      if (!first) sb.append(", ");
      sb.append("vin:");
      if (this.vin == null) {
        sb.append("null");
      } else {
        sb.append(this.vin);
      }
      first = false;
    }
    if (isSetRes()) {
      if (!first) sb.append(", ");
      sb.append("res:");
      if (this.res == null) {
        sb.append("null");
      } else {
        sb.append(this.res);
      }
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

  private static class ThriftObdDsStandardSchemeFactory implements SchemeFactory {
    public ThriftObdDsStandardScheme getScheme() {
      return new ThriftObdDsStandardScheme();
    }
  }

  private static class ThriftObdDsStandardScheme extends StandardScheme<ThriftObdDs> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ThriftObdDs struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sn = iprot.readString();
              struct.setSnIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // GPSTIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.gpstime = iprot.readI64();
              struct.setGpstimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TOTAL_FUEL
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.totalFuel = iprot.readDouble();
              struct.setTotalFuelIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TOTAL_MILEAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.totalMileage = iprot.readDouble();
              struct.setTotalMileageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // MILEAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.mileage = iprot.readDouble();
              struct.setMileageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // SPEED
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.speed = iprot.readDouble();
              struct.setSpeedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // ENGINE_SPEED
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.engineSpeed = iprot.readDouble();
              struct.setEngineSpeedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // VIN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.vin = iprot.readString();
              struct.setVinIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 9: // RES
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.res = iprot.readString();
              struct.setResIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ThriftObdDs struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sn != null) {
        oprot.writeFieldBegin(SN_FIELD_DESC);
        oprot.writeString(struct.sn);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(GPSTIME_FIELD_DESC);
      oprot.writeI64(struct.gpstime);
      oprot.writeFieldEnd();
      if (struct.isSetTotalFuel()) {
        oprot.writeFieldBegin(TOTAL_FUEL_FIELD_DESC);
        oprot.writeDouble(struct.totalFuel);
        oprot.writeFieldEnd();
      }
      if (struct.isSetTotalMileage()) {
        oprot.writeFieldBegin(TOTAL_MILEAGE_FIELD_DESC);
        oprot.writeDouble(struct.totalMileage);
        oprot.writeFieldEnd();
      }
      if (struct.isSetMileage()) {
        oprot.writeFieldBegin(MILEAGE_FIELD_DESC);
        oprot.writeDouble(struct.mileage);
        oprot.writeFieldEnd();
      }
      if (struct.isSetSpeed()) {
        oprot.writeFieldBegin(SPEED_FIELD_DESC);
        oprot.writeDouble(struct.speed);
        oprot.writeFieldEnd();
      }
      if (struct.isSetEngineSpeed()) {
        oprot.writeFieldBegin(ENGINE_SPEED_FIELD_DESC);
        oprot.writeDouble(struct.engineSpeed);
        oprot.writeFieldEnd();
      }
      if (struct.vin != null) {
        if (struct.isSetVin()) {
          oprot.writeFieldBegin(VIN_FIELD_DESC);
          oprot.writeString(struct.vin);
          oprot.writeFieldEnd();
        }
      }
      if (struct.res != null) {
        if (struct.isSetRes()) {
          oprot.writeFieldBegin(RES_FIELD_DESC);
          oprot.writeString(struct.res);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ThriftObdDsTupleSchemeFactory implements SchemeFactory {
    public ThriftObdDsTupleScheme getScheme() {
      return new ThriftObdDsTupleScheme();
    }
  }

  private static class ThriftObdDsTupleScheme extends TupleScheme<ThriftObdDs> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ThriftObdDs struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSn()) {
        optionals.set(0);
      }
      if (struct.isSetGpstime()) {
        optionals.set(1);
      }
      if (struct.isSetTotalFuel()) {
        optionals.set(2);
      }
      if (struct.isSetTotalMileage()) {
        optionals.set(3);
      }
      if (struct.isSetMileage()) {
        optionals.set(4);
      }
      if (struct.isSetSpeed()) {
        optionals.set(5);
      }
      if (struct.isSetEngineSpeed()) {
        optionals.set(6);
      }
      if (struct.isSetVin()) {
        optionals.set(7);
      }
      if (struct.isSetRes()) {
        optionals.set(8);
      }
      oprot.writeBitSet(optionals, 9);
      if (struct.isSetSn()) {
        oprot.writeString(struct.sn);
      }
      if (struct.isSetGpstime()) {
        oprot.writeI64(struct.gpstime);
      }
      if (struct.isSetTotalFuel()) {
        oprot.writeDouble(struct.totalFuel);
      }
      if (struct.isSetTotalMileage()) {
        oprot.writeDouble(struct.totalMileage);
      }
      if (struct.isSetMileage()) {
        oprot.writeDouble(struct.mileage);
      }
      if (struct.isSetSpeed()) {
        oprot.writeDouble(struct.speed);
      }
      if (struct.isSetEngineSpeed()) {
        oprot.writeDouble(struct.engineSpeed);
      }
      if (struct.isSetVin()) {
        oprot.writeString(struct.vin);
      }
      if (struct.isSetRes()) {
        oprot.writeString(struct.res);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ThriftObdDs struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(9);
      if (incoming.get(0)) {
        struct.sn = iprot.readString();
        struct.setSnIsSet(true);
      }
      if (incoming.get(1)) {
        struct.gpstime = iprot.readI64();
        struct.setGpstimeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.totalFuel = iprot.readDouble();
        struct.setTotalFuelIsSet(true);
      }
      if (incoming.get(3)) {
        struct.totalMileage = iprot.readDouble();
        struct.setTotalMileageIsSet(true);
      }
      if (incoming.get(4)) {
        struct.mileage = iprot.readDouble();
        struct.setMileageIsSet(true);
      }
      if (incoming.get(5)) {
        struct.speed = iprot.readDouble();
        struct.setSpeedIsSet(true);
      }
      if (incoming.get(6)) {
        struct.engineSpeed = iprot.readDouble();
        struct.setEngineSpeedIsSet(true);
      }
      if (incoming.get(7)) {
        struct.vin = iprot.readString();
        struct.setVinIsSet(true);
      }
      if (incoming.get(8)) {
        struct.res = iprot.readString();
        struct.setResIsSet(true);
      }
    }
  }

}

