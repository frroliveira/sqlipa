INSERT INTO database_name.table_name DEFAULT VALUES;
REPLACE INTO table_name DEFAULT VALUES;
INSERT OR ROLLBACK INTO table_name(column_name1) VALUES(1);
INSERT OR ABORT INTO table_name(column_name1) VALUES(1), (2), (3);
INSERT OR REPLACE INTO table_name(column_name1, column_name2) VALUES(1, 2);
INSERT OR FAIL INTO database_name.table_name(column_name1, column_name2) VALUES(1, 2), (3, 4);
INSERT OR IGNORE INTO table_name SELECT *;
