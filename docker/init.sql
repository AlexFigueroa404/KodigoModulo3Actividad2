IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'KodigoDB')
    BEGIN
        CREATE DATABASE KodigoDB;
    END