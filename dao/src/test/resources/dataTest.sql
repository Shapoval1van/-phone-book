  INSERT INTO lang VALUES (DEFAULT, 'English'),
    (DEFAULT, 'Ukraine'),
    (DEFAULT, 'Russian');
  INSERT INTO person VALUES (DEFAULT, 'user', 'user', DEFAULT, DEFAULT),
    (DEFAULT, 'Kunkur', '123456d', DEFAULT, DEFAULT),
    (DEFAULT, 'Knur', 'isuprecnur', DEFAULT, DEFAULT);
  INSERT INTO group_c VALUES (DEFAULT, 'School', TRUE, DEFAULT),
    (DEFAULT, 'Work', TRUE, DEFAULT),
    (DEFAULT, 'Friends', TRUE, DEFAULT),
    (DEFAULT, 'MyGroup', FALSE, 1),
    (DEFAULT, 'GroupForDelete', FALSE, 1);
  INSERT INTO address VALUES (DEFAULT, 'Ukraine', NULL),
    (DEFAULT, 'Ukraine', 'Kiev'),
    (DEFAULT, 'Ukraine', 'PH');
  INSERT INTO contact VALUES
    (DEFAULT, 'Jimmy', 'Tudeski', '+380934562312', NULL, 'tudeski@gmail.com', '2015-06-30', 1, 1,1),
    (DEFAULT, 'Andy', 'Dufresne', '+380934322212', '4342323', 'dufresne@gmail.com', '2015-06-30', 1, 1,2),
    (DEFAULT, 'Jeffrey', 'Goines', '+380933765428', NULL, 'jeffreye@gmail.com1', '2015-06-30', 2, 2,1),
    (DEFAULT, 'John', 'McClane', '+380937654238', NULL, NULL, '2015-06-30', 3,3,2),
    (DEFAULT, 'You', 'Deleted', '+380937654238', NULL, NULL, '2015-06-30', 3,5,2),
    (DEFAULT, 'And', 'YuoToo', '+380937654238', NULL, NULL, '2015-06-30', 3,5,2);