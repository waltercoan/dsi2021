INSERT IGNORE INTO CIDADE(id, nome,estado) values(1,'Joinville','Santa Catarina') ;
INSERT IGNORE INTO CIDADE(id, nome,estado) values(2,'Jaraguá do Sul','Santa Catarina') ;
INSERT IGNORE INTO CIDADE(id, nome,estado) values(3,'Curitiba','Parana') ;
INSERT IGNORE INTO CIDADE(id, nome,estado) values(4,'Florianópolis','Santa Catarina') ;


INSERT IGNORE INTO PACIENTE(id, nome, sexo, cidade_id) values(10,'Zezinho','Masculino', 1) ;

INSERT IGNORE INTO CONSULTA(id, `data`, `status`, paciente_id) values(10,'2021-08-26','Finalizado', 10) ;

INSERT IGNORE INTO PROCEDIMENTO_REALIZADO (id, descricao, valor, consulta_id) values(1,'Anamnese', 350, 10) ;



INSERT IGNORE INTO POST(ID, DATA_POST, TITULO, DESCRICAO) values(1,'2021-08-26','ULTIMO POST', 'POST TESTE 3') ;
INSERT IGNORE INTO POST(ID, DATA_POST, TITULO, DESCRICAO) values(2,'2021-08-27','POST DO MEIO', 'POST TESTE 2') ;
INSERT IGNORE INTO POST(ID, DATA_POST, TITULO, DESCRICAO) values(3,'2021-09-02','PRIMEIRO POST', 'POST TESTE 1') ;
