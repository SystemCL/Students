
  INSERT INTO `studentdb`.`Group`(`nameGroup`, `faculty`)
  VALUES('TI-141', 'FCIM');
  INSERT INTO `studentdb`.`Group`(`nameGroup`, `faculty`)
  VALUES('FI-141', 'FCIM');
  
  INSERT INTO `studentdb`.`Student`(`firstName`, `lastName`, `age`, `enrolment_date`, `group_Id`)
  VALUES('Ostapenco', 'Ivan', '21', '2016-09-04', '1');
  INSERT INTO `studentdb`.`Student`(`firstName`, `lastName`, `age`, `enrolment_date`, `group_Id`)
  VALUES('Hrishca', 'Gheorghe', '21','2016-09-04', '2');
  INSERT INTO `studentdb`.`Student`(`firstName`, `lastName`, `age`, `enrolment_date`, `group_Id`)
  VALUES('Frunze', 'Max', '22','2016-09-04', '1');
  INSERT INTO `studentdb`.`Student`(`firstName`, `lastName`, `age`, `enrolment_date`, `group_Id`)
  VALUES('Chirica', 'Sergiu', '21','2016-09-04', '1');
  INSERT INTO `studentdb`.`Student`(`firstName`, `lastName`, `age`, `enrolment_date`, `group_Id`)
  VALUES('Caldare', 'Valeriu', '22','2016-09-04', '2');
  
  
  INSERT INTO `studentdb`.`Address`(`nameAddress`, `nrPhone`)
  VALUES('str. Stefan cel Mare 23', '+373069365784');
  INSERT INTO `studentdb`.`Address`(`nameAddress`, `nrPhone`)
  VALUES('str. Cuza Voda 32', '+373078115262');
  INSERT INTO `studentdb`.`Address`(`nameAddress`, `nrPhone`)
  VALUES('str. Samisegetuza', '+373068171205');
  
  INSERT INTO `studentdb`.`Course`(`nameCourse`, `nameProf`, `startDate`, `endDate`)
  VALUES('Matematica Discreta', 'Trifoi Valeiru', '2016-09-04', '2017-02-04');
  INSERT INTO `studentdb`.`Course`(`nameCourse`, `nameProf`, `startDate`, `endDate`)
  VALUES('Metode Numerice', 'Moraru Vasile', '2016-09-04', '2017-02-04');
  INSERT INTO `studentdb`.`Course`(`nameCourse`, `nameProf`, `startDate`, `endDate`)
  VALUES('Mecanica', 'Casian Ion', '2016-09-04', '2017-02-04');
  INSERT INTO `studentdb`.`Course`(`nameCourse`, `nameProf`, `startDate`, `endDate`)
  VALUES('Limba Franceza', 'Tcaci Olga', '2016-09-04', '2017-02-04');
  
  
  
  
  
  );