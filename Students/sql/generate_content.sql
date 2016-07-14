
  INSERT INTO `studentsdb`.`Group`(`nameGroup`, `faculty`)
  VALUES('TI-141', 'FCIM');
  INSERT INTO `studentsdb`.`Group`(`nameGroup`, `faculty`)
  VALUES('FI-141', 'FCIM');
  INSERT INTO `studentsdb`.`Group`(`nameGroup`, `faculty`)
  VALUES('FAF-141', 'FCIM');
  INSERT INTO `studentsdb`.`Group`(`nameGroup`, `faculty`)
  VALUES('FI-141', 'FCIM');
  
  INSERT INTO `studentsdb`.`Address`(`nameAddress`, `nrPhone`)
  VALUES('str. Stefan cel Mare 23', '+373069365784');
  INSERT INTO `studentsdb`.`Address`(`nameAddress`, `nrPhone`)
  VALUES('str. Cuza Voda 32', '+373078115262');
  INSERT INTO `studentsdb`.`Address`(`nameAddress`, `nrPhone`)
  VALUES('str. Samisegetuza', '+373068171205');
  INSERT INTO `studentsdb`.`Address`(`nameAddress`, `nrPhone`)
  VALUES('str. Traian 54', '+373067222235');
  INSERT INTO `studentsdb`.`Address`(`nameAddress`, `nrPhone`)
  VALUES('str. Dacia 14', '+373069114678');
  
  
  INSERT INTO `studentsdb`.`Student` (`firstName`, `lastName`, `age`,`enrolment_date`, `group_student`, `address_id`)
  VALUES ('Ostapenco', 'Ivan', '21', '2016-09-04', '1', '1');
  INSERT INTO `studentsdb`.`Student`(`firstName`, `lastName`, `age`, `enrolment_date`, `group_student`, `address_id`)
  VALUES('Hrishca', 'Gheorghe', '21','2016-09-04', '1', '2');
  INSERT INTO `studentsdb`.`Student`(`firstName`, `lastName`, `age`, `enrolment_date`, `group_student`, `address_id`)
  VALUES('Frunze', 'Max', '22','2016-09-04', '3',  '3');
  INSERT INTO `studentsdb`.`Student`(`firstName`, `lastName`, `age`, `enrolment_date`, `group_student`, `address_id`)
  VALUES('Chirica', 'Sergiu', '21','2016-09-04', '2', '4');
  INSERT INTO `studentsdb`.`Student`(`firstName`, `lastName`, `age`, `enrolment_date`, `group_student`, `address_id`)
  VALUES('Caldare', 'Valeriu', '22','2016-09-04', '1', '5');
  
  
  INSERT INTO `studentsdb`.`Course`(`nameCourse`, `nameProf`, `startDate`, `endDate`)
  VALUES('Matematica Discreta', 'Trifoi Valeiru', '2016-09-04', '2017-02-04');
  INSERT INTO `studentsdb`.`Course`(`nameCourse`, `nameProf`, `startDate`, `endDate`)
  VALUES('Metode Numerice', 'Moraru Vasile', '2016-09-04', '2017-02-04');
  INSERT INTO `studentsdb`.`Course`(`nameCourse`, `nameProf`, `startDate`, `endDate`)
  VALUES('Mecanica', 'Casian Ion', '2016-09-04', '2017-02-04');
  INSERT INTO `studentsdb`.`Course`(`nameCourse`, `nameProf`, `startDate`, `endDate`)
  VALUES('Limba Franceza', 'Tcaci Olga', '2016-09-04', '2017-02-04');
  

  INSERT INTO `studentsdb`.`Student_Course`(`student_id`, `course_id`)
  VALUES('1','1');
  INSERT INTO `studentsdb`.`Student_Course`(`student_id`, `course_id`)
  VALUES('1','2');
  INSERT INTO `studentsdb`.`Student_Course`(`student_id`, `course_id`)
  VALUES('1','3');
  INSERT INTO `studentsdb`.`Student_Course`(`student_id`, `course_id`)
  VALUES('2','2');
  INSERT INTO `studentsdb`.`Student_Course`(`student_id`, `course_id`)
  VALUES('2','3');
  INSERT INTO `studentsdb`.`Student_Course`(`student_id`, `course_id`)
  VALUES('3','1');
  INSERT INTO `studentsdb`.`Student_Course`(`student_id`, `course_id`)
  VALUES('3','3');
  INSERT INTO `studentsdb`.`Student_Course`(`student_id`, `course_id`)
  VALUES('3','4');
  INSERT INTO `studentsdb`.`Student_Course`(`student_id`, `course_id`)
  VALUES('4','2');
  INSERT INTO `studentsdb`.`Student_Course`(`student_id`, `course_id`)
  VALUES('4','4');
  
  
SELECT firstName, lastName FROM student where `id` = (SELECT id FROM address WHERE id=2)
--  ALTER TABLE `studentsdb`.`Student` ADD FOREIGN KEY (`group_id`) REFERENCES Group(`group_id`);
--  
--  ALTER TABLE `Student` ADD CONSTRAINT fk_StGr FOREIGN KEY (group_id) REFERENCES Group(`idGr`);
--  
--  ALTER TABLE `studentsdb`.`Group` CHANGE `idGr` `id` INT;
--  ALTER TABLE `studentsdb`.`Student` CHANGE `idSt` `id` INT;
--  ALTER TABLE `studentsdb`.`Student` DROP  COLUMN `group_id`;
  
  