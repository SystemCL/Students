CREATE SCHEMA `studentsdb` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `studentsdb`.`Group` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nameGroup` VARCHAR(45) NULL,
  `faculty` VARCHAR(60) NULL,
  PRIMARY KEY (`id`)
 );

 DROP TABLE `Group`;
 DROP TABLE `Address`;
 DROP TABLE `Course`;
 DROP TABLE `Student`;
 
 CREATE TABLE IF NOT EXISTS `studentsdb`.`Address` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nameAddress` VARCHAR(50) ,
  `nrPhone` VARCHAR(50) ,
  PRIMARY KEY (`id`)
 );
 
CREATE TABLE IF NOT EXISTS `studentsdb`.`Student` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `firstName` VARCHAR(50) ,
  `lastName` VARCHAR(50) ,
  `age` INT NOT NULL ,
  `enrolment_date` DATE NULL,
  `group_student` INT NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `st_gr` FOREIGN KEY (`group_student`) REFERENCES `Group` (`id`) ON DELETE CASCADE,
  CONSTRAINT `st_addr` FOREIGN KEY(`address_id`) REFERENCES `address` (`id`) ON UPDATE CASCADE);
  --`group_id` INT ,
  
 -- FOREIGN KEY (`group_id`) REFERENCES Group(id) ON DELETE CASCADE );
  

  --FOREIGN KEY (`id`) REFERENCES Student(`id`));
  
  CREATE TABLE IF NOT EXISTS `studentsdb`.`Course` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nameCourse` VARCHAR(50) ,
  `nameProf` VARCHAR(50) ,
  `startDate` DATE NULL ,
  `endDate` DATE NULL ,
  PRIMARY KEY (`id`) );
  
  CREATE TABLE IF NOT EXISTS `studentsdb`.`Student_Course` (
  `idStudent_Course` INT NOT NULL AUTO_INCREMENT,
  `student_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  PRIMARY KEY (`idStudent_Course`),
  CONSTRAINT `st_cr` FOREIGN KEY (`student_id`) REFERENCES `Student` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `cr_st` FOREIGN KEY (`course_id`) REFERENCES `Course` (`id`) ON UPDATE CASCADE
  );
  