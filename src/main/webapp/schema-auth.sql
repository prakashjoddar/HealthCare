/* @author : Prakash Joddar
 * @Date   : 2023-03-16 (yyyy-mm-dd)
 * @note   : apm_city, I am creating this table to store city name linked with stateid
 */
DROP TABLE IF EXISTS "maximus"."apm_city";
CREATE TABLE  "maximus"."apm_city" (
  "id" int(11) NOT NULL AUTO_INCREMENT,
  "state_id" int(11) NOT NULL DEFAULT 0,
  "name" varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

DROP TABLE IF EXISTS "maximus"."apm_state";
CREATE TABLE  "maximus"."apm_state" (
  "id" int(11) NOT NULL AUTO_INCREMENT,
  "name" varchar(100) DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

DROP TABLE IF EXISTS "maximus"."user_creds";
CREATE TABLE  "maximus"."user_creds" (
  "id" int(11) NOT NULL AUTO_INCREMENT,
  "userid" int(11) NOT NULL DEFAULT 0,
  "password" varchar(150) NOT NULL DEFAULT '0',
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

DROP TABLE IF EXISTS "maximus"."user_details";
CREATE TABLE  "maximus"."user_details" (
  "id" int(11) NOT NULL AUTO_INCREMENT,
  "firstname" varchar(45) NOT NULL DEFAULT '',
  "lastname" varchar(45) NOT NULL,
  "fullname" varchar(100) NOT NULL,
  "address" text NOT NULL,
  "contact" varchar(20) NOT NULL DEFAULT '',
  "gender" varchar(10) NOT NULL DEFAULT '',
  "stateid" int(11) NOT NULL DEFAULT 0,
  "cityid" int(11) NOT NULL DEFAULT 0,
  "email" varchar(40) NOT NULL DEFAULT '0',
  "dob" varchar(20) NOT NULL DEFAULT '0',
  "reg_date" varchar(20) NOT NULL DEFAULT '0',
  "last_modified" varchar(20) NOT NULL DEFAULT '',
  "isadmin" int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;