CREATE TRIGGER IF NOT EXISTS trigger_name BEFORE DELETE
ON table_name FOR EACH ROW
BEGIN
    UPDATE table_name SET column_name = 1; 
END;
CREATE TEMP TRIGGER database_name.trigger_name AFTER INSERT
ON table_name FOR EACH ROW WHEN column_name == 1
BEGIN
    INSERT INTO table_name DEFAULT VALUES; 
END;
CREATE TEMPORARY TRIGGER trigger_name INSTEAD OF UPDATE
ON table_name WHEN column_name == 1
BEGIN
    DELETE FROM table_name; 
END;
CREATE TEMPORARY TRIGGER trigger_name INSTEAD OF UPDATE
ON table_name WHEN column_name == 1
BEGIN
    INSERT INTO table_name DEFAULT VALUES; 
    DELETE FROM table_name; 
END;
CREATE TEMPORARY TRIGGER trigger_name INSTEAD OF UPDATE
ON table_name WHEN column_name == 1
BEGIN
END;
CREATE TRIGGER trigger_name UPDATE OF column_name1
ON table_name
BEGIN
    SELECT *; 
END;
CREATE TRIGGER trigger_name UPDATE OF column_name1, column_name2
ON table_name
BEGIN
    SELECT *; 
END;
CREATE TRIGGER trigger_name UPDATE OF
ON table_name
BEGIN
    SELECT *; 
END;