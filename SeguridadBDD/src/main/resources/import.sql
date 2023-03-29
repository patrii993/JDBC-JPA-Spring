INSERT INTO `seguridad`.`roles` (`nombre`) VALUES ('ROLE_ADMIN');
INSERT INTO `seguridad`.`roles` (`nombre`) VALUES ('ROLE_USER');
INSERT INTO `seguridad`.`usuarios` ( `password`, `username`) VALUES ('$2a$10$RMkn5af7MxFIvfJTCFtnF.pKrfXFx9Lob8xLjRMoC28LWY/nuhXwW', 'admin');
INSERT INTO `seguridad`.`usuarios` ( `password`, `username`) VALUES ('$2a$10$RMkn5af7MxFIvfJTCFtnF.pKrfXFx9Lob8xLjRMoC28LWY/nuhXwW', 'user');
INSERT INTO `seguridad`.`usuariorol` (`idrol`, `idusuario`) VALUES ('1', '1');
INSERT INTO `seguridad`.`usuariorol` (`idrol`, `idusuario`) VALUES ('2', '2');
