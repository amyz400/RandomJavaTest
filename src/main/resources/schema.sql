drop table if exists NOTES;
create table NOTES (
	id INT NOT NULL auto_increment,
  notes VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);
