INSERT INTO `spring_security`.`authorities`
(username, authority)
VALUES
    ('john', 'write');

INSERT INTO `spring_security`.`members`
(name, pwd, enabled)
VALUES
    ('john', '12345', '1');
