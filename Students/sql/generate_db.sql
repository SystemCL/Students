CREATE SCHEMA `studentsdb` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `studentsdb`.`Group` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nameGroup` VARCHAR(45) NULL,
  `faculty` VARCHAR(60) NULL,
  PRIMARY KEY (`id`) );

CREATE TABLE IF NOT EXISTS `studentsdb`.`Student` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `firstName` VARCHAR(50) ,
  `lastName` VARCHAR(50) ,
  `age` INT NOT NULL ,
  `enrolment_date` DATE NULL,
  PRIMARY KEY (`id`) );
  --`group_id` INT ,
  
 -- FOREIGN KEY (`group_id`) REFERENCES Group(id) ON DELETE CASCADE );
  
  CREATE TABLE IF NOT EXISTS `studentsdb`.`Address` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nameAddress` VARCHAR(50) ,
  `nrPhone` VARCHAR(50) ,
  PRIMARY KEY (`id`));
  --FOREIGN KEY (`id`) REFERENCES Student(`id`));
  
  CREATE TABLE IF NOT EXISTS `studentsdb`.`Course` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nameCourse` VARCHAR(50) ,
  `nameProf` VARCHAR(50) ,
  `startDate` DATE NULL ,
  `endDate` DATE NULL ,
  PRIMARY KEY (`id`) );
  