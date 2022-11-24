/*You can add SQL here and it will be executed by H2 in-memory database when available*/
INSERT INTO TB_THREAD (thread_name) VALUES ('thread1');
INSERT INTO TB_CARD (card_description, thread_id) VALUES ('card1',1);
INSERT INTO TB_CARD (card_description, thread_id) VALUES ('card2',1);