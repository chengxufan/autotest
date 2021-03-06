/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.tongbaotu.fits.thrift.idl;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransferQueryConditionStruct implements org.apache.thrift.TBase<TransferQueryConditionStruct, TransferQueryConditionStruct._Fields>, java.io.Serializable, Cloneable, Comparable<TransferQueryConditionStruct> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TransferQueryConditionStruct");

  private static final org.apache.thrift.protocol.TField INVESTOR_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("investorID", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField INVEST_SPECIAL_ACCOUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("invest_special_account", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField BEGINDATE_FIELD_DESC = new org.apache.thrift.protocol.TField("begindate", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField ENDDATE_FIELD_DESC = new org.apache.thrift.protocol.TField("enddate", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TransferQueryConditionStructStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TransferQueryConditionStructTupleSchemeFactory());
  }

  public String investorID; // required
  public String invest_special_account; // required
  public int begindate; // required
  public int enddate; // required
  public int status; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    INVESTOR_ID((short)1, "investorID"),
    INVEST_SPECIAL_ACCOUNT((short)2, "invest_special_account"),
    BEGINDATE((short)3, "begindate"),
    ENDDATE((short)4, "enddate"),
    STATUS((short)5, "status");

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
        case 1: // INVESTOR_ID
          return INVESTOR_ID;
        case 2: // INVEST_SPECIAL_ACCOUNT
          return INVEST_SPECIAL_ACCOUNT;
        case 3: // BEGINDATE
          return BEGINDATE;
        case 4: // ENDDATE
          return ENDDATE;
        case 5: // STATUS
          return STATUS;
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
  private static final int __BEGINDATE_ISSET_ID = 0;
  private static final int __ENDDATE_ISSET_ID = 1;
  private static final int __STATUS_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.INVESTOR_ID, new org.apache.thrift.meta_data.FieldMetaData("investorID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.INVEST_SPECIAL_ACCOUNT, new org.apache.thrift.meta_data.FieldMetaData("invest_special_account", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BEGINDATE, new org.apache.thrift.meta_data.FieldMetaData("begindate", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ENDDATE, new org.apache.thrift.meta_data.FieldMetaData("enddate", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TransferQueryConditionStruct.class, metaDataMap);
  }

  public TransferQueryConditionStruct() {
  }

  public TransferQueryConditionStruct(
    String investorID,
    String invest_special_account,
    int begindate,
    int enddate,
    int status)
  {
    this();
    this.investorID = investorID;
    this.invest_special_account = invest_special_account;
    this.begindate = begindate;
    setBegindateIsSet(true);
    this.enddate = enddate;
    setEnddateIsSet(true);
    this.status = status;
    setStatusIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TransferQueryConditionStruct(TransferQueryConditionStruct other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetInvestorID()) {
      this.investorID = other.investorID;
    }
    if (other.isSetInvest_special_account()) {
      this.invest_special_account = other.invest_special_account;
    }
    this.begindate = other.begindate;
    this.enddate = other.enddate;
    this.status = other.status;
  }

  public TransferQueryConditionStruct deepCopy() {
    return new TransferQueryConditionStruct(this);
  }

  @Override
  public void clear() {
    this.investorID = null;
    this.invest_special_account = null;
    setBegindateIsSet(false);
    this.begindate = 0;
    setEnddateIsSet(false);
    this.enddate = 0;
    setStatusIsSet(false);
    this.status = 0;
  }

  public String getInvestorID() {
    return this.investorID;
  }

  public TransferQueryConditionStruct setInvestorID(String investorID) {
    this.investorID = investorID;
    return this;
  }

  public void unsetInvestorID() {
    this.investorID = null;
  }

  /** Returns true if field investorID is set (has been assigned a value) and false otherwise */
  public boolean isSetInvestorID() {
    return this.investorID != null;
  }

  public void setInvestorIDIsSet(boolean value) {
    if (!value) {
      this.investorID = null;
    }
  }

  public String getInvest_special_account() {
    return this.invest_special_account;
  }

  public TransferQueryConditionStruct setInvest_special_account(String invest_special_account) {
    this.invest_special_account = invest_special_account;
    return this;
  }

  public void unsetInvest_special_account() {
    this.invest_special_account = null;
  }

  /** Returns true if field invest_special_account is set (has been assigned a value) and false otherwise */
  public boolean isSetInvest_special_account() {
    return this.invest_special_account != null;
  }

  public void setInvest_special_accountIsSet(boolean value) {
    if (!value) {
      this.invest_special_account = null;
    }
  }

  public int getBegindate() {
    return this.begindate;
  }

  public TransferQueryConditionStruct setBegindate(int begindate) {
    this.begindate = begindate;
    setBegindateIsSet(true);
    return this;
  }

  public void unsetBegindate() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __BEGINDATE_ISSET_ID);
  }

  /** Returns true if field begindate is set (has been assigned a value) and false otherwise */
  public boolean isSetBegindate() {
    return EncodingUtils.testBit(__isset_bitfield, __BEGINDATE_ISSET_ID);
  }

  public void setBegindateIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __BEGINDATE_ISSET_ID, value);
  }

  public int getEnddate() {
    return this.enddate;
  }

  public TransferQueryConditionStruct setEnddate(int enddate) {
    this.enddate = enddate;
    setEnddateIsSet(true);
    return this;
  }

  public void unsetEnddate() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ENDDATE_ISSET_ID);
  }

  /** Returns true if field enddate is set (has been assigned a value) and false otherwise */
  public boolean isSetEnddate() {
    return EncodingUtils.testBit(__isset_bitfield, __ENDDATE_ISSET_ID);
  }

  public void setEnddateIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ENDDATE_ISSET_ID, value);
  }

  public int getStatus() {
    return this.status;
  }

  public TransferQueryConditionStruct setStatus(int status) {
    this.status = status;
    setStatusIsSet(true);
    return this;
  }

  public void unsetStatus() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return EncodingUtils.testBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  public void setStatusIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STATUS_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case INVESTOR_ID:
      if (value == null) {
        unsetInvestorID();
      } else {
        setInvestorID((String)value);
      }
      break;

    case INVEST_SPECIAL_ACCOUNT:
      if (value == null) {
        unsetInvest_special_account();
      } else {
        setInvest_special_account((String)value);
      }
      break;

    case BEGINDATE:
      if (value == null) {
        unsetBegindate();
      } else {
        setBegindate((Integer)value);
      }
      break;

    case ENDDATE:
      if (value == null) {
        unsetEnddate();
      } else {
        setEnddate((Integer)value);
      }
      break;

    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case INVESTOR_ID:
      return getInvestorID();

    case INVEST_SPECIAL_ACCOUNT:
      return getInvest_special_account();

    case BEGINDATE:
      return Integer.valueOf(getBegindate());

    case ENDDATE:
      return Integer.valueOf(getEnddate());

    case STATUS:
      return Integer.valueOf(getStatus());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case INVESTOR_ID:
      return isSetInvestorID();
    case INVEST_SPECIAL_ACCOUNT:
      return isSetInvest_special_account();
    case BEGINDATE:
      return isSetBegindate();
    case ENDDATE:
      return isSetEnddate();
    case STATUS:
      return isSetStatus();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TransferQueryConditionStruct)
      return this.equals((TransferQueryConditionStruct)that);
    return false;
  }

  public boolean equals(TransferQueryConditionStruct that) {
    if (that == null)
      return false;

    boolean this_present_investorID = true && this.isSetInvestorID();
    boolean that_present_investorID = true && that.isSetInvestorID();
    if (this_present_investorID || that_present_investorID) {
      if (!(this_present_investorID && that_present_investorID))
        return false;
      if (!this.investorID.equals(that.investorID))
        return false;
    }

    boolean this_present_invest_special_account = true && this.isSetInvest_special_account();
    boolean that_present_invest_special_account = true && that.isSetInvest_special_account();
    if (this_present_invest_special_account || that_present_invest_special_account) {
      if (!(this_present_invest_special_account && that_present_invest_special_account))
        return false;
      if (!this.invest_special_account.equals(that.invest_special_account))
        return false;
    }

    boolean this_present_begindate = true;
    boolean that_present_begindate = true;
    if (this_present_begindate || that_present_begindate) {
      if (!(this_present_begindate && that_present_begindate))
        return false;
      if (this.begindate != that.begindate)
        return false;
    }

    boolean this_present_enddate = true;
    boolean that_present_enddate = true;
    if (this_present_enddate || that_present_enddate) {
      if (!(this_present_enddate && that_present_enddate))
        return false;
      if (this.enddate != that.enddate)
        return false;
    }

    boolean this_present_status = true;
    boolean that_present_status = true;
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (this.status != that.status)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TransferQueryConditionStruct other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetInvestorID()).compareTo(other.isSetInvestorID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInvestorID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.investorID, other.investorID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetInvest_special_account()).compareTo(other.isSetInvest_special_account());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInvest_special_account()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.invest_special_account, other.invest_special_account);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBegindate()).compareTo(other.isSetBegindate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBegindate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.begindate, other.begindate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEnddate()).compareTo(other.isSetEnddate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEnddate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.enddate, other.enddate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
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
    StringBuilder sb = new StringBuilder("TransferQueryConditionStruct(");
    boolean first = true;

    sb.append("investorID:");
    if (this.investorID == null) {
      sb.append("null");
    } else {
      sb.append(this.investorID);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("invest_special_account:");
    if (this.invest_special_account == null) {
      sb.append("null");
    } else {
      sb.append(this.invest_special_account);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("begindate:");
    sb.append(this.begindate);
    first = false;
    if (!first) sb.append(", ");
    sb.append("enddate:");
    sb.append(this.enddate);
    first = false;
    if (!first) sb.append(", ");
    sb.append("status:");
    sb.append(this.status);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (investorID == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'investorID' was not present! Struct: " + toString());
    }
    if (invest_special_account == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'invest_special_account' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'begindate' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'enddate' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'status' because it's a primitive and you chose the non-beans generator.
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

  private static class TransferQueryConditionStructStandardSchemeFactory implements SchemeFactory {
    public TransferQueryConditionStructStandardScheme getScheme() {
      return new TransferQueryConditionStructStandardScheme();
    }
  }

  private static class TransferQueryConditionStructStandardScheme extends StandardScheme<TransferQueryConditionStruct> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TransferQueryConditionStruct struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // INVESTOR_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.investorID = iprot.readString();
              struct.setInvestorIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // INVEST_SPECIAL_ACCOUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.invest_special_account = iprot.readString();
              struct.setInvest_special_accountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // BEGINDATE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.begindate = iprot.readI32();
              struct.setBegindateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ENDDATE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.enddate = iprot.readI32();
              struct.setEnddateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.status = iprot.readI32();
              struct.setStatusIsSet(true);
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
      if (!struct.isSetBegindate()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'begindate' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetEnddate()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'enddate' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TransferQueryConditionStruct struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.investorID != null) {
        oprot.writeFieldBegin(INVESTOR_ID_FIELD_DESC);
        oprot.writeString(struct.investorID);
        oprot.writeFieldEnd();
      }
      if (struct.invest_special_account != null) {
        oprot.writeFieldBegin(INVEST_SPECIAL_ACCOUNT_FIELD_DESC);
        oprot.writeString(struct.invest_special_account);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(BEGINDATE_FIELD_DESC);
      oprot.writeI32(struct.begindate);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ENDDATE_FIELD_DESC);
      oprot.writeI32(struct.enddate);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.status);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TransferQueryConditionStructTupleSchemeFactory implements SchemeFactory {
    public TransferQueryConditionStructTupleScheme getScheme() {
      return new TransferQueryConditionStructTupleScheme();
    }
  }

  private static class TransferQueryConditionStructTupleScheme extends TupleScheme<TransferQueryConditionStruct> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TransferQueryConditionStruct struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.investorID);
      oprot.writeString(struct.invest_special_account);
      oprot.writeI32(struct.begindate);
      oprot.writeI32(struct.enddate);
      oprot.writeI32(struct.status);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TransferQueryConditionStruct struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.investorID = iprot.readString();
      struct.setInvestorIDIsSet(true);
      struct.invest_special_account = iprot.readString();
      struct.setInvest_special_accountIsSet(true);
      struct.begindate = iprot.readI32();
      struct.setBegindateIsSet(true);
      struct.enddate = iprot.readI32();
      struct.setEnddateIsSet(true);
      struct.status = iprot.readI32();
      struct.setStatusIsSet(true);
    }
  }

}

