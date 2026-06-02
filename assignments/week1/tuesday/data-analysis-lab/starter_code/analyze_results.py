import pandas as pd
df = pd.read_csv("test_data.csv")

total_tests = len(df)
passed_rate = (len(df[df["status"] == "pass"]) / total_tests) * 100
avg_duration = df["duration_ms"].mean()
slowest = df[df["duration_ms"] == df["duration_ms"].max()]
fastest = df[df["duration_ms"] == df["duration_ms"].min()]

def test_res():
    print(f"    {"Total Tests:":<20}{total_tests}")
    print(f"    {"Pass Rate:":<20}{passed_rate}")
    print(f"    {"Avg Duration:":<20}{avg_duration:.2f}ms ({avg_duration/1000:.2f}s)")
    print(f"    {"Slowest:":<20}{slowest["test_name"].iloc[0]} ({slowest["duration_ms"].iloc[0]:,}ms)")
    print(f"    {"Fastest:":<20}{fastest["test_name"].iloc[0]} ({fastest["duration_ms"].iloc[0]}ms)")
    print("\n")

def module_res():
    print(f"    ── By Module ──")
    print(f"    {"Module":<15} Tests    Pass Rate   Avg Duration")
    auth = df[df["module"] == "auth"]
    checkout = df[df["module"] == "checkout"]
    profile = df[df["module"] == "profile"]
    search = df[df["module"] == "search"]

    print(f"    {"auth":<15} {len(auth):<9}{(f"{len(auth[auth["status"] == "pass"]) / len(auth) * 100:.2f}%"):<12}{auth["duration_ms"].mean():.2f}ms")
    print(f"    {"checkout":<15} {len(checkout):<9}{(f"{len(checkout[checkout["status"] == "pass"]) / len(checkout) * 100:.2f}%"):<12}{checkout["duration_ms"].mean():.2f}ms")
    print(f"    {"profile":<15} {len(profile):<9}{(f"{len(profile[profile["status"] == "pass"]) / len(profile) * 100:.2f}%"):<12}{profile["duration_ms"].mean():.2f}ms")
    print(f"    {"search":<15} {len(search):<9}{(f"{len(search[search["status"] == "pass"]) / len(search) * 100:.2f}%"):<12}{search["duration_ms"].mean():.2f}ms")
    print("\n")

def failed_res():
    print(f"    ── Failed Tests ──")
    failed = df[df["status"] == "fail"]

    for _, fail in failed.iterrows():
        print(f"    {fail["test_name"]:<25}{fail["module"]:<10}{fail["duration_ms"]:,}ms")
    print("\n")

print(df.head(5))
print("\n")

print("=" * 30)
print(" Test Results Analysis")
print("=" * 30)
print("\n")

test_res()
module_res()
failed_res()

