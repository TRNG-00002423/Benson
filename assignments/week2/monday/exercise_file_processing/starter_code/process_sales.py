"""
Week 2 Exercise — CSV processing with context managers.

TODO:
1. Read starter_code/data/sales.csv using csv.DictReader and with open(...).
2. Compute rows count, grand total (sum of units * unit_price), average line revenue.
3. Find SKU with max line revenue (tie: first in file).
4. Write output/summary.txt using with open(..., "w", encoding="utf-8").
"""

from __future__ import annotations
import csv
import os

def main() -> None:
    bad_count = 0
    rows = []
    grand_total = 0
    top_sku = ""
    top_line_revenue = 0

    with open("./data/sales.csv", "r", encoding="utf-8", newline="") as file:
        reader = csv.DictReader(file)
        for row in reader:
            try:
                sku, units, unit_price = row["sku"], int(row["units"]), float(row["unit_price"])
                rows.append({"sku": sku, "units": units, "unit_price": unit_price})
                curr_line_revenue = unit_price * units
                grand_total += curr_line_revenue

                if curr_line_revenue > top_line_revenue:
                    top_line_revenue = curr_line_revenue
                    top_sku = sku
            except Exception as e:
                bad_count += 1
                print(f"Error: {e}")

    os.makedirs("./output", exist_ok=True) #relative to starter_code            
    with open("./output/summary.txt", "w", encoding="utf-8") as file:
        file.write(f"rows={len(rows)}\n")
        file.write(f"grand_total={grand_total}\n")
        file.write(f"average_line_revenue={grand_total/len(rows):.2f}\n")
        file.write(f"top_sku={top_sku}\n")
        file.write(f"top_line_revenue={top_line_revenue}\n")

if __name__ == "__main__":
    main()