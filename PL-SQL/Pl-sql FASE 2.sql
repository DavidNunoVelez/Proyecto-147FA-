--PAQUETE LISTAR TRABAJADORES 
CREATE OR REPLACE PACKAGE TRABAJADORES
AS
PROCEDURE CONSULTA_TRABAJADORES(C_TRA OUT SYS_REFCURSOR);
PROCEDURE CONSULTA_TRANSPORTISTAS(C_TRAN OUT SYS_REFCURSOR);
PROCEDURE CONSULTA_TRABAJADOR(ID_TRA IN TRABAJADOR.ID_TRABAJADOR%TYPE, 
  C_TRA OUT SYS_REFCURSOR );
PROCEDURE CONSULTA_TRABAJADORES_CENTRO(C_TRA OUT SYS_REFCURSOR,
  V_ID_CENTRO IN CENTRO.ID_CENTRO%TYPE);
END TRABAJADORES;

CREATE OR REPLACE PACKAGE BODY TRABAJADORES
AS
PROCEDURE CONSULTA_TRABAJADORES(C_TRA OUT SYS_REFCURSOR)
AS
BEGIN 
  OPEN C_TRA FOR 
  SELECT ID_TRABAJADOR,DNI,NOMBRE,AP1,AP2 FROM TRABAJADOR; 
EXCEPTION 
  WHEN NO_DATA_FOUND THEN 
    RAISE_APPLICATION_ERROR(-20005,'No se ha encontrado el trabajador');
  WHEN OTHERS THEN 
    RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error');   
END CONSULTA_TRABAJADORES; 

PROCEDURE CONSULTA_TRANSPORTISTAS(C_TRAN OUT SYS_REFCURSOR)
AS
BEGIN 
  OPEN C_TRAN FOR 
  SELECT ID_TRABAJADOR,DNI,NOMBRE,AP1,AP2 FROM TRABAJADOR
  WHERE CATEGORIA='Transportista'; 
EXCEPTION 
  WHEN NO_DATA_FOUND THEN 
    RAISE_APPLICATION_ERROR(-20005,'No se ha encontrado el trabajador');
  WHEN OTHERS THEN 
    RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error');   
END CONSULTA_TRANSPORTISTAS; 

PROCEDURE CONSULTA_TRABAJADOR(ID_TRA IN TRABAJADOR.ID_TRABAJADOR%TYPE, 
  C_TRA OUT SYS_REFCURSOR ) 
AS 
BEGIN 
  OPEN C_TRA FOR
    SELECT * FROM TRABAJADOR WHERE ID_TRABAJADOR=ID_TRA; 
EXCEPTION 
  WHEN NO_DATA_FOUND THEN 
     RAISE_APPLICATION_ERROR(-20005,'No se ha encontrado el trabajador');
  WHEN TOO_MANY_ROWS THEN 
    RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error'); 
  WHEN OTHERS THEN 
    RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error'); 
END CONSULTA_TRABAJADOR; 

PROCEDURE CONSULTA_TRABAJADORES_CENTRO( C_TRA OUT SYS_REFCURSOR,
  V_ID_CENTRO IN CENTRO.ID_CENTRO%TYPE)
AS
BEGIN
  OPEN C_TRA FOR
    SELECT ID_TRABAJADOR,DNI,NOMBRE,AP1,AP2 FROM TRABAJADOR WHERE ID_CENTRO=V_ID_CENTRO;
EXCEPTION 
  WHEN NO_DATA_FOUND THEN 
     RAISE_APPLICATION_ERROR(-20005,'No se ha encontrado el trabajador');
  WHEN TOO_MANY_ROWS THEN 
    RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error'); 
  WHEN OTHERS THEN 
    RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error'); 
END CONSULTA_TRABAJADORES_CENTRO;

END TRABAJADORES;

--PAQUETE LISTAR CENTROS 
 
CREATE OR REPLACE PACKAGE PAQ_CENTROS 
AS 
PROCEDURE CONSULTA_CENTRO(ID_CEN IN CENTRO.ID_CENTRO%TYPE, 
  C_CEN OUT SYS_REFCURSOR); 
PROCEDURE CONSULTA_CENTROS(C_CENS OUT SYS_REFCURSOR); 
END PAQ_CENTROS; 
 
CREATE OR REPLACE PACKAGE BODY PAQ_CENTROS  
AS 
PROCEDURE CONSULTA_CENTRO(ID_CEN IN CENTRO.ID_CENTRO%TYPE, 
  C_CEN OUT SYS_REFCURSOR)
  AS 
  BEGIN 
    OPEN C_CEN FOR
      SELECT * FROM CENTRO WHERE ID_CENTRO=ID_CEN; 
  EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
      RAISE_APPLICATION_ERROR(-20004,'No se ha encontrado el centro');
    WHEN TOO_MANY_ROWS THEN 
      RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error'); 
    WHEN OTHERS THEN 
      RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error'); 
  END CONSULTA_CENTRO; 
  PROCEDURE CONSULTA_CENTROS(C_CENS OUT SYS_REFCURSOR) 
  AS 
  BEGIN 
    OPEN C_CENS FOR 
    SELECT ID_CENTRO,NOMBRE,LOC FROM CENTRO; 
  EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
      RAISE_APPLICATION_ERROR(-20004,'No se ha encontrado el centro');
    WHEN OTHERS THEN 
      RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error'); 
  END CONSULTA_CENTROS; 
END PAQ_CENTROS; 

--PAQUETE USUARIOS PROCEDIMIENTOS GUARDAR Y LOGIN
--!!PENDIENTE COMPROBAR ESTE PAQUETE!!
CREATE OR REPLACE PACKAGE USUARIOS
AS
  USU_ENCONTRADO USUARIO.ID_USUARIO%TYPE;
  CON_ENCONTRADO USUARIO."CONTRASE�A"%TYPE;
  USU_REPETIDO USUARIO.ID_USUARIO%TYPE;
  CATEGO TRABAJADOR.CATEGORIA%TYPE;
  FECHA_PARTE PARTE.FECHA%TYPE;
  ID_TRABAJA TRABAJADOR.ID_TRABAJADOR%TYPE;
  CONTADOR NUMBER;
PROCEDURE USUARIO_NUEVO(USU IN USUARIO.ID_USUARIO%TYPE,
CON IN USUARIO.CONTRASE�A%TYPE);
PROCEDURE USUARIO_LOGIN(USU IN USUARIO.ID_USUARIO%TYPE,
CON IN USUARIO.CONTRASE�A%TYPE,
TRABAJ OUT SYS_REFCURSOR,
PART OUT SYS_REFCURSOR,
REPART OUT SYS_REFCURSOR,
AVIS OUT SYS_REFCURSOR,
VEHIC OUT SYS_REFCURSOR,
CONTADOR OUT NUMBER);
END USUARIOS;

CREATE OR REPLACE PACKAGE BODY USUARIOS
AS
PROCEDURE USUARIO_NUEVO(USU IN USUARIO.ID_USUARIO%TYPE,
CON IN USUARIO.CONTRASE�A%TYPE)
AS
BEGIN
  INSERT INTO USUARIO VALUES(USU,ORA_HASH(CON));
  COMMIT;
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN 
    RAISE_APPLICATION_ERROR(-20001,'Ya existe un usuario con ese nombre');
  WHEN OTHERS THEN
    RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error');
END USUARIO_NUEVO;

PROCEDURE USUARIO_LOGIN(USU IN USUARIO.ID_USUARIO%TYPE,
CON IN USUARIO.CONTRASE�A%TYPE,
TRABAJ OUT SYS_REFCURSOR,
PART OUT SYS_REFCURSOR,
REPART OUT SYS_REFCURSOR,
AVIS OUT SYS_REFCURSOR,
VEHIC OUT SYS_REFCURSOR,
CONTADOR OUT NUMBER)
AS
BEGIN
  SELECT ID_USUARIO INTO USU_ENCONTRADO FROM USUARIO WHERE ID_USUARIO=USU AND "CONTRASE�A"=ORA_HASH(CON);
  SELECT CATEGORIA INTO CATEGO FROM TRABAJADOR WHERE ID_USUARIO=USU;
  OPEN TRABAJ FOR
  SELECT * FROM TRABAJADOR WHERE ID_USUARIO=USU;
  SELECT ID_TRABAJADOR INTO ID_TRABAJA FROM TRABAJADOR WHERE ID_USUARIO=USU;
  IF CATEGO = 'Administrativo' THEN
    OPEN AVIS FOR
    SELECT * FROM AVISO WHERE ID_TRABAJADOR_R=ID_TRABAJA;
  END IF;
  IF CATEGO ='Transportista' THEN
  --if saber si tiene un parte abierto
  SELECT COUNT(*) INTO CONTADOR FROM PARTE WHERE ID_TRABAJADOR=ID_TRABAJA AND ABIERTO=1;
  IF CONTADOR>=1 THEN
    SELECT FECHA INTO FECHA_PARTE FROM PARTE WHERE ABIERTO = 1 AND ID_TRABAJADOR=ID_TRABAJA;
      OPEN PART FOR
      SELECT * FROM PARTE WHERE ABIERTO = 1 AND ID_TRABAJADOR=ID_TRABAJA;
      OPEN REPART FOR
      SELECT * FROM REPARTO WHERE ID_TRABAJADOR=ID_TRABAJA AND FECHA =FECHA_PARTE ;
      OPEN VEHIC FOR
      SELECT * FROM VEHICULO WHERE ID_VEHICULO=(SELECT ID_VEHICULO FROM PARTE WHERE FECHA =FECHA_PARTE AND ID_TRABAJADOR=ID_TRABAJA) ;
    END IF;
  END IF;
EXCEPTION
  WHEN INVALID_CURSOR THEN
     RAISE_APPLICATION_ERROR(-20006, 'CURSOR NO EXISTENTE');
  WHEN VALUE_ERROR THEN
    RAISE_APPLICATION_ERROR(-20004, 'Problemas de conversi�n');
  WHEN CURSOR_ALREADY_OPEN THEN
    RAISE_APPLICATION_ERROR(-20005, 'CURSOR ABIERTO');
  WHEN NO_DATA_FOUND THEN 
    RAISE_APPLICATION_ERROR(-20003,'Usuario o contrase�a incorrecta');
  WHEN TOO_MANY_ROWS THEN
    RAISE_APPLICATION_ERROR(-20010,'Se ha encontrado m�s de una l�nea');
  WHEN OTHERS THEN
    RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error');
END USUARIO_LOGIN;
END USUARIOS;

--PAQUETE LISTAR PARTES
CREATE OR REPLACE PACKAGE PARTES
AS
PROCEDURE TODOS(C_PAR OUT SYS_REFCURSOR);
PROCEDURE TODOS_FECHA(V_FECHA_INI IN PARTE.FECHA%TYPE,
  V_FECHA_FIN IN PARTE.FECHA%TYPE,
  C_PAR OUT SYS_REFCURSOR);
PROCEDURE TODOS_FECHA_TRABAJADOR(V_FECHA_INI IN PARTE.FECHA%TYPE,
  V_FECHA_FIN IN PARTE.FECHA%TYPE,
  V_ID_TRABAJADOR IN TRABAJADOR.ID_TRABAJADOR%TYPE,
  C_PAR OUT SYS_REFCURSOR);
PROCEDURE TODOS_CERRADOS_FECHAS(V_FECHAINI IN PARTE.FECHA%TYPE,V_FECHAFIN IN PARTE.FECHA%TYPE,C_PAR OUT SYS_REFCURSOR);
PROCEDURE UNO(V_ID_TRABAJADOR IN TRABAJADOR.ID_TRABAJADOR%TYPE,V_FECHA IN PARTE.FECHA%TYPE, C_PARTE OUT SYS_REFCURSOR, C_REPARTO OUT SYS_REFCURSOR);
END PARTES;

CREATE OR REPLACE PACKAGE BODY PARTES
AS
PROCEDURE TODOS(C_PAR OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN C_PAR FOR
  SELECT T.ID_TRABAJADOR, T.NOMBRE,T.AP1, P.FECHA AS FECHA_PARTE,
    sum(extract(day from 24*60*(hora_fin - hora_inicio)))/60 
    AS "HORAS_TOTALES", P.ABIERTO FROM PARTE P, REPARTO R, TRABAJADOR T
    WHERE P.ID_TRABAJADOR=R.ID_TRABAJADOR AND P.FECHA=R.FECHA
    AND P.ID_TRABAJADOR=T.ID_TRABAJADOR
    GROUP BY  T.ID_TRABAJADOR,P.FECHA, P.ABIERTO,T.NOMBRE,T.AP1
    ORDER BY T.ID_TRABAJADOR,P.FECHA;
EXCEPTION
  WHEN NO_DATA_FOUND THEN 
    RAISE_APPLICATION_ERROR(-20003,'Usuario o contrase�a incorrecta');
  WHEN TOO_MANY_ROWS THEN
    RAISE_APPLICATION_ERROR(-20010,'Se ha encontrado m�s de una l�nea');
  WHEN OTHERS THEN
    RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error');
END;

PROCEDURE TODOS_FECHA(V_FECHA_INI IN PARTE.FECHA%TYPE,
  V_FECHA_FIN IN PARTE.FECHA%TYPE,
  C_PAR OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN C_PAR FOR
  SELECT T.ID_TRABAJADOR, T.NOMBRE,T.AP1, P.FECHA AS FECHA_PARTE,
  sum(extract(day from 24*60*(hora_fin - hora_inicio)))/60 
  AS "HORAS_TOTALES", P.ABIERTO FROM PARTE P, REPARTO R, TRABAJADOR T  
  WHERE P.ID_TRABAJADOR=R.ID_TRABAJADOR AND P.FECHA=R.FECHA 
  AND P.ID_TRABAJADOR = T.ID_TRABAJADOR
  AND P.FECHA BETWEEN V_FECHA_INI AND V_FECHA_FIN
  GROUP BY  T.ID_TRABAJADOR,P.FECHA, P.ABIERTO,T.NOMBRE,T.AP1
  ORDER BY T.ID_TRABAJADOR,P.FECHA;
EXCEPTION
  WHEN NO_DATA_FOUND THEN 
    RAISE_APPLICATION_ERROR(-20003,'Usuario o contrase�a incorrecta');
  WHEN TOO_MANY_ROWS THEN
    RAISE_APPLICATION_ERROR(-20010,'Se ha encontrado m�s de una l�nea');
  WHEN OTHERS THEN
    RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error');
END;

PROCEDURE TODOS_FECHA_TRABAJADOR(V_FECHA_INI IN PARTE.FECHA%TYPE,
  V_FECHA_FIN IN PARTE.FECHA%TYPE,
  V_ID_TRABAJADOR IN TRABAJADOR.ID_TRABAJADOR%TYPE,
  C_PAR OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN C_PAR FOR
  SELECT T.ID_TRABAJADOR, T.NOMBRE,T.AP1, P.FECHA AS FECHA_PARTE,
  sum(extract(day from 24*60*(hora_fin - hora_inicio)))/60 
  AS "HORAS_TOTALES", P.ABIERTO FROM PARTE P, REPARTO R, TRABAJADOR T  
  WHERE P.ID_TRABAJADOR=R.ID_TRABAJADOR AND P.FECHA=R.FECHA 
  AND T.ID_TRABAJADOR=P.ID_TRABAJADOR
  AND T.CATEGORIA='Transportista'
  AND P.FECHA BETWEEN V_FECHA_INI AND V_FECHA_FIN
  AND P.ID_TRABAJADOR=V_ID_TRABAJADOR
  GROUP BY  T.ID_TRABAJADOR,P.FECHA, P.ABIERTO,T.NOMBRE,T.AP1
  ORDER BY T.ID_TRABAJADOR,P.FECHA;
EXCEPTION
  WHEN NO_DATA_FOUND THEN 
    RAISE_APPLICATION_ERROR(-20003,'Usuario o contrase�a incorrecta');
  WHEN TOO_MANY_ROWS THEN
    RAISE_APPLICATION_ERROR(-20010,'Se ha encontrado m�s de una l�nea');
  WHEN OTHERS THEN
    RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error');
END;

PROCEDURE TODOS_CERRADOS_FECHAS(V_FECHAINI IN PARTE.FECHA%TYPE,V_FECHAFIN IN PARTE.FECHA%TYPE,C_PAR OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN C_PAR FOR
  SELECT P.ID_TRABAJADOR, P.FECHA AS FECHA_PARTE,sum(extract(day from 24*60*(hora_fin - hora_inicio)))/60 AS "HORAS_TOTALES", P.ABIERTO FROM PARTE P, REPARTO R
  WHERE P.ID_TRABAJADOR=R.ID_TRABAJADOR AND P.FECHA=R.FECHA AND ABIERTO=1 AND P.FECHA BETWEEN V_FECHAINI AND V_FECHAFIN
  GROUP BY R.FECHA, P.ID_TRABAJADOR, P.FECHA, p.ABIERTO
  ORDER BY P.ID_TRABAJADOR, P.FECHA;
EXCEPTION
  WHEN NO_DATA_FOUND THEN 
    RAISE_APPLICATION_ERROR(-20003,'Usuario o contrase�a incorrecta');
  WHEN TOO_MANY_ROWS THEN
    RAISE_APPLICATION_ERROR(-20010,'Se ha encontrado m�s de una l�nea');
  WHEN OTHERS THEN
    RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error');
END;

PROCEDURE UNO(V_ID_TRABAJADOR IN TRABAJADOR.ID_TRABAJADOR%TYPE,V_FECHA IN PARTE.FECHA%TYPE, C_PARTE OUT SYS_REFCURSOR, C_REPARTO OUT SYS_REFCURSOR)
AS
CURSOR C1 IS SELECT ID_TRABAJADOR, FECHA, ABIERTO FROM PARTE WHERE ID_TRABAJADOR= V_ID_TRABAJADOR AND FECHA=V_FECHA;
BEGIN
  OPEN C_PARTE FOR 
  SELECT * FROM PARTE WHERE ID_TRABAJADOR= V_ID_TRABAJADOR AND FECHA=V_FECHA;
  OPEN C_REPARTO FOR
  SELECT * FROM REPARTO WHERE ID_TRABAJADOR=V_ID_TRABAJADOR AND FECHA=V_FECHA;
  IF C_PARTE%NOTFOUND THEN
  RAISE NO_DATA_FOUND;
  END IF;
  IF C_PARTE%ROWCOUNT >1 THEN
  RAISE TOO_MANY_ROWS;
  END IF;
EXCEPTION
  WHEN NO_DATA_FOUND THEN 
    RAISE_APPLICATION_ERROR(-20003,'No se ha encontrado nada');
  WHEN TOO_MANY_ROWS THEN
    RAISE_APPLICATION_ERROR(-20010,'Se ha encontrado m�s de una l�nea');
  WHEN OTHERS THEN
    RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error');
END;
END PARTES;


CREATE OR REPLACE PROCEDURE ABIERTO(V_ID_TRABAJADOR IN TRABAJADOR.ID_TRABAJADOR%TYPE, C_PAR OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN C_PAR FOR
  SELECT * FROM PARTE WHERE ID_TRABAJADOR=V_ID_TRABAJADOR;
  IF C_PAR%NOTFOUND THEN
  RAISE NO_DATA_FOUND;
  END IF;
  IF C_PAR%ROWCOUNT >1 THEN
  RAISE TOO_MANY_ROWS;
  END IF;
EXCEPTION
  WHEN NO_DATA_FOUND THEN 
    RAISE_APPLICATION_ERROR(-20003,'No se ha encontrado nada');
  WHEN TOO_MANY_ROWS THEN
    RAISE_APPLICATION_ERROR(-20010,'Se ha encontrado m�s de una l�nea');
  WHEN OTHERS THEN
    RAISE_APPLICATION_ERROR(-20002,'Ha ocurrido un error');
END ABIERTO;



insert into usuario values('aaaaa',)





