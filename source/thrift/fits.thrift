namespace java com.tongbaotu.fits.thrift.idl
namespace php fits

//FITS的Thrift异常
exception FitsException {
  //异常码
  1: required i32 code

  //异常消息
  2: required string message
} 

//通用处理结果消息
struct ResultInfoStruct
{
  1: required i32 retCode
  2: required string mess
}

//用户注册信息
struct InvestorRegisterInfoStruct
{
  //移动电话号码
  1: required string mobilePhoneNumber
}

//用户注册处理结果消息
struct InvestorRegisterResultInfoStruct
{
  //移动电话号码
  1: required string mobilePhoneNumber

  //投资人ID
  2: string investorID
}

//风险评级变更请求消息
struct RiskLevelStruct
{
  //投资者ID
  1: required string investorID

  //风险级别
  2: required i32 riskLevel
}

//银行签约请求消息
struct BankSignInfoStruct
{
  //投资人ID
  1: required string investorID
  
  //有效身份证件类型：0中国居民身份证、2港澳居民来往内地通行证、3台湾居民来往大陆通行证、4外国人永久居留证、5外国护照、6其他
  2: required string id_type

  //有效身份证件的姓名
  3: required string id_name

  //有效身份证件的号码
  4: required string id_number

  //有效身份证件的发证单位
  5: required string id_authority

  //有效身份证件所记录的地址
  6: required string id_address

  //有效身份证件的有效期 YYYYMMDD  调用方负责检查有效格式
  7: required string id_card_vaild
  
  //性别 1男 2女 3其他
  8: required i32 gender
  
  //结算行ID
  9: required string proxyBankID
  
  //普通结算户号码
  10: required string bank_account
}

//银行签约处理结果
struct BankSignResultStruct
{
   //投资专用资金账户
   1: string invest_special_account
}

//机构注册信息
struct InstitutionInfoStruct
{
  //机构ID
  1: string id
  
  //上一级机构ID
  2: string superid
  
  //机构类别 1 发行机构；2 代销机构；3 发行兼代销机构；4 其他
  3: required i32 type

  //机构名称
  4: required string name

  //机构组织机构代码
  5: required string organizationCode

  //机构地址
  6: required string address

  //机构邮编
  7: required string ZIP

  //固定联系电话
  8: required string fixedTelephone

  //传真
  9: required string FAX

  //网站站点
  10: required string webSite

  //通报图资金归集(代销行)/清算(发行行)账户
  11: required string TBTCapitalAccountID

  //联系人姓名
  12: required string contactName

  //联系人移动电话号码
  13: required string mobilePhoneNumber

  //联系人电子邮箱
  14: required string email

  //联系人住址
  15: required string contactAddress

  //请求日期 
  16: i32 registerDate

  //初始状态
  17: i32 status
}

//代销行注册结果信息
struct InstitutionResultStruct
{
  //机构ID
  1: required string id
}

//发行行产品注册信息
struct IssuBankProductInfoStruct
{
   //产品name
   1: required string name
   
   //产品类型  0 债权型; 1 特定资产型; 2 准基金型; 3指数挂钩型
   2: required i32 type
   
   //收益计算方式 1 一次性；2 按月；3 按季；4 按年
   3: required i32 calculationearn
   
   //收益计算基础  （产品目标收益率计算基础）
   // 0 '30/360';  1 'Act/360';  2 'Act/366'
   4: required i32 target_rate_formula
   
   //资产管理人ID
   5: required string assetManager
   
   //资产托管人ID
   6: required string assetTrustee
   
   //发行行ID
   7: required string issubankid
   
   //币种 0 人民币；1 港币；2 美元；3 其他
   8: required  i32 currency
   
   //风险级别
   9: required i32 risk_level
   
   // 目标收益率
   10: required double target_rate
   
   // 募集金额上限
   11: required double raise_upper
   
   //募集金额下限
   12: required double raise_low
   
   //单一投资人申购上限
   13: required double investment_upper_limit
   
   //单一投资人申购下限
   14: required double investment_low_limit
   
   //募集人数上限
   15: required i32 max_raise_number
   
   //产品上线日
   16: required i32 launch_date
   
   //募集起始日
   17: required i32 raise_start_date
   
   //募集截止日
   18: required i32 raise_end_date
   
   //产品起息日
   19: required i32 value_date
   
   //产品到期日
   20: required i32 due_date
   
   //产品清算日
   21: required  i32 reckon_date
   
   //预计回款日
   22: required  i32 expected_payment_date
   
   //状态 0 正常；1 无效；2 已清算
   23: i32 productStatus
}

//发行行产品注册处理结果信息
struct IssuBankProductInfoResultStruct
{
   //产品ID
   1: string productid
}

//银投/投银转账信息
struct TransferInfoStruct
{
  //投资人ID
  1: required string investorID
  
  //转账数量
  2: required double amount
  
   //币种 0 人民币；1 港币；2 美元；3 其他
  3: required i32 currency
  
  //转账类型 1 银投转账；2 投银转账
  4: required i32 transferType
  
  //投资专用资金账户
  5: required string invest_special_account
}

//银投/投银转账信息
struct TransferResultStruct
{
  //投资人ID
  1: required string investorID
  
  //投资专用资金账户
  2: required string invest_special_account
  
  //转账数量
  3: required double amount
  
  //投资账户当前余额
  4: required  double currentbalance
}

struct PurchaseInfoStruct
{
  //投资人ID
  1: required string investorID
  
  //投资专用资金账户
  2: required string invest_special_account
  
  //产品ID
  3: required string productid
  
  //购买金额
  4: required double amount
}

struct PurchaseResultStruct
{
  //投资人ID
  1: required string investorID
  
  //产品ID
  2: required string productid
  
  //购买金额
  3: required double amount
  
  //订单号
  4: required string orderno
}

service  Fits {
	
  //投资者注册
  InvestorRegisterResultInfoStruct investor_register(1:InvestorRegisterInfoStruct investorInfo) throws (1: FitsException fe),
  
  //投资者状态切换
  //状态说明
  //1; 已注册成功
  //2; 已完成评级
  //3; 正常交易
  //4; 冻结
  //5; 注销
  void investor_switchState(1:string investorID, 2:i32 newState)  throws (1: FitsException fe),

  //更新投资者风险级别
  void investor_updateRiskLevel(1:RiskLevelStruct riskLevel)  throws (1: FitsException fe),

  //投资者银行签约
  BankSignResultStruct investor_bankSign(1:BankSignInfoStruct bankSignInfo)  throws (1: FitsException fe),
  
  //银投/投银转账
  TransferResultStruct silverInvestTransfer(1:TransferInfoStruct transferInfo)  throws (1: FitsException fe),
  
  //产品购买
  PurchaseResultStruct purchaseProduct(1:PurchaseInfoStruct purchaseInfo)  throws (1: FitsException fe),
  
  //发行行产品注册
  IssuBankProductInfoResultStruct issubank_productregister(1:IssuBankProductInfoStruct productInfo)  throws (1: FitsException fe),

  //机构注册
  InstitutionResultStruct institution_regist(1:InstitutionInfoStruct institutionInfo)  throws (1: FitsException fe),
  
  //获取机构信息
  InstitutionInfoStruct institution_getInfo(1:string institutionid)  throws (1: FitsException fe),
}