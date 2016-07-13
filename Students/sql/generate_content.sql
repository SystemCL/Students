
  INSERT INTO `studentsdb`.`Group`(`nameGroup`, `faculty`)
  VALUES('TI-141', 'FCIM');
  INSERT INTO `studentsdb`.`Group`(`nameGroup`, `faculty`)
  VALUES('FI-141', 'FCIM');
  
  INSERT INTO `studentsdb`.`Student` (`firstName`, `lastName`, `age`,`enrolment_date`)
  VALUES ('Ostapenco', 'Ivan', '21', '2016-09-04');
  INSERT INTO `studentsdb`.`Student`(`firstName`, `lastName`, `age`, `enrolment_date`)
  VALUES('Hrishca', 'Gheorghe', '21','2016-09-04');
  INSERT INTO `studentsdb`.`Student`(`firstName`, `lastName`, `age`, `enrolment_date`)
  VALUES('Frunze', 'Max', '22','2016-09-04');
  INSERT INTO `studentsdb`.`Student`(`firstName`, `lastName`, `age`, `enrolment_date`)
  VALUES('Chirica', 'Sergiu', '21','2016-09-04');
  INSERT INTO `studentsdb`.`Student`(`firstName`, `lastName`, `age`, `enrolment_date`)
  VALUES('Caldare', 'Valeriu', '22','2016-09-04');
  
  INSERT INTO `studentsdb`.`Address`(`nameAddress`, `nrPhone`)
  VALUES('str. Stefan cel Mare 23', '+373069365784');
  INSERT INTO `studentsdb`.`Address`(`nameAddress`, `nrPhone`)
  VALUES('str. Cuza Voda 32', '+373078115262');
  INSERT INTO `studentsdb`.`Address`(`nameAddress`, `nrPhone`)
  VALUES('str. Samisegetuza', '+373068171205');
  
  INSERT INTO `studentsdb`.`Course`(`nameCourse`, `nameProf`, `startDate`, `endDate`)
  VALUES('Matematica Discreta', 'Trifoi Valeiru', '2016-09-04', '2017-02-04');
  INSERT INTO `studentsdb`.`Course`(`nameCourse`, `nameProf`, `startDate`, `endDate`)
  VALUES('Metode Numerice', 'Moraru Vasile', '2016-09-04', '2017-02-04');
  INSERT INTO `studentsdb`.`Course`(`nameCourse`, `nameProf`, `startDate`, `endDate`)
  VALUES('Mecanica', 'Casian Ion', '2016-09-04', '2017-02-04');
  INSERT INTO `studentsdb`.`Course`(`nameCourse`, `nameProf`, `startDate`, `endDate`)
  VALUES('Limba Franceza', 'Tcaci Olga', '2016-09-04', '2017-02-04');
  
  
  
--  ALTER TABLE `studentsdb`.`Student` ADD FOREIGN KEY (`group_id`) REFERENCES Group(`group_id`);
--  
--  ALTER TABLE `Student` ADD CONSTRAINT fk_StGr FOREIGN KEY (group_id) REFERENCES Group(`idGr`);
--  
--  ALTER TABLE `studentsdb`.`Group` CHANGE `idGr` `id` INT;
--  ALTER TABLE `studentsdb`.`Student` CHANGE `idSt` `id` INT;
--  ALTER TABLE `studentsdb`.`Student` DROP  COLUMN `group_id`;
  
  