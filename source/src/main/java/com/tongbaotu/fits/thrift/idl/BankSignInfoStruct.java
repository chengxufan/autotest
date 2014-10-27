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

public class BankSignInfoStruct implements org.apache.thrift.TBase<BankSignInfoStruct, BankSignInfoStruct._Fields>, java.io.Serializable, Cloneable, Comparable<BankSignInfoStruct> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BankSignInfoStruct");

  private static final org.apache.thrift.protocol.TField INVESTOR_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("investorID", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ID_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("id_type", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField ID_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("id_name", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField ID_NUMBER_FIELD_DESC = new org.apache.thrift.protocol.TField("id_number", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField ID_AUTHORITY_FIELD_DESC = new org.apache.thrift.protocol.TField("id_authority", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField ID_ADDRESS_FIELD_DESC = new org.apache.thrift.protocol.TField("id_address", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField ID_CARD_VAILD_FIELD_DESC = new org.apache.thrift.protocol.TField("id_card_vaild", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField GENDER_FIELD_DESC = new org.apache.thrift.protocol.TField("gender", org.apache.thrift.protocol.TType.I32, (short)8);
  private static final org.apache.thrift.protocol.TField BANK_ACCOUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("bank_account", org.apache.thrift.protocol.TType.STRING, (short)9);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BankSignInfoStructStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BankSignInfoStructTupleSchemeFactory());
  }

  public String investorID; // required
  public String id_type; // required
  public String id_name; // required
  public String id_number; // required
  public String id_authority; // required
  public String id_address; // required
  public String id_card_vaild; // required
  public int gender; // required
  public String bank_account; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    INVESTOR_ID((short)1, "investorID"),
    ID_TYPE((short)2, "id_type"),
    ID_NAME((short)3, "id_name"),
    ID_NUMBER((short)4, "id_number"),
    ID_AUTHORITY((short)5, "id_authority"),
    ID_ADDRESS((short)6, "id_address"),
    ID_CARD_VAILD((short)7, "id_card_vaild"),
    GENDER((short)8, "gender"),
    BANK_ACCOUNT((short)9, "bank_account");

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
        case 2: // ID_TYPE
          return ID_TYPE;
        case 3: // ID_NAME
          return ID_NAME;
        case 4: // ID_NUMBER
          return ID_NUMBER;
        case 5: // ID_AUTHORITY
          return ID_AUTHORITY;
        case 6: // ID_ADDRESS
          return ID_ADDRESS;
        case 7: // ID_CARD_VAILD
          return ID_CARD_VAILD;
        case 8: // GENDER
          return GENDER;
        case 9: // BANK_ACCOUNT
          return BANK_ACCOUNT;
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
  private static final int __GENDER_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.INVESTOR_ID, new org.apache.thrift.meta_data.FieldMetaData("investorID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ID_TYPE, new org.apache.thrift.meta_data.FieldMetaData("id_type", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ID_NAME, new org.apache.thrift.meta_data.FieldMetaData("id_name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ID_NUMBER, new org.apache.thrift.meta_data.FieldMetaData("id_number", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ID_AUTHORITY, new org.apache.thrift.meta_data.FieldMetaData("id_authority", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ID_ADDRESS, new org.apache.thrift.meta_data.FieldMetaData("id_address", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ID_CARD_VAILD, new org.apache.thrift.meta_data.FieldMetaData("id_card_vaild", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.GENDER, new org.apache.thrift.meta_data.FieldMetaData("gender", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.BANK_ACCOUNT, new org.apache.thrift.meta_data.FieldMetaData("bank_account", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BankSignInfoStruct.class, metaDataMap);
  }

  public BankSignInfoStruct() {
  }

  public BankSignInfoStruct(
    String investorID,
    String id_type,
    String id_name,
    String id_number,
    String id_authority,
    String id_address,
    String id_card_vaild,
    int gender,
    String bank_account)
  {
    this();
    this.investorID = investorID;
    this.id_type = id_type;
    this.id_name = id_name;
    this.id_number = id_number;
    this.id_authority = id_authority;
    this.id_address = id_address;
    this.id_card_vaild = id_card_vaild;
    this.gender = gender;
    setGenderIsSet(true);
    this.bank_account = bank_account;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BankSignInfoStruct(BankSignInfoStruct other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetInvestorID()) {
      this.investorID = other.investorID;
    }
    if (other.isSetId_type()) {
      this.id_type = other.id_type;
    }
    if (other.isSetId_name()) {
      this.id_name = other.id_name;
    }
    if (other.isSetId_number()) {
      this.id_number = other.id_number;
    }
    if (other.isSetId_authority()) {
      this.id_authority = other.id_authority;
    }
    if (other.isSetId_address()) {
      this.id_address = other.id_address;
    }
    if (other.isSetId_card_vaild()) {
      this.id_card_vaild = other.id_card_vaild;
    }
    this.gender = other.gender;
    if (other.isSetBank_account()) {
      this.bank_account = other.bank_account;
    }
  }

  public BankSignInfoStruct deepCopy() {
    return new BankSignInfoStruct(this);
  }

  @Override
  public void clear() {
    this.investorID = null;
    this.id_type = null;
    this.id_name = null;
    this.id_number = null;
    this.id_authority = null;
    this.id_address = null;
    this.id_card_vaild = null;
    setGenderIsSet(false);
    this.gender = 0;
    this.bank_account = null;
  }

  public String getInvestorID() {
    return this.investorID;
  }

  public BankSignInfoStruct setInvestorID(String investorID) {
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

  public String getId_type() {
    return this.id_type;
  }

  public BankSignInfoStruct setId_type(String id_type) {
    this.id_type = id_type;
    return this;
  }

  public void unsetId_type() {
    this.id_type = null;
  }

  /** Returns true if field id_type is set (has been assigned a value) and false otherwise */
  public boolean isSetId_type() {
    return this.id_type != null;
  }

  public void setId_typeIsSet(boolean value) {
    if (!value) {
      this.id_type = null;
    }
  }

  public String getId_name() {
    return this.id_name;
  }

  public BankSignInfoStruct setId_name(String id_name) {
    this.id_name = id_name;
    return this;
  }

  public void unsetId_name() {
    this.id_name = null;
  }

  /** Returns true if field id_name is set (has been assigned a value) and false otherwise */
  public boolean isSetId_name() {
    return this.id_name != null;
  }

  public void setId_nameIsSet(boolean value) {
    if (!value) {
      this.id_name = null;
    }
  }

  public String getId_number() {
    return this.id_number;
  }

  public BankSignInfoStruct setId_number(String id_number) {
    this.id_number = id_number;
    return this;
  }

  public void unsetId_number() {
    this.id_number = null;
  }

  /** Returns true if field id_number is set (has been assigned a value) and false otherwise */
  public boolean isSetId_number() {
    return this.id_number != null;
  }

  public void setId_numberIsSet(boolean value) {
    if (!value) {
      this.id_number = null;
    }
  }

  public String getId_authority() {
    return this.id_authority;
  }

  public BankSignInfoStruct setId_authority(String id_authority) {
    this.id_authority = id_authority;
    return this;
  }

  public void unsetId_authority() {
    this.id_authority = null;
  }

  /** Returns true if field id_authority is set (has been assigned a value) and false otherwise */
  public boolean isSetId_authority() {
    return this.id_authority != null;
  }

  public void setId_authorityIsSet(boolean value) {
    if (!value) {
      this.id_authority = null;
    }
  }

  public String getId_address() {
    return this.id_address;
  }

  public BankSignInfoStruct setId_address(String id_address) {
    this.id_address = id_address;
    return this;
  }

  public void unsetId_address() {
    this.id_address = null;
  }

  /** Returns true if field id_address is set (has been assigned a value) and false otherwise */
  public boolean isSetId_address() {
    return this.id_address != null;
  }

  public void setId_addressIsSet(boolean value) {
    if (!value) {
      this.id_address = null;
    }
  }

  public String getId_card_vaild() {
    return this.id_card_vaild;
  }

  public BankSignInfoStruct setId_card_vaild(String id_card_vaild) {
    this.id_card_vaild = id_card_vaild;
    return this;
  }

  public void unsetId_card_vaild() {
    this.id_card_vaild = null;
  }

  /** Returns true if field id_card_vaild is set (has been assigned a value) and false otherwise */
  public boolean isSetId_card_vaild() {
    return this.id_card_vaild != null;
  }

  public void setId_card_vaildIsSet(boolean value) {
    if (!value) {
      this.id_card_vaild = null;
    }
  }

  public int getGender() {
    return this.gender;
  }

  public BankSignInfoStruct setGender(int gender) {
    this.gender = gender;
    setGenderIsSet(true);
    return this;
  }

  public void unsetGender() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __GENDER_ISSET_ID);
  }

  /** Returns true if field gender is set (has been assigned a value) and false otherwise */
  public boolean isSetGender() {
    return EncodingUtils.testBit(__isset_bitfield, __GENDER_ISSET_ID);
  }

  public void setGenderIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __GENDER_ISSET_ID, value);
  }

  public String getBank_account() {
    return this.bank_account;
  }

  public BankSignInfoStruct setBank_account(String bank_account) {
    this.bank_account = bank_account;
    return this;
  }

  public void unsetBank_account() {
    this.bank_account = null;
  }

  /** Returns true if field bank_account is set (has been assigned a value) and false otherwise */
  public boolean isSetBank_account() {
    return this.bank_account != null;
  }

  public void setBank_accountIsSet(boolean value) {
    if (!value) {
      this.bank_account = null;
    }
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

    case ID_TYPE:
      if (value == null) {
        unsetId_type();
      } else {
        setId_type((String)value);
      }
      break;

    case ID_NAME:
      if (value == null) {
        unsetId_name();
      } else {
        setId_name((String)value);
      }
      break;

    case ID_NUMBER:
      if (value == null) {
        unsetId_number();
      } else {
        setId_number((String)value);
      }
      break;

    case ID_AUTHORITY:
      if (value == null) {
        unsetId_authority();
      } else {
        setId_authority((String)value);
      }
      break;

    case ID_ADDRESS:
      if (value == null) {
        unsetId_address();
      } else {
        setId_address((String)value);
      }
      break;

    case ID_CARD_VAILD:
      if (value == null) {
        unsetId_card_vaild();
      } else {
        setId_card_vaild((String)value);
      }
      break;

    case GENDER:
      if (value == null) {
        unsetGender();
      } else {
        setGender((Integer)value);
      }
      break;

    case BANK_ACCOUNT:
      if (value == null) {
        unsetBank_account();
      } else {
        setBank_account((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case INVESTOR_ID:
      return getInvestorID();

    case ID_TYPE:
      return getId_type();

    case ID_NAME:
      return getId_name();

    case ID_NUMBER:
      return getId_number();

    case ID_AUTHORITY:
      return getId_authority();

    case ID_ADDRESS:
      return getId_address();

    case ID_CARD_VAILD:
      return getId_card_vaild();

    case GENDER:
      return Integer.valueOf(getGender());

    case BANK_ACCOUNT:
      return getBank_account();

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
    case ID_TYPE:
      return isSetId_type();
    case ID_NAME:
      return isSetId_name();
    case ID_NUMBER:
      return isSetId_number();
    case ID_AUTHORITY:
      return isSetId_authority();
    case ID_ADDRESS:
      return isSetId_address();
    case ID_CARD_VAILD:
      return isSetId_card_vaild();
    case GENDER:
      return isSetGender();
    case BANK_ACCOUNT:
      return isSetBank_account();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BankSignInfoStruct)
      return this.equals((BankSignInfoStruct)that);
    return false;
  }

  public boolean equals(BankSignInfoStruct that) {
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

    boolean this_present_id_type = true && this.isSetId_type();
    boolean that_present_id_type = true && that.isSetId_type();
    if (this_present_id_type || that_present_id_type) {
      if (!(this_present_id_type && that_present_id_type))
        return false;
      if (!this.id_type.equals(that.id_type))
        return false;
    }

    boolean this_present_id_name = true && this.isSetId_name();
    boolean that_present_id_name = true && that.isSetId_name();
    if (this_present_id_name || that_present_id_name) {
      if (!(this_present_id_name && that_present_id_name))
        return false;
      if (!this.id_name.equals(that.id_name))
        return false;
    }

    boolean this_present_id_number = true && this.isSetId_number();
    boolean that_present_id_number = true && that.isSetId_number();
    if (this_present_id_number || that_present_id_number) {
      if (!(this_present_id_number && that_present_id_number))
        return false;
      if (!this.id_number.equals(that.id_number))
        return false;
    }

    boolean this_present_id_authority = true && this.isSetId_authority();
    boolean that_present_id_authority = true && that.isSetId_authority();
    if (this_present_id_authority || that_present_id_authority) {
      if (!(this_present_id_authority && that_present_id_authority))
        return false;
      if (!this.id_authority.equals(that.id_authority))
        return false;
    }

    boolean this_present_id_address = true && this.isSetId_address();
    boolean that_present_id_address = true && that.isSetId_address();
    if (this_present_id_address || that_present_id_address) {
      if (!(this_present_id_address && that_present_id_address))
        return false;
      if (!this.id_address.equals(that.id_address))
        return false;
    }

    boolean this_present_id_card_vaild = true && this.isSetId_card_vaild();
    boolean that_present_id_card_vaild = true && that.isSetId_card_vaild();
    if (this_present_id_card_vaild || that_present_id_card_vaild) {
      if (!(this_present_id_card_vaild && that_present_id_card_vaild))
        return false;
      if (!this.id_card_vaild.equals(that.id_card_vaild))
        return false;
    }

    boolean this_present_gender = true;
    boolean that_present_gender = true;
    if (this_present_gender || that_present_gender) {
      if (!(this_present_gender && that_present_gender))
        return false;
      if (this.gender != that.gender)
        return false;
    }

    boolean this_present_bank_account = true && this.isSetBank_account();
    boolean that_present_bank_account = true && that.isSetBank_account();
    if (this_present_bank_account || that_present_bank_account) {
      if (!(this_present_bank_account && that_present_bank_account))
        return false;
      if (!this.bank_account.equals(that.bank_account))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(BankSignInfoStruct other) {
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
    lastComparison = Boolean.valueOf(isSetId_type()).compareTo(other.isSetId_type());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId_type()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id_type, other.id_type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId_name()).compareTo(other.isSetId_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id_name, other.id_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId_number()).compareTo(other.isSetId_number());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId_number()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id_number, other.id_number);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId_authority()).compareTo(other.isSetId_authority());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId_authority()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id_authority, other.id_authority);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId_address()).compareTo(other.isSetId_address());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId_address()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id_address, other.id_address);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId_card_vaild()).compareTo(other.isSetId_card_vaild());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId_card_vaild()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id_card_vaild, other.id_card_vaild);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGender()).compareTo(other.isSetGender());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGender()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.gender, other.gender);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBank_account()).compareTo(other.isSetBank_account());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBank_account()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bank_account, other.bank_account);
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
    StringBuilder sb = new StringBuilder("BankSignInfoStruct(");
    boolean first = true;

    sb.append("investorID:");
    if (this.investorID == null) {
      sb.append("null");
    } else {
      sb.append(this.investorID);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("id_type:");
    if (this.id_type == null) {
      sb.append("null");
    } else {
      sb.append(this.id_type);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("id_name:");
    if (this.id_name == null) {
      sb.append("null");
    } else {
      sb.append(this.id_name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("id_number:");
    if (this.id_number == null) {
      sb.append("null");
    } else {
      sb.append(this.id_number);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("id_authority:");
    if (this.id_authority == null) {
      sb.append("null");
    } else {
      sb.append(this.id_authority);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("id_address:");
    if (this.id_address == null) {
      sb.append("null");
    } else {
      sb.append(this.id_address);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("id_card_vaild:");
    if (this.id_card_vaild == null) {
      sb.append("null");
    } else {
      sb.append(this.id_card_vaild);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("gender:");
    sb.append(this.gender);
    first = false;
    if (!first) sb.append(", ");
    sb.append("bank_account:");
    if (this.bank_account == null) {
      sb.append("null");
    } else {
      sb.append(this.bank_account);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (investorID == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'investorID' was not present! Struct: " + toString());
    }
    if (id_type == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'id_type' was not present! Struct: " + toString());
    }
    if (id_name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'id_name' was not present! Struct: " + toString());
    }
    if (id_number == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'id_number' was not present! Struct: " + toString());
    }
    if (id_authority == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'id_authority' was not present! Struct: " + toString());
    }
    if (id_address == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'id_address' was not present! Struct: " + toString());
    }
    if (id_card_vaild == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'id_card_vaild' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'gender' because it's a primitive and you chose the non-beans generator.
    if (bank_account == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'bank_account' was not present! Struct: " + toString());
    }
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

  private static class BankSignInfoStructStandardSchemeFactory implements SchemeFactory {
    public BankSignInfoStructStandardScheme getScheme() {
      return new BankSignInfoStructStandardScheme();
    }
  }

  private static class BankSignInfoStructStandardScheme extends StandardScheme<BankSignInfoStruct> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BankSignInfoStruct struct) throws org.apache.thrift.TException {
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
          case 2: // ID_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id_type = iprot.readString();
              struct.setId_typeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ID_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id_name = iprot.readString();
              struct.setId_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ID_NUMBER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id_number = iprot.readString();
              struct.setId_numberIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ID_AUTHORITY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id_authority = iprot.readString();
              struct.setId_authorityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // ID_ADDRESS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id_address = iprot.readString();
              struct.setId_addressIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // ID_CARD_VAILD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id_card_vaild = iprot.readString();
              struct.setId_card_vaildIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // GENDER
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.gender = iprot.readI32();
              struct.setGenderIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 9: // BANK_ACCOUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.bank_account = iprot.readString();
              struct.setBank_accountIsSet(true);
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
      if (!struct.isSetGender()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'gender' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, BankSignInfoStruct struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.investorID != null) {
        oprot.writeFieldBegin(INVESTOR_ID_FIELD_DESC);
        oprot.writeString(struct.investorID);
        oprot.writeFieldEnd();
      }
      if (struct.id_type != null) {
        oprot.writeFieldBegin(ID_TYPE_FIELD_DESC);
        oprot.writeString(struct.id_type);
        oprot.writeFieldEnd();
      }
      if (struct.id_name != null) {
        oprot.writeFieldBegin(ID_NAME_FIELD_DESC);
        oprot.writeString(struct.id_name);
        oprot.writeFieldEnd();
      }
      if (struct.id_number != null) {
        oprot.writeFieldBegin(ID_NUMBER_FIELD_DESC);
        oprot.writeString(struct.id_number);
        oprot.writeFieldEnd();
      }
      if (struct.id_authority != null) {
        oprot.writeFieldBegin(ID_AUTHORITY_FIELD_DESC);
        oprot.writeString(struct.id_authority);
        oprot.writeFieldEnd();
      }
      if (struct.id_address != null) {
        oprot.writeFieldBegin(ID_ADDRESS_FIELD_DESC);
        oprot.writeString(struct.id_address);
        oprot.writeFieldEnd();
      }
      if (struct.id_card_vaild != null) {
        oprot.writeFieldBegin(ID_CARD_VAILD_FIELD_DESC);
        oprot.writeString(struct.id_card_vaild);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(GENDER_FIELD_DESC);
      oprot.writeI32(struct.gender);
      oprot.writeFieldEnd();
      if (struct.bank_account != null) {
        oprot.writeFieldBegin(BANK_ACCOUNT_FIELD_DESC);
        oprot.writeString(struct.bank_account);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BankSignInfoStructTupleSchemeFactory implements SchemeFactory {
    public BankSignInfoStructTupleScheme getScheme() {
      return new BankSignInfoStructTupleScheme();
    }
  }

  private static class BankSignInfoStructTupleScheme extends TupleScheme<BankSignInfoStruct> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BankSignInfoStruct struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.investorID);
      oprot.writeString(struct.id_type);
      oprot.writeString(struct.id_name);
      oprot.writeString(struct.id_number);
      oprot.writeString(struct.id_authority);
      oprot.writeString(struct.id_address);
      oprot.writeString(struct.id_card_vaild);
      oprot.writeI32(struct.gender);
      oprot.writeString(struct.bank_account);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BankSignInfoStruct struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.investorID = iprot.readString();
      struct.setInvestorIDIsSet(true);
      struct.id_type = iprot.readString();
      struct.setId_typeIsSet(true);
      struct.id_name = iprot.readString();
      struct.setId_nameIsSet(true);
      struct.id_number = iprot.readString();
      struct.setId_numberIsSet(true);
      struct.id_authority = iprot.readString();
      struct.setId_authorityIsSet(true);
      struct.id_address = iprot.readString();
      struct.setId_addressIsSet(true);
      struct.id_card_vaild = iprot.readString();
      struct.setId_card_vaildIsSet(true);
      struct.gender = iprot.readI32();
      struct.setGenderIsSet(true);
      struct.bank_account = iprot.readString();
      struct.setBank_accountIsSet(true);
    }
  }

}

