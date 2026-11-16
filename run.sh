#!/usr/bin/env bash
echo "==================================================="
echo "  Inventory Management POS - Point of Sale System"
echo "==================================================="
echo ""
echo "Launching Inventory POS Application..."

if ! command -v java &> /dev/null; then
    echo "[ERROR] Java is not installed or not in PATH."
    echo "Please install Java 21 or higher (e.g. from https://adoptium.net/)"
    exit 1
fi

java -jar inventory-2.0.1.jar
