@echo off
title Inventory Management POS
echo ===================================================
echo   Inventory Management POS - Point of Sale System
echo ===================================================
echo.
echo Launching Inventory POS Application...
echo.

where java >nul 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo [ERROR] Java is not found in your system PATH.
    echo Please install Java 21 or higher (e.g. Eclipse Temurin JDK 21) from:
    echo https://adoptium.net/
    echo.
    pause
    exit /b 1
)

java -jar inventory-2.0.1.jar
if %ERRORLEVEL% NEQ 0 (
    echo.
    echo [ERROR] Application closed with an error.
    echo If this is a database connection error, make sure MySQL is running
    echo and database credentials in application.properties are correct.
    echo.
    pause
)
