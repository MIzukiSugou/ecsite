-- Project Name : テーブル定義データ
-- Date/Time    : 2021/04/27
-- Author       : 菅生
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

/*
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
*/

--* RestoreFromTempTable
create table ARRIVE_MST (
  ARRIVE_CODE CHAR(6) not null
  , ARRIVE_NAME VARCHAR(255)
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(6) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(6) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint ARRIVE_MST_PKC primary key (ARRIVE_CODE));

--* RestoreFromTempTable
create table CAMPAIGN (
  CAMPAIGN_ID CHAR(8) not null
  , GOODS_ID CHAR(8) not null
  , LIMIT_COUNT INTEGER
  , CAMPAIGN_START_DATE DATE not null
  , CAMPAIGN_END_DATE DATE not null
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(4) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(4) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint CAMPAIGN_PKC primary key (CAMPAIGN_ID));

--* RestoreFromTempTable
create table CATEGORY_MASTER (
  GOODS_CATEGORY CHAR(2) not null
  , CATEGORY_NAME VARCHAR(100) not null
  , CATEGORY_SORT_NO INTEGER not null
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(4) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(4) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint CATEGORY_MASTER_PKC primary key (GOODS_CATEGORY)
);

--* RestoreFromTempTable
create table DESTINATION_MST (
  DESTINATION_CODE CHAR(6) not null
  , DESTINATION_NAME VARCHAR(255)
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(6) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(6) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint DESTINATION_MST_PKC primary key (DESTINATION_CODE)
);

--* RestoreFromTempTable
create table EMPLOYEE_MST (
  EMPLOYEE_ID CHAR(4) not null
  , FAMILY_NM VARCHAR(20) not null
  , FIRST_NM VARCHAR(20) not null
  , FAMILY_NM_KANA VARCHAR(20) not null
  , FIRST_NM_KANA VARCHAR(20) not null
  , MAIL_ADDRESS CHAR(30)
  , ADDRESS1 VARCHAR(30)
  , ADDRESS2 VARCHAR(30)
  , ZIP_CODE CHAR(8)
  , TEL_NO CHAR(13)
  , BIRTH_DAY INTEGER not null
  , INSERT_DATE DATE not null
  , UPDATE_DATE DATE not null
  , constraint EMPLOYEE_MST_PKC primary key (EMPLOYEE_ID)
);

--* RestoreFromTempTable
create table EXCHANGE_DECIDE (
  EXCHANGE_NO CHAR(8) not null
  , USER_ID CHAR(4) not null
  , GOODS_ID CHAR(8) not null
  , RESERVE_DATE DATETIME not null
  , EXCHANGE_AMOUNT INTEGER not null
  , INSERT_DATE DATETIME not null
  , INSERT_USER CHAR(4) not null
  , UPDATE_DATE DATETIME not null
  , UPDATE_USER CHAR(4) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint EXCHANGE_DECIDE_PKC primary key (EXCHANGE_NO)
);

--* RestoreFromTempTable
create table EXCHANGE_PLAN (
  RESERVE_NO CHAR(8) not null
  , USER_ID CHAR(4) not null
  , GOODS_ID CHAR(8) not null
  , RESERVE_DATE DATETIME not null
  , EXCHANGE_AMOUNT INTEGER not null
  , INSERT_DATE DATETIME not null
  , INSERT_USER CHAR(4) not null
  , UPDATE_DATE DATETIME not null
  , UPDATE_USER CHAR(4) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint EXCHANGE_PLAN_PKC primary key (RESERVE_NO)
);

--* RestoreFromTempTable
create table EXPERIENCE_LANG (
  EMPLOYEE_ID CHAR(4) not null
  , LANGUAGE_CODE CHAR(1) not null
  , constraint EXPERIENCE_LANG_PKC primary key (EMPLOYEE_ID,LANGUAGE_CODE)
);

--* RestoreFromTempTable
create table GOODS_MASTER (
  GOODS_ID CHAR(8) not null
  , GOODS_NAME VARCHAR(200) not null
  , GOODS_POINT INTEGER not null
  , GOODS_INFO_1 VARCHAR(1000)
  , GOODS_INFO_2 VARCHAR(1000)
  , IMAGE_PATH VARCHAR(100)
  , GOODS_CATEGORY CHAR(2) not null
  , GOODS_RANK CHAR(1) not null
  , MAX_EXCHANGE_COUNT INTEGER
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(4) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(4) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint GOODS_MASTER_PKC primary key (GOODS_ID)
);

--* RestoreFromTempTable
create table GOODS_PLAN (
  GOODS_PLAN_ID CHAR(4) not null
  , GOODS_ID CHAR(8) not null
  , SHOW_DATE DATE not null
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(4) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(4) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint GOODS_PLAN_PKC primary key (GOODS_PLAN_ID)
);

--* RestoreFromTempTable
create table ITEM_CLASS_MST (
  ITEM_CLASS_CODE CHAR(2) not null
  , ITEM_CLASS_NAME VARCHAR(100) not null
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(6) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(6) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint ITEM_CLASS_MST_PKC primary key (ITEM_CLASS_CODE)
);

--* RestoreFromTempTable
create table ITEM_MST (
  ITEM_CODE CHAR(8) not null
  , ITEM_NAME VARCHAR(200) not null
  , ITEM_CLASS_CODE CHAR(2) not null
  , VALID_START DATE not null
  , VALID_END DATE not null
  , ITEM_TYPE CHAR(2)
  , PALLET_RATE INTEGER not null
  , CASE_RATE INTEGER not null
  , BOAR_RATE INTEGER not null
  , KEEP_CODE CHAR(2)
  , OPEN_FLAG CHAR(1)
  , IMPORT_FLAG CHAR(1)
  , ORIGINAL_COUNTRY_CODE CHAR(3)
  , TERM_CODE CHAR(1)
  , TAX_CODE CHAR(1)
  , SIZE_H DECIMAL(10, 2)
  , SIZE_W DECIMAL(10, 2)
  , SIZE_D DECIMAL(10, 2)
  , STOP_FLAG CHAR(1)
  , REMARK VARCHAR(255)
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(6) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(6) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint ITEM_MST_PKC primary key (ITEM_CODE)
);

--* RestoreFromTempTable
create table LANGUAGE_MST (
  LANGUAGE_CODE CHAR(1) not null
  , LANGUAGE_NAME VARCHAR(30) not null
  , constraint LANGUAGE_MST_PKC primary key (LANGUAGE_CODE)
);

--* RestoreFromTempTable
create table PASSWORD_MANAGEMENT (
  USER_ID CHAR(4) not null
  , CHANGE_COUNT INTEGER not null
  , PASSWORD VARCHAR(100) not null
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(4) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(4) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint PASSWORD_MANAGEMENT_PKC primary key (USER_ID,CHANGE_COUNT)
);

--* RestoreFromTempTable
create table POINT_CATEGORY_MASTER (
  POINT_CATEGORY_CODE CHAR(4) not null
  , POINT_AMOUNT INTEGER not null
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(4) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(4) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint POINT_CATEGORY_MASTER_PKC primary key (POINT_CATEGORY_CODE)
);

--* RestoreFromTempTable
create table POINT_MASTER (
  USER_ID CHAR(4) not null
  , POINT_YM CHAR(6) not null
  , BALANCE_POINT INTEGER not null
  , PREV_BALANCE_POINT INTEGER not null
  , ACQUISITION_POINT INTEGER not null
  , EXPENDITURE_POINT INTEGER not null
  , EXCHANGE_COUNT INTEGER not null
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(4) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(4) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint POINT_MASTER_PKC primary key (USER_ID,POINT_YM)
);

--* RestoreFromTempTable
create table RESERVE_DEST (
  RESERVE_DEST_NO CHAR(6) not null
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(6) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(6) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint RESERVE_DEST_PKC primary key (RESERVE_DEST_NO)
);

--* RestoreFromTempTable
create table SCHEDULE_TRX (
  EMPLOYEE_ID CHAR(4) not null
  , LANGUAGE_CODE CHAR(1) not null
  , LEC_YMD CHAR(8) not null
  , LEC_PLAN_WEEK CHAR(3) not null
  , LEC_PLAN_ST_TIME CHAR(5) not null
  , LEC_PLAN_EN_TIME CHAR(5) not null
  , constraint SCHEDULE_TRX_PKC primary key (EMPLOYEE_ID,LANGUAGE_CODE,LEC_YMD)
);

--* RestoreFromTempTable
create table SHIP_PLAN (
  SHIP_PLAN_NO CHAR(8) not null
  , SHIP_PLAN_DATE DATE
  , ITEM_CODE CHAR(8)
  , WAREHOUSE_CODE CHAR(6)
  , PALLET_AMOUNT INTEGER
  , CASE_AMOUNT INTEGER
  , BOAR_AMOUNT INTEGER
  , PEACE_AMOUNT INTEGER
  , DESTINATION_CODE CHAR(6)
  , RESERVE_DEST_NO CHAR(6)
  , REMARK VARCHAR(255)
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(6) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(6) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint SHIP_PLAN_PKC primary key (SHIP_PLAN_NO)
);

--* RestoreFromTempTable
create table STOCK (
  STOCK_CODE CHAR(8) not null
  , ITEM_CODE CHAR(8) not null
  , STATUS_CODE CHAR(2) not null
  , WAREHOUSE_CODE CHAR(6) not null
  , PALLET_AMOUNT INTEGER not null
  , CASE_AMOUNT INTEGER not null
  , BOAR_AMOUNT INTEGER not null
  , PEACE_AMOUNT INTEGER not null
  , REMARK VARCHAR(255)
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(6) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(6) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint STOCK_PKC primary key (STOCK_CODE)
);

--* RestoreFromTempTable
create table STOREDS (
  STORED_NO CHAR(8) not null
  , STORED_DATE DATE not null
  , ITEM_CODE CHAR(8) not null
  , WAREHOUSE_CODE CHAR(6) not null
  , PALLET_AMOUNT INTEGER not null
  , CASE_AMOUNT INTEGER not null
  , BOAR_AMOUNT INTEGER not null
  , PEACE_AMOUNT INTEGER not null
  , ARRIVE_CODE CHAR(6)
  , REMARK VARCHAR(255)
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(6) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(6) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint STORED_PKC primary key (STORED_NO)
);

--* RestoreFromTempTable
create table USER_MASTER (
  USER_ID CHAR(4) not null
  , FAMILY_NM VARCHAR(10) not null
  , FIRST_NM VARCHAR(10) not null
  , FAMILY_NM_KANA VARCHAR(100)
  , FIRST_NM_KANA VARCHAR(100)
  , LAST_LOGIN_DATE DATETIME
  , USER_RANK CHAR(1) not null
  , LOGIN_COUNT INTEGER
  , LOGIN_FAILURE_COUNT INTEGER
  , ACCOUNT_LOCK_FLAG CHAR(1) not null
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(4) not null
  , UPDATE_DATE DATETIME not null
  , UPDATE_USER CHAR(4) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint USER_MASTER_PKC primary key (USER_ID)
);

--* RestoreFromTempTable
create table USER_MST (
  USER_ID CHAR(6) not null
  , USER_NAME VARCHAR(255)
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(6) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(6) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint USER_MST_PKC primary key (USER_ID)
);

--* RestoreFromTempTable
create table WAREHOUSE_MST (
  WAREHOUSE_CODE CHAR(6) not null
  , WAREHOUSE_NAME VARCHAR(200) not null
  , WAREHOUSE_ADDRESS VARCHAR(255)
  , WAREHOUSE_TEL CHAR(10)
  , INSERT_DATE DATE not null
  , INSERT_USER CHAR(6) not null
  , UPDATE_DATE DATE not null
  , UPDATE_USER CHAR(6) not null
  , DELETE_FLAG CHAR(1) not null
  , constraint WAREHOUSE_MST_PKC primary key (WAREHOUSE_CODE)
);
