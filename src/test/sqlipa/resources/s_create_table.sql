CREATE TABLE IF NOT EXISTS table_name(
    column_name1
);
CREATE TEMP TABLE database_name.table_name(
    column_name1,
    column_name2
);
CREATE TEMPORARY TABLE table_name(
    column_name1,
    column_name2,
    CHECK(column_name1 == 1)
);
CREATE TABLE table_name(
    column_name1,
    column_name2,
    CHECK(column_name1 == 1),
    CHECK(column_name2 == 2)
);
CREATE TABLE IF NOT EXISTS table_name();
CREATE TABLE IF NOT EXISTS table_name AS SELECT *;
CREATE TEMP TABLE database_name.table_name AS SELECT *;
CREATE TEMPORARY TABLE table_name AS SELECT *;